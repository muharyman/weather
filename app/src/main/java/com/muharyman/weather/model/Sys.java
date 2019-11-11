package com.muharyman.weather.model;

import io.realm.RealmObject;

public class Sys extends RealmObject {
    public int type;
    public int id;
    public String message;
    public String country;
    public long sunrise;
    public long sunset;
}
