package com.example.sunshine.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunshine.R;
import com.example.sunshine.data.model.DailyWeather;
import com.example.sunshine.ui.vewholders.DayWeatherViewHolder;

import java.util.ArrayList;
import java.util.List;

public class DayWeatherAdapter extends RecyclerView.Adapter<DayWeatherViewHolder> {

    private List<DailyWeather> data;

    public DayWeatherAdapter(List<DailyWeather> data){
        this.data = data;
    }

    @NonNull
    @Override
    public DayWeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_daily_weather, parent, false);
        DayWeatherViewHolder viewHolder = new DayWeatherViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DayWeatherViewHolder holder, int position) {
        DailyWeather currentDailyWeather = data.get(position);
        double temperature = currentDailyWeather.getAvgTemperature();
        long date = currentDailyWeather.getDate();
        String condition = currentDailyWeather.getCondition();
        holder.setTemperature(temperature);
        holder.setDay(date);
        holder.setConditionImage(condition);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
