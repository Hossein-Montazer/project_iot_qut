package com.example.exam2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import app.app;

public class AndroidActivityRecycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_recycle);
        setTitle(getResources().getString(R.string.AndroidActivityRecycle));

        app.log  ("onCreate");
        app.toast("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        app.log  ("onStart");
        app.toast("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        app.log  ("onPause");
        app.toast("onPause");
    }

    @Override
    protected void onPause() {
        app.log  ("onPause");
        app.toast("onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        app.log  ("onStop");
        app.toast("onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        app.log  ("onRestart");
        app.toast("onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        app.log  ("onDestroy");
        app.toast("onDestroy");
        super.onDestroy();
    }
}
