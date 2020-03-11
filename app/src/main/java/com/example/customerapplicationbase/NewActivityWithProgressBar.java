package com.example.customerapplicationbase;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;

import java.util.concurrent.TimeUnit;

class NewActivityWithProgressBar extends AsyncTask<Void, Void, Void> {
    private Context from;
    private Class<?> to;
    private View baseView;

    AlphaAnimation inAnimation;
    AlphaAnimation outAnimation;



    public NewActivityWithProgressBar(View basis, Context packageContext, Class<?> cls){
        baseView = basis;
        from = packageContext;
        to = cls;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        inAnimation = new AlphaAnimation(0f, 1f);
        inAnimation.setDuration(200);
        baseView.setAnimation(inAnimation);
        baseView.setVisibility(View.VISIBLE);
        Log.v("TAG", "onPreExecute");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        outAnimation = new AlphaAnimation(1f, 0f);
        outAnimation.setDuration(200);
        baseView.setAnimation(outAnimation);
        baseView.setVisibility(View.GONE);
        Log.v("TAG", "onPostExecute");
        Intent intent = new Intent(from, to);
        from.startActivity(intent);
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
