package com.example.otvertka.makko;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.provider.Settings;
import android.util.Log;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

public class getSomething extends Thread {

    String name = "Err";
    String water = "0";
    String gas = "0";
    InputStream is = null;
    String result = null;
    String line = null;
    boolean nice;
    ArrayList<String> list = new ArrayList<>();


    public void run() {
        DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
        HttpPost httppost = new HttpPost("http://vkravchik.000webhostapp.com/menuSelect.php");
        System.out.println(1);
// Depends on your web service
        httppost.setHeader("Content-type", "application/json");
        System.out.println(1);

        InputStream inputStream = null;
        String result = null;
        try {
            HttpResponse response = httpclient.execute(httppost);
            System.out.println(2);
            HttpEntity entity = response.getEntity();
            System.out.println(3);

            inputStream = entity.getContent();
            System.out.println(4);
            // json is UTF-8 by default
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
            System.out.println(5);
            StringBuilder sb = new StringBuilder();
            System.out.println(6);

            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            System.out.println(7);
            result = sb.toString();
        } catch (Exception e) {
            System.out.println("fhdjsaflhdskal");
        }
        nice = true;
        String title = "";
        System.out.println(result);
        try {
            JSONArray jsonarray = new JSONArray(result);
            for (int i = 0; i < jsonarray.length(); i++) {
                try {
                    JSONObject oneObject = jsonarray.getJSONObject(i);
                    list.add(oneObject.getString("name"));
                    System.out.println(oneObject.getString("name"));
                } catch (JSONException e) {
                    System.out.println("some shit");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    public void start(String name, String water, String gas) {
        this.start();
    }

    public ArrayList<String> returnResult() {
        return list;
    }
}



