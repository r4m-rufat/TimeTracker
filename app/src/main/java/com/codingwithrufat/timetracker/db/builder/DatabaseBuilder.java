package com.codingwithrufat.timetracker.db.builder;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import com.codingwithrufat.timetracker.db.databases.CategoryDatabase;
import com.codingwithrufat.timetracker.db.databases.ProjectDatabase;
import com.codingwithrufat.timetracker.db.databases.TimeCategoryDatabase;
import com.codingwithrufat.timetracker.db.databases.TimeProjectDatabase;

public class DatabaseBuilder {

    private static String TAG="MyTagHere";

    public static CategoryDatabase getCategoryDatabase(Context context){

        return Room.databaseBuilder(
                context,
                CategoryDatabase.class,
                "CATEGORY_DB"
        ).allowMainThreadQueries()
                .build();

    }

    public static ProjectDatabase getProjectDatabase(Context context){
        return Room.databaseBuilder(
                context,
                ProjectDatabase.class,
                "PROJECT_DB"
        ).allowMainThreadQueries().build();

    }

    public static TimeCategoryDatabase getTimeCategoryDatabase(Context context){

        return Room.databaseBuilder(
                context,
                TimeCategoryDatabase.class,
                "TIME_CATEGORY_DB"
        ).allowMainThreadQueries().build();

    }

    public static TimeProjectDatabase getTimeProjectDatabase(Context context){

        return Room.databaseBuilder(
                context,
                TimeProjectDatabase.class,
                "TIME_PROJECT_DB"
        ).allowMainThreadQueries().build();

    }

}
