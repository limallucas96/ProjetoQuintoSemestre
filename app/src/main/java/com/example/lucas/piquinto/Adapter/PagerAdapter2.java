package com.example.lucas.piquinto.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.lucas.piquinto.Fragment.Tab1;
import com.example.lucas.piquinto.Fragment.Tab2;
import com.example.lucas.piquinto.Fragment.Tab3;

/**
 * Created by Lucas on 14/03/2018.
 */

public class PagerAdapter2 extends FragmentStatePagerAdapter{

    private  int numberOfTabs;

    public PagerAdapter2(FragmentManager fm, int numberOfTabs){
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
       switch (position){

           case 0:
               Tab1 tab1 = new Tab1();
               return tab1;
           case 1:
               Tab2 tab2 = new Tab2();
               return tab2;
           case 2:
               Tab3 tab3 = new Tab3();
               return tab3;
           default:
               return null;


       }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
