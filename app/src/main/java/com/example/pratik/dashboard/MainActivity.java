package com.example.pratik.dashboard;

import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.CardView;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    ImageView imageViewCourse,imageViewSports,imageViewMessage,imageViewVideo,imageStudyMaterial,imageViewPlacement;
    TextView textViewCourse,textViewSports,textViewMessage,textViewVideo,textViewPlacement;
    LinearLayout linearLayout,linearLayout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewCourse = (ImageView) findViewById(R.id.courseImage);
        imageViewSports = findViewById(R.id.imageSports);
        imageViewMessage = findViewById(R.id.imageMessage);
        imageViewVideo = findViewById(R.id.imageVideoLectures);
        textViewPlacement = findViewById(R.id.textPlacement);
        imageViewPlacement = findViewById(R.id.imagePlacement);
        imageStudyMaterial = findViewById(R.id.imageStudyMaterial);
        textViewVideo = findViewById(R.id.textVideoLectures);
        textViewMessage = findViewById(R.id.textMessage);
        textViewCourse = (TextView)findViewById(R.id.coursesText);
        textViewSports = findViewById(R.id.textSports);
        textViewCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Courses.class);
                startActivity(i);
            }
        });
        imageViewCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Courses.class);
                startActivity(i);
            }
        });
        textViewPlacement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),PlacementModule.class);
                startActivity(i);
            }
        });
        imageViewPlacement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),PlacementModule.class);
                startActivity(i);
            }
        });
        //
        textViewVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SelectVideo.class);
                startActivity(i);
            }
        });
        imageViewVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SelectVideo.class);
                startActivity(i);
            }
        });
        imageStudyMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MessagesNotices.class);
                startActivity(i);
            }
        });
        textViewSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Sports.class);
                startActivity(i);
            }
        });
        imageViewSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Sports.class);
                startActivity(i);
            }
        });
        textViewMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),OnlyTextMessages.class);
                startActivity(i);
            }
        });
        imageViewMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),OnlyTextMessages.class);
                startActivity(i);
            }
        });

    }
}
