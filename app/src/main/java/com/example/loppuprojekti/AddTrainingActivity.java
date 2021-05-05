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
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class AddTrainingActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ImageView trainingIcon;
    Toolbar topbar;
    DrawerLayout menulayout;
    NavigationView menuitems;
    public static String TAG = "kukkuu";
    private EditText editTextKesto;
    private EditText editTextKalorit;
    private EditText editTextAskeleet;
    private final String sharedPreferenceName = "Harjoitukset";
    private final String messageKey = "Viimeisin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_training);

        trainingIcon = findViewById(R.id.trainingButton);
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
        menuitems.setCheckedItem(R.id.addnew);

        //preferences = getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE);



    }

    public void addTrainingClicked(View v){

        SharedPreferences preferences = getSharedPreferences("myKey", MODE_PRIVATE);

        editTextKesto = findViewById(R.id.editTextNumber5);
        editTextKalorit = findViewById(R.id.editTextNumber6);
        editTextAskeleet = findViewById(R.id.editTextNumber7);

        String kesto = editTextKesto.getText().toString();
        int kestofinal = Integer.parseInt(kesto);

        String kalorit = editTextKalorit.getText().toString();
        int kaloritfinal = Integer.parseInt(kalorit);

        String askeleet= editTextAskeleet.getText().toString();
        int askeleetfinal=Integer.parseInt(askeleet);

        Harjoitus harjoitus = new Harjoitus(kestofinal, kaloritfinal, askeleetfinal);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(messageKey, harjoitus.toString());
        Log.d("kukkuu", harjoitus.toString());
        editor.commit();

        Intent training = new Intent(this, TrainingActivity.class);
        startActivity(training);

    }



    public void openTraining(View V) {
        Intent training = new Intent(this, TrainingActivity.class);
        startActivity(training);
    }

    public void profileButtonPressed(View V) {
        Intent profile = new Intent(this, ProfileActivity.class);
        startActivity(profile);
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

    @Override
    public void onBackPressed() {

        if(menulayout.isDrawerOpen(GravityCompat.START)) {
            menulayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @SuppressLint("NonConstantResourceId")
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