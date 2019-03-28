package com.example.pratik.dashboard;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public class StudentMessageRecieve extends AppCompatActivity {
    Button button;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_message_recieve);
        button = findViewById(R.id.buttonRecieve);
        db = FirebaseFirestore.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.collection("users")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (DocumentSnapshot document : task.getResult()) {
                                        Map hashMap = document.getData();
                                        Object x = hashMap.get("Message");
                                        x.toString();
                                        Toast.makeText(StudentMessageRecieve.this, x.toString(), Toast.LENGTH_SHORT).show();
                                        Log.d("DONE", document.getId() + " => " + document.getData());
                                    }
                                } else {
                                    Log.w("DONE", "Error getting documents.", task.getException());
                                }
                            }
                        });
            }
        });
    }
}
