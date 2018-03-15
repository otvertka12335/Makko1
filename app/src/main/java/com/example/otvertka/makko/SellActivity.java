package com.example.otvertka.makko;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
import java.util.ArrayList;

public class SellActivity extends AppCompatActivity {

    ListView listSell;

    InputStream is = null;
    String result = null;
    String line = null;

    String id = "0";
    String name = "Not Founded";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty);

//        frag = new Fragment1();

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//        listSell = (ListView) findViewById(R.id.listSell);
//
//        ArrayList<NameValuePair> sellValuePairs = new ArrayList<NameValuePair>();
//
//        sellValuePairs.clear();
//
//        try {
//            HttpClient httpClient = new DefaultHttpClient();
//            HttpPost httpPost = new HttpPost("http://vkravchik.000webhostapp.com/menuSelect.php");
//            httpPost.setEntity(new UrlEncodedFormEntity(sellValuePairs, "UTF-8"));
//            HttpResponse response = httpClient.execute(httpPost);
//            HttpEntity entity = response.getEntity();
//            is = entity.getContent();
//            Log.e("Pass 1.2", "Connection success");
//        } catch (Exception e) {
//            Log.e("Fail 1.2", e.toString());
//        }
//        //Відповідь від сервера
//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
//            StringBuilder stringBuilder = new StringBuilder();
//            while ((line = reader.readLine()) != null) {
//                stringBuilder.append(line + "\n");
//            }
//            is.close();
//            result = stringBuilder.toString();
//            Log.e("Pass 2.2", "Connection success: " + result);
//        } catch (Exception e) {
//            Log.e("Fail 2.2", e.toString());
//        }
//        //Получаэмо результат
//        try {
//            JSONObject jsonObject = new JSONObject(result);
//            id = (jsonObject.getString("id"));
//            name = (jsonObject.getString("name"));
//            Log.e("Pass 3.2", "ID: " + id + " Ім’я: " + name);
//
//            sellValuePairs.add(new BasicNameValuePair("id", id));
//            sellValuePairs.add(new BasicNameValuePair("name", name));
//
//
//
//
//
//
//
//
//            // создаем адаптер
//            ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, sellValuePairs);
//            // устанавливаем для списка адаптер
//            listSell.setAdapter(adapter);
//        } catch (Exception e) {
//            Log.e("Fail 3.2", e.toString());
//        }


    }
}
