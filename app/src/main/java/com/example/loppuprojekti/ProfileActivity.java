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

/*"implements NavigationView.OnNavigationItemSelectedListener" lisätään luokkaan, jotta drawer menun valittuja kohtia voidaan valita ja painaa.*/
public class ProfileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    // muuttujat ja preferenssit.
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
    EditText unisivunimi;

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

    // SuppressLint ignoraa tietyt ehdotukset. Ohjelma ehdottaa, että loisin aliluokkia,
    // jotta saisin ohjelman toimimaan myös käyttäjillä, jotka ovat sokeita

    /**
     * Metodi jota kutsutaan sovelluksen luodessa
     * @param savedInstanceState palauttaa aktiviteetin aikaisempaan tilaan tietyissä tapauksissa
     * @author Tuomas Heikkilä
     */
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // liitä layoutti aktiviteettiin
        setContentView(R.layout.activity_profile);
        // hae tekstikentät, muokattavat tekstikentät ja toolbaari ideiden avulla
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
        // hae layoutin taustakuva resource tiedostoista ja aseta se muuttujaan
        Drawable sky = getResources().getDrawable(R.drawable.sky);
        // aseta sky muuttujalle opacityä
        sky.setAlpha(90);
        // tee toolbaarista actionbar, jotta toolbaarista tulee interaktiivinen
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
        menuitems.setCheckedItem(R.id.profiilishortcut);
        // aseta alapalkissa olevalle iconille erilainen väri, jotta siitä erottaa millä sivulla ollaan
        profileIcon.setBackgroundColor(0xFF2196F3);
        // kutsu metodeja loadData, joka tallentaa preferenssit ja update, joka asettaa preferensseihin tallennetut arvot näkyville
        loadData();
        update();
        // luo OnTouchListenerit, jotka poistavat EditText kentistä tekstin ja käyttäjä voi aloittaa kirjoittamisen tyhjältä inputkentältä
        profileName.setOnTouchListener(new View.OnTouchListener() {
            @Override
            // luo OnTouchListenerit, jotka poistavat EditText kentistä tekstin ja käyttäjä voi aloittaa kirjoittamisen tyhjältä inputkentältä
            public boolean onTouch(View v, MotionEvent event) {
                profileName.getText().clear();
                return false;
            }
        });

        profileAge.setOnTouchListener(new View.OnTouchListener() {
            @Override
            // luo OnTouchListenerit, jotka poistavat EditText kentistä tekstin ja käyttäjä voi aloittaa kirjoittamisen tyhjältä inputkentältä
            public boolean onTouch(View v, MotionEvent event) {
                profileAge.getText().clear();
                return false;
            }
        });

        profileSleep.setOnTouchListener(new View.OnTouchListener() {
            @Override
            // luo OnTouchListenerit, jotka poistavat EditText kentistä tekstin ja käyttäjä voi aloittaa kirjoittamisen tyhjältä inputkentältä
            public boolean onTouch(View v, MotionEvent event) {
                profileSleep.getText().clear();
                return false;
            }
        });

        profileCalories.setOnTouchListener(new View.OnTouchListener() {
            @Override
            // luo OnTouchListenerit, jotka poistavat EditText kentistä tekstin ja käyttäjä voi aloittaa kirjoittamisen tyhjältä inputkentältä
            public boolean onTouch(View v, MotionEvent event) {
                profileCalories.getText().clear();
                return false;
            }
        });

        profileHeight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            // luo OnTouchListenerit, jotka poistavat EditText kentistä tekstin ja käyttäjä voi aloittaa kirjoittamisen tyhjältä inputkentältä
            public boolean onTouch(View v, MotionEvent event) {
                profileHeight.getText().clear();
                return false;
            }
        });

        profileWeight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            // luo OnTouchListenerit, jotka poistavat EditText kentistä tekstin ja käyttäjä voi aloittaa kirjoittamisen tyhjältä inputkentältä
            public boolean onTouch(View v, MotionEvent event) {
                profileWeight.getText().clear();
                return false;
            }
        });
    }

    /**
     * luodaan onPause funktion, jota kutsutaan, kun sovellus menee esim. taustalle tai sitä ei käytetä
     * @author Tuomas Heikkilä
     */
    protected void onPause() {
        super.onPause();
        // luo shared preferences ja editori, jonne tallennetaan merkkijonoja
        SharedPreferences preferences = getSharedPreferences(sharedPreferencesName, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        // tallenna/aseta preferensseihin editoria käyttämällä merkkijonoiksi muunnetut käyttäjän syöttämät tiedot
        editor.putString(namepref, profileName.getText().toString());
        editor.putString(agepref, profileAge.getText().toString());
        editor.putString(sleeppref, profileSleep.getText().toString());
        editor.putString(caloriespref, profileCalories.getText().toString());
        editor.putString(heightpref, profileHeight.getText().toString());
        editor.putString(weightpref, profileWeight.getText().toString());
        // suorita preferensseihin tallennus
        editor.apply();
    }

    /**
     * metodi, joka hakee preferensseistä merkkijonot ja asettaa oletusarvon "", jos haettua tietoa ei löydy
     * @author Tuomas Heikkilä
     */
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPreferencesName, MODE_PRIVATE);
        namesavedpref = sharedPreferences.getString(namepref, "");
        agesavedpref = sharedPreferences.getString(agepref, "");
        sleepsavedpref = sharedPreferences.getString(sleeppref, "");
        caloriessavedpref = sharedPreferences.getString(caloriespref, "");
        heightsavedpref = sharedPreferences.getString(heightpref, "");
        weightsavedpref = sharedPreferences.getString(weightpref, "");
    }

    /**
     * metodi, joka asettaa haetut merkkijonot EditText kenttiin. asettaa käyttäjän aikasemmin syöttämät tiedot profiilisivulle (metodia kutsuttu oncreatess
     * @author Tuomas Heikkilä
     */
    public void update() {
        profileName.setText(namesavedpref);
        profileAge.setText(agesavedpref);
        profileSleep.setText(sleepsavedpref);
        profileCalories.setText(caloriessavedpref);
        profileHeight.setText(heightsavedpref);
        profileWeight.setText(weightsavedpref);
    }
    /**
     * Metodi homeButtonPressed avaa profiilisivun aktiviteetin.
     * @param V tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Tuomas Heikkilä
     */
    public void homeButtonPressed(View V) {
        Intent profile = new Intent(this, MainActivity.class);
        startActivity(profile);
    }
    /**
     * Metodi openTraining avaa harjoitussivun aktiviteetin.
     * @param V tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Tuomas Heikkilä
     */
    public void openTraining(View V) {
        Intent training = new Intent(this, TrainingActivity.class);
        startActivity(training);
    }
    /**
     * Metodi profileButtonPressed avaa profiilisivun aktiviteetin.
     * @param V tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Tuomas Heikkilä
     */
    public void profileButtonPressed(View V) {
        Intent profile = new Intent(this, ProfileActivity.class);
        startActivity(profile);
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
     * Metodi saveInformationButtonPressed antaa muuttujiin arvoiksi EditTextkentissä olevat tiedot ja muuttaa ne oikeisiin arvoihin Stringiksi
     * ja inteiksi. Tallentaa tekstikenttien tiedot olioluokkaan, josta niitä voi käyttää golbaalisti singletonin avulla.
     * Lopulta asettaa tekstin, joka kertoo, että tietojen tallentaminen onnistui, kun nappia painetaan
     * @param V tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Tuomas Heikkilä
     */
    public void saveInformationButtonPressed(View V) {
        Toast.makeText(this, "Tiedot tallennettu", Toast.LENGTH_SHORT).show();
        name = profileName.getText().toString();
        age = Integer.parseInt(profileAge.getText().toString());
        sleep = Integer.parseInt(profileSleep.getText().toString());
        calories = Integer.parseInt(profileCalories.getText().toString());
        height = Integer.parseInt(profileHeight.getText().toString());
        weight = Integer.parseInt(profileWeight.getText().toString());
        profileInformation = new ProfileInformation(name, age, sleep, calories, height, weight);
        Log.d(TAG, profileInformation.toString());
        saved.setText("Tietojen tallentaminen onnistui");
    }

    /**
     * Kun emulaattorin nuolinappulaa eli takaisin nappulaa painetaan, jos drawer menu on auki, sulje se, muutoin käytä takaisin nappulaa normaalisti.
     * @author Tuomas Heikkilä
     */
    @Override
    public void onBackPressed() {

        if (menulayout.isDrawerOpen(GravityCompat.START)) {
            menulayout.closeDrawer(GravityCompat.START);
        } else {
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
            // hae menussa olevan nappulan/itemin id.
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