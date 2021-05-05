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
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrainingActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static String TAG = "Kukkuu";
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
        menuitems.setCheckedItem(R.id.addnew);

        trainingIcon.setBackgroundColor(0xFF2196F3);
        menuitems.setCheckedItem(R.id.trainingshortcut);

        //ArrayListin luonti ja uusi harjoitus listalle
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

    /**
     * Avaa harjoitussivun aktiviteetin.
     * @param V tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Niko Ala-aho
     */
    public void openTraining(View V) {
        Intent training = new Intent(this, TrainingActivity.class);
        startActivity(training);
    }

    /**
     * Avaa aktiviteetin, uuden harjoituksen lisäämiseen.
     * @param V tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Niko Ala-aho
     */
    public void newTraining(View V){
        Intent addtraining = new Intent(this, AddTrainingActivity.class);
        startActivity(addtraining);
    }

    /**
     * Avaa profiilisivun aktiviteetin.
     * @param V tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Niko Ala-aho
     */
    public void profileButtonPressed(View V) {
        Intent profile = new Intent(this, ProfileActivity.class);
        startActivity(profile);
    }

    /**
     * Avaa kotisivun aktiviteetin.
     * @param V tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Niko Ala-aho
     */
    public void homeButtonPressed(View V) {
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }

    /**
     * Avaa unisivun aktiviteetin.
     * @param V tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Niko Ala-aho
     */
    public void uniButtonPressed(View V) {
        Intent uni = new Intent(this, UniSivu.class);
        startActivity(uni);
    }

    /**
     * Avaa ravintosivun aktiviteetin.
     * @param V tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Niko Ala-aho
     */
    public void ravintoButtonPressed(View V) {
        Intent ravinto = new Intent(this, RavintoSivu.class);
        startActivity(ravinto);
    }

    /**
     * Kun emulaattorin nuolinappulaa eli takaisin nappulaa painetaan, jos drawer menu on auki sulje se, muutoin käytä takaisin nappulaa normaalisti.
     * @author Niko Ala-aho
     */
    @Override
    public void onBackPressed() {

        if(menulayout.isDrawerOpen(GravityCompat.START)) {
            menulayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    /**
     * Lisää drawer menussa oleviin nappuloihin toiminnallisuudet eli, kun menussa olevia nappuloita painetaan avaa nappulaa vastaava aktiviteetti
     * @param item nappula, joka haetaan id:n avulla
     * @return palauttaa true, eli kun nappula valitaan menusta palauttaa true
     * @author Niko Ala-aho
     */
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