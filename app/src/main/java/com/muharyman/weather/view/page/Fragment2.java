package com.muharyman.weather.view.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.muharyman.weather.R;
import com.muharyman.weather.service.WeatherResponse;
import com.muharyman.weather.view.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Fragment2 extends BaseFragment implements Contract {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    private View view;
    private Adapter adapter;
    private ArrayList<WeatherResponse> weatherData;

    @Override
    protected View onBaseCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment2, container, false);
        ButterKnife.bind(this, view);

        weatherData = new ArrayList<>();
        adapter = new Adapter(getContext(), weatherData);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onSuccess(WeatherResponse weather) {

    }

    @Override
    public void updateData() {
        adapter.getFromDatabase();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(String body) {

    }

    @Override
    public void onResume() {
        super.onResume();
        updateData();
    }
}
