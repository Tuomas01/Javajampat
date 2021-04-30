package com.example.loppuprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toolbar;

public class RavintoSivu extends AppCompatActivity {

    Toolbar topbar;
    ImageView foodIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ravinto_sivu);

        foodIcon = findViewById(R.id.foodButton);
        topbar = findViewById(R.id.toolbar);
        foodIcon.setBackgroundColor(0xFF2196F3);
    }
}