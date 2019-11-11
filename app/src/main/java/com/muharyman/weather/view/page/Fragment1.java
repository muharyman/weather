package com.muharyman.weather.view.page;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.muharyman.weather.R;
import com.muharyman.weather.service.WeatherResponse;
import com.muharyman.weather.view.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.muharyman.weather.App.MY_PERMISSIONS_REQUEST_LOCATION;

public class Fragment1 extends BaseFragment implements Contract {

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

        presenter = new Presenter(this, retrofit, getContext());

        return view;
    }

    @Override
    public void onSuccess(WeatherResponse weather) {
        namaKota.setText(weather.name);
        cuaca.setText(weather.weather.get(0).description);
        suhu.setText(String.valueOf(weather.main.temp));
    }

    @Override
    public void updateData() {

    }

    @Override
    public void onFailure(String body) {

    }

    @OnClick(R.id.button_kota)
    void submit() {
        name = inputKota.getText().toString();
        presenter.sendGetWeatherCity(name);
    }

    @OnClick(R.id.gps)
    void allowGPS() {
        LocationManager lm = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
        if (checkLocationPermission()) {
            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();

            presenter.sendGetWeatherGPS(latitude,longitude);
        }
    }

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                //Prompt the user once explanation has been shown
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);

            } else {
                // No explanation needed, we can request the permission.
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }
}
