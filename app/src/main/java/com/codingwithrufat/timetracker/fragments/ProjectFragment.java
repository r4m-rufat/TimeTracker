package com.codingwithrufat.timetracker.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingwithrufat.timetracker.adapters.RecycProjectAdapter;
import com.codingwithrufat.timetracker.databinding.FragmentProjectBinding;
import com.codingwithrufat.timetracker.db.builder.DatabaseBuilder;
import com.codingwithrufat.timetracker.db.models.Project;

import java.util.List;

public class ProjectFragment extends Fragment {
    private FragmentProjectBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentProjectBinding.inflate(inflater);
        List<Project> myProjectList =DatabaseBuilder.getProjectDatabase(requireContext()).getProjectDao().getAllProjects();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false);
        binding.myRecyclerView.setLayoutManager(layoutManager);
        RecycProjectAdapter projectAdapter=new RecycProjectAdapter(myProjectList,requireContext());
        binding.myRecyclerView.setAdapter(projectAdapter);

        return binding.getRoot();
    }
}