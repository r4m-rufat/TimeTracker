package com.codingwithrufat.timetracker.db.databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.codingwithrufat.timetracker.dataModels.TimeCategory;
import com.codingwithrufat.timetracker.db.daos.TimeCategoryDao;

@Database(entities = {TimeCategory.class}, version = 1, exportSchema = false)
public abstract class TimeCategoryDatabase extends RoomDatabase {

    public abstract TimeCategoryDao getTimeCategoryDao();

}
