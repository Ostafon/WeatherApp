package com.ostafon.model;

import java.util.List;



public class ForecastResponse {
    private Forecast forecast;
    public Forecast getForecast() {
        return forecast;
    }

    public static class Forecast {
        private List<ForecastDay> forecastday;

        public List<ForecastDay> getForecastday() {
            return forecastday;
        }
    }
}
