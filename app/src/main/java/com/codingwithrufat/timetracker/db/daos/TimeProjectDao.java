package com.codingwithrufat.timetracker.db.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.codingwithrufat.timetracker.dataModels.Project;
import com.codingwithrufat.timetracker.dataModels.TimeProject;

import java.util.List;

@Dao
public interface TimeProjectDao {

    @Query("SELECT * FROM TIME_PROJECT_TABLE ORDER BY id DESC")
    List<TimeProject> getAllProjects();

    @Insert
    void insertProject(TimeProject timeProject);

    @Query("SELECT DISTINCT project_date FROM TIME_PROJECT_TABLE ORDER BY id DESC")
    List<String> getUniqueDateProject();

    @Query("SELECT * FROM TIME_PROJECT_TABLE WHERE project_date = :date")
    List<TimeProject> getDataDueToDateProject(String date);

}
