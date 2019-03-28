package com.example.pratik.dashboard;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DepartmentStudyMaterial extends AppCompatActivity
{
    ImageView imageViewMechanical,imageViewComputer,imageViewCivil,imageViewElectrical,imageViewAutoMobile,imageViewEc;
    TextView textViewMechanical,textViewComputer,textViewCivil,textViewElectrical,textViewAutoMobile,textViewEc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_study_material);
        imageViewMechanical = findViewById(R.id.imageDepartmentMechanical);
        imageViewComputer = findViewById(R.id.imageDepartmentComputer);
        imageViewCivil = findViewById(R.id.imageDepartmentCivil);
        imageViewAutoMobile = findViewById(R.id.imageDepartmentAutomobile);
        imageViewElectrical =findViewById(R.id.imageDepartmentElectrical);
        imageViewEc = findViewById(R.id.imageDepartmentEc);
        textViewMechanical = findViewById(R.id.textDepartmentMechanical);
        textViewComputer = findViewById(R.id.textDepartmentComputer);
        textViewCivil = findViewById(R.id.textDepartmentCivil);
        textViewAutoMobile = findViewById(R.id.textDepartmentAutomobile);
        textViewElectrical =findViewById(R.id.textDepartmentElectrical);
        textViewEc = findViewById(R.id.textDepartmentEc);
        imageViewMechanical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iMechanial = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ldrp.ac.in/scheme-mechanical/"));
                startActivity(iMechanial);
            }
        });
        imageViewComputer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iComputer = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ldrp.ac.in/scheme-computer/"));
                startActivity(iComputer);
            }
        });
        imageViewCivil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iCivil = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ldrp.ac.in/scheme-civil/"));
                startActivity(iCivil);
            }
        });
        imageViewAutoMobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iAutoMobile = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ldrp.ac.in/scheme-automobile/"));
                startActivity(iAutoMobile);
            }
        });
        imageViewElectrical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iElectrical = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ldrp.ac.in/scheme-electrical/"));
                startActivity(iElectrical);
            }
        });
        imageViewEc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iEC = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ldrp.ac.in/scheme-ec/"));
                startActivity(iEC);
            }
        });


        textViewMechanical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iMechanial = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ldrp.ac.in/scheme-mechanical/"));
                startActivity(iMechanial);
            }
        });
        textViewComputer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iComputer = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ldrp.ac.in/scheme-computer/"));
                startActivity(iComputer);
            }
        });
        textViewCivil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iCivil = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ldrp.ac.in/scheme-civil/"));
                startActivity(iCivil);
            }
        });


        textViewAutoMobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iAutoMobile = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ldrp.ac.in/scheme-automobile/"));
                startActivity(iAutoMobile);
            }
        });
        textViewElectrical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iElectrical = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ldrp.ac.in/scheme-electrical/"));
                startActivity(iElectrical);
            }
        });
        textViewEc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iEC = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ldrp.ac.in/scheme-ec/"));
                startActivity(iEC);
            }
        });
    }

}
