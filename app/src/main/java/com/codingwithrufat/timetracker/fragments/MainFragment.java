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
import android.widget.Button;
import android.widget.TextView;

import com.codingwithrufat.timetracker.helper.listener.ClickListener;
import com.codingwithrufat.timetracker.R;
import com.codingwithrufat.timetracker.adapters.RecyclerAddProject;
import com.codingwithrufat.timetracker.adapters.RecyclerRunningProject;
import com.codingwithrufat.timetracker.db.builder.DatabaseBuilder;
import com.codingwithrufat.timetracker.dataModels.Category;
import com.codingwithrufat.timetracker.db.models.RunningProjects;
import com.codingwithrufat.timetracker.db.models.WholeCategory;
import com.codingwithrufat.timetracker.dataModels.Project;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment {

    private Button button_addCategory;
    private RecyclerAddProject recyclerAddProject;
    private RecyclerRunningProject recyclerRunningProject;
    private RecyclerView recyclerViewProjects, recyclerViewRunningProjects;
    private TextView lookCalendar;
    List<WholeCategory>wholeCategories=new ArrayList<>();
    List<RunningProjects>runningProjects=new ArrayList<>();


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
        List<Category>categories=DatabaseBuilder.getCategoryDatabase(requireContext()).getCategoryDao().getAllCategories();
        List<Project>projects=DatabaseBuilder.getProjectDatabase(requireContext()).getProjectDao().getAllProjects();
        recyclerAddProject = new RecyclerAddProject(
                requireContext(),
                wholeCategories,
             new ClickListener() {
                 @Override
                 public void onClick(String name, Integer color_code, Long start, Long end, boolean playing) {
                     if (playing){
                         setupRunnigProjects(projects);
                     }
                     else{
                         setupRunnigProjects(projects);
                     }
                 }

                 @Override
                 public void onClick_Refresh() {

                 }
             });

        recyclerViewProjects.setHasFixedSize(true);
        recyclerViewProjects.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        recyclerViewProjects.setAdapter(recyclerAddProject);
        setupWholeCategory(categories,projects);
        setupRunnigProjects(projects);

    }

    private void setItemsToRunningRecycler(List<RunningProjects>runningProjects){
        recyclerRunningProject = new RecyclerRunningProject(requireContext(),runningProjects);
        recyclerViewRunningProjects.setHasFixedSize(true);
        recyclerViewRunningProjects.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        recyclerViewRunningProjects.setAdapter(recyclerRunningProject);
    }
    private void setupRunnigProjects(List<Project>projects){
        runningProjects.clear();
        for (int j = 0; j<projects.size(); j++) {
            if (projects.get(j).isPlaying()) {
                runningProjects.add(new RunningProjects(
                        projects.get(j).getName(),
                        projects.get(j).getColor_code(),
                        projects.get(j).getStart(),
                        projects.get(j).getEnded(),
                        projects.get(j).isPlaying()
                ));
            }

        }
        setItemsToRunningRecycler(runningProjects);


    }
    private void setupWholeCategory(List<Category> categoryList, List<Project> projectList) {
        for (Category category : categoryList) {
            List<Project> newProjectList = new ArrayList<>();
            for (int j = 0; j < projectList.size(); j++) {

                if (category.getId() == projectList.get(j).getCategory_id()) {

                    newProjectList.add(projectList.get(j));

                }

            }


            wholeCategories.add(
                    new WholeCategory(
                            category.getId(),
                            category.getName(),
                            category.getColor_code(),
                            category.isExpand(),
                            newProjectList
                    )
            );

            Log.d("AppDebug", "setupWholeCategory: Size: " + newProjectList.size());

        }

    }


}