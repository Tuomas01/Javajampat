package com.example.loppuprojekti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrainingActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView trainingIcon;
    Toolbar topbar;
    DrawerLayout menulayout;
    NavigationView menuitems;

    TextView harjoitus;
    //ListView harjoituksetLista;

    public ArrayList<String> harjoitukset;

    private final String sharedPreferenceName = "HarjoitusLista";
    private final String messageKey2 = "vika";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

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

        trainingIcon.setBackgroundColor(0xFF2196F3);

        //ArrayList ja uusi harjoitus listalle
        harjoitukset = new ArrayList<String>();
        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        String value = sharedPreferences.getString("Viimeisin","Ei harjoituksia");
        harjoitukset.add(value);


        //HashSetin tallennus
        SharedPreferences preferences2 = getSharedPreferences("myKey2", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences2.edit();
        Set<String> set = new HashSet<String>();
        set.addAll(harjoitukset);

        editor.putStringSet(messageKey2, set);
        editor.commit();


        //Listalta otto
        SharedPreferences sharedPreferences2 = getSharedPreferences("myKey2", MODE_PRIVATE);
        //String value2 = sharedPreferences2.getString("vika","Ei harjoituksia");

        List<String> list = new ArrayList<String>(set);
        //list.add(value2);
        ListView harjoituksetLista = findViewById(R.id.harjoitukset);
        harjoituksetLista.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));

        //Set<String> setti = harjoitukset.getStringSet("key", null);

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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.addnew:
                Intent training = new Intent(this, AddTrainingActivity.class);
                startActivity(training);
        }

        return true;
    }
}