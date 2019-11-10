package com.muharyman.weather.model;

import io.realm.RealmObject;

public class Weather extends RealmObject{
    public int id ;
    public String main ;
    public String description ;
    public String icon ;
}
