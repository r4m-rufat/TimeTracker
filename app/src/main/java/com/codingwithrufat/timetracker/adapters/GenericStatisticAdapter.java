package com.codingwithrufat.timetracker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codingwithrufat.timetracker.R;
import com.codingwithrufat.timetracker.dataModels.Category;
import com.codingwithrufat.timetracker.dataModels.Project;
import com.codingwithrufat.timetracker.db.builder.DatabaseBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GenericStatisticAdapter extends RecyclerView.Adapter<GenericStatisticAdapter.ViewHolder>{
    boolean isProjectSection;
    String dueTo;
    private List<Project> projectList;
    private List<Category> categoryList;
    private Context mContext;

    public GenericStatisticAdapter(Context context, boolean isProjectSection, String dueTo){
        this.isProjectSection = isProjectSection;
        this.dueTo = dueTo;
        mContext = context;
        projectList = DatabaseBuilder.getProjectDatabase(context).getProjectDao().getAllProjects();
        categoryList = DatabaseBuilder.getCategoryDatabase(context).getCategoryDao().getAllCategories();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(isProjectSection){
            holder.date.setText(getFormatDate(projectList.get(position).getStart()));
            RecycProjectSubAdapter subAdapter = new RecycProjectSubAdapter(projectList,mContext);
            holder.myRecyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
            holder.myRecyclerView.setAdapter(subAdapter);
        }else{
            //TODO assign date from categoryList database
            RecycCategorySubAdapter subAdapter = new RecycCategorySubAdapter(categoryList,mContext);
            holder.myRecyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
            holder.myRecyclerView.setAdapter(subAdapter);

        }
    }

    private String getFormatDate(long myTimer) {
        if(dueTo == "daily"){
            SimpleDateFormat sdf = new SimpleDateFormat("dd");
            Date resultDate = new Date(myTimer);
            return sdf.format(resultDate);
        }else if(dueTo == "weekly"){
            SimpleDateFormat sdf = new SimpleDateFormat("EEE");
            Date resultDate = new Date(myTimer);
            return sdf.format(resultDate);
        }else{
            SimpleDateFormat sdf = new SimpleDateFormat("MM");
            Date resultDate = new Date(myTimer);
            return sdf.format(resultDate);
        }

    }

    @Override
    public int getItemCount() {
        if(isProjectSection){
            return projectList.size();
        }else{
            return categoryList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView date;
        RecyclerView myRecyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myRecyclerView = itemView.findViewById(R.id.subRecyclerView);
            date = itemView.findViewById(R.id.projectTime);
        }
    }
}
