package com.codingwithrufat.timetracker.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.codingwithrufat.timetracker.R;
import com.codingwithrufat.timetracker.dataModels.Project;
import com.codingwithrufat.timetracker.dataModels.TimeProject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecycProjectSubAdapter extends RecyclerView.Adapter<RecycProjectSubAdapter.ViewHolder>{
    private List<TimeProject> subList;
    private String TAG = "MyTagHere";
    private Context mContext;

    public RecycProjectSubAdapter(List<TimeProject> list,Context mContext){
        subList=list;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_project,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        changeColorOfTargetResourceFile(subList.get(position).getColor_code());
        holder.timer.setText(getTimerAsFormat(subList.get(position).getProject_date()));
        holder.category.setText(subList.get(position).getCategory_id());
        holder.project.setText(subList.get(position).getName());

    }

    private String getTimerAsFormat(String start) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date resultDate = new Date(Long.getLong(start));
        return sdf.format(resultDate);
    }

    @Override
    public int getItemCount() {
        return subList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView project,category,timer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            project = itemView.findViewById(R.id.projects);
            category = itemView.findViewById(R.id.categoryInProject);
            timer = itemView.findViewById(R.id.pTimer);
            imageView = itemView.findViewById(R.id.color);
        }
    }

    private void changeColorOfTargetResourceFile(int targetColor) {
        Drawable unwrappedDrawable = AppCompatResources.getDrawable(mContext, R.drawable.selected_colors);
        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
        DrawableCompat.setTint(wrappedDrawable, targetColor);
    }
}
