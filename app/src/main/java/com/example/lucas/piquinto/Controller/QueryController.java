package com.example.lucas.piquinto.Controller;

import android.util.Log;

import com.example.lucas.piquinto.Model.Quarto;

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
import java.util.ArrayList;

/**
 * Created by Lucas on 20/03/2018.
 */

public class QueryController {

        private String url_login;
        private InputStream inputStream;

   public QueryController(String url){
       this.url_login = url;
   }

    public String[] getData(String value) {
        try {

            ArrayList<String> queryResult;

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

            JSONArray jsonArray = new JSONArray(result);
            JSONObject jsonObject = null;


            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);

            }

            String data[] = new String[jsonArray.length()];

            for(int i = 0 ; i < data.length ; i++){

                jsonObject = jsonArray.getJSONObject(i);
                data[i] = jsonObject.getString(value);
                Log.e("TESTE2", data[i]);
            }

            return data;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getUrl_login() {
        return url_login;
    }

    public void setUrl_login(String url_login) {
        this.url_login = url_login;
    }

}
