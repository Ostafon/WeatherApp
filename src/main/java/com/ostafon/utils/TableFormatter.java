package com.ostafon.utils;

import com.ostafon.model.CityForecast;

import java.util.List;

public class TableFormatter {

    public static void printTable(List<CityForecast> forecasts) {
        System.out.print("+-----------+------------+-------------+-------------+-------------+----------------+\n");
        System.out.printf("| %-9s | %-10s | %-11s | %-11s | %-11s | %-14s |\n",
                "City", "Date", "Min Temp °C", "Max Temp °C", "Humidity (%)", "Wind (kph, dir)");
        System.out.print("+-----------+------------+-------------+-------------+-------------+----------------+\n");

        for (CityForecast cf : forecasts) {
            System.out.printf("| %-9s | %-10s | %-11.1f | %-11.1f | %-11d | %-5.1f %-8s |\n",
                    cf.getCityName(), cf.getDate(), cf.getMinTemp(), cf.getMaxTemp(),
                    cf.getHumidity(), cf.getWindSpeed(), cf.getWindDirection());
        }

        System.out.print("+-----------+------------+-------------+-------------+-------------+----------------+\n");
    }
}
