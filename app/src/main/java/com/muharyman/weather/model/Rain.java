package com.muharyman.weather.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Rain extends RealmObject {
    @SerializedName("3h")
    public float h3;
}
