package com.ostafon.service;

import com.ostafon.model.ForecastResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface WeatherService {
    @GET("forecast.json")
    Call<ForecastResponse> getForecast(
            @Query("key") String key,
            @Query("q") String city,
            @Query("days") int days
    );
}
