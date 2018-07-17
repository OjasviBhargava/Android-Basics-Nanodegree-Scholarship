package com.example.ojasvi.surasvi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    public static boolean isHomeActivityShown = true;
    public boolean isFragment1Shown = false;
    public boolean isFragment2Shown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (savedInstanceState == null){
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, new HomeFragment()).commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentTransaction.replace(R.id.container, new HomeFragment()).commit();
                    return true;
                case R.id.navigation_dashboard:
                    isFragment1Shown = true;
                    isHomeActivityShown = false;
                    fragmentTransaction.replace(R.id.container, new AlbumFragment()).commit();
                    return true;
                case R.id.navigation_notifications:
                    isFragment2Shown = true;
                    isHomeActivityShown = false;
                    isFragment1Shown= false;
                    fragmentTransaction.replace(R.id.container, new AboutFragment()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    public void onBackPressed() {
        if (isHomeActivityShown){
            finish();
        }
        else if(isFragment1Shown){
            Fragment mainFragment = new HomeFragment();
            isFragment1Shown = false;
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.container, mainFragment).commit();
            isHomeActivityShown = true;
            bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        }
        else if(isFragment2Shown){
            Fragment mainFragment = new HomeFragment();
            isFragment1Shown = false;
            isFragment2Shown = false;
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.container,mainFragment).commit();
            bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        }

    }
}