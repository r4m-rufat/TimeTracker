package com.codingwithrufat.timetracker.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codingwithrufat.timetracker.R;
import com.codingwithrufat.timetracker.dataModels.Category;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecycCategoryAdapter extends RecyclerView.Adapter<RecycCategoryAdapter.ViewHolder>{
    private String TAG="MyTagHere";
    private List<Category> myList;
    Context context;

    public RecycCategoryAdapter(List<Category> list,Context context){
        myList=list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: we are here!");

        //TODO add date to the date section from Database with the help of getDate method(there is no any date in the Room database)


        //assigning of subRecyclerView
        RecycCategorySubAdapter subAdapter=new RecycCategorySubAdapter(myList,context);
        holder.subRecyclerView_category.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        holder.subRecyclerView_category.setAdapter(subAdapter);
    }

    private String getDate(Long start) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        Date resultDate = new Date(start);
        return sdf.format(resultDate);

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView date;
        RecyclerView subRecyclerView_category;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.projectTime);
            subRecyclerView_category=itemView.findViewById(R.id.subRecyclerView);
        }
    }
}
