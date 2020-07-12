package com.example.sunshine.data.remote.retrofit;

import com.example.sunshine.data.remote.model.WeekForecastResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiWrapper {

    private ApiService service;
    private ServiceListener<WeekForecastResponse> serviceListener;

    public ApiWrapper(ApiService service){
        this.service = service;
    }

    /**
     @param location city and ISO country code, example: "london,uk"
     @param aggregateHours The interval between weather forecast data in the output. 1 means hourly forecast, 24 means daily forecast
     @param unitGroup The system of units used for the output data. Supported values are us,uk,metric.
     @param contentType Can be json or csv
     */
    public void getWeekForecast(String location,
                                int aggregateHours,
                                String unitGroup,
                                String contentType,
                                final ServiceListener<WeekForecastResponse> listener){
        service.getWeekForecast(location, aggregateHours, unitGroup, contentType).enqueue(new Callback<WeekForecastResponse>() {
            @Override
            public void onResponse(Call<WeekForecastResponse> call, Response<WeekForecastResponse> response) {
                if(response.isSuccessful()){
                    listener.onDataReceived(response.body());
                }
            }

            @Override
            public void onFailure(Call<WeekForecastResponse> call, Throwable t) {
                listener.onErrorReceived(t.toString());
            }
        });
    }

    public interface ServiceListener<T>{
        public void onDataReceived(T data);
        public void onErrorReceived(String error);
    }
}
