package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.view.MotionEvent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {
    private ImageView Logo;
    private MenuItem item;
    SupportMapFragment smf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MRTFragment mrtFragment = new MRTFragment();
        MapsFragment mapsFragment = new MapsFragment();
        FragmentManager manager = getSupportFragmentManager();

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        //manager.beginTransaction().add(R.id.mainlayout,mrtFragment).commit();
        //SupportMapFragment build
        smf = SupportMapFragment.newInstance();
        smf.getMapAsync(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {           //選取bar的功能
        Fragment fragment = null;
        FragmentManager sFm = getSupportFragmentManager();

        if(smf.isAdded()){
            sFm.beginTransaction().hide(smf).commit();
        }

        switch (item.getItemId()) {

            case R.id.nav1:
                fragment = new MRTFragment();                    //要改主頁的内容去該XXXXFragment改程式碼
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.mainlayout,fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}