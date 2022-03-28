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
    List<Project> getAllProjects();

    @Insert
    void insertProject(TimeProject timeProject);

}
