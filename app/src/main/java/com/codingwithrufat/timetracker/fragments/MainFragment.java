package com.codingwithrufat.timetracker.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codingwithrufat.timetracker.R;
import com.codingwithrufat.timetracker.adapters.ProjectsAdapter;
import com.codingwithrufat.timetracker.adapters.RecyclerAddProject;
import com.codingwithrufat.timetracker.adapters.RecyclerRunningProject;
import com.codingwithrufat.timetracker.db.builder.DatabaseBuilder;

import java.util.ArrayList;


public class MainFragment extends Fragment {

    private Button button_addCategory;
    private RecyclerAddProject recyclerAddProject;
    private RecyclerRunningProject recyclerRunningProject;
    private RecyclerView recyclerViewProjects, recyclerViewRunningProjects;
    private TextView lookCalendar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        initWidgets(view);
        clickedButtonAddCategory();
        setItemsToRecyclerAddProject();
        setItemsToRunningRecycler();
        return view;

    }

    private void initWidgets(View view){

        button_addCategory = view.findViewById(R.id.button_addCategory);
        recyclerViewProjects = view.findViewById(R.id.recyclerAddProject);
        recyclerViewRunningProjects = view.findViewById(R.id.recyclerRunningProjects);
        lookCalendar = view.findViewById(R.id.txt_lookCalendar);


    }

    private void clickedButtonAddCategory(){
        button_addCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_addFragment);
            }
        });

        lookCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_projectFragment2);
            }
        });


    }

    private void setItemsToRecyclerAddProject(){
        recyclerAddProject = new RecyclerAddProject(
                requireContext(),
                DatabaseBuilder.getCategoryDatabase(requireContext()).getCategoryDao().getAllCategories(),
                DatabaseBuilder.getProjectDatabase(requireContext()).getProjectDao().getAllProjects()
                );

        recyclerViewProjects.setHasFixedSize(true);
        recyclerViewProjects.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        recyclerViewProjects.setAdapter(recyclerAddProject);

    }

    private void setItemsToRunningRecycler(){

        recyclerRunningProject = new RecyclerRunningProject(requireContext(), new ArrayList<>());
        recyclerViewRunningProjects.setHasFixedSize(true);
        recyclerViewRunningProjects.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        recyclerViewRunningProjects.setAdapter(recyclerRunningProject);
    }


}