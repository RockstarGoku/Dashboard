package com.example.pratik.dashboard;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class OnlyTextMessages extends AppCompatActivity {
    Button button;
    FirebaseFirestore db;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_only_text_messages);
        button = findViewById(R.id.buttonSendMessages);
        db = FirebaseFirestore.getInstance();
        final Map<String, Object> user = new HashMap<>();
        editText = findViewById(R.id.editSendMessages);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = editText.getText().toString();
                user.put("MessageNotices", msg);

                db.collection("Notices")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("Done", "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("Done", "Error adding document", e);
                            }
                        });
                Intent intent = new Intent(OnlyTextMessages.this,RecyclerViewForMessages.class);
                startActivity(intent);
            }
        });

    }
}
