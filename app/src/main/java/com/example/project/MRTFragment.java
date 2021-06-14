package com.example.project;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.*;
import androidx.fragment.app.Fragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.reflect.Array;
import java.util.HashMap;

import static androidx.navigation.Navigation.findNavController;

public class MRTFragment extends Fragment {
    private Button btn;
    private GoogleMap mMap;
    private Spinner spinner;
    private Spinner spinner2;
    private TextView ticket;
    private ArrayList<String> mdata;
    notdata isdata;
    // TODO: Rename and change types of parameters


    public MRTFragment() {
        // Required empty public constructor
        mdata = new ArrayList<>();
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
        View RootView = inflater.inflate(R.layout.fragment_m_r_t,container, false);
        spinner = RootView.findViewById(R.id.spinner);
        spinner2 = RootView.findViewById(R.id.spinner2);
        btn = RootView.findViewById(R.id.btn);
        ticket = RootView.findViewById(R.id.howmuch);

        initspinnerfooter();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"已確認",Toast.LENGTH_LONG).show();
                ticket.setText((CharSequence) spinner.getSelectedItem().toString());
                MapsFragment mapsFragment = new MapsFragment();

                Bundle bundle = new Bundle();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                bundle.putString("end",spinner2.getSelectedItem().toString());
                bundle.putString("start",spinner.getSelectedItem().toString());

                mapsFragment.setArguments(bundle);

                fragmentTransaction.addToBackStack(null);
                //fragmentTransaction.replace(R.id.mainlayout,mapsFragment);
                fragmentTransaction.add(R.id.mainlayout,mapsFragment);
                fragmentTransaction.commit();
            }
        });
        return RootView;
    }

    public void initspinnerfooter() {
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.MRT_array, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner2.setAdapter(spinnerAdapter);
        spinner.setSelection(7, false);
        //未設立防呆
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"起點站設定為:" + spinnerAdapter.getItem(position),Toast.LENGTH_LONG).show();
                //isdata.start_point = spinnerAdapter.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"終點站設定為:" + spinnerAdapter.getItem(position),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}