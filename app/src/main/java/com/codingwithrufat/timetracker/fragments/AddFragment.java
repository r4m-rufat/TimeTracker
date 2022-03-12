package com.codingwithrufat.timetracker.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.codingwithrufat.timetracker.R;
import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.listeners.ColorListener;
import com.skydoves.colorpickerview.sliders.AlphaSlideBar;


public class AddFragment extends Fragment {

    private ColorPickerView colorPickerView;
    private AlphaSlideBar alphaSlideBar;
    private CardView cardSelectedColor;

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
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        initWidgets(view);

        setupColorPickerDialog(view);

        return view;

    }

    private void initWidgets(View view){

        colorPickerView = view.findViewById(R.id.colorPickerView);
        alphaSlideBar = view.findViewById(R.id.alphaSlideBar);
        cardSelectedColor = view.findViewById(R.id.card_selectedColor);

    }

    private void setupColorPickerDialog(View view){

        colorPickerView.attachAlphaSlider(alphaSlideBar);
        colorPickerView.setColorListener(new ColorListener() {
            @Override
            public void onColorSelected(int color, boolean fromUser) {
                cardSelectedColor.setCardBackgroundColor(color);
            }
        });

    }


}