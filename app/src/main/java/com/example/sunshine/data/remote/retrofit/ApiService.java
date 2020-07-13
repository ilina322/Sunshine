package com.example.sunshine.data.remote.retrofit;

import com.example.sunshine.data.remote.model.WeekForecastResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiService {

    public static final String BASE_URL = "http://api.openweathermap.org";
    public static final String API_KEY = "fc7bf5e5267b5a5dcd69386c8bff4023";

    @GET("/data/2.5/onecall")
    Call<WeekForecastResponse> getWeekForecast(@Query("lat") double lat,
                                               @Query("lon") double lon,
                                               @Query("units") String units,
                                               @Query("exclude") String exclude,
                                               @Query("appid") String apiKey);
}
