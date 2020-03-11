package main

import (
	"github.com/fsnotify/fsnotify"
	"log"
	"os/exec"
	"path/filepath"
)

func expected(path string) bool {
	return filepath.Ext(path) == ".txt"
}

func exec_target() {
	log.Println(">> start make")
	stdout, err := exec.Command("make").Output()
	if err != nil {
		log.Println(err)
		return
	}
	log.Printf("%s", stdout)
}

func handler(watcher *fsnotify.Watcher) {
	for {
		select {
		case event, ok := <-watcher.Events:
			if !ok {
				return
			}
			//log.Println("event:", event)
			if event.Op&fsnotify.Write == fsnotify.Write {
				log.Println("modified file:", event.Name)
				if expected(event.Name) {
					exec_target()
				}
			}
		case err, ok := <-watcher.Errors:
			if !ok {
				return
			}
			log.Println("error:", err)
		}
	}
}

func register_target(watcher *fsnotify.Watcher) {
	err := watcher.Add(".")
	if err != nil {
		log.Fatal(err)
	}
}

func main() {
	watcher, err := fsnotify.NewWatcher()
	if err != nil {
		log.Fatal(err)
	}
	defer watcher.Close()
	done := make(chan bool)

	register_target(watcher)
	go handler(watcher)
	<-done
}
