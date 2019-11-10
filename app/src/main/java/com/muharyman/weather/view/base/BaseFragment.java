package com.muharyman.weather.view.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.muharyman.weather.App;
import com.muharyman.weather.service.LongTypeAdapter;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseFragment extends Fragment {

    protected Retrofit retrofit;
    protected OkHttpClient client;

    protected abstract View onBaseCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setupWebservice();
        return onBaseCreateView(inflater, container, savedInstanceState);
    }

    protected void setupWebservice() {
        client = new OkHttpClient.Builder()
                .addInterceptor(new StethoInterceptor())
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();

        Gson gson = new GsonBuilder()
                .serializeNulls()
                .registerTypeAdapter(Long.class, new LongTypeAdapter())
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(App.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

    }

}
