package com.example.loppuprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView training;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        training = (ImageView) findViewById(R.id.trainingButton);
        training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTraining();
            }
        });
    }
    public void openTraining() {
        Intent intent = new Intent(this, TrainingActivity.class);
        startActivity(intent);
    }
}