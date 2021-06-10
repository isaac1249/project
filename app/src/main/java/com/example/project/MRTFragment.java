package com.example.project;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

import com.example.project.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

import java.lang.reflect.Array;
import java.util.HashMap;

public class MRTFragment extends Fragment {
    private Context context;
    private Button btn;
    private GoogleMap mMap;
    private Spinner spinner;
    private Spinner spinner2;
    // TODO: Rename and change types of parameters


    public MRTFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void setContentView(int activity_main) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View RootView = inflater.inflate(R.layout.fragment_m_r_t,null);
        spinner = RootView.findViewById(R.id.spinner);
        spinner2 = RootView.findViewById(R.id.spinner2);
        btn = RootView.findViewById(R.id.btn);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.MRT_array, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner2.setAdapter(spinnerAdapter);
        spinner.setSelection(2, false);

        return inflater.inflate(R.layout.fragment_m_r_t, container, false);
    }
}