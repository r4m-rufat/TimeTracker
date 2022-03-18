package com.codingwithrufat.timetracker.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingwithrufat.timetracker.R;
import com.codingwithrufat.timetracker.adapters.RecycCategoryAdapter;
import com.codingwithrufat.timetracker.adapters.RecycProjectAdapter;
import com.codingwithrufat.timetracker.databinding.FragmentCategoryBinding;
import com.codingwithrufat.timetracker.databinding.FragmentProjectBinding;
import com.codingwithrufat.timetracker.db.builder.DatabaseBuilder;
import com.codingwithrufat.timetracker.db.models.Category;
import com.codingwithrufat.timetracker.db.models.Project;

import java.util.List;

public class CategoryFragment extends Fragment {
     FragmentCategoryBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCategoryBinding.inflate(inflater);
        List<Category> myProjectList = DatabaseBuilder.getCategoryDatabase(requireContext()).getCategoryDao().getAllCategories();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false);
        binding.myRecyclerViewCategory.setLayoutManager(layoutManager);
        RecycCategoryAdapter categoryAdapter=new RecycCategoryAdapter(myProjectList,requireContext());
        binding.myRecyclerViewCategory.setAdapter(categoryAdapter);

        return binding.getRoot();
    }
}