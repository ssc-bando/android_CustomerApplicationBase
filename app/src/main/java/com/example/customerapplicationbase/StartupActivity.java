package com.example.customerapplicationbase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;

public class StartupActivity extends AppCompatActivity {
    private View progressOverlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
    }

    public void onAutoLoginButtonClicked(View view) {
        progressOverlay = (View)findViewById(R.id.progress_bar);
        new NewActivityWithProgressBar(progressOverlay,StartupActivity.this, MainActivity.class)
                .execute();
    }

    public void onManualLoginButtonClicked(View view) {
        Intent intent = new Intent(StartupActivity.this, LoginProgressActivity.class);
        startActivity(intent);
    }

}
