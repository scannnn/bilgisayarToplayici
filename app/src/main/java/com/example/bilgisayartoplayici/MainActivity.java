package com.example.bilgisayartoplayici;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    public String ipv4 = "";
    EditText iterasyonSayisi;
    EditText nesilSayisi;
    EditText ortalamaFiyat;
    EditText ortalamaPuan;
    EditText ipv4Al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iterasyonSayisi = findViewById(R.id.iterasyonSayisi);
        nesilSayisi = findViewById(R.id.nesilSayisi);
        ortalamaFiyat = findViewById(R.id.ortalamaFiyat);
        ortalamaPuan = findViewById(R.id.ortalamaPuan);
        ipv4Al = findViewById(R.id.ipv4Al);
    }

    public void gonder(View view) {
        final Intent intent = new Intent(this,sonucEkrani.class);

        String url = "http://"+ipv4+"/genetik/iterasyon="+iterasyonSayisi.getText().toString()
                +"&nesil="+nesilSayisi.getText().toString()+"&para="+ortalamaFiyat.getText().toString()+"&puan="+ortalamaPuan.getText().toString();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String text = new String(responseBody);
                intent.putExtra("response", text);
                startActivity(intent);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                error.printStackTrace();
            }
        });

    }

    public void ipv4Click(View view) {
        ipv4 = ipv4Al.getText().toString();
        ipv4Al.setText("");
    }

    public void temizleClick(View view) {
        iterasyonSayisi.setText("");
        nesilSayisi.setText("");
        ortalamaPuan.setText("");
        ortalamaFiyat.setText("");
    }
}
