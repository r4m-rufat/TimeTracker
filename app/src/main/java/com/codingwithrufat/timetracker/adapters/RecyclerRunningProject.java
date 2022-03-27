package com.codingwithrufat.timetracker.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.codingwithrufat.timetracker.R;
import com.codingwithrufat.timetracker.db.models.RunningProjects;
import com.codingwithrufat.timetracker.time.Time;

import java.util.List;

public class RecyclerRunningProject extends RecyclerView.Adapter<RecyclerRunningProject.ViewHolder> {

    private Context context;
    private List<RunningProjects>runningProjects;

    public RecyclerRunningProject(Context context, List<RunningProjects>runningProjects) {
        this.context = context;
        this.runningProjects =runningProjects;
    }

    @NonNull
    @Override
    public RecyclerRunningProject.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_running_project_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerRunningProject.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
                  holder.runningproject.setText(runningProjects.get(position).getName());
                  holder.cardView.setBackgroundColor(runningProjects.get(position).getColor_code());
                  holder.project_time.setText(Time.converttounixHour(runningProjects.get(position).getEnd()-runningProjects.get(position).getStart()));


    }

    @Override
    public int getItemCount() {
        return runningProjects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         TextView runningproject,project_time;
         CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.project_card);
            project_time=itemView.findViewById(R.id.project_time);
            runningproject=itemView.findViewById(R.id.running_project_name);
        }
    }
}
