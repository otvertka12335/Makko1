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
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

public class DBHelper extends Thread {

    String name = "Err";
    String water = "0";
    String gas = "0";
    InputStream is = null;
    String result = null;
    String line = null;

    public void run(){
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

        nameValuePairs.clear();

        nameValuePairs.add(new BasicNameValuePair("name", name));
        nameValuePairs.add(new BasicNameValuePair("water", water));
        nameValuePairs.add(new BasicNameValuePair("gas", gas));
        //Звернення до сервера
        try{
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://vkravchik.000webhostapp.com/auth.php");
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
            Log.e("Pass 1","Connection success");
        } catch (Exception e){
            Log.e("Fail 1", e.toString());
        }
        //Відповідь від сервера
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
            StringBuilder stringBuilder = new StringBuilder();
            while((line = reader.readLine()) != null){
                stringBuilder.append(line + "\n");
            }
            is.close();
            result = stringBuilder.toString();
            Log.e("Pass 2", "Connection success: " + result);
        } catch (Exception e){
            Log.e("Fail 2", e.toString());
        }
        //Получаэмо результат
        try{
            JSONObject jsonObject = new JSONObject(result);
            name = (jsonObject.getString("user_id"));
            water = (jsonObject.getString("water"));
            gas = (jsonObject.getString("gas"));
            Log.e("Pass 3", "Ім’я: " + name + " Вода: "  + water + " Гас: " + gas);

        } catch (Exception e){
            Log.e("Fail 3", e.toString());
        }
    }

    public void start(String name, String water, String gas){
        this.name = name;
        this.water = water;
        this.gas = gas;
        this.start();
    }

    public String returnResult(){
        String result = "Ім’я: " + name + " Вода: "  + water + " Гас: " + gas;
        return result;
    }
}



