package com.codingwithrufat.timetracker.db.models;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.codingwithrufat.timetracker.db.converter.ListDataConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

@Entity(tableName = "CATEGORY_TABLE")
public class Category {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String name;
    private Integer color_code;
    private boolean expand;

    public Category(Integer id,String name, Integer color_code) {
        this.id=id;
        this.name = name;
        this.color_code = color_code;
        this.expand=false;

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


    public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }


}

