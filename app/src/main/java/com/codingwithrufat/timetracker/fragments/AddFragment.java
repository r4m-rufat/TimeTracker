package com.codingwithrufat.timetracker.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.codingwithrufat.timetracker.R;
import com.codingwithrufat.timetracker.db.builder.DatabaseBuilder;
import com.codingwithrufat.timetracker.db.daos.CategoryDao;
import com.codingwithrufat.timetracker.db.daos.ProjectDao;
import com.codingwithrufat.timetracker.dataModels.Category;
import com.codingwithrufat.timetracker.dataModels.Project;
import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.listeners.ColorListener;
import com.skydoves.colorpickerview.sliders.AlphaSlideBar;


public class AddFragment extends Fragment {

    private ColorPickerView colorPickerView;
    private AlphaSlideBar alphaSlideBar;
    private CardView cardSelectedColor;
    private CategoryDao categoryDao;
    private ProjectDao projectDao;
    private EditText edit_add;
    private Button button_save;
    private Integer category_color, category_id;
    private boolean coming_project = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            coming_project = getArguments().getBoolean("coming_project");
            category_id = getArguments().getInt("category_id");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        initWidgets(view);
        setItemValues();

        setupColorPickerDialog();

        clickedSaveButton();

        return view;

    }

    private void initWidgets(View view){

        colorPickerView = view.findViewById(R.id.colorPickerView);
        alphaSlideBar = view.findViewById(R.id.alphaSlideBar);
        cardSelectedColor = view.findViewById(R.id.card_selectedColor);
        button_save = view.findViewById(R.id.button_save);
        edit_add = view.findViewById(R.id.edit_add);

    }

    private void setItemValues(){

        if (coming_project){
            edit_add.setHint("Add Project");
            button_save.setText("Save Project");
        }

    }

    private void setupColorPickerDialog(){

        colorPickerView.attachAlphaSlider(alphaSlideBar);
        colorPickerView.setColorListener(new ColorListener() {
            @Override
            public void onColorSelected(int color, boolean fromUser) {
                cardSelectedColor.setCardBackgroundColor(color);
                category_color = color;
            }
        });

    }

    private void clickedSaveButton(){

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (coming_project){
                    addProjectToLocalDB();
                }else{
                    addCategoryToLocalDB();
                }


                Navigation.findNavController(view).navigate(R.id.action_add_fragment_to_main);
            }
        });

    }

    @SuppressLint("RestrictedApi")
    private void addProjectToLocalDB(){

        projectDao = DatabaseBuilder
                .getProjectDatabase(requireContext())
                .getProjectDao();

        Log.d("MyTagHere", "addProjectToLocalDB: "+ category_color);
        projectDao.insertProject(new Project(
                category_id,
                edit_add.getText().toString(),
                category_color,
                null,
                0L,
                false
        ));



    }

    private void addCategoryToLocalDB(){

       categoryDao = DatabaseBuilder
               .getCategoryDatabase(requireContext())
               .getCategoryDao();
        categoryDao.insertCategory(new Category(
                category_id,
                edit_add.getText().toString(),
                category_color
        ));

    }


}