package com.codingwithrufat.timetracker.db.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "PROJECT_TABLE")
public class Project {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private Integer category_id;
    private String name;
    private String color_code;
    private Integer start;
    private Integer end;

    public Project(Integer id, Integer category_id, String name, String color_code, Integer start, Integer end) {
        this.id = id;
        this.category_id = category_id;
        this.name = name;
        this.color_code = color_code;
        this.start = start;
        this.end = end;
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

    public String getColor_code() {
        return color_code;
    }

    public void setColor_code(String color_code) {
        this.color_code = color_code;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
