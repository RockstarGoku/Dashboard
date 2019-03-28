package com.example.pratik.dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Sports extends AppCompatActivity {
    ImageView imageViewCricket,imageViewFootball,imageViewTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
        imageViewCricket = findViewById(R.id.imageCricket);
        imageViewFootball = findViewById(R.id.imageFootball);
        imageViewTable = findViewById(R.id.imageTableTennis);
        imageViewFootball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sports.this,SportsUI.class);
                startActivity(intent);
            }
        });
        imageViewTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sports.this,SportsUI.class);
                startActivity(intent);
            }
        });
        imageViewCricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sports.this,SportsUI.class);
                startActivity(intent);
            }
        });
    }
}
