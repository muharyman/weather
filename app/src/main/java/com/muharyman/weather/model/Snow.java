package com.muharyman.weather.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Snow extends RealmObject {
    @SerializedName("1h")
    public float h1;
    @SerializedName("3h")
    public float h3;
}
