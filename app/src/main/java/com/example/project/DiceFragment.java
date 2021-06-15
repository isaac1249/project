package com.example.project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DiceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiceFragment extends Fragment {
    private static int randomcount;
    private Button btn;
    private TextView textView1,textView2,textView3,textView4;
    public DiceFragment() {
        // Required empty public constructor
    }


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
        View RootView = inflater.inflate(R.layout.fragment_dice,container, false);
        textView1 = RootView.findViewById(R.id.t1);
        textView2 = RootView.findViewById(R.id.t2);
        textView3 = RootView.findViewById(R.id.t3);
        textView4 = RootView.findViewById(R.id.t4);

        if(getArguments() != null){
            if(getArguments().getString("end").contains("市政府")){
                textView1.setText(getResources().getStringArray(R.array.shing_su_chang)[0]);
                textView2.setText(getResources().getStringArray(R.array.shing_su_chang)[1]);
                textView3.setText(getResources().getStringArray(R.array.shing_su_chang)[2]);
                textView4.setText(getResources().getStringArray(R.array.shing_su_chang)[3]);
            }
        }

        return RootView;
    }
}