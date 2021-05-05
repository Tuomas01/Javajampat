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

import com.google.android.material.navigation.NavigationView;

public class RavintoSivu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    // Muuttujat
    public static String TAG = "Kukkuu";
    Toolbar topbar;
    ImageView foodIcon;
    DrawerLayout menulayout;
    NavigationView menuitems;
    /**
     * Metodi jota kutsutaan sovelluksen luodessa
     * @param savedInstanceState palauttaa aktiviteetin aikaisempaan tilaan tietyissä tapauksissa
     * @author Tuomas Heikkilä
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ravinto_sivu);
        // hae iconit, yläpalkki, drawermenun layout ja menun sisältö ideiden avulla
        foodIcon = findViewById(R.id.foodButton);
        topbar = findViewById(R.id.toolbar);
        menulayout = findViewById(R.id.drawerLayout);
        menuitems = findViewById(R.id.menuView);
        // hae aktiviteetin taustakuva
        Drawable campfire = getResources().getDrawable(R.drawable.campfire);
        // aseta taustakuvalle opacity
        campfire.setAlpha(90);
        // tee toolbaarista actionbar, jotta toolbaarista tulee interaktiivine
        setSupportActionBar(topbar);
        // piilota projektin nimi (Loppuprojekti) toolbaarista
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // tee menussa olevista napeista painettavia, jos ne eivät toimi ilman koodipätkää
        menuitems.bringToFront();
        // nappia painettaessa avaa tai sulje drawer menu
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, menulayout, topbar, R.string.drawerOpen, R.string.drawerClose);
        // lisää toiminto menu layouttiin
        menulayout.addDrawerListener(toggle);
        // synkronoi menun nappulan ja ilman sitä kuvakkeen synkronointi toimii huonommin tai ei toimi ollenkaan
        toggle.syncState();
        // tee menun nappuloista painettavia ja lisää "menuitems.bringToFront();", jos nappuloita ei voi tämän koodipätkän avulla clikata
        menuitems.setNavigationItemSelectedListener(this);
        // aseta menussa oleva nappi, joka kuvaa tätä luokkaa highlightatuksi
        menuitems.setCheckedItem(R.id.ravintoshortcut);
        // aseta alapalkissa olevalle iconille erilainen väri, jotta siitä erottaa millä sivulla ollaan
        foodIcon.setBackgroundColor(0xFF2196F3);
    }
    /**
     * Metodi homeButtonPressed avaa profiilisivun aktiviteetin.
     * @param V tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Tuomas Heikkilä
     */
    public void profileButtonPressed(View V) {
        Intent profile = new Intent(this, ProfileActivity.class);
        startActivity(profile);
    }
    /**
     * Metodi openTraining avaa harjoitus sivun aktiviteetin.
     * @param V tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Tuomas Heikkilä
     */
    public void openTraining(View V) {
        Intent training = new Intent(this, TrainingActivity.class);
        startActivity(training);
    }
    /**
     * Metodi homeButtonPressed avaa kotisivun aktiviteetin.
     * @param V tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Tuomas Heikkilä
     */
    public void homeButtonPressed(View V) {
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }
    /**
     * Metodi uniButtonPressed avaa unisivun aktiviteetin.
     * @param V tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Tuomas Heikkilä
     */
    public void uniButtonPressed(View V) {
        Intent uni = new Intent(this, UniSivu.class);
        startActivity(uni);
    }
    /**
     * Metodi ravintoButtonPressed avaa ravintosivun aktiviteetin.
     * @param V tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Tuomas Heikkilä
     */
    public void ravintoButtonPressed(View V) {
        Intent ravinto = new Intent(this, RavintoSivu.class);
        startActivity(ravinto);
    }
    /**
     * Kun emulaattorin nuolinappulaa eli takaisin nappulaa painetaan, jos drawer menu on auki sulje se, muutoin käytä takaisin nappulaa normaalisti.
     * @author Tuomas Heikkilä
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
     * @author Tuomas Heikkilä
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.addnew:
                // luo uusi intent aktiviteetille
                Intent training = new Intent(this, AddTrainingActivity.class);
                // käynnistä aktiviteetti, kun menussa olevaa nappulaa painetaan
                startActivity(training);
                Log.d(TAG, "training selected");
                break;
            case R.id.trainingshortcut:
                // luo uusi intent aktiviteetille
                Intent trainingPage = new Intent(this, TrainingActivity.class);
                // käynnistä aktiviteetti, kun menussa olevaa nappulaa painetaan
                startActivity(trainingPage);
                Log.d(TAG, "trainingsivu selected");
                break;
            case R.id.ravintoshortcut:
                // luo uusi intent aktiviteetille
                Intent ravinto = new Intent(this, RavintoSivu.class);
                // käynnistä aktiviteetti, kun menussa olevaa nappulaa painetaan
                startActivity(ravinto);
                Log.d(TAG, "ravinto selected");
                break;
            case R.id.homeshortcut:
                // luo uusi intent aktiviteetille
                Intent home = new Intent(this, MainActivity.class);
                // käynnistä aktiviteetti, kun menussa olevaa nappulaa painetaan
                startActivity(home);
                Log.d(TAG, "home selected");
                break;
            case R.id.unisivushortcut:
                // luo uusi intent aktiviteetille
                Intent uni = new Intent(this, UniSivu.class);
                // käynnistä aktiviteetti, kun menussa olevaa nappulaa painetaan
                startActivity(uni);
                Log.d(TAG, "uni selected");
                break;
            case R.id.profiilishortcut:
                // luo uusi intent aktiviteetille
                Intent profiili = new Intent(this, ProfileActivity.class);
                // käynnistä aktiviteetti, kun menussa olevaa nappulaa painetaan
                startActivity(profiili);
                Log.d(TAG, "profiili selected");
                break;

        }

        menulayout.closeDrawer(GravityCompat.START);
        return true;
    }
}