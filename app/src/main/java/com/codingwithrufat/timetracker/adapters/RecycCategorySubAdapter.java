package com.codingwithrufat.timetracker.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codingwithrufat.timetracker.R;
import com.codingwithrufat.timetracker.db.models.Category;
import com.codingwithrufat.timetracker.db.models.Project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecycCategorySubAdapter extends RecyclerView.Adapter<RecycCategorySubAdapter.ViewHolder>{
    List<Category> subList;

    public RecycCategorySubAdapter(List<Category> list){
        subList=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_category,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setBackgroundColor(subList.get(position).getColor_code());
        //TODO add time to the timer from Database
        holder.category.setText(subList.get(position).getColor_code());


        //TODO to format long value, use the getTimerAsFormat method below
    }

    private String getTimerAsFormat(Long start) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date resultDate = new Date(start);
        return sdf.format(resultDate);
    }

    @Override
    public int getItemCount() {
        return subList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView category,timer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.categories);
            timer = itemView.findViewById(R.id.cTimer);
            imageView = itemView.findViewById(R.id.color_category);
        }
    }
}
