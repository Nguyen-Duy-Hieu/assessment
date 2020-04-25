package com.calendar.utils;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class WeatherAPI {
    private static final String FORECAST5 = "http://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s";
    private static final String TODAY = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";
    private static String response, inputLine;

    public static JSONObject getForecast5(String city, String appID) {
        return query(String.format(FORECAST5, city, appID));
    }

    public static JSONObject getCurrentWeather(String city, String appID) {
        return query(String.format(TODAY, city, appID));
    }

    private static JSONObject query(String url){
        response = "";
        BufferedReader in=null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(new URL(url).openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!((inputLine = in.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            response += inputLine;
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new JSONObject(response);
    }
}
