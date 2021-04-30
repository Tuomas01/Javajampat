package com.example.loppuprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toolbar;

public class UniSivu extends AppCompatActivity {

    Toolbar topbar;
    ImageView sleepIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uni_sivu);


        sleepIcon = findViewById(R.id.sleepButton);
        topbar = findViewById(R.id.toolbar);
        sleepIcon.setBackgroundColor(0xFF2196F3);
    }
}