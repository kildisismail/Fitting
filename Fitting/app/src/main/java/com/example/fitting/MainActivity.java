package com.example.fitting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageButton btnEndeks;
    ImageButton btnKalori;
    ImageButton btnTarif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEndeks=(ImageButton) findViewById(R.id.btnEndeks);
        btnEndeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intentEndeks = new Intent(MainActivity.this,Endeks.class);
            startActivity(intentEndeks);
            finish();
            }
        });

        btnKalori=(ImageButton) findViewById(R.id.btnKalori);

        btnKalori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKalori = new Intent(MainActivity.this,Kalori.class);
                startActivity(intentKalori);
                finish();
            }
        });

        btnTarif=(ImageButton) findViewById(R.id.btnTarif);

        btnTarif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTarif = new Intent(MainActivity.this,Tarif.class);
                startActivity(intentTarif);
                finish();
            }
        });
    }
}
