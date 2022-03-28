package com.codingwithrufat.timetracker.helper.timer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConverter {

    public static String convertToHourFormat(long dt) {
        Date date = new Date(dt);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        String formatted = sdf.format(date);
        return formatted;
    }

    public static String calculateDifferenceAndConvertHourFormat(long start, long end) {
        int time_diff = (int) (end - start) / 1000;
        int hour = time_diff / 3600;
        int minutes = (time_diff - (hour * 3600)) / 60;
        int seconds = time_diff % 60;
        return digitFormat(hour) + ":" + digitFormat(minutes) + ":" + digitFormat(seconds);
    }

    private static String digitFormat(int digit) {
        return digit < 9 ? ("0" + digit) : "" + digit;
    }

    public static String convertToDateFormat(long date_time) {
        Date date = new Date(date_time);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String formatted = sdf.format(date);
        return formatted;
    }

}

