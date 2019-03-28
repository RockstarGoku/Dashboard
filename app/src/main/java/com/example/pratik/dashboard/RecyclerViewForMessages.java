package com.example.pratik.dashboard;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.Map;

public class RecyclerViewForMessages extends AppCompatActivity {
    FirebaseFirestore db;
    String[] storeData = new String[30];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_for_messages);
        db = FirebaseFirestore.getInstance();
        final RecyclerView recyclerView = findViewById(R.id.programmingList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final String[] language = {"Notice : ","Notice : " ,"Notice : ","Notice : ","Notice : ","Notice : ","Notice : ","Notice : "};
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int i=0;
                            for (DocumentSnapshot document : task.getResult()) {
                                String print;
                                Map hashMap = document.getData();
                                Object x = hashMap.get("Message");
                                print = x.toString();
                                storeData[i] = print;
                                i++;
                                //Toast.makeText(RecyclerViewForMessages.this, x.toString(), Toast.LENGTH_SHORT).show();
                                //Log.d("DONE", document.getId() + " => " + document.getData());
                            }
                            recyclerView.setAdapter(new ProgrammingAdapter(storeData));
                        } else
                            {
                           // Log.w("DONE", "Error getting documents.", task.getException());
                        }
                    }
                });
        db.collection("Sports")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int i=0;
                            for (DocumentSnapshot document : task.getResult()) {
                                String print;
                                Map hashMap = document.getData();
                                Object x = hashMap.get("MessageSports");
                                print = x.toString();
                                storeData[i] = print;
                                i++;
                                //Toast.makeText(RecyclerViewForMessages.this, x.toString(), Toast.LENGTH_SHORT).show();
                                //Log.d("DONE", document.getId() + " => " + document.getData());
                            }
                            recyclerView.setAdapter(new ProgrammingAdapter(storeData));
                        } else
                        {
                            // Log.w("DONE", "Error getting documents.", task.getException());
                        }
                    }
                });
        db.collection("Placement")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int i=0;
                            for (DocumentSnapshot document : task.getResult()) {
                                String print;
                                Map hashMap = document.getData();
                                Object x = hashMap.get("MessagePlacement");
                                print = x.toString();
                                storeData[i] = print;
                                i++;
                                //Toast.makeText(RecyclerViewForMessages.this, x.toString(), Toast.LENGTH_SHORT).show();
                                //Log.d("DONE", document.getId() + " => " + document.getData());
                            }
                            recyclerView.setAdapter(new ProgrammingAdapter(storeData));
                        } else
                        {
                            // Log.w("DONE", "Error getting documents.", task.getException());
                        }
                    }
                });
        db.collection("Notices")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int i=0;
                            for (DocumentSnapshot document : task.getResult()) {
                                String print;
                                Map hashMap = document.getData();
                                Object x = hashMap.get("MessageNotices");
                                print = x.toString();
                                storeData[i] = print;
                                i++;
                                //Toast.makeText(RecyclerViewForMessages.this, x.toString(), Toast.LENGTH_SHORT).show();
                                //Log.d("DONE", document.getId() + " => " + document.getData());
                            }
                            recyclerView.setAdapter(new ProgrammingAdapter(storeData));
                        } else
                        {
                            // Log.w("DONE", "Error getting documents.", task.getException());
                        }
                    }
                });
        //recyclerView.setAdapter(new ProgrammingAdapter(storeData));
    }
}
