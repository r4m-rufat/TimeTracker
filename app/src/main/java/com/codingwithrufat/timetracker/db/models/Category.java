package com.codingwithrufat.timetracker.db.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "CATEGORY_TABLE")
public class Category {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String name;
    private String color_code;

    public Category(Integer id, String name, String color_code) {
        this.id = id;
        this.name = name;
        this.color_code = color_code;
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

    public String getColor_code() {
        return color_code;
    }

    public void setColor_code(String color_code) {
        this.color_code = color_code;
    }
}

