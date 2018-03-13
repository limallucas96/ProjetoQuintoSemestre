package com.example.lucas.piquinto;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RecepcaoActivity extends AppCompatActivity {

    private final String url_login = "http://192.168.11.1/quickroomservice/login.php";

    private ListView lv;
    private TextView txtUsuario;

    private ArrayAdapter<String> adapter;
    private InputStream inputStream = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepcao);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().build());

        txtUsuario = findViewById(R.id.txtUsuario_id);
        txtUsuario.setText(getData("login"));



    }

    private String getData(String value) {
        try {

            URL url = new URL(url_login);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            inputStream = new BufferedInputStream(connection.getInputStream());

            //READ ITS CONTENT INTO A STRING

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();

            String line = "";

            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }

            inputStream.close();
            String result = sb.toString();

            //PARSING JSON DATA

            JSONArray jsonArray = new JSONArray(result);
            JSONObject jsonObject = null;

            String data[] = new String[jsonArray.length()];

            for (int i = 0; i < data.length; i++) {
                jsonObject = jsonArray.getJSONObject(i);
            }

            return jsonObject.getString(value);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
