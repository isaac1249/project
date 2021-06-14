package com.example.project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public class MapsFragment extends Fragment {

    SupportMapFragment mapFragment;
    private OnMapReadyCallback callback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(@NonNull @NotNull GoogleMap googleMap) {

            ArrayList restartant_info  = new ArrayList<HashMap<String, String>>();
            HashMap<String,String> temp = new HashMap<String,String>();
            temp.put("name","北屯總站");
            temp.put("lat","24.189132");
            temp.put("long","120.70864");
            restartant_info.add(0,temp);

            temp = new HashMap<String,String>();
            temp.put("name","舊社站");
            temp.put("lat","24.182289");
            temp.put("long","120.707294");
            restartant_info.add(1,temp);

            temp = new HashMap<String,String>();
            temp.put("name","松竹站");
            temp.put("lat","24.180807");
            temp.put("long","120.70145");
            restartant_info.add(2,temp);

            temp = new HashMap<String,String>();
            temp.put("name","四維國小站");
            temp.put("lat","24.171243");
            temp.put("long","120.693295");
            restartant_info.add(3,temp);

            temp = new HashMap<String,String>();temp.put("name","文心崇德站");
            temp.put("lat","24.172194");
            temp.put("long","120.684869");
            restartant_info.add(4,temp);

            temp = new HashMap<String,String>();temp.put("name","文心中清站");
            temp.put("lat","24.173682");
            temp.put("long","120.670599");
            restartant_info.add(5,temp);

            temp = new HashMap<String,String>();temp.put("name","文華高中站");
            temp.put("lat","24.171416");
            temp.put("long","120.660455");
            restartant_info.add(6,temp);

            temp = new HashMap<String,String>();temp.put("name","文心櫻花站");
            temp.put("lat","24.167587");
            temp.put("long","120.653718");
            restartant_info.add(7,temp);

            temp = new HashMap<String,String>();temp.put("name","市政府站");
            temp.put("lat","24.161788");
            temp.put("long","120.649041");
            restartant_info.add(8,temp);

            temp = new HashMap<String,String>();temp.put("name","水安宮站");
            temp.put("lat","24.1531");
            temp.put("long","120.6468");
            restartant_info.add(9,temp);

            temp = new HashMap<String,String>();
            temp.put("name","文心森林公園站");
            temp.put("lat","24.1454");
            temp.put("long","120.6467");
            restartant_info.add(10,temp);

            temp = new HashMap<String,String>();
            temp.put("name","南屯站");
            temp.put("lat","24.1405");
            temp.put("long","120.6467");
            restartant_info.add(11,temp);

            temp = new HashMap<String,String>();
            temp.put("name","豐樂公園站");
            temp.put("lat","24.1326");
            temp.put("long","120.6464");
            restartant_info.add(12,temp);

            temp = new HashMap<String,String>();
            temp.put("name","大慶站");
            temp.put("lat","24.1191");
            temp.put("long","120.6476");
            restartant_info.add(13,temp);

            temp = new HashMap<String,String>();
            temp.put("name","九張犁站");
            temp.put("lat","24.111");
            temp.put("long","120.6345");
            restartant_info.add(14,temp);

            temp = new HashMap<String,String>();
            temp.put("name","烏日站");
            temp.put("lat","24.1089");
            temp.put("long","120.6249");
            restartant_info.add(15,temp);

            temp = new HashMap<String,String>();
            temp.put("name","高鐵臺中站");
            temp.put("lat","24.110314");
            temp.put("long","120.613573");
            restartant_info.add(16,temp);

            for(int k = 0; k < restartant_info.size(); k++){
                temp = (HashMap)restartant_info.get(k);
                LatLng sydney2 = new LatLng(Double.parseDouble(temp.get("lat")), Double.parseDouble(temp.get("long")));
                googleMap.addMarker(new MarkerOptions().position(sydney2).title(temp.get("name"))).showInfoWindow();

            }

            LatLng sydney3 = new LatLng(24.161788, 120.649041);
            googleMap.addMarker(new MarkerOptions().position(sydney3).title("市政府站"));

            BitmapDescriptor d = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE);


            if(getArguments() != null) {
                int myInt = getArguments().getInt("end");

                for(int k = 0; k < restartant_info.size(); k++){
                    temp = (HashMap)restartant_info.get(k);
                    if(getArguments().getString("end").equals(temp.get("name"))){
                        LatLng sydney4 = new LatLng(Double.parseDouble(temp.get("lat")), Double.parseDouble(temp.get("long")));
                        googleMap.addMarker(new MarkerOptions().icon(d).position(sydney4).title(temp.get("name"))).showInfoWindow();
                    }
                    else if (getArguments().getString("start").equals(temp.get("name"))){
                        LatLng sydney1 = new LatLng(Double.parseDouble(temp.get("lat")), Double.parseDouble(temp.get("long")));
                        googleMap.addMarker(new MarkerOptions().icon(d).position(sydney1).title(temp.get("name"))).showInfoWindow();
                    }
                }
                //googleMap.addMarker(new MarkerOptions().icon(d).position(test).title(getArguments().getString("end"))).showInfoWindow();
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney3));

                googleMap.getUiSettings().setZoomControlsEnabled(true);
                googleMap.getUiSettings().setCompassEnabled(true);
                googleMap.getUiSettings().setMapToolbarEnabled(true);
                googleMap.animateCamera(CameraUpdateFactory.zoomTo(12));
            }
        }


    };

    @Nullable
    public void onMapReady(GoogleMap googleMap) {
        LatLng taichung_center = new LatLng(24.161750662568583, 120.64903709898806);
        googleMap.addMarker(new MarkerOptions().position(taichung_center).title("以臺中市政府捷運站為中心"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(taichung_center));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_maps, container, false);
        mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        if(mapFragment==null){
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            mapFragment = SupportMapFragment.newInstance();
            ft.replace(R.id.map,mapFragment).commit();
        }
        //mapFragment.getMapAsync(this);
        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}