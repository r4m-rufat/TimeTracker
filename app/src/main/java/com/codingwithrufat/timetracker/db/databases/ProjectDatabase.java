package com.codingwithrufat.timetracker.db.databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.codingwithrufat.timetracker.db.daos.ProjectDao;
import com.codingwithrufat.timetracker.db.models.Project;

@Database(entities = {Project.class}, version = 1, exportSchema = false)
public abstract class ProjectDatabase extends RoomDatabase {

    public abstract ProjectDao getProjectDao();

}
