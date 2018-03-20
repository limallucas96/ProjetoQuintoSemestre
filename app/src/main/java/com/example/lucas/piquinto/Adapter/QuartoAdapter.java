package com.example.lucas.piquinto.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.lucas.piquinto.Fragment.AbrirCheckinFragment;
import com.example.lucas.piquinto.Fragment.BuscarCheckinFragment;
import com.example.lucas.piquinto.Fragment.FecharCheckinFragment;
import com.example.lucas.piquinto.Fragment.PedidoFragment;
import com.example.lucas.piquinto.Fragment.StatusFragment;
import com.example.lucas.piquinto.Fragment.UsuarioFragment;

/**
 * Created by Lucas on 19/03/2018.
 */

public class QuartoAdapter extends FragmentStatePagerAdapter  {

    private  int numberOfTabs;

    public QuartoAdapter(FragmentManager fm, int numberOfTabs){
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
               UsuarioFragment usuarioFragment = new UsuarioFragment() ;
                return usuarioFragment;
            case 1:
                PedidoFragment pedidoFragment = new PedidoFragment();
                return pedidoFragment;
            case 2:
                StatusFragment statusFragment = new StatusFragment();
                return statusFragment;
            default:
                return null;


        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
