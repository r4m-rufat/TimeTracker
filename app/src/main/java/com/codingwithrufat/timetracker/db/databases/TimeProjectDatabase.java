package com.codingwithrufat.timetracker.db.databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.codingwithrufat.timetracker.dataModels.TimeProject;
import com.codingwithrufat.timetracker.db.daos.TimeProjectDao;

@Database(entities = {TimeProject.class}, version = 1, exportSchema = false)
public abstract class TimeProjectDatabase extends RoomDatabase {

    public abstract TimeProjectDao getTimeProjectDao();

}
