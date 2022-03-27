package com.codingwithrufat.timetracker.adapters;

import android.content.Context;
import android.graphics.Color;
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
import com.codingwithrufat.timetracker.db.models.Category;
import com.codingwithrufat.timetracker.db.models.Project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecycCategorySubAdapter extends RecyclerView.Adapter<RecycCategorySubAdapter.ViewHolder>{
    List<Category> subList;
    Context mContext;

    public RecycCategorySubAdapter(List<Category> list,Context context){
        subList=list;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_category,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        changeColorOfTargetResourceFile(subList.get(position).getColor_code());
        holder.imageView.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.selected_colors));
        //TODO add time to the timer from Database
        holder.category.setText(subList.get(position).getName());
        //TODO to format long value, use the getTimerAsFormat method below(There is no any data timers to format)
    }

    private void changeColorOfTargetResourceFile(int targetColor) {
        Drawable unwrappedDrawable = AppCompatResources.getDrawable(mContext, R.drawable.selected_colors);
        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
        DrawableCompat.setTint(wrappedDrawable, targetColor);
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
