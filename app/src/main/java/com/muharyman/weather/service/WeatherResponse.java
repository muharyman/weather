package com.muharyman.weather.service;

import com.muharyman.weather.model.Clouds;
import com.muharyman.weather.model.Coord;
import com.muharyman.weather.model.Main;
import com.muharyman.weather.model.Rain;
import com.muharyman.weather.model.Snow;
import com.muharyman.weather.model.Sys;
import com.muharyman.weather.model.Weather;
import com.muharyman.weather.model.Wind;

import java.util.Date;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.Sort;
import io.realm.annotations.Index;

public class WeatherResponse extends RealmObject {
    public Coord coord;
    public RealmList<Weather> weather;
    public String base;
    public Main main;
    public Wind wind;
    public Rain rain;
    public Snow snow;
    public long dt;
    public long visibility;
    public Clouds clouds;
    public Sys sys;
    public int timezone;
    @Index
    public long id;
    public String name;
    public int cod;
    public Date date;

    public WeatherResponse() {
        super();
    }

    public static RealmResults<WeatherResponse> getQuery(Realm realm) {
        return realm.where(WeatherResponse.class).sort("date", Sort.DESCENDING).findAllAsync();
    }
}
