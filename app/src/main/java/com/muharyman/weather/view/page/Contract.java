package com.muharyman.weather.view.page;

import com.muharyman.weather.service.WeatherResponse;

public interface Contract {
    void onSuccess(WeatherResponse weather);
    void updateData();
    void onFailure(String body);
}
