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
import com.codingwithrufat.timetracker.dataModels.Project;
import com.codingwithrufat.timetracker.dataModels.TimeProject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecycProjectAdapter extends RecyclerView.Adapter<RecycProjectAdapter.ViewHolder>{
    private String TAG="MyTagHere";
    private List<TimeProject> myList;
    private Context context;

    public RecycProjectAdapter(List<TimeProject> list, Context context){
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
        Log.d(TAG, "onBindViewHolder: we are here!"+ myList.size());


        //date
        String day = getDay(myList.get(position).getProject_date());
        holder.date.setText(day);



        //code for recyclerView
        RecycProjectSubAdapter subAdapter=new RecycProjectSubAdapter(myList,context);
        holder.subRecyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        holder.subRecyclerView.setAdapter(subAdapter);
    }

    private String getDay(String start) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        Date resultDate = new Date(Long.getLong(start));
        return sdf.format(resultDate);

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView date;
        RecyclerView subRecyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.projectTime);
            subRecyclerView=itemView.findViewById(R.id.subRecyclerView);
        }
    }
}
