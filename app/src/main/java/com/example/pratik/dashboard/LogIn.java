package com.example.pratik.dashboard;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class LogIn extends AppCompatActivity{
    TextView textViewLoginToSignUp;
    EditText editTextUserName,editTextPassword;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth.AuthStateListener mAuthListner;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    DatabaseReference databaseReference;
    FirebaseFirestore firebaseFirestore;
    DocumentReference documentReference;
    Button login;
    SharedPreferences sharedPreferences;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        textViewLoginToSignUp = findViewById(R.id.textViewSignUp);
        firebaseDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        sharedPreferences = getApplicationContext().getSharedPreferences("MyPrefs",Context.MODE_PRIVATE);
        sharedPreferences.getString("SelectSemester"," ");
        sharedPreferences.getString("SelectUser"," ");
        sharedPreferences.getString("SelectDepartment"," ");
        databaseReference = firebaseDatabase.getReferenceFromUrl("https://cmsystem-c4443.firebaseio.com");
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        login = findViewById(R.id.buttonLogIn);
        //
        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (mUser != null) {
                    Intent intent = new Intent(LogIn.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else
                {
                    Log.d("mAuthListener else loop","AuthStateChanged:Logout");
                }

            }
        };
        //

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSign();
            }
        });
        //from login to sign up activity
        textViewLoginToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LogIn.this,Signup.class);
                startActivity(i);
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        //removeAuthSateListner is used  in onStart function just for checking purposes,it helps in logging you out.
        mAuth.removeAuthStateListener(mAuthListner);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListner != null) {
            mAuth.removeAuthStateListener(mAuthListner);
        }

    }

    @Override
    public void onBackPressed() {
        LogIn.super.finish();
    }



    private void userSign()
    {
        documentReference = firebaseFirestore.collection("STUDENT").document(editTextUserName.getText().toString());

        documentReference.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists())
                        {
                            String uniqueid = editTextUserName.getText().toString();
                            String password = editTextPassword.getText().toString();
                            String UNIQUEID = documentSnapshot.getString("uniqueId");
                            String PASSWORD = documentSnapshot.getString("passWord");
                            String department = documentSnapshot.getString("selectdepartment");
                            String semester = documentSnapshot.getString("selectsemester");
                            String user = documentSnapshot.getString("selectuser");
                            if((PASSWORD.equals(password))&&(uniqueid.equals(UNIQUEID)))
                            {
                                Intent intent = new Intent(LogIn.this, MainActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(LogIn.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LogIn.this, LogIn.class);
                                startActivity(intent);
                            }

                        }
                        else
                        {
                            Toast.makeText(LogIn.this, "Please Sign UP First!!!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LogIn.this, LogIn.class);
                            startActivity(intent);
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LogIn.this, "LOG IN FAILED", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LogIn.this, LogIn.class);
                        startActivity(intent);
                    }
                });
    }
    private void checkIfEmailVerified(){
        FirebaseUser users=FirebaseAuth.getInstance().getCurrentUser();
        boolean emailVerified=users.isEmailVerified();
        if(!emailVerified){
            Toast.makeText(this,"Verify the Email Id",Toast.LENGTH_SHORT).show();
            mAuth.signOut();
            finish();
        }
        else {
            editTextUserName.getText().clear();

            editTextPassword.getText().clear();
            Intent intent = new Intent(LogIn.this, MainActivity.class);

            // Sending Email to Dashboard Activity using intent.
            //intent.putExtra(editTextUserName,email);

            startActivity(intent);

        }
    }
}