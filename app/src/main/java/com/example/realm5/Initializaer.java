package com.example.realm5;

import android.app.Application;

import io.realm.Realm;

public class Initializaer extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

    }
}
