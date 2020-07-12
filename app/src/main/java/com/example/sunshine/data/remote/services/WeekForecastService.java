package com.example.sunshine.data.remote.services;

import com.example.sunshine.data.remote.WeekForecastRepository;
import com.example.sunshine.data.remote.model.WeekForecastResponse;
import com.example.sunshine.data.remote.retrofit.ApiWrapper;

public class WeekForecastService implements WeekForecastRepository {

    private ApiWrapper apiWrapper;

    public WeekForecastService(ApiWrapper apiWrapper){
        this.apiWrapper = apiWrapper;
    }

    @Override
    public void getWeekForecast(String location,
                                int aggregateHours,
                                String unitGroup,
                                String contentType,
                                final DataListener<WeekForecastResponse> listener) {

        apiWrapper.getWeekForecast(location, aggregateHours, unitGroup, contentType, new ApiWrapper.ServiceListener<WeekForecastResponse>() {
            @Override
            public void onDataReceived(WeekForecastResponse data) {
                listener.onData(data);
            }

            @Override
            public void onErrorReceived(String error) {
                listener.onError(error);
            }
        });

    }
}
