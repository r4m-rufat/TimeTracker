package com.codingwithrufat.timetracker.db.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "CATEGORY_TABLE")
public class Category {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String name;
    private Integer color_code;

    public Category(String name, Integer color_code) {
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

    public Integer getColor_code() {
        return color_code;
    }

    public void setColor_code(Integer color_code) {
        this.color_code = color_code;
    }
}

