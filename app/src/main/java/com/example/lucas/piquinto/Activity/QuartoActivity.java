package com.example.lucas.piquinto.Activity;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.lucas.piquinto.Adapter.QuartoAdapter;
import com.example.lucas.piquinto.Fragment.PedidoFragment;
import com.example.lucas.piquinto.Fragment.StatusFragment;
import com.example.lucas.piquinto.Fragment.UsuarioFragment;
import com.example.lucas.piquinto.R;

public class QuartoActivity extends AppCompatActivity implements PedidoFragment.OnFragmentInteractionListener, StatusFragment.OnFragmentInteractionListener, UsuarioFragment.OnFragmentInteractionListener {


    private Toolbar toolbar;
    private ViewPager viewPager;
    private QuartoAdapter quartoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarto);

        toolbar = findViewById(R.id.quarto_toolbar);
        toolbar.setTitle("Quarto 7");
        setSupportActionBar(toolbar);

        TabLayout tabLayout = findViewById(R.id.tablayout_quarto);
        tabLayout.addTab(tabLayout.newTab().setText("Quarto"));
        tabLayout.addTab(tabLayout.newTab().setText("Pedido"));
        tabLayout.addTab(tabLayout.newTab().setText("Status"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = findViewById(R.id.pager_quarto);

        quartoAdapter = new QuartoAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(quartoAdapter);
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
