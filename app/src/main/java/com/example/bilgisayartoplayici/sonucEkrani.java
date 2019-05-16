package com.example.bilgisayartoplayici;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class sonucEkrani extends AppCompatActivity {

    TextView ekranKarti;
    TextView anaKart;
    TextView islemci;
    TextView ram;
    TextView powerSupply;
    TextView hardDisk;
    TextView puan;
    TextView fiyat;
    TextView bulduguIterasyon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc_ekrani);

        ekranKarti = findViewById(R.id.ekranKarti);
        anaKart = findViewById(R.id.anaKart);
        islemci = findViewById(R.id.islemci);
        ram = findViewById(R.id.ram);
        powerSupply = findViewById(R.id.powerSupply);
        hardDisk = findViewById(R.id.hardDisk);
        puan = findViewById(R.id.puan);
        fiyat = findViewById(R.id.fiyat);
        bulduguIterasyon = findViewById(R.id.bulduguIterasyon);

        Intent intent = getIntent();
        String response = intent.getStringExtra("response");
        String[] text = response.split("/");
        anaKart.setText(text[0]);
        ekranKarti.setText(text[1]);
        hardDisk.setText(text[2]);
        islemci.setText(text[3]);
        powerSupply.setText(text[4]);
        ram.setText(text[5]);
        fiyat.setText(text[6]);
        puan.setText(text[7]);
        bulduguIterasyon.setText(text[8]);
    }

    public void yeni(View view) {
        this.finish();
    }
    
}
