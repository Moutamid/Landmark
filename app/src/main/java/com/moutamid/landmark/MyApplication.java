package com.moutamid.landmark;

import android.app.Application;

import com.fxn.stash.Stash;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stash.init(this);
    }
}
