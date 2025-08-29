package com.ostafon.model;

import java.util.List;

public class ForecastDay {
    private String date;
    private Day day;
    private List<Hour> hour;

    public String getDate() {
        return date;
    }

    public Day getDay() {
        return day;
    }
    public List<Hour> getHour() {
        return hour;
    }
}
