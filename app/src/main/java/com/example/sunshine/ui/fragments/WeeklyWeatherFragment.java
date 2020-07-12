package com.example.sunshine.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunshine.R;
import com.example.sunshine.data.model.DailyWeather;
import com.example.sunshine.ui.adapters.DayWeatherAdapter;
import com.example.sunshine.utils.NavigationManager;

import java.util.ArrayList;
import java.util.List;

public class WeeklyWeatherFragment extends Fragment implements DayWeatherAdapter.ItemClickListener {

    private RecyclerView recDays;
    private RecyclerView.Adapter daysAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<DailyWeather> dummyData;
    private DailyWeather dummyToday;

    public static WeeklyWeatherFragment newInstance() {
        return new WeeklyWeatherFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //TODO: switch data from the following method with real data from api
        setDummyData();

        View view = inflater.inflate(R.layout.fragment_weekly_weather, container, false);
        setupDaysRecView(view);
        setupTodayViews(view);
        return view;
    }

    private void setupDaysRecView(View view) {
        recDays = (RecyclerView) view.findViewById(R.id.rec_days);
        recDays.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recDays.setLayoutManager(layoutManager);
        daysAdapter = new DayWeatherAdapter(dummyData, this);
        recDays.setAdapter(daysAdapter);
    }

    private void setupTodayViews(View view){
        TextView txtTemperature = view.findViewById(R.id.txt_today_temperature);
        ImageView imgCondition = view.findViewById(R.id.img_today_condition);
        double todayTemperature = dummyToday.getAvgTemperature();
        String todayCondition = dummyToday.getCondition();
        String formatTodayTemperature = todayTemperature + getString(R.string.celsius);
        txtTemperature.setText(formatTodayTemperature);
        imgCondition.setImageResource(R.drawable.ic_cloudy_day);
    }

    @Override
    public void onItemClicked(DailyWeather dailyWeather) {
        NavigationManager.getInstance().openDayWeatherScreen(dailyWeather.getDate());
    }


    private void setDummyData() {
        dummyData = new ArrayList<DailyWeather>();

        DailyWeather dummy1 = new DailyWeather();
        DailyWeather dummy2 = new DailyWeather();
        DailyWeather dummy3 = new DailyWeather();

        dummy1.setAvgTemperature(9.8);
        dummy2.setAvgTemperature(18.5);
        dummy3.setAvgTemperature(26);

        dummy1.setDate(1594684800000L);
        dummy2.setDate(1594598400000L);
        dummy3.setDate(1594512000000L);

        dummy1.setCondition("");
        dummy1.setCondition("");
        dummy1.setCondition("");

        dummyData.add(dummy2);
        dummyData.add(dummy3);

        dummyToday = dummy1;
    }
}
