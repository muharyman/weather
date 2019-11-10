package com.muharyman.weather.view.page;

import androidx.annotation.NonNull;

import com.muharyman.weather.WeatherWebService;
import com.muharyman.weather.response.WeatherResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import io.realm.ImportFlag;
import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.muharyman.weather.App.APPID;

public class Presenter {

    private Retrofit retrofit;
    private Contract view;
    private Realm realm = Realm.getDefaultInstance();

    public Presenter(Contract view, Retrofit retrofit) {
        this.view = view;
        this.retrofit = retrofit;
    }

    public void sendGetWeatherCity(String city_name) {
        WeatherWebService service = retrofit.create(WeatherWebService.class);
        Call<WeatherResponse> call = service.getCurrentWeatherCity(city_name, APPID);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(@NonNull Call<WeatherResponse> call,
                                   @NonNull Response<WeatherResponse> response) {
                if (response.isSuccessful()) {
                    final WeatherResponse responseBody = response.body();
                    realm.executeTransactionAsync(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            realm.copyToRealmOrUpdate(responseBody,
                                    ImportFlag.CHECK_SAME_VALUES_BEFORE_SET);
                        }
                    }, new Realm.Transaction.OnSuccess() {

                        @Override
                        public void onSuccess() {
                            view.updateData();
                        }
                    });
                } else {
                    try {
                        JSONObject error = new JSONObject(response.errorBody().string());
                        view.onFailure(error.getString("msg"));
                    } catch (JSONException e) {
                        view.onFailure(e.getMessage());
                    } catch (IOException e) {
                        view.onFailure(e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<WeatherResponse> call, @NonNull Throwable t) {
                view.onFailure(t.getMessage());
            }
        });
    }

    public void sendGetWeatherData(String lat , String lon) {
        WeatherWebService service = retrofit.create(WeatherWebService.class);
        Call<WeatherResponse> call = service.getCurrentWeatherData(lat, lon, APPID);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(@NonNull Call<WeatherResponse> call,
                                   @NonNull Response<WeatherResponse> response) {
                if (response.isSuccessful()) {
                    final WeatherResponse responseBody = response.body();
                    realm.executeTransactionAsync(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            realm.copyToRealmOrUpdate(responseBody,
                                    ImportFlag.CHECK_SAME_VALUES_BEFORE_SET);
                        }
                    }, new Realm.Transaction.OnSuccess() {

                        @Override
                        public void onSuccess() {
                            view.updateData();
                        }
                    });
                } else {
                    try {
                        JSONObject error = new JSONObject(response.errorBody().string());
                        view.onFailure(error.getString("msg"));
                    } catch (JSONException e) {
                        view.onFailure(e.getMessage());
                    } catch (IOException e) {
                        view.onFailure(e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<WeatherResponse> call, @NonNull Throwable t) {
                view.onFailure(t.getMessage());
            }
        });
    }
}
