package com.example.loppuprojekti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    public static final String sharedPreferencesName = "MessageStore";
    public static final String namepref = "LatestHitsMessage";
    public static final String agepref = "agepref";
    public static final String sleeppref = "sleeppref";
    public static final String caloriespref = "caloriespref";
    public static final String heightpref = "heightpref";
    public static final String weightpref = "weightpref";
    private String namesavedpref;
    private String agesavedpref;
    private String sleepsavedpref;
    private String caloriessavedpref;
    private String heightsavedpref;
    private String weightsavedpref;
    TextView saved;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileName = findViewById(R.id.nameInput);
        profileAge = findViewById(R.id.ageInput);
        profileSleep = findViewById(R.id.sleepInput);
        profileCalories = findViewById(R.id.caloriesInput);
        profileHeight = findViewById(R.id.heightInput);
        profileWeight = findViewById(R.id.weightInput);
        profileIcon = findViewById(R.id.profiiliButton);
        topbar = findViewById(R.id.toolbar);
        menulayout = findViewById(R.id.drawerLayout);
        menuitems = findViewById(R.id.menuView);
        saved = findViewById(R.id.tiedotTallennettu);

        Drawable sky = getResources().getDrawable(R.drawable.sky);
        sky.setAlpha(90);

        setSupportActionBar(topbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        menuitems.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, menulayout, topbar, R.string.drawerOpen, R.string.drawerClose);
        menulayout.addDrawerListener(toggle);
        toggle.syncState();

        menuitems.setNavigationItemSelectedListener(this);

        menuitems.setCheckedItem(R.id.profiilishortcut);

        profileIcon.setBackgroundColor(0xFF2196F3);

        loadData();
        update();

        profileName.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                profileName.getText().clear();
                return false;
            }
        });

        profileAge.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                profileAge.getText().clear();
                return false;
            }
        });

        profileSleep.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                profileSleep.getText().clear();
                return false;
            }
        });

        profileCalories.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                profileCalories.getText().clear();
                return false;
            }
        });

        profileHeight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                profileHeight.getText().clear();
                return false;
            }
        });

        profileWeight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                profileWeight.getText().clear();
                return false;
            }
        });
    }

    protected void onPause() {
        super.onPause();
        SharedPreferences preferences = getSharedPreferences(sharedPreferencesName, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(namepref, profileName.getText().toString());
        editor.putString(agepref, profileAge.getText().toString());
        editor.putString(sleeppref, profileSleep.getText().toString());
        editor.putString(caloriespref, profileCalories.getText().toString());
        editor.putString(heightpref, profileHeight.getText().toString());
        editor.putString(weightpref, profileWeight.getText().toString());

        editor.apply();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPreferencesName, MODE_PRIVATE);
        namesavedpref = sharedPreferences.getString(namepref, "");
        agesavedpref = sharedPreferences.getString(agepref, "");
        sleepsavedpref = sharedPreferences.getString(sleeppref, "");
        caloriessavedpref = sharedPreferences.getString(caloriespref, "");
        heightsavedpref = sharedPreferences.getString(heightpref, "");
        weightsavedpref = sharedPreferences.getString(weightpref, "");
    }

    public void update() {
        profileName.setText(namesavedpref);
        profileAge.setText(agesavedpref);
        profileSleep.setText(sleepsavedpref);
        profileCalories.setText(caloriessavedpref);
        profileHeight.setText(heightsavedpref);
        profileWeight.setText(weightsavedpref);
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
        Toast.makeText(this, "Tiedot tallennettu", Toast.LENGTH_SHORT).show();
        saved.setText("Tiedot tallennettu");
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

        if (menulayout.isDrawerOpen(GravityCompat.START)) {
            menulayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.addnew:
                Intent training = new Intent(this, AddTrainingActivity.class);
                startActivity(training);
                Log.d(TAG, "training selected");
                break;
            case R.id.trainingshortcut:
                Intent trainingPage = new Intent(this, TrainingActivity.class);
                startActivity(trainingPage);
                Log.d(TAG, "trainingsivu selected");
                break;
            case R.id.ravintoshortcut:
                Intent ravinto = new Intent(this, RavintoSivu.class);
                startActivity(ravinto);
                Log.d(TAG, "ravinto selected");
                break;
            case R.id.homeshortcut:
                Intent home = new Intent(this, MainActivity.class);
                startActivity(home);
                Log.d(TAG, "home selected");
                break;
            case R.id.unisivushortcut:
                Intent uni = new Intent(this, UniSivu.class);
                startActivity(uni);
                Log.d(TAG, "uni selected");
                break;
            case R.id.profiilishortcut:
                Intent profiili = new Intent(this, ProfileActivity.class);
                startActivity(profiili);
                Log.d(TAG, "profiili selected");
                break;

        }

        menulayout.closeDrawer(GravityCompat.START);
        return true;
    }
}