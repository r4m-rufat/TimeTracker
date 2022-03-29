package com.codingwithrufat.timetracker.db.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.codingwithrufat.timetracker.dataModels.Project;
import com.codingwithrufat.timetracker.dataModels.TimeCategory;

import java.util.List;

@Dao
public interface TimeCategoryDao {

    @Query("SELECT * FROM TIME_CATEGORY_TABLE ORDER BY id DESC")
    List<TimeCategory> getAllCategories();

    @Insert
    void insertCategory(TimeCategory timeCategory);

    @Query("SELECT DISTINCT category_date FROM TIME_CATEGORY_TABLE ORDER BY id DESC")
    List<String> getUniqueDateCategory();

    @Query("SELECT * FROM TIME_CATEGORY_TABLE WHERE category_date = :date ORDER BY id DESC")
    List<TimeCategory> getDataDueToDateCategory(String date);
}
