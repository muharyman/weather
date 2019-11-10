package com.muharyman.weather.view.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muharyman.weather.R;
import com.muharyman.weather.service.service.WeatherResponse;
import com.muharyman.weather.view.base.BaseFragment;

public class Fragment2 extends BaseFragment implements Contract{

    private View view;

    @Override
    protected View onBaseCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1, container, false);

        return view;
    }

    @Override
    public void onSuccess(WeatherResponse weather) {

    }

    @Override
    public void updateData() {

    }

    @Override
    public void onFailure(String body) {

    }
}
