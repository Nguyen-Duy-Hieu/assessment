package com.calendar.pages;

import com.calendar.constants.PropertyConstants;
import com.calendar.utils.APPHelper;
import com.calendar.utils.ReadPropertiesFile;
import com.calendar.utils.WeatherAPI;
import org.apache.log4j.Logger;
import org.json.JSONObject;

public class WeatherToday {
    private static final Logger LOG = Logger.getLogger(APPHelper.class);
    private static float SWITCH_TO_CELCIUS = 273.15f;
    private JSONObject weather;

    public void getCurrentWeather(String city){
        weather = WeatherAPI.getCurrentWeather(city
                , ReadPropertiesFile.GetProperty(PropertyConstants.USER_APP_KEY));
    }

    public float getDegree(){
        return weather.getJSONObject("main").getFloat("temp") -SWITCH_TO_CELCIUS;
    }

    public String getCity(){
        return weather.getJSONObject("sys").getString("name");
    }
}
