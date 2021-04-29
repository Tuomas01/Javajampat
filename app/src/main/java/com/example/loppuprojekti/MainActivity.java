package com.example.loppuprojekti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar topbar = findViewById(R.id.toolbar);
        setSupportActionBar(topbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}