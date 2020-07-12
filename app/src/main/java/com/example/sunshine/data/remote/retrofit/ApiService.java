package com.example.sunshine.data.remote.retrofit;

import com.example.sunshine.data.remote.model.WeekForecastResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface ApiService {

    @Headers("X-RapidAPI-Key: 53eba5c975mshfc8ec24e7f77231p1a9327jsn1757b4429ca1")
    @GET("/forecast")
    Call<WeekForecastResponse> getWeekForecast(@Query("location") String location,
                                               @Query("aggregateHours") int aggregateHours,
                                               @Query("unitGroup") String unitGroup,
                                               @Query("contentType") String contentType);
}
