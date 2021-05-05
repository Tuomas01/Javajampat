package com.example.loppuprojekti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static String TAG = "Kukkuu";
    Toolbar topbar;
    ImageView homeicon;
    DrawerLayout menulayout;
    NavigationView menuitems;
    TextView tervehdys;
    /**
     * Metodi onCreate tekee navigointipalkin, ja eri napit jotka ovat liitettynä siihen.
     * @param savedInstanceState tekee mahdolliseksi tervehdystekstin näkymisen ja menuitemien näkymisen.
     * @author Tuomas Alatalo
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeicon = findViewById(R.id.homeButton);
        topbar = findViewById(R.id.toolbar);
        menulayout = findViewById(R.id.drawerLayout);
        menuitems = findViewById(R.id.menuView);
        tervehdys = findViewById(R.id.Tervehdysviesti);
        tervehdys.setText("Hei käyttäjä");
        setSupportActionBar(topbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Drawable forest = getResources().getDrawable(R.drawable.forest);
        forest.setAlpha(255);

        menuitems.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, menulayout, topbar, R.string.drawerOpen, R.string.drawerClose);
        menulayout.addDrawerListener(toggle);
        toggle.syncState();

        menuitems.setNavigationItemSelectedListener(this);
        menuitems.setCheckedItem(R.id.homeshortcut);

        homeicon.setBackgroundColor(0xFF2196F3);
    }
    /**
     * Metodi profileButtonPressed avaa profiilisivun aktiviteetin.
     * @param V tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Tuomas Alatalo
     */
    public void profileButtonPressed(View V) {
        Intent profile = new Intent(this, ProfileActivity.class);
        startActivity(profile);
    }
    /**
     * Avaa harjoitussivun aktiiviteetin
     * @param V tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Tuomas Alatalo
     */
    public void openTraining(View V) {
        Intent training = new Intent(this, TrainingActivity.class);
        startActivity(training);
    }
    /**
     * Metodi homeButtonPressed avaa etusivun aktiviteetin.
     * @param V tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Tuomas Alatalo
     */
    public void homeButtonPressed(View V) {
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }
    /**
     * Metodi uniButtonPressed avaa unisivun aktiviteetin.
     * @param V tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Tuomas Alatalo
     */
    public void uniButtonPressed(View V) {
        Intent uni = new Intent(this, UniSivu.class);
        startActivity(uni);
    }
    /**
     * Metodi ravintoButtonPressed avaa ravintosivun aktiviteetin.
     * @param V tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Tuomas Alatalo
     */
    public void ravintoButtonPressed(View V) {
        Intent ravinto = new Intent(this, RavintoSivu.class);
        startActivity(ravinto);
    }

    public void newFromMenuPressed(View V) {
        Intent addTraining = new Intent(this, AddTrainingActivity.class);
        startActivity(addTraining);
    }
    /**
     * Kun emulaattorin nuolinappulaa eli takaisin nappulaa painetaan, jos drawer menu on auki sulje se, muutoin käytä takaisin nappulaa normaalisti.
     * @author Tuomas Alatalo
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
     * @author Tuomas Alatalo
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