package com.example.administrator.myapplication;

import android.app.Application;

public class GameApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Max.initialize(this);
    }
}
