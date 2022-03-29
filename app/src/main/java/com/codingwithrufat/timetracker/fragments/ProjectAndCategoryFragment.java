package com.codingwithrufat.timetracker.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingwithrufat.timetracker.R;
import com.codingwithrufat.timetracker.adapters.RecycCategoryAdapter;
import com.codingwithrufat.timetracker.adapters.RecycProjectAdapter;
import com.codingwithrufat.timetracker.dataModels.TimeProject;
import com.codingwithrufat.timetracker.databinding.FragmentProjectBinding;
import com.codingwithrufat.timetracker.db.builder.DatabaseBuilder;

import java.util.List;

public class ProjectAndCategoryFragment extends Fragment {
    private FragmentProjectBinding binding;
    private boolean isClicked = false,isProjectSection = true;
    private final String TAG="MyTagHere";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            binding = FragmentProjectBinding.inflate(inflater);

            moveToProjectAdapter();
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
                    binding.arrowDirection.setBackgroundDrawable(requireContext().getResources().getDrawable(R.drawable.ic_arrow_down));
                    isClicked = false;
                }
            }
        });

        binding.genericStatistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_projectFragment2_to_generalStatisticFragment);
            }
        });

        binding.selectedText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.selectedText.setVisibility(View.GONE);
                binding.arrowDirection.setBackgroundDrawable(requireContext().getResources().getDrawable(R.drawable.ic_arrow_down));
                isClicked = false;
                if (isProjectSection) {
                    moveToCategoryAdapter();

                    isProjectSection = false;
                    binding.mainText.setText("Kateqoriyalar");
                    binding.selectedText.setText("Proyektlər");
                } else {
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
        List<String> myDateList =DatabaseBuilder.getTimeProjectDatabase(requireContext()).getTimeProjectDao().getUniqueDateProject();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false);
        binding.myRecyclerView.setLayoutManager(layoutManager);
        RecycProjectAdapter projectAdapter=new RecycProjectAdapter(myDateList,requireContext());
        binding.myRecyclerView.setAdapter(projectAdapter);
    }

    private void moveToCategoryAdapter() {
        Log.d(TAG, "moveToCategoryAdapter: call the RecycCategoryAdapter");
        List<String> myProjectList = DatabaseBuilder.getTimeCategoryDatabase(requireContext()).getTimeCategoryDao().getUniqueDateCategory();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false);
        binding.myRecyclerView.setLayoutManager(layoutManager);
        RecycCategoryAdapter categoryAdapter=new RecycCategoryAdapter(myProjectList,requireContext());
        binding.myRecyclerView.setAdapter(categoryAdapter);
    }
}