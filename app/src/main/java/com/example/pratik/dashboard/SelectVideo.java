package com.example.pratik.dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SelectVideo extends AppCompatActivity {
    ImageView ai,android,bda,firebase,ml,java;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_video);
        ai = findViewById(R.id.ai);
        android = findViewById(R.id.android);
        bda = findViewById(R.id.bda);
        firebase = findViewById(R.id.firebase);
        ml = findViewById(R.id.machineLearning);
        java = findViewById(R.id.java);

        firebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Video.class);
                startActivity(i);
            }
        });

        ai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AI.class);
                startActivity(i);
            }
        });
        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Android.class);
                startActivity(i);
            }
        });

        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Java.class);
                startActivity(i);
            }
        });
        ml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MachineLearning.class);
                startActivity(i);
            }
        });

        bda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),BigData.class);
                startActivity(i);
            }
        });
    }
}
