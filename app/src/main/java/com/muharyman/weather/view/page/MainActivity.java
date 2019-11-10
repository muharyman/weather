package com.muharyman.weather.view.page;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.muharyman.weather.R;
import com.muharyman.weather.view.base.BaseActivity;

public class MainActivity extends BaseActivity  implements Contract{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void updateData() {

    }

    @Override
    public void onFailure(String body) {

    }
}
