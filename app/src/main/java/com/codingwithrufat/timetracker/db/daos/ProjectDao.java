package com.codingwithrufat.timetracker.db.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.codingwithrufat.timetracker.dataModels.Project;

import java.util.List;

@Dao
public interface ProjectDao {

    @Query("SELECT * FROM PROJECT_TABLE ORDER BY id DESC")
    List<Project> getAllProjects();

    @Insert
    void insertProject(Project project);

    @Update
    void updateproject(Project project);

    @Query("UPDATE project_table SET playing = :playing WHERE name=:name")
    void updateproject(boolean playing,String name);

    @Query("UPDATE project_table SET start= :start,ended=:end,playing = :playing WHERE name=:name")
    void updateproject(boolean playing,String name,Long start,Long end);

}
