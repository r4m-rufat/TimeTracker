package com.codingwithrufat.timetracker.time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Time {

    public static String converttounixHour(long dt) {
        Date date=new Date(dt);
        SimpleDateFormat sdf =new SimpleDateFormat("hh:mm:ss");
        String formatted=sdf.format(date);
        return  formatted;
    }
    public static String converttodifferHour() {
        Date date=new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("04:00:00");
        String formatted=sdf.format(date);
        return  formatted;
    }
}

