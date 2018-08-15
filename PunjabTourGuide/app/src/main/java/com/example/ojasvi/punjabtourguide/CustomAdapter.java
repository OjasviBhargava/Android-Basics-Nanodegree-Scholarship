package com.example.ojasvi.punjabtourguide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Ojasvi on 15-08-2018.
 */

public class CustomAdapter extends FragmentPagerAdapter {

    public CustomAdapter(Context context, FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new AmritsarFragment();
        }
        else if(position == 1){
            return new JalandharFragment();
        }
        else if (position == 2){
            return new PatialaFragment();
        }
        else{
            return new ChandigarhFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "Amritsar";
        }else if(position == 1){
            return "Jalandhar";
        }else if (position == 2){
            return "Patiala";
        }
        else{
            return "Chandigarh";
        }
    }
}