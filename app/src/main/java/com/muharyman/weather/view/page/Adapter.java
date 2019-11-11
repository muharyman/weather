package com.muharyman.weather.view.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.muharyman.weather.R;
import com.muharyman.weather.service.WeatherResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<WeatherResponse> weatherData;
    private Context context;
    private Realm realm = Realm.getDefaultInstance();

    public Adapter(Context context, List<WeatherResponse> weatherData) {
        this.weatherData = weatherData;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_fragment2, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        WeatherResponse currentData = weatherData.get(position);
        holder.bindTo(currentData);
    }

    @Override
    public int getItemCount() {
        return weatherData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.kota_history)
        TextView kotaHistory;
        @BindView(R.id.cuaca_history)
        TextView cuacaHistory;
        @BindView(R.id.suhu_history)
        TextView suhuHistory;
        @BindView(R.id.tanggal_history)
        TextView tanggalHistory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindTo(WeatherResponse currentData) {
            kotaHistory.setText(currentData.name);
            cuacaHistory.setText(currentData.weather.get(0).description);
            suhuHistory.setText(String.valueOf(currentData.main.temp));
            tanggalHistory.setText(String.valueOf(currentData.date));

        }

    }

    public void getFromDatabase() {
        final RealmResults<WeatherResponse> templistData;
        weatherData.clear();
        if (!realm.isEmpty()) {
            templistData = WeatherResponse.getQuery(realm);
            templistData.addChangeListener(new RealmChangeListener<RealmResults<WeatherResponse>>() {
                @Override
                public void onChange(RealmResults<WeatherResponse> datas) {
                    if (!templistData.isEmpty()) {
                        weatherData.addAll(templistData);
                        notifyDataSetChanged();
                    }
                }
            });
        }
    }
}
