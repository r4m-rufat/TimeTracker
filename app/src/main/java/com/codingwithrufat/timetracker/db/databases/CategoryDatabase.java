package com.codingwithrufat.timetracker.db.databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.codingwithrufat.timetracker.db.daos.CategoryDao;
import com.codingwithrufat.timetracker.db.models.Category;

@Database(entities = {Category.class}, version = 1, exportSchema = false)
public abstract class CategoryDatabase extends RoomDatabase {

    public abstract CategoryDao getCategoryDao();

}
