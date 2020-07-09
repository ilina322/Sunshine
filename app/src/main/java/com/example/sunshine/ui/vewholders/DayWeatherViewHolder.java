package com.example.sunshine.ui.vewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunshine.R;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DayWeatherViewHolder extends RecyclerView.ViewHolder {
    private static final String CELSIUS = "°C";
    public View view;

    public DayWeatherViewHolder(@NonNull View view) {
        super(view);
        this.view = view;
    }

    public void setTemperature(double temperature){
        TextView txtTemperature = (TextView) view.findViewById(R.id.txt_temperature);
        String formatTemperature = temperature + CELSIUS;
        txtTemperature.setText(formatTemperature);
    }

    public void setDay(long date){
        TextView txtDay = (TextView) view.findViewById(R.id.txt_weekday);
        Timestamp timestamp = new Timestamp(date);
        String weekday = (new SimpleDateFormat("EEEE")).format(timestamp.getTime());
        txtDay.setText(weekday);
    }

    public void setConditionImage(String condition){
        ImageView imgCondition = (ImageView) view.findViewById(R.id.img_condition);
        //TODO: set image according to condition, this can be done after finding out what the conditions can be
        imgCondition.setImageResource(R.drawable.ic_moon);
    }
}
