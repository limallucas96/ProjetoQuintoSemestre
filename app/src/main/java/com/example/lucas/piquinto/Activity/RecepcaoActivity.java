package com.example.lucas.piquinto.Activity;

import android.net.Uri;
import android.os.StrictMode;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;


import com.example.lucas.piquinto.Adapter.RecepcaoAdapter;
import com.example.lucas.piquinto.Fragment.FecharCheckinFragment;
import com.example.lucas.piquinto.Fragment.AbrirCheckinFragment;
import com.example.lucas.piquinto.Fragment.BuscarCheckinFragment;
import com.example.lucas.piquinto.R;

import java.io.InputStream;


public class RecepcaoActivity extends AppCompatActivity implements FecharCheckinFragment.OnFragmentInteractionListener, AbrirCheckinFragment.OnFragmentInteractionListener, BuscarCheckinFragment.OnFragmentInteractionListener{

    private final String url_login = "http://192.168.11.1/quickroomservice/login.php";

    private ArrayAdapter<String> adapter;
    private InputStream inputStream = null;

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepcao);


        //Componentes da tela
        toolbar = findViewById(R.id.recepcao_toolbar);
        toolbar.setTitle("Recepção");
        setSupportActionBar(toolbar);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().build());

        TabLayout tabLayout = findViewById(R.id.tablayout_recepcao);
        tabLayout.addTab(tabLayout.newTab().setText("FECHAR CHECKIN"));
        tabLayout.addTab(tabLayout.newTab().setText("NOVO CHECKIN"));
        tabLayout.addTab(tabLayout.newTab().setText("BUSCAR"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager_recepcao);
        final RecepcaoAdapter adapter = new RecepcaoAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
