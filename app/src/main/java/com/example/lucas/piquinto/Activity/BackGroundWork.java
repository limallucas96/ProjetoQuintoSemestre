package com.example.lucas.piquinto.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

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
    private boolean loginStatus = false;

    private final String DATA_TYPE = "UTF-8";
    private final String DATA_TYPE2 = "iso-8859-1";

    BackGroundWork(Context context) {
        this.contex = context.getApplicationContext();

    }


    @Override
    protected String doInBackground(String... params) {
        String type = params[0]; //pega valores passados no metodo onLogin da classe mainActivity
        String user_name = params[1];
        String password = params[2];
        String login_url = "http://192.168.11.1/quickroomservice/login.php";
        String register_url = "http://192.168.0.2/register.php";

        if (type.equals("login")) {
            try {
                URL url = new URL(login_url);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);
                connection.setDoInput(true);

                OutputStream outputStream = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, DATA_TYPE));
                String post_data = URLEncoder.encode("login", DATA_TYPE) + "=" + URLEncoder.encode(user_name, DATA_TYPE) + "&" +
                        URLEncoder.encode("senha", DATA_TYPE) + "=" + URLEncoder.encode(password, DATA_TYPE);

                writer.write(post_data);
                writer.flush();
                writer.close();
                outputStream.close();

                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, DATA_TYPE2));

                String result = "", line;
                while ((line = reader.readLine()) != null) {
                    result += line;
                }
                reader.close();
                inputStream.close();

                connection.disconnect();

                loginStatus = true;
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (type.equals("register")) {

            String user_user_name = params[1];
            String user_surname = params[2];
            String user_age = params[3];
            String user_username = params[4];
            String user_password = params[5];

            try {
                URL url = new URL(register_url);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);
                connection.setDoInput(true);

                OutputStream outputStream = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, DATA_TYPE));
                String post_data =
                        URLEncoder.encode("user_name", DATA_TYPE) + "=" + URLEncoder.encode(user_user_name, DATA_TYPE) + "&" +
                        URLEncoder.encode("user_surname", DATA_TYPE) + "=" + URLEncoder.encode(user_surname, DATA_TYPE) + "&" +
                        URLEncoder.encode("user_age", DATA_TYPE) + "=" + URLEncoder.encode(user_age, DATA_TYPE) + "&" +
                        URLEncoder.encode("user_username", DATA_TYPE) + "=" + URLEncoder.encode(user_username, DATA_TYPE) + "&" +
                        URLEncoder.encode("user_password", DATA_TYPE) + "=" + URLEncoder.encode(user_password, DATA_TYPE);

                writer.write(post_data);
                writer.flush();
                writer.close();
                outputStream.close();

                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, DATA_TYPE2));

                String result = "", line;
                while ((line = reader.readLine()) != null) {
                    result += line;
                }
                reader.close();
                inputStream.close();

                connection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return "doInBackGround error";
    }

    @Override
    protected void onPostExecute(String result) {
        Toast toast = Toast.makeText(contex.getApplicationContext(), result, Toast.LENGTH_LONG);
        toast.show();

        if(loginStatus){
            Intent intent = new Intent(contex.getApplicationContext(), RecepcaoActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            contex.startActivity(intent);
            loginStatus = false;
        }

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
