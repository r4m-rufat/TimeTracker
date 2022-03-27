package com.codingwithrufat.timetracker.db.models;

import java.util.List;

public class RunningProjects {
    private String name;
    private Integer color_code;
    private Long start;
    private Long end;
    private boolean playing;

    public RunningProjects(String name,Integer color_code,Long start,Long end,boolean playing) {
        this.name = name;
        this.color_code=color_code;
        this.start=start;
        this.end=end;
        this.playing=playing;
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

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
}
