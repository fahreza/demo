package com.apps.id.rijks;

import android.app.Application;

import com.orhanobut.hawk.Hawk;

/**
 * Created by fahrezafauzi on 8/26/18.
 */

public class RijksApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Hawk.init(this).build();
    }

}
