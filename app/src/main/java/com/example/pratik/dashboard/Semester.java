package com.example.pratik.dashboard;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Semester extends AppCompatActivity {
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);
        textView1 = findViewById(R.id.textSEMESTER1);
        textView2 =findViewById(R.id.textSEMESTER2);
        textView3 =findViewById(R.id.textSEMESTER3);
        textView4 =findViewById(R.id.textSEMESTER4);
        textView5 =findViewById(R.id.textSEMESTER5);
        textView6 =findViewById(R.id.textSEMESTER6);
        textView7 =findViewById(R.id.textSEMESTER7);
        textView8 =findViewById(R.id.textSEMESTER8);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Semester.this,DepartmentStudyMaterial.class);
                startActivity(i);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Semester.this,DepartmentStudyMaterial.class);
                startActivity(i);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Semester.this,DepartmentStudyMaterial.class);
                startActivity(i);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Semester.this,DepartmentStudyMaterial.class);
                startActivity(i);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Semester.this,DepartmentStudyMaterial.class);
                startActivity(i);
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Semester.this,DepartmentStudyMaterial.class);
                startActivity(i);
            }
        });
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Semester.this,DepartmentStudyMaterial.class);
                startActivity(i);
            }
        });
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Semester.this,DepartmentStudyMaterial.class);
                startActivity(i);
            }
        });
    }

}
