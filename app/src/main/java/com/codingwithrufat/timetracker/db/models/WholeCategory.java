package com.codingwithrufat.timetracker.db.models;

import com.codingwithrufat.timetracker.dataModels.Project;

import java.util.ArrayList;
import java.util.List;

public class WholeCategory {
    private Integer category_id;
    private String name;
    private Integer color_code;
    private boolean expand;
    private List<Project>projects=new ArrayList<>();


    public WholeCategory(Integer category_id, String name, Integer color_code,boolean expand,List<Project>projects) {
        this.category_id = category_id;
        this.name = name;
        this.color_code = color_code;
        this.expand=false;
        this.projects=projects;
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

    public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
