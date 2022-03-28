package com.codingwithrufat.timetracker.dataModels;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "PROJECT_TABLE")
public class Project {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private Integer category_id;
    private String name;
    private Integer color_code;
    private Long start;
    private Long ended;
    private boolean playing;

    public Project(Integer category_id, String name, Integer color_code, Long start, Long ended,boolean playing) {
        this.category_id = category_id;
        this.name = name;
        this.color_code = color_code;
        this.start = start;
        this.ended=ended;
        this.playing=playing;
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

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public Long getEnded() {
        return ended;
    }

    public void setEnded(Long ended) {
        this.ended = ended;
    }
}
