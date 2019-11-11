package com.muharyman.weather.service;

import com.muharyman.weather.service.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherWebService {
    @GET("weather")
    Call<WeatherResponse> getCurrentWeatherCity(@Query("q") String name , @Query("APPID") String appid );

    @GET("weather")
    Call<WeatherResponse> getCurrentWeatherData(@Query("lat") double lat, @Query("lon") double lon, @Query("APPID") String appid);

}
