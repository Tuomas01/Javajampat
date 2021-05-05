package com.example.loppuprojekti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class UniSivu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar topbar;
    ImageView sleepIcon;
    DrawerLayout menulayout;
    NavigationView menuitems;
    TextView timeslept;
    String nimi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uni_sivu);
        topbar = findViewById(R.id.toolbar);
        menulayout = findViewById(R.id.drawerLayout);
        menuitems = findViewById(R.id.menuView);
        sleepIcon = findViewById(R.id.sleepButton);
        timeslept.setText(nimi);

        setSupportActionBar(topbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        menuitems.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, menulayout, topbar, R.string.drawerOpen, R.string.drawerClose);
        menulayout.addDrawerListener(toggle);
        toggle.syncState();

        menuitems.setNavigationItemSelectedListener(this);

        sleepIcon.setBackgroundColor(0xFF2196F3);
    }

    public void profileButtonPressed(View V) {
        Intent profile = new Intent(this, ProfileActivity.class);
        startActivity(profile);
    }

    public void openTraining(View V) {
        Intent training = new Intent(this, TrainingActivity.class);
        startActivity(training);
    }

    public void homeButtonPressed(View V) {
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }

    public void uniButtonPressed(View V) {
        Intent uni = new Intent(this, UniSivu.class);
        startActivity(uni);
    }

    public void ravintoButtonPressed(View V) {
        Intent ravinto = new Intent(this, RavintoSivu.class);
        startActivity(ravinto);
    }

    public void getName(ProfileActivity profileActivity) {
        nimi = profileActivity.profileInformation.getName();
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