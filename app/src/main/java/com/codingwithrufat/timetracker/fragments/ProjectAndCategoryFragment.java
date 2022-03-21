package com.codingwithrufat.timetracker.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingwithrufat.timetracker.R;
import com.codingwithrufat.timetracker.adapters.RecycCategoryAdapter;
import com.codingwithrufat.timetracker.adapters.RecycProjectAdapter;
import com.codingwithrufat.timetracker.databinding.FragmentProjectBinding;
import com.codingwithrufat.timetracker.db.builder.DatabaseBuilder;
import com.codingwithrufat.timetracker.db.models.Category;
import com.codingwithrufat.timetracker.db.models.Project;

import java.util.List;
import java.util.Objects;

public class ProjectAndCategoryFragment extends Fragment {
    private FragmentProjectBinding binding;
    private boolean isClicked = false,isProjectSection = true;
    private String TAG="MyTagHere";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            binding = FragmentProjectBinding.inflate(inflater);


            setClickListeners();



            return binding.getRoot();
    }

    private void setClickListeners() {
        binding.projectReturnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().onBackPressed();
            }
        });

        binding.linearChangeSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: MainText clicked!");
                if(!isClicked){
                    binding.selectedText.setVisibility(View.VISIBLE);
                    binding.arrowDirection.setBackgroundDrawable(requireContext().getResources().getDrawable(R.drawable.arrow_up));
                    isClicked=true;
                }
                else{
                    binding.selectedText.setVisibility(View.GONE);
                    binding.arrowDirection.setBackgroundDrawable(requireContext().getResources().getDrawable(R.drawable.ic_baseline_keyboard_arrow_down_24));
                    isClicked = false;
                }
            }
        });

        binding.selectedText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.selectedText.setVisibility(View.GONE);
                binding.arrowDirection.setBackgroundDrawable(requireContext().getResources().getDrawable(R.drawable.ic_baseline_keyboard_arrow_down_24));
                isClicked = false;
                if(isProjectSection){
                    moveToCategoryAdapter();

                    isProjectSection = false;
                    binding.mainText.setText("Kateqoriyalar");
                    binding.selectedText.setText("Proyektlər");
                }else{
                    moveToProjectAdapter();

                    isProjectSection = true;
                    binding.mainText.setText("Proyektlər");
                    binding.selectedText.setText("Kateqoriyalar");
                }
            }
        });
    }

    private void moveToProjectAdapter() {
        Log.d(TAG, "moveToProjectAdapter: call the RecycProjectAdapter");
        List<Project> myProjectList =DatabaseBuilder.getProjectDatabase(requireContext()).getProjectDao().getAllProjects();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false);
        binding.myRecyclerView.setLayoutManager(layoutManager);
        RecycProjectAdapter projectAdapter=new RecycProjectAdapter(myProjectList,requireContext());
        binding.myRecyclerView.setAdapter(projectAdapter);
    }

    private void moveToCategoryAdapter() {
        Log.d(TAG, "moveToCategoryAdapter: call the RecycCategoryAdapter");
        List<Category> myProjectList = DatabaseBuilder.getCategoryDatabase(requireContext()).getCategoryDao().getAllCategories();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false);
        binding.myRecyclerView.setLayoutManager(layoutManager);
        RecycCategoryAdapter categoryAdapter=new RecycCategoryAdapter(myProjectList,requireContext());
        binding.myRecyclerView.setAdapter(categoryAdapter);
    }
}