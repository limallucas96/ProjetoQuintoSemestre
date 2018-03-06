package com.example.lucas.piquinto;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Lucas on 06/03/2018.
 */

public class BackGroundWork extends AsyncTask<String, Void, String> {

    private Context contex;
    private AlertDialog alertDialog;

    private final String DATA_TYPE = "UTF-8";
    private final String DATA_TYPE2 = "iso-8859-1";

    BackGroundWork(Context context){
        this.contex = context;

    }


    @Override
    protected String doInBackground(String... params) {
        String type = params[0]; //pega valores passados no metodo onLogin da classe mainActivity
        String user_name = params[1];
        String password = params[2];
        String login_url = "http://192.168.0.2/login.php";

        if(type.equals("login")){
            try {
                URL url = new URL(login_url);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);
                connection.setDoInput(true);

                OutputStream outputStream = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, DATA_TYPE));
                String post_data = URLEncoder.encode("user_name", DATA_TYPE)+"="+URLEncoder.encode(user_name, DATA_TYPE)+"&"+
                                      URLEncoder.encode("password", DATA_TYPE)+"="+URLEncoder.encode(password, DATA_TYPE);

                writer.write(post_data);
                writer.flush();
                writer.close();
                outputStream.close();

                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, DATA_TYPE2));

                String result = "", line;
                while((line = reader.readLine()) != null){
                    result += line;
                }
                reader.close();
                inputStream.close();

                connection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        return "doInBackGround error";
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(contex).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
