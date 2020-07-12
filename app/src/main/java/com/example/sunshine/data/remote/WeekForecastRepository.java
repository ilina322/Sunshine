package com.example.sunshine.data.remote;

import com.example.sunshine.data.remote.model.WeekForecastResponse;
import com.example.sunshine.data.remote.retrofit.ApiWrapper;

public interface WeekForecastRepository {

    public void getWeekForecast(String location,
                                int aggregateHours,
                                String unitGroup,
                                String contentType,
                                final DataListener<WeekForecastResponse> listener);

    public interface DataListener<T>{
        public void onData(T data);
        public void onError(String error);
    }
}
