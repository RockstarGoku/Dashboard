package com.example.pratik.dashboard;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MessagesNotices extends AppCompatActivity {
    TextView messageTextView;
    Button sendMessage,gotoStudentSide;
    Spinner semesterSpinner, fileTypeSpinner;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages_notices);
        semesterSpinner = findViewById(R.id.spinnerSemester);
        messageTextView = findViewById(R.id.editSendMessages);
        sendMessage = findViewById(R.id.buttonSendMessages);
        gotoStudentSide = findViewById(R.id.buttonGoToStudentSide);
        gotoStudentSide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),StudentMessageRecieve.class);
                startActivity(i);
            }
        });
        fileTypeSpinner = findViewById(R.id.spinnerSelectFile);
        db = FirebaseFirestore.getInstance();
        final Map<String, Object> user = new HashMap<>();
        fileTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
                if(selectedItem.equals("IMAGE"))
                {
                    Intent intent = new Intent(getApplicationContext(),UploadAndRetreiveFile.class);
                    intent.putExtra("type",selectedItem);

                    startActivity(intent);
                }
                else if(selectedItem.equals("PDF"))
                {
                    Intent intent = new Intent(getApplicationContext(),UploadAndRetreiveFile.class);
                    intent.putExtra("type",selectedItem);

                    startActivity(intent);
                }
                else if(selectedItem.equals("EXCEL"))
                {
                    Intent intent = new Intent(getApplicationContext(),UploadAndRetreiveFile.class);
                    intent.putExtra("type",selectedItem);

                    startActivity(intent);
                }
                else if (selectedItem.equals("TEXT")) {
                    messageTextView.setVisibility(View.VISIBLE);
                    sendMessage.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sendMessage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String msg = messageTextView.getText().toString();
                user.put("Message", msg);

                db.collection("users")
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
               Intent intent = new Intent(MessagesNotices.this,RecyclerViewForMessages.class);
               startActivity(intent);

            }
        });

    }
    protected void onStart()
    {
        super.onStart();
    }

    protected void onPause()
    {
        super.onPause();
    }
    protected void onResume()
    {
        super.onResume();
    }
}