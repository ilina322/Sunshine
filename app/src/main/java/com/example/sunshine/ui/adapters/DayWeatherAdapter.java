package com.example.sunshine.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunshine.R;
import com.example.sunshine.data.remote.model.WeekForecast;
import com.example.sunshine.ui.vewholders.DayWeatherViewHolder;

import java.util.List;

public class DayWeatherAdapter extends RecyclerView.Adapter<DayWeatherViewHolder> {

    private List<WeekForecast> data;
    private ItemClickListener listener;

    public DayWeatherAdapter(List<WeekForecast> data, ItemClickListener listener){
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DayWeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_daily_weather, parent, false);
        return new DayWeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DayWeatherViewHolder holder, int position) {
        WeekForecast currentWeekForecast = data.get(position);
        holder.bind(currentWeekForecast, listener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface ItemClickListener {
        public void onItemClicked(WeekForecast weekForecast);
    }
}
