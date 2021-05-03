package com.example.loppuprojekti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class ProfileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static String TAG = "Kukkuu";
    ImageView profileIcon;
    Toolbar topbar;
    DrawerLayout menulayout;
    NavigationView menuitems;
    ProfileInformation profileInformation;
    EditText profileName;
    EditText profileAge;
    EditText profileSleep;
    EditText profileCalories;
    EditText profileHeight;
    EditText profileWeight;
    public static String name;
    int age;
    int sleep;
    int calories;
    int height;
    int weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileIcon = findViewById(R.id.profiiliButton);
        topbar = findViewById(R.id.toolbar);
        menulayout = findViewById(R.id.drawerLayout);
        menuitems = findViewById(R.id.menuView);

        setSupportActionBar(topbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        menuitems.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, menulayout, topbar, R.string.drawerOpen, R.string.drawerClose);
        menulayout.addDrawerListener(toggle);
        toggle.syncState();

        menuitems.setNavigationItemSelectedListener(this);

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

    public void uniButtonPressed(View V) {
        Intent uni = new Intent(this, UniSivu.class);
        startActivity(uni);
    }

    public void ravintoButtonPressed(View V) {
        Intent ravinto = new Intent(this, RavintoSivu.class);
        startActivity(ravinto);
    }

    public void saveInformationButtonPressed(View V) {
        profileName = findViewById(R.id.nameInput);
        profileAge = findViewById(R.id.ageInput);
        profileSleep = findViewById(R.id.sleepInput);
        profileCalories = findViewById(R.id.caloriesInput);
        profileHeight = findViewById(R.id.heightInput);
        profileWeight = findViewById(R.id.weightInput);

        name = profileName.getText().toString();
        age = Integer.parseInt(profileAge.getText().toString());
        sleep = Integer.parseInt(profileSleep.getText().toString());
        calories = Integer.parseInt(profileCalories.getText().toString());
        height = Integer.parseInt(profileHeight.getText().toString());
        weight = Integer.parseInt(profileWeight.getText().toString());
        profileInformation = new ProfileInformation(name, age, sleep, calories, height, weight);
        Log.d(TAG, profileInformation.toString());
    }

    @Override
    public void onBackPressed() {

        if(menulayout.isDrawerOpen(GravityCompat.START)) {
            menulayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.addnew:
                Intent training = new Intent(this, TrainingActivity.class);
                startActivity(training);
        }

        return true;
    }
}