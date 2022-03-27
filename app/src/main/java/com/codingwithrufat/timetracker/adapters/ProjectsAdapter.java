package com.codingwithrufat.timetracker.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codingwithrufat.timetracker.listener.ClickListener;
import com.codingwithrufat.timetracker.R;
import com.codingwithrufat.timetracker.db.builder.DatabaseBuilder;
import com.codingwithrufat.timetracker.db.daos.ProjectDao;
import com.codingwithrufat.timetracker.dataModels.Project;
import com.codingwithrufat.timetracker.time.Time;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ViewHolder>{
    Context context;
    List<Project>projects;
    ClickListener clickListener;
    ProjectDao projectDao;

    public ProjectsAdapter( Context context, List<Project>projects,ClickListener clickListener) {
        this.context = context;
        this.projects = projects;
        this.clickListener=clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_add_new_project_caterogy_items,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

                       holder.projectName.setText(projects.get(position).getName());
                       holder.relativeLayout.setBackgroundColor(projects.get(position).getColor_code());
                       if (projects.get(position).getEnded()!=null)
                           holder.project_time.setText(Time.converttounixHour(projects.get(position).getEnded()));
                       if (projects.get(position).getStart()!=null)
                           holder.project_time.setText(Time.converttounixHour(projects.get(position).getStart()));
                       if (projects.get(position).getStart()!=null && projects.get(position).getEnded()!=null)
                           holder.project_time.setText(Time.converttounixHour(projects.get(position).getEnded()-projects.get(position).getStart()));
                       if (!projects.get(position).isPlaying()){
                           holder.startOrstop.setBackgroundResource(R.drawable.ic_start_play);
                       }
                       else {
                           holder.startOrstop.setBackgroundResource(R.drawable.ic_start);
                       }



                       holder.startOrstop.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {

                               boolean project_playing=projects.get(position).isPlaying();
                               projects.get(position).setPlaying(!project_playing);
                               if (!projects.get(position).isPlaying()){
                                   holder.startOrstop.setBackgroundResource(R.drawable.ic_start_play);
                                   projects.get(position).setEnded(System.currentTimeMillis());
                               }
                               else {
                                   holder.startOrstop.setBackgroundResource(R.drawable.ic_start);
                               }

                               update_projects(position);
                               setTimer(holder,position);
                           }

                       });


    }

    private void setTimer(ViewHolder holder, int position) {
        Timer timer = new Timer();
        TimerTask t = new TimerTask() {
            @Override
            public void run() {

            }
        };
    }

    private void update_projects(int position) {
        projectDao=DatabaseBuilder
                .getProjectDatabase(context)
                .getProjectDao();
        projectDao.updateproject(projects.get(position).isPlaying(),projects.get(position).getName(),projects.get(position).getStart(),projects.get(position).getEnded());
        if (projects.get(position).getStart()==null){
            projects.get(position).setStart(System.currentTimeMillis());
            projectDao.updateproject(projects.get(position).isPlaying(),projects.get(position).getName(),projects.get(position).getStart(), null);
        }

            clickListener.onClick(projects.get(position).getName(),
                    projects.get(position).getColor_code(),
                    projects.get(position).getStart(),
                    projects.get(position).getEnded(),
                    projects.get(position).isPlaying());


    }

    @Override
    public int getItemCount() {
        if (projects.isEmpty())return 0;
        return projects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView projectName,project_time;
        RelativeLayout relativeLayout;
        ImageView startOrstop;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            project_time=itemView.findViewById(R.id.project_time);
            projectName=itemView.findViewById(R.id.txt_new_projectname);
            relativeLayout=itemView.findViewById(R.id.relativ_projects);
            startOrstop=itemView.findViewById(R.id.startorstop);
        }
    }
}
