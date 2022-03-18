package com.codingwithrufat.timetracker.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codingwithrufat.timetracker.R;
import com.codingwithrufat.timetracker.db.builder.DatabaseBuilder;
import com.codingwithrufat.timetracker.db.models.Category;
import com.codingwithrufat.timetracker.db.models.Project;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAddProject extends RecyclerView.Adapter<RecyclerAddProject.ViewHolder> {

    private Context context;
    private List<Category> categoryList;
    private List<Project>projects;
    ProjectsAdapter expandapleradapter;
    RecyclerView expandaplerecycleview;
    private List<Project>addingProjects=new ArrayList<>();



    public RecyclerAddProject(Context context, List<Category> categoryList,List<Project>projects) {
        this.context = context;
        this.categoryList = categoryList;
        this.projects=projects;
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

        if (categoryList.get(position).isExpand()){
            holder.arrowdown.setBackgroundResource(R.drawable.ic_arrow_up);
        }
        else {
            holder.arrowdown.setBackgroundResource(R.drawable.ic_arrow_down);
        }
        checkcatorigises(holder,position);
        holder.add_project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("coming_project", true);
                bundle.putInt("category_id", categoryList.get(position).getId());
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_addFragment, bundle);
            }
        });


    }

    private void checkcatorigises(ViewHolder holder, int position) {

        boolean expand=categoryList.get(position).isExpand();
        holder.expandedlayout.setVisibility(expand ? View.VISIBLE : View.GONE);
        holder.arrowdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Category category=categoryList.get(position);
                category.setExpand(!category.isExpand());
                notifyItemChanged(position);


                if (category.isExpand()){
                    holder.arrowdown.setBackgroundResource(R.drawable.ic_arrow_up);


                }
                else {
                    holder.arrowdown.setBackgroundResource(R.drawable.ic_arrow_down);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        if (!categoryList.isEmpty()){
            return categoryList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView category_name;
        ImageView add_project;
        CardView card_category_color;
        ImageView arrowdown;
        LinearLayout expandedlayout;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            expandedlayout = itemView.findViewById(R.id.linearexpanded);
            category_name = itemView.findViewById(R.id.txt_categoryName);
            add_project = itemView.findViewById(R.id.icon_addProject);
            card_category_color = itemView.findViewById(R.id.card_categoryColor);
            expandaplerecycleview = itemView.findViewById(R.id.expandablerecyclernewAddProject);
            arrowdown = itemView.findViewById(R.id.imgArrowDown);

            for (int j = 0; j < categoryList.size(); j++) {
                for (int i = 0; i < projects.size(); i++) {
                    if (categoryList.get(j).getId() == projects.get(i).getCategory_id())
                        addingProjects.add(projects.get(i));


                }

                if (!addingProjects.isEmpty()) {
                    expandapleradapter = new ProjectsAdapter(
                            categoryList,
                            context,
                            addingProjects

                    );
                    expandaplerecycleview.setHasFixedSize(true);
                    expandaplerecycleview.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                    expandaplerecycleview.setAdapter(expandapleradapter);


                }
                addingProjects.clear();
            }
        }




}
}



