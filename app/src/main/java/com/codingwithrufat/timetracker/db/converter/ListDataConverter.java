package com.codingwithrufat.timetracker.db.converter;

import androidx.room.TypeConverter;

import com.codingwithrufat.timetracker.db.models.Project;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.List;

public class ListDataConverter {
    @TypeConverter
    public String fromOptionValuesList(List<Project>projects) {
        if (projects == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Project>>() {
        }.getType();
        String json = gson.toJson(projects, type);
        return json;
    }

    @TypeConverter
    public List<Project> toOptionValuesList(String projectvalueString) {
        if ( projectvalueString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Project>>() {
        }.getType();
        List<Project> projectList = gson.fromJson(projectvalueString, type);
        return projectList;
    }

}
