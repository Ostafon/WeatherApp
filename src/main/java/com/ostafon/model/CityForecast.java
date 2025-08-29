package com.ostafon.model;

public class CityForecast {
    private final String cityName;
    private final String date;
    private final double minTemp;
    private final double maxTemp;
    private final int humidity;
    private final double windSpeed;
    private final String windDirection;

    public CityForecast(String cityName, String date, double minTemp, double maxTemp,
                        int humidity, double windSpeed, String windDirection) {
        this.cityName = cityName;
        this.date = date;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }

    public String getCityName() { return cityName; }
    public String getDate() { return date; }
    public double getMinTemp() { return minTemp; }
    public double getMaxTemp() { return maxTemp; }
    public int getHumidity() { return humidity; }
    public double getWindSpeed() { return windSpeed; }
    public String getWindDirection() { return windDirection; }
}
