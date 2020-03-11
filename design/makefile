.PHONY: default build example auto auto_setup ifdoc

SRCDIR    := input
DESTDIR   := images
IFDESTDIR := ./ifdoc
LIB       := lib/plantuml.jar

IMGSRC   := $(wildcard *.txt)
DEST     := $(IMGSRC:.txt=.png)

default: build

build: $(DEST)

%.png: %.txt
	java -jar $(LIB) -charset UTF-8 -tpng  $<

auto:
	go run auto/main.go

auto_setup:
	@echo 'please install golang first.'
	go get -u github.com/fsnotify/fsnotify

