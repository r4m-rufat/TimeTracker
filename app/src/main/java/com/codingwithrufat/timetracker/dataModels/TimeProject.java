package com.codingwithrufat.timetracker.dataModels;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TIME_PROJECT_TABLE")
public class TimeProject {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private Integer category_id;
    private String name;
    private Integer color_code;
    private String project_date;
    private String project_running_time;

    public TimeProject(Integer id, Integer category_id, String name, Integer color_code, String project_date, String project_running_time) {
        this.id = id;
        this.category_id = category_id;
        this.name = name;
        this.color_code = color_code;
        this.project_date = project_date;
        this.project_running_time = project_running_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getColor_code() {
        return color_code;
    }

    public void setColor_code(Integer color_code) {
        this.color_code = color_code;
    }

    public String getProject_date() {
        return project_date;
    }

    public void setProject_date(String project_date) {
        this.project_date = project_date;
    }

    public String getProject_running_time() {
        return project_running_time;
    }

    public void setProject_running_time(String project_running_time) {
        this.project_running_time = project_running_time;
    }
}
