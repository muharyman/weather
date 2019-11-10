package com.muharyman.weather;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends MultiDexApplication {

    public static final String BASE_URL = "http://api.openweathermap.org/";
    public static final String APPID = "9fb6176409645f92abc6d663b51e379a";

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .schemaVersion(1) //
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
