package com.codingwithrufat.timetracker.db.builder;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import com.codingwithrufat.timetracker.db.databases.CategoryDatabase;
import com.codingwithrufat.timetracker.db.databases.ProjectDatabase;

public class DatabaseBuilder {

    private static String TAG="MyTagHere";

    public static CategoryDatabase getCategoryDatabase(Context context){

        return Room.databaseBuilder(
                context,
                CategoryDatabase.class,
                "CATEGORY_DB"
        ).allowMainThreadQueries().build();

    }

    public static ProjectDatabase getProjectDatabase(Context context){
        Log.d(TAG, "getProjectDatabase: ");
        return Room.databaseBuilder(
                context,
                ProjectDatabase.class,
                "PROJECT_DB"
        ).allowMainThreadQueries().build();

    }



}
