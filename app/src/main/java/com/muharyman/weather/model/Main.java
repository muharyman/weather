package com.muharyman.weather.model;

import io.realm.RealmObject;

public class Main extends RealmObject {
    public float temp;
    public int pressure;
    public int humidity;
    public float temp_min;
    public float temp_max;
    public int sea_level;
    public int grnd_level;
}


