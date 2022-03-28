package com.codingwithrufat.timetracker.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codingwithrufat.timetracker.helper.listener.ClickListener;
import com.codingwithrufat.timetracker.R;
import com.codingwithrufat.timetracker.dataModels.Project;
import com.codingwithrufat.timetracker.db.models.WholeCategory;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAddProject extends RecyclerView.Adapter<RecyclerAddProject.ViewHolder> {

    private Context context;
    private RecyclerView expandaplerecycleview;
    private List<WholeCategory> categoryList;
    private List<Project> list = new ArrayList<>();
    private ClickListener clickListener;

    public RecyclerAddProject(Context context, List<WholeCategory>categoryList,ClickListener clickListener) {
        this.context = context;
        this.categoryList = categoryList;
        this.clickListener=clickListener;
    }

    @NonNull
    @Override
    public RecyclerAddProject.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_add_project_category_items, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerAddProject.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.category_name.setText(categoryList.get(position).getName());
        holder.card_category_color.setCardBackgroundColor(categoryList.get(position).getColor_code());
        boolean expand=categoryList.get(position).isExpand();
        holder.expandedlinear.setVisibility(expand? View.VISIBLE:View.GONE);
        if (categoryList.get(position).isExpand()) {
            holder.arrowdown.setBackgroundResource(R.drawable.ic_arrow_up);
        } else {
            holder.arrowdown.setBackgroundResource(R.drawable.ic_arrow_down);
        }

        expandaplerecycleview.setHasFixedSize(true);
        expandaplerecycleview.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        expandaplerecycleview.setAdapter(new ProjectsAdapter(context,
                list,
                clickListener

        ));

        holder.arrowdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                categoryList.get(position).setExpand(!categoryList.get(position).isExpand());
                if (categoryList.get(position).isExpand()) {
                    holder.arrowdown.setBackgroundResource(R.drawable.ic_arrow_up);
                } else {
                    holder.arrowdown.setBackgroundResource(R.drawable.ic_arrow_down);
                }

                list = categoryList.get(position).getProjects();
                notifyItemChanged(position);
            }

        });

        holder.add_project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("coming_project", true);
                bundle.putInt("category_id", categoryList.get(position).getCategory_id());
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_addFragment, bundle);
            }
        });


    }

    @Override
    public int getItemCount() {
        if (!categoryList.isEmpty()) {
            return categoryList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView category_name;
        ImageView add_project;
        CardView card_category_color;
        ImageView arrowdown;
        LinearLayout expandedlinear;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            category_name = itemView.findViewById(R.id.txt_categoryName);
            add_project = itemView.findViewById(R.id.icon_addProject);
            card_category_color = itemView.findViewById(R.id.card_categoryColor);
            expandaplerecycleview = itemView.findViewById(R.id.expandablerecyclernewAddProject);
            arrowdown = itemView.findViewById(R.id.imgArrowDown);
            expandedlinear=itemView.findViewById(R.id.linearexpanded);
        }

    }
}

