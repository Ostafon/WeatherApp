package com.ostafon;

import com.ostafon.model.CityForecast;
import com.ostafon.model.ForecastDay;
import com.ostafon.model.ForecastResponse;
import com.ostafon.service.WeatherService;
import com.ostafon.utils.TableFormatter;
import io.github.cdimascio.dotenv.Dotenv;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static Dotenv dotenv = Dotenv.load();
    private final static String API_KEY = dotenv.get("API_KEY");
    private final static String base_url = dotenv.get("BASE_URL");
    private final static String[] CITIES = {"Chisinau", "Madrid", "Kyiv", "Amsterdam"};
    private final static List<CityForecast> forecasts = new ArrayList<>();

    public static void main(String[] args) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService service = retrofit.create(WeatherService.class);
        getCitiesForecast(service);
        TableFormatter.printTable(forecasts);

    }

    private static void getCitiesForecast(WeatherService service) {
        for(String city : CITIES) {
            try {
                ForecastResponse response = service.getForecast(API_KEY, city, 2).execute().body();

                if(response != null && response.getForecast() != null) {
                    ForecastDay nextDay = response.getForecast().getForecastday().get(1);

                    double windKph = nextDay.getHour().get(15).getWindKph();
                    String windDir = nextDay.getHour().get(15).getWindDir();

                    Main.forecasts.add(new CityForecast(
                            city,
                            nextDay.getDate(),
                            nextDay.getDay().getMaxtemp_c(),
                            nextDay.getDay().getMintemp_c(),
                            nextDay.getDay().getAvghumidity(),
                            windKph,
                            windDir
                    ));
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}