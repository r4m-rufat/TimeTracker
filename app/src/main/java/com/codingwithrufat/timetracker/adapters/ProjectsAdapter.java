package com.codingwithrufat.timetracker.adapters;

import android.content.Context;
import android.content.pm.LabeledIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codingwithrufat.timetracker.R;
import com.codingwithrufat.timetracker.db.models.Category;
import com.codingwithrufat.timetracker.db.models.Project;

import java.util.List;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ViewHolder>{

    Context context;
    List<Project>projects;
    List<Category>categoryList;

    public ProjectsAdapter(List<Category> categoryList, Context context, List<Project>projects) {
        this.context = context;
        this.projects = projects;
        this.categoryList=categoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_add_new_project_caterogy_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

                       holder.projectName.setText(projects.get(position).getName());

    }

    @Override
    public int getItemCount() {
        if (projects.isEmpty())return 0;
        return projects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView projectName,project_time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            project_time=itemView.findViewById(R.id.project_time);
            projectName=itemView.findViewById(R.id.txt_new_projectname);
        }
    }
}
