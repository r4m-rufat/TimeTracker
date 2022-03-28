package com.codingwithrufat.timetracker.helper.listener;

public interface ClickListener {
     void onClick(String name,Integer color_code,Long start,Long end,boolean playing);
     void onClick_Refresh();

}
