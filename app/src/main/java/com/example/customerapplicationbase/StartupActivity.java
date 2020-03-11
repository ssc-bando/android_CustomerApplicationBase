package com.example.customerapplicationbase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;

import java.util.concurrent.TimeUnit;

public class StartupActivity extends AppCompatActivity {
    private View progressOverlay;
    AlphaAnimation inAnimation;
    AlphaAnimation outAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
    }

    public void onAutoLoginButtonClicked(View view) {
        progressOverlay = (View)findViewById(R.id.progress_bar);
        new MyTask().execute();
    }

    public void onManualLoginButtonClicked(View view) {
        Intent intent = new Intent(StartupActivity.this, LoginProgressActivity.class);
        startActivity(intent);
    }

    private class MyTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            inAnimation = new AlphaAnimation(0f, 1f);
            inAnimation.setDuration(200);
            progressOverlay.setAnimation(inAnimation);
            progressOverlay.setVisibility(View.VISIBLE);
            Log.v("TAG", "onPreExecute");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            outAnimation = new AlphaAnimation(1f, 0f);
            outAnimation.setDuration(200);
            progressOverlay.setAnimation(outAnimation);
            progressOverlay.setVisibility(View.GONE);
            Log.v("TAG", "onPostExecute");
            Intent intent = new Intent(StartupActivity.this, MainActivity.class);
            startActivity(intent);
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                for (int i = 0; i < 3; i++) {
                    Log.d("TAG", "Emulating some task.. Step " + i);
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
