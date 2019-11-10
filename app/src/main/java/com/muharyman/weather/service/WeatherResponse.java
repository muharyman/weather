package com.muharyman.weather.service.service;

import com.google.gson.annotations.SerializedName;
import com.muharyman.weather.model.Clouds;
import com.muharyman.weather.model.Coord;
import com.muharyman.weather.model.ListWeather;
import com.muharyman.weather.model.Main;
import com.muharyman.weather.model.Rain;
import com.muharyman.weather.model.Sys;
import com.muharyman.weather.model.Wind;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class WeatherResponse extends RealmObject {
    public Coord coord;
    @SerializedName("weather")
    public ListWeather listWeather;
    public String base;
    public Main main;
    public Wind wind;
    public Rain rain;
    public Clouds clouds;
    public Sys sys;
    public int timezone;
    @Index
    @PrimaryKey
    public long id;
    public String name;
    public int cod;

    public WeatherResponse(){
        super();
    }

    public static RealmResults<WeatherResponse> getQuery(Realm realm, String search_key){
        return realm.where(WeatherResponse.class).findAllAsync();
    }
}
