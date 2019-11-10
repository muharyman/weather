package com.muharyman.weather.model;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class ListWeather extends RealmObject {
    public RealmList<Weather> weather;
}
