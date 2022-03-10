package com.codingwithrufat.timetracker.db.databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.codingwithrufat.timetracker.db.daos.ProjectDao;
import com.codingwithrufat.timetracker.db.models.Project;

@Database(entities = {Project.class}, version = 1)
abstract class ProjectDatabase extends RoomDatabase {

    public abstract ProjectDao getDao();
    private ProjectDatabase INSTANCE = null;
    public ProjectDatabase getProjectDatabase(Context context){

        if (INSTANCE == null){

            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ProjectDatabase.class,
                    "CATEGORY_DB"
            ).allowMainThreadQueries().build();

        }

        return INSTANCE;

    }

}
