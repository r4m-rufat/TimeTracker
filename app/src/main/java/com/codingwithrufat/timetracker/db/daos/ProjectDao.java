package com.codingwithrufat.timetracker.db.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.codingwithrufat.timetracker.db.models.Category;
import com.codingwithrufat.timetracker.db.models.Project;

import java.util.List;

@Dao
public interface ProjectDao {

    @Query("SELECT * FROM PROJECT_TABLE ORDER BY id DESC")
    List<Project> getAllProjects();

    @Insert
    void insertProject(Project project);



}
