package com.example.lucas.piquinto.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.lucas.piquinto.Fragment.AbrirCheckinFragment;
import com.example.lucas.piquinto.Fragment.FecharCheckinFragment;
import com.example.lucas.piquinto.Fragment.BuscarCheckinFragment;

/**
 * Created by Lucas on 14/03/2018.
 */

public class RecepcaoAdapter extends FragmentStatePagerAdapter{

    private  int numberOfTabs;

    public RecepcaoAdapter(FragmentManager fm, int numberOfTabs){
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
       switch (position){

           case 0:
               FecharCheckinFragment fecharCheckinFragment = new FecharCheckinFragment();
               return fecharCheckinFragment;
           case 1:
               AbrirCheckinFragment abrirCheckinFragment = new AbrirCheckinFragment();
               return abrirCheckinFragment;
           case 2:
               BuscarCheckinFragment buscarCheckinFragment = new BuscarCheckinFragment();
               return buscarCheckinFragment;
           default:
               return null;


       }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
