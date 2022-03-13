package com.codingwithrufat.timetracker.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.codingwithrufat.timetracker.R;
import com.codingwithrufat.timetracker.db.models.Category;

import java.util.List;

public class RecyclerAddProject extends RecyclerView.Adapter<RecyclerAddProject.ViewHolder> {

    private Context context;
    private List<Category> categoryList;

    public RecyclerAddProject(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            category_name = itemView.findViewById(R.id.txt_categoryName);
            add_project = itemView.findViewById(R.id.icon_addProject);
            card_category_color = itemView.findViewById(R.id.card_categoryColor);

        }
    }
}
