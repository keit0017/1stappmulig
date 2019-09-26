package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    /*variabler bliver deklererede*/

    Button b1,b2;
    TextView lost;
    WebView babu;
    int lateral;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        babu = (WebView) findViewById(R.id.webview1);   //webview hentes fra activity_main
        babu.setWebViewClient(new WebViewClient());     //webclienten åbnes
        babu.loadUrl("https://en.wikipedia.org/wiki/Purchasing_power_parity");
        babu.setVisibility(View.GONE);                  //her vælger jeg at gemme hjemmesiden i første omgang
        lateral=0;


        b1 = findViewById(R.id.button);                 //knapperne deklereres
        b2 = findViewById(R.id.button2);

        lost = findViewById(R.id.textView);


        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    public void onClick(View v) {
        System.out.println("Der blev trykket på en knap");

        if (v == b1) {
            lost.setText("KNAP 1 TRYKKET");



        } else if (v == b2) {
            lost.setText("KNAP 2 TRYKKET ");

            /*Denne kode gør at jeg ved at tryke på denne knap ændre
            1. webview
            2. knap 1 visabilitet
            3. status teksten
            hvis denne knap trykkes igen går det tilbage til før.
             */

            if (lateral==0){
                babu.setVisibility(View.VISIBLE);
                b1.setVisibility(View.GONE);
                lateral=1;
                lost.setText("knap2; Webview er nu åben");

            } else {
                babu.setVisibility(View.GONE);
                b1.setVisibility(View.VISIBLE);
                lateral=0;
                lost.setText("knap2; Webview er nu lukket");
            }

        }

    }
}
