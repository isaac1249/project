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
import android.support.v4.app.*;
import static androidx.navigation.Navigation.findNavController;

public class MRTFragment extends Fragment {
    private Button btn,gotoplay;
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
        gotoplay = RootView.findViewById(R.id.gotoplay);
        ticket = RootView.findViewById(R.id.howmuch);

        initspinnerfooter();

        gotoplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiceFragment diceFragment = new DiceFragment();
                Bundle bundle = new Bundle();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                //onHiddenChanged(true);

                bundle.putString("end",spinner2.getSelectedItem().toString());
                diceFragment.setArguments(bundle);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.mainlayout,diceFragment);
                fragmentTransaction.commit();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "已確認", Toast.LENGTH_LONG).show();

                if (ticketprice(spinner2.getSelectedItem().toString(), spinner.getSelectedItem().toString()).equals(null)){
                    ticket.setText("起點為：" + (CharSequence) spinner.getSelectedItem().toString() + "\n"
                            + "終點為：" + (CharSequence) spinner2.getSelectedItem().toString() + "\n"
                            + ticketprice(spinner.getSelectedItem().toString(), spinner2.getSelectedItem().toString()));
                }else{
                    ticket.setText("起點為：" + (CharSequence) spinner.getSelectedItem().toString() + "\n"
                            + "終點為：" + (CharSequence) spinner2.getSelectedItem().toString() + "\n"
                            + ticketprice(spinner2.getSelectedItem().toString(), spinner.getSelectedItem().toString()));

                }


                MapsFragment mapsFragment = new MapsFragment();
                Bundle bundle = new Bundle();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                onHiddenChanged(true);

                bundle.putString("end",spinner2.getSelectedItem().toString());
                bundle.putString("start",spinner.getSelectedItem().toString());

                mapsFragment.setArguments(bundle);

                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.mainlayout,mapsFragment);
                fragmentTransaction.commit();
            }
        });
        return RootView;
    }
    public String ticketprice(String spinner1,String spinner2){
        if (    spinner1.equals("北屯總站") && spinner2.equals("舊社站") ||
                spinner1.equals("北屯總站") && spinner2.equals("松竹站") ||
                spinner1.equals("北屯總站") && spinner2.equals("四維國小站") ||
                spinner1.equals("北屯總站") && spinner2.equals("文心崇德站") ||
                spinner1.equals("舊社站") && spinner2.equals("北屯總站") ||
                spinner1.equals("舊社站") && spinner2.equals("松竹站") ||
                spinner1.equals("舊社站") && spinner2.equals("四維國小站") ||
                spinner1.equals("舊社站") && spinner2.equals("文心崇德站") ||
                spinner1.equals("舊社站") && spinner2.equals("文心中清站") ||
                spinner1.equals("四維國小站") && spinner2.equals("北屯總站") ||
                spinner1.equals("四維國小站") && spinner2.equals("舊社站") ||
                spinner1.equals("四維國小站") && spinner2.equals("松竹站") ||
                spinner1.equals("四維國小站") && spinner2.equals("文心崇德站") ||
                spinner1.equals("四維國小站") && spinner2.equals("文心中清站") ||
                spinner1.equals("四維國小站") && spinner2.equals("文華高中站") ||
                spinner1.equals("四維國小站") && spinner2.equals("文心櫻花站") ||
                spinner1.equals("四維國小站") && spinner2.equals("市政府站") ||
                spinner1.equals("文心崇德站") && spinner2.equals("北屯總站") ||
                spinner1.equals("文心崇德站") && spinner2.equals("舊社站") ||
                spinner1.equals("文心崇德站") && spinner2.equals("松竹站") ||
                spinner1.equals("文心崇德站") && spinner2.equals("四維國小站") ||
                spinner1.equals("文心崇德站") && spinner2.equals("文心中清站") ||
                spinner1.equals("文心崇德站") && spinner2.equals("文華高中站") ||
                spinner1.equals("文心崇德站") && spinner2.equals("文心櫻花站") ||
                spinner1.equals("文心崇德站") && spinner2.equals("市政府站") ||
                spinner1.equals("文心中清站") && spinner2.equals("松竹站") ||
                spinner1.equals("文心中清站") && spinner2.equals("四維國小站") ||
                spinner1.equals("文心中清站") && spinner2.equals("文心崇德站") ||
                spinner1.equals("文心中清站") && spinner2.equals("文華高中站") ||
                spinner1.equals("文心中清站") && spinner2.equals("文新櫻花站") ||
                spinner1.equals("文心中清站") && spinner2.equals("市政府站") ||
                spinner1.equals("文心中清站") && spinner2.equals("永安宮站") ||
                spinner1.equals("文心中清站") && spinner2.equals("文心森林公園站") ||
                spinner1.equals("文華高中站") && spinner2.equals("松竹站") ||
                spinner1.equals("文華高中站") && spinner2.equals("四維國小站") ||
                spinner1.equals("文華高中站") && spinner2.equals("文心崇德站") ||
                spinner1.equals("文華高中站") && spinner2.equals("文心中清站") ||
                spinner1.equals("文華高中站") && spinner2.equals("文心櫻花站") ||
                spinner1.equals("文華高中站") && spinner2.equals("市政府站") ||
                spinner1.equals("文華高中站") && spinner2.equals("永安宮站") ||
                spinner1.equals("文華高中站") && spinner2.equals("文心森林公園站") ||
                spinner1.equals("文華高中站") && spinner2.equals("南屯站") ||
                spinner1.equals("文華高中站") && spinner2.equals("豐樂公園站") ||
                spinner1.equals("文心櫻花站") && spinner2.equals("四維國小站") ||
                spinner1.equals("文心櫻花站") && spinner2.equals("文心崇德站") ||
                spinner1.equals("文心櫻花站") && spinner2.equals("文心中清站") ||
                spinner1.equals("文心櫻花站") && spinner2.equals("文華高中站") ||
                spinner1.equals("文心櫻花站") && spinner2.equals("市政府站") ||
                spinner1.equals("文心櫻花站") && spinner2.equals("永安宮站") ||
                spinner1.equals("文心櫻花站") && spinner2.equals("文心森林公園站") ||
                spinner1.equals("文心櫻花站") && spinner2.equals("南屯站") ||
                spinner1.equals("文心櫻花站") && spinner2.equals("豐樂公園站") ||
                spinner1.equals("市政府站") && spinner2.equals("四維國小站") ||
                spinner1.equals("市政府站") && spinner2.equals("文心崇德站") ||
                spinner1.equals("市政府站") && spinner2.equals("文心中清站") ||
                spinner1.equals("市政府站") && spinner2.equals("文華高中站") ||
                spinner1.equals("市政府站") && spinner2.equals("文心櫻花站") ||
                spinner1.equals("市政府站") && spinner2.equals("永安宮站") ||
                spinner1.equals("市政府站") && spinner2.equals("文心森林公園站") ||
                spinner1.equals("市政府站") && spinner2.equals("南屯站") ||
                spinner1.equals("市政府站") && spinner2.equals("豐樂公園站") ||
                spinner1.equals("市政府站") && spinner2.equals("大慶站") ||
                spinner1.equals("永安宮站") && spinner2.equals("文心中清站") ||
                spinner1.equals("永安宮站") && spinner2.equals("文華高中站") ||
                spinner1.equals("永安宮站") && spinner2.equals("文心櫻花站") ||
                spinner1.equals("永安宮站") && spinner2.equals("市政府站") ||
                spinner1.equals("永安宮站") && spinner2.equals("永安宮站") ||
                spinner1.equals("永安宮站") && spinner2.equals("文心森林公園站") ||
                spinner1.equals("永安宮站") && spinner2.equals("南屯站") ||
                spinner1.equals("永安宮站") && spinner2.equals("豐樂公園站") ||
                spinner1.equals("永安宮站") && spinner2.equals("大慶站") ||
                spinner1.equals("文心森林公園站") && spinner2.equals("文心中清站") ||
                spinner1.equals("文心森林公園站") && spinner2.equals("文華高中站") ||
                spinner1.equals("文心森林公園站") && spinner2.equals("文心櫻花站") ||
                spinner1.equals("文心森林公園站") && spinner2.equals("市政府站") ||
                spinner1.equals("文心森林公園站") && spinner2.equals("永安宮站") ||
                spinner1.equals("文心森林公園站") && spinner2.equals("南屯站") ||
                spinner1.equals("文心森林公園站") && spinner2.equals("豐樂公園站") ||
                spinner1.equals("文心森林公園站") && spinner2.equals("大慶站") ||
                spinner1.equals("文心森林公園站") && spinner2.equals("九張犁站") ||
                spinner1.equals("南屯站") && spinner2.equals("文華高中站") ||
                spinner1.equals("南屯站") && spinner2.equals("文心櫻花站") ||
                spinner1.equals("南屯站") && spinner2.equals("市政府站") ||
                spinner1.equals("南屯站") && spinner2.equals("永安宮站") ||
                spinner1.equals("南屯站") && spinner2.equals("文心森林公園站") ||
                spinner1.equals("南屯站") && spinner2.equals("豐樂公園站") ||
                spinner1.equals("南屯站") && spinner2.equals("大慶站") ||
                spinner1.equals("南屯站") && spinner2.equals("九張犁站") ||
                spinner1.equals("豐樂公園站") && spinner2.equals("文華高中站") ||
                spinner1.equals("豐樂公園站") && spinner2.equals("文心櫻花站") ||
                spinner1.equals("豐樂公園站") && spinner2.equals("市政府站") ||
                spinner1.equals("豐樂公園站") && spinner2.equals("永安宮站") ||
                spinner1.equals("豐樂公園站") && spinner2.equals("文心森林公園站") ||
                spinner1.equals("豐樂公園站") && spinner2.equals("南屯站") ||
                spinner1.equals("豐樂公園站") && spinner2.equals("大慶站") ||
                spinner1.equals("豐樂公園站") && spinner2.equals("九張犁站") ||
                spinner1.equals("豐樂公園站") && spinner2.equals("烏日站") ||
                spinner1.equals("大慶站") && spinner2.equals("市政府站") ||
                spinner1.equals("大慶站") && spinner2.equals("永安宮站") ||
                spinner1.equals("大慶站") && spinner2.equals("文心森林公園站") ||
                spinner1.equals("大慶站") && spinner2.equals("南屯站") ||
                spinner1.equals("大慶站") && spinner2.equals("豐樂公園站") ||
                spinner1.equals("大慶站") && spinner2.equals("九張犁站") ||
                spinner1.equals("大慶站") && spinner2.equals("烏日站") ||
                spinner1.equals("大慶站") && spinner2.equals("高鐵台中站") ||
                spinner1.equals("九張犁站") && spinner2.equals("永安宮站") ||
                spinner1.equals("九張犁站") && spinner2.equals("文心森林公園站") ||
                spinner1.equals("九張犁站") && spinner2.equals("南屯站") ||
                spinner1.equals("九張犁站") && spinner2.equals("豐樂公園站") ||
                spinner1.equals("九張犁站") && spinner2.equals("大慶站") ||
                spinner1.equals("九張犁站") && spinner2.equals("烏日站") ||
                spinner1.equals("九張犁站") && spinner2.equals("高鐵台中站") ||
                spinner1.equals("烏日站") && spinner2.equals("豐樂公園站") ||
                spinner1.equals("烏日站") && spinner2.equals("大慶站") ||
                spinner1.equals("烏日站") && spinner2.equals("九張犁站") ||
                spinner1.equals("烏日站") && spinner2.equals("高鐵台中站") ||
                spinner1.equals("高鐵台中站") && spinner2.equals("大慶站") ||
                spinner1.equals("高鐵台中站") && spinner2.equals("九張犁站") ||
                spinner1.equals("高鐵台中站") && spinner2.equals("烏日站") ){
            return "票價為：20元";
        }
        else if (spinner1.equals("北屯總站") && spinner2.equals("文心中清站") ||
                spinner1.equals("北屯總站") && spinner2.equals("文華高中站") ||
                spinner1.equals("舊社站") && spinner2.equals("文華高中站") ||
                spinner1.equals("舊社站") && spinner2.equals("文心櫻花站") ||
                spinner1.equals("松竹站") && spinner2.equals("文心櫻花站") ||
                spinner1.equals("松竹站") && spinner2.equals("市政府站") ||
                spinner1.equals("四維國小站") && spinner2.equals("永安宮站") ||
                spinner1.equals("四維國小站") && spinner2.equals("文心森林公園站") ||
                spinner1.equals("文心崇德站") && spinner2.equals("永安宮站") ||
                spinner1.equals("文心崇德站") && spinner2.equals("文心森林公園站") ||
                spinner1.equals("文心崇德站") && spinner2.equals("南屯站") ||
                spinner1.equals("文心中清站") && spinner2.equals("南屯站") ||
                spinner1.equals("文心中清站") && spinner2.equals("豐樂公園站") ||
                spinner1.equals("文華高中站") && spinner2.equals("大慶站") ||
                spinner1.equals("文心櫻花站") && spinner2.equals("大慶站") ||
                spinner1.equals("文心櫻花站") && spinner2.equals("九張犁站") ||
                spinner1.equals("市政府站") && spinner2.equals("九張犁站") ||
                spinner1.equals("永安宮站") && spinner2.equals("烏日站") ||
                spinner1.equals("文心森林公園站") && spinner2.equals("烏日站") ||
                spinner1.equals("文心森林公園站") && spinner2.equals("高鐵台中站") ||
                spinner1.equals("南屯站") && spinner2.equals("烏日站") ||
                spinner1.equals("南屯站") && spinner2.equals("高鐵台中站") ||
                spinner1.equals("豐樂公園站") && spinner2.equals("高鐵台中站")
                 ){
            return "票價為：25元";
        }
        else if (spinner1.equals("北屯總站") && spinner2.equals("文心櫻花站") ||
                spinner1.equals("北屯總站") && spinner2.equals("市政府站") ||
                spinner1.equals("舊社站") && spinner2.equals("市政府站") ||
                spinner1.equals("舊社站") && spinner2.equals("永安宮站") ||
                spinner1.equals("松竹站") && spinner2.equals("永安宮站") ||
                spinner1.equals("松竹站") && spinner2.equals("文心森林公園站") ||
                spinner1.equals("四維國小站") && spinner2.equals("南屯站") ||
                spinner1.equals("文心崇德站") && spinner2.equals("豐樂公園站") ||
                spinner1.equals("文心中清站") && spinner2.equals("大慶站") ||
                spinner1.equals("文心中清站") && spinner2.equals("九張犁站") ||
                spinner1.equals("文華高中站") && spinner2.equals("九張犁站") ||
                spinner1.equals("文心櫻花站") && spinner2.equals("烏日站") ||
                spinner1.equals("市政府站") && spinner2.equals("烏日站") ||
                spinner1.equals("市政府站") && spinner2.equals("高鐵台中站") ||
                spinner1.equals("永安宮站") && spinner2.equals("高鐵台中站")){
            return "票價為：30元";
        }
        else if (spinner1.equals("北屯總站") && spinner2.equals("永安宮站") ||
                spinner1.equals("北屯總站") && spinner2.equals("文心森林公園站") ||
                spinner1.equals("北屯總站") && spinner2.equals("南屯站") ||
                spinner1.equals("舊社站") && spinner2.equals("文心森林公園站") ||
                spinner1.equals("舊社站") && spinner2.equals("南屯站") ||
                spinner1.equals("舊社站") && spinner2.equals("豐樂公園站") ||
                spinner1.equals("松竹站") && spinner2.equals("南屯站") ||
                spinner1.equals("松竹站") && spinner2.equals("豐樂公園站") ||
                spinner1.equals("四維國小站") && spinner2.equals("大慶站") ||
                spinner1.equals("四維國小站") && spinner2.equals("九張犁站") ||
                spinner1.equals("文心崇德站") && spinner2.equals("大慶站") ||
                spinner1.equals("文心崇德站") && spinner2.equals("九張犁站") ||
                spinner1.equals("文心中清站") && spinner2.equals("烏日站") ||
                spinner1.equals("文華高中站") && spinner2.equals("烏日站") ||
                spinner1.equals("文華高中站") && spinner2.equals("高鐵台中站") ||
                spinner1.equals("文心櫻花站") && spinner2.equals("高鐵台中站")){
            return "票價為：35元";
        }
        else if (spinner1.equals("北屯總站站") && spinner2.equals("豐樂公園站") ||
                spinner1.equals("舊社站") && spinner2.equals("大慶站") ||
                spinner1.equals("松竹站") && spinner2.equals("大慶站") ||
                spinner1.equals("松竹站") && spinner2.equals("九張犁站") ||
                spinner1.equals("四維國小站") && spinner2.equals("烏日站") ||
                spinner1.equals("文心崇德站") && spinner2.equals("烏日站") ||
                spinner1.equals("文心崇德站") && spinner2.equals("高鐵台中站") ||
                spinner1.equals("文心中清站") && spinner2.equals("高鐵台中站")){
            return "票價為:40元";
        }
        else if(spinner1.equals("北屯總站") && spinner2.equals("烏日站") ||
                spinner1.equals("北屯總站") && spinner2.equals("高鐵台中站") ||
                spinner1.equals("舊社站") && spinner2.equals("高鐵台中站") ||
                spinner1.equals("松竹站") && spinner2.equals("高鐵台中站")){
            return "票價為：50元";
        }
        else if (spinner1.equals("北屯總站") && spinner2.equals("大慶站") ||
                spinner1.equals("北屯總站") && spinner2.equals("九張犁站") ||
                spinner1.equals("舊社站") && spinner2.equals("烏日站") ||
                spinner1.equals("松竹站") && spinner2.equals("烏日站") ||
                spinner1.equals("四維國小站") && spinner2.equals("高鐵台中站")){
            return "票價為：45元";
        }
        return null;
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
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {   // 不在最前端显示 相当于调用了onPause();
            return ;
        }else{  // 在最前端显示 相当于调用了onResume();
            //网络数据刷新
        }
    }

}