package com.example.otvertka.makko;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnLogin;
    EditText edtName, edtWater, edtGas;

    TextView textView;

    ListView listIndicators;

    DBHelper dbHelper;

    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        textView = (TextView) findViewById(R.id.textView);

        listIndicators = (ListView) findViewById(R.id.listIndicators);

        edtName = (EditText) findViewById(R.id.edtName);
        edtWater = (EditText) findViewById(R.id.edtWater);
        edtGas = (EditText) findViewById(R.id.edtGas);

        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        dbHelper = new DBHelper();
        String name = edtName.getText().toString();
        String water = edtWater.getText().toString();
        String gas = edtGas.getText().toString();

        switch (view.getId()){
            case R.id.btnLogin:
                dbHelper.start(name, water, gas);
                try {
                    dbHelper.join();
                } catch (InterruptedException ie) {
                    Log.e("pass 0", ie.getMessage());
                    textView.setText("ERRor: " + ie.getMessage());
                }
                textView.setText("GOOD. " + dbHelper.returnResult());
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
                break;
        }
    }
}
