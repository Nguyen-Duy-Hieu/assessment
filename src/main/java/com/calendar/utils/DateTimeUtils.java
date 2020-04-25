package com.calendar.utils;

import com.calendar.constants.PropertyConstants;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtils {
    public enum UTC {
        UTC10;

        @Override
        public String toString(){
            switch (this){
                case UTC10: return "UTC+7";
                default: return "Please define it";
            }
        }
    }

    private static final String DEFAULT_DATE_FORMAT = "yyyy/MM/dd";
    private static DateTimeFormatter dtf;

    private static String getCurrentDateDueToUTC(UTC utc) {
        Date date = new Date();
        dtf = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
        LocalDateTime localDate;
        localDate = date.toInstant().atZone(ZoneId.of(utc.toString())).toLocalDateTime();
        return localDate.format(dtf);
    }

    /*
        get current date Sydney
     */

    public static String getCurrentDateSydney(){
        return getCurrentDateDueToUTC(UTC.UTC10);
    }

    /*
        is weekend
        date is format "yyyy-MM-dd"
     */

    public static boolean isWeekend(String date){
        dtf = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
        LocalDate localDate = LocalDate.parse(date, dtf);
        if (localDate.getDayOfWeek() == DayOfWeek.SATURDAY || localDate.getDayOfWeek() == DayOfWeek.SUNDAY)
            return true;
        else
            return false;
    }

    /*
        define a list holiday in calendar properties
        each date spit by comma
     */

    public static boolean isHoliday(String date){
        String holiday = ReadPropertiesFile.GetProperty(PropertyConstants.HOLIDAY);
        return holiday.indexOf(date) > -1;
    }
}
