package com.muharyman.weather.view.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.muharyman.weather.R;
import com.muharyman.weather.service.service.WeatherResponse;
import com.muharyman.weather.view.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Fragment1 extends BaseFragment implements Contract{

    @BindView(R.id.input_kota)
    EditText inputKota;
    @BindView(R.id.button_kota)
    Button submit;
    @BindView(R.id.gps)
    Button gps;
    @BindView(R.id.kota)
    TextView namaKota;
    @BindView(R.id.cuaca)
    TextView cuaca;
    @BindView(R.id.suhu)
    TextView suhu;

    private View view;
    private Presenter presenter;
    private String name;


    @Override
    protected View onBaseCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1, container, false);
        ButterKnife.bind(this, view);

        presenter = new Presenter(this,retrofit,getContext());

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

    @OnClick(R.id.button_kota)
    void submit(){
        name = inputKota.getText().toString();
        presenter.sendGetWeatherCity(name);
    }
}
