package com.example.loppuprojekti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    ImageView profileIcon;
    Toolbar topbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileIcon = findViewById(R.id.profiiliButton);
        topbar = findViewById(R.id.toolbar);
        setSupportActionBar(topbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        profileIcon.setBackgroundColor(0xFF2196F3);
    }

    public void homeButtonPressed(View V) {
        Intent profile = new Intent(this, MainActivity.class);
        startActivity(profile);
    }

    public void openTraining(View V) {
        Intent training = new Intent(this, TrainingActivity.class);
        startActivity(training);
    }

    public void profileButtonPressed(View V) {
        Intent profile = new Intent(this, ProfileActivity.class);
        startActivity(profile);
    }
}