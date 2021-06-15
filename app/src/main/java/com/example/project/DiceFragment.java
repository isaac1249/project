package com.example.project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.SupportMapFragment;

import org.w3c.dom.Text;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DiceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiceFragment extends Fragment {
    private static int randomcount;
    String uri;
    private Button btn;
    private Button textView1,textView2,textView3,textView4;
    public DiceFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View RootView = inflater.inflate(R.layout.fragment_dice,container, false);
        textView1 = RootView.findViewById(R.id.btn1);
        textView2 = RootView.findViewById(R.id.btn2);
        textView3 = RootView.findViewById(R.id.btn3);
        textView4 = RootView.findViewById(R.id.btn4);

        if(getArguments() != null){
            if(getArguments().getString("end").contains("市政府")){
                textView1.setText(getResources().getStringArray(R.array.shing_su_chang)[0]);
                textView2.setText(getResources().getStringArray(R.array.shing_su_chang)[1]);
                textView3.setText(getResources().getStringArray(R.array.shing_su_chang)[2]);
                textView4.setText(getResources().getStringArray(R.array.shing_su_chang)[3]);
            }
        }
        textView1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                uri = String.format("google.navigation:q="+textView1.getText()+"&mode=w");
                launchMap();
            }
        });

        textView2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                uri = String.format("google.navigation:q="+textView2.getText()+"&mode=w");
                launchMap();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                uri = String.format("google.navigation:q="+textView3.getText()+"&mode=w");
                launchMap();
            }
        });

        textView4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                uri = String.format("google.navigation:q="+textView4.getText()+"&mode=w");
                launchMap();
            }
        });

        return RootView;
    }
    public void launchMap(){
        Uri intentUri = Uri.parse(uri);
        Intent intent = new Intent(Intent.ACTION_VIEW,intentUri);
        intent.setPackage("com.google.android.apps.maps");


        startActivity(intent);

    }
}