package com.example.lucas.piquinto;

import android.net.Uri;
import android.os.StrictMode;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;


import com.example.lucas.piquinto.Adapter.PagerAdapter2;
import com.example.lucas.piquinto.Fragment.Tab1;
import com.example.lucas.piquinto.Fragment.Tab2;
import com.example.lucas.piquinto.Fragment.Tab3;
import java.io.InputStream;


public class RecepcaoActivity extends AppCompatActivity implements Tab1.OnFragmentInteractionListener, Tab2.OnFragmentInteractionListener, Tab3.OnFragmentInteractionListener{

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

        TabLayout tabLayout = findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("FECHAR CHECKIN"));
        tabLayout.addTab(tabLayout.newTab().setText("NOVO CHECKIN"));
        tabLayout.addTab(tabLayout.newTab().setText("BUSCAR"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager);
        final PagerAdapter2 adapter = new PagerAdapter2(getSupportFragmentManager(), tabLayout.getTabCount());
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

//    private String getData(String value) {
//        try {
//
//            URL url = new URL(url_login);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//            connection.setRequestMethod("GET");
//
//            inputStream = new BufferedInputStream(connection.getInputStream());
//
//            //READ ITS CONTENT INTO A STRING
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            StringBuilder sb = new StringBuilder();
//
//            String line = "";
//
//            while ((line = reader.readLine()) != null) {
//                sb.append(line + "\n");
//            }
//
//            inputStream.close();
//            String result = sb.toString();
//
//            //PARSING JSON DATA
//
//            JSONArray jsonArray = new JSONArray(result);
//            JSONObject jsonObject = null;
//
//            String data[] = new String[jsonArray.length()];
//
//            for (int i = 0; i < data.length; i++) {
//                jsonObject = jsonArray.getJSONObject(i);
//            }
//
//            return jsonObject.getString(value);
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
