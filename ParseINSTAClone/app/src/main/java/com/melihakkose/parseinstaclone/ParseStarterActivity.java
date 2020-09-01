package com.melihakkose.parseinstaclone;

import android.app.Application;

import com.parse.Parse;

public class ParseStarterActivity extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

        //INITIALIZE =baslatmak
        Parse.initialize(new Parse.Configuration.Builder(this)
                        .applicationId("")
                        .clientKey("")
                        .server("")
                        .build()

        );


    }
}
