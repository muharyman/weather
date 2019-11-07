package com.muharyman.weather.view.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.muharyman.weather.App;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseActivity extends AppCompatActivity {

    protected Retrofit retrofit;
    protected OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupWebservice();
    }

    protected void setupWebservice() {
        client = new OkHttpClient.Builder()
                .addInterceptor(new StethoInterceptor())
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();

//        Gson gson = new GsonBuilder()
//                .serializeNulls()
//                .registerTypeAdapter(Long.class, new LongTypeAdapter())
//                .setDateFormat("yyyy-MM-dd HH:mm:ss")
//                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(App.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

    }
}
