package com.example.loppuprojekti;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class AddTrainingActivity extends AppCompatActivity {

    ImageView trainingIcon;
    Toolbar topbar;
    DrawerLayout menulayout;
    NavigationView menuitems;

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

        //menuitems.setNavigationItemSelectedListener(this);
        menuitems.setCheckedItem(R.id.addnew);

        //preferences = getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE);



    }

    /**
     * Lisää harjoituksen keston, poltetut kalorit ja askeleet editTexteistä uuteen harjoitus-olioon ja avaa harjoitussivun.
     * @param v tekee mahdolliseksi liittää metodin widgettin layoutissa esim. onClick.
     * @author Niko Ala-aho
     */
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
}