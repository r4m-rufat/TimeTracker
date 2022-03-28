package com.codingwithrufat.timetracker.dataModels;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TIME_CATEGORY_TABLE")
public class TimeCategory {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String name;
    private Integer color_code;
    private String category_date;
    private String category_running_time;

    public TimeCategory(Integer id, String name, Integer color_code, String category_date, String category_running_time) {
        this.id = id;
        this.name = name;
        this.color_code = color_code;
        this.category_date = category_date;
        this.category_running_time = category_running_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCategory_date() {
        return category_date;
    }

    public void setCategory_date(String category_date) {
        this.category_date = category_date;
    }

    public String getCategory_running_time() {
        return category_running_time;
    }

    public void setCategory_running_time(String category_running_time) {
        this.category_running_time = category_running_time;
    }
}
