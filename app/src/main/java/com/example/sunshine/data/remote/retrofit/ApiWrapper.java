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
     @param lat latitude
     @param lon longitude
     @param units temperature is available in Fahrenheit, Celsius and kelvin units.

     For temperature in Fahrenheit, units=imperial
     For temperature in Celsius, units=metric
     Kelvin is used by default, so there is no need to use the units parameter in the API call if you want this

     @param exclude exclude some parts of the weather data from the API response. It should be a comma-delimited list (without spaces).
     Available values:
         current
         minutely
         hourly
         daily

     */
    public void getWeekForecast(double lat,
                                double lon,
                                String units,
                                String exclude,
                                final ServiceListener<WeekForecastResponse> listener){
        service.getWeekForecast(lat, lon, units, exclude, ApiService.API_KEY).enqueue(new Callback<WeekForecastResponse>() {
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
