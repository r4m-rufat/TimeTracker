package com.codingwithrufat.timetracker.db.databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.codingwithrufat.timetracker.db.daos.CategoryDao;
import com.codingwithrufat.timetracker.db.models.Category;

@Database(entities = {Category.class}, version = 1, exportSchema = false)
abstract class CategoryDatabase extends RoomDatabase {

    public abstract CategoryDao getDao();
    private CategoryDatabase INSTANCE = null;
    public CategoryDatabase getCategoryDatabase(Context context){

        if (INSTANCE == null){

            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    CategoryDatabase.class,
                    "CATEGORY_DB"
            ).allowMainThreadQueries().build();

        }

        return INSTANCE;

    }

}
