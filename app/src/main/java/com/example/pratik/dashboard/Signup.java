package com.example.pratik.dashboard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Signup extends AppCompatActivity {
    TextInputEditText t1,t2,t3,t4,t5,t6;
    Button b1,b2;
    SharedPreferences sharedPreferences;
    Spinner spinnerselectuser,spinnerselectsemester,spinnerselectdepartment;
    private FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private static final String Unique_Id = "uniqueId";
    private static final String Password = "passWord";
    private static final String USERNAME = "userName";
    private static final String MOBILE = "mobile";
    private static final String EMAILID = "email-id";
    private static final String SELECTUSER = "selectuser";
    private static final String SELECTSEMESTER = "selectsemester";
    private static final String SELECTDEPARTMENT = "selectdepartment";
    private static String selectedDepartment;// = " ";
    private static String selectedUser;// = " ";
    private static String selectedSemester;
    String codesent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        spinnerselectuser = findViewById(R.id.spinnerSelectUser);
        sharedPreferences = getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        spinnerselectsemester = findViewById(R.id.spinnerSemester);
        spinnerselectdepartment = findViewById(R.id.spinnerSelectDepartment);
        t1= (TextInputEditText) findViewById(R.id.tidUsername);
        t2= (TextInputEditText) findViewById(R.id.tidEmailid);
        t3= (TextInputEditText) findViewById(R.id.tidUniqueId);
        t4= (TextInputEditText) findViewById(R.id.tidMobilenumber);
        t5= (TextInputEditText) findViewById(R.id.tidPassword);
        t6 = (TextInputEditText) findViewById(R.id.tidOtp);
        b1=findViewById(R.id.buttongetcode);
        b2 = findViewById(R.id.buttonSignUp);
        spinnerselectuser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedUser =spinnerselectuser.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerselectsemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedDepartment = ((TextView) view).getText().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerselectdepartment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedSemester = ((TextView) view).getText().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        editor.putString("SelectSemester",selectedSemester);
        editor.putString("SelectUser",selectedUser);
        editor.putString("SelectDepartment",selectedDepartment);
        editor.commit();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendVerificationCode();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifySignInCode();
                addUser();
            }
        });
    }
    private void verifySignInCode()
    {
        String code = t6.getText().toString();
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codesent, code);
        signInWithPhoneAuthCredential(credential);
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(i);
                        }
                        else
                        {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Intent i = new Intent(getApplicationContext(),Signup.class);
                                startActivity(i);
                                Toast.makeText(getApplicationContext(), "Incorrect Verification Code", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }
    private void sendVerificationCode()
    {
        String username = t1.getText().toString();
        String emailid = t2.getText().toString();
        String uniqueid = t3.getText().toString();
        String mobile = t4.getText().toString();
        String password = t5.getText().toString();
        if(username.isEmpty())
        {
            t1.setError("User Name Required");
            t1.requestFocus();
            return;
        }
        else if(emailid.isEmpty())
        {
            t2.setError("Email-ID Required");
            t2.requestFocus();
            return;
        }
        else if(uniqueid.isEmpty())
        {
            t3.setError("Unique-ID Required");
            t3.requestFocus();
            return;
        }
        else if(mobile.isEmpty()||mobile.length() >= 14)
        {
            t4.setError("Mobile Number Required");
            t4.requestFocus();
            return;
        }
        else if(password.isEmpty())
        {
            t5.setError("Password Required");
            t5.requestFocus();
            return;
        }
        PhoneAuthProvider.getInstance().verifyPhoneNumber
                (
                        mobile,// Phone number to verify
                        30,                 // Timeout duration
                        TimeUnit.SECONDS,   // Unit of timeout
                        this,               // Activity (for callback binding)
                        mCallbacks);        // OnVerificationStateChangedCallbacks
        Toast.makeText(getApplicationContext(),mobile,Toast.LENGTH_LONG).show();
    }
    private void addUser()
    {
        String username = t1.getText().toString();
        String emailid = t2.getText().toString();
        String uniqueid = t3.getText().toString();
        String mobile = t4.getText().toString();
        String password = t5.getText().toString();

        Map<String,Object> map = new HashMap<>();
        map.put(Unique_Id,uniqueid);
        map.put(Password,password);
        map.put(USERNAME,username);
        map.put(EMAILID,emailid);
        map.put(MOBILE,mobile);
        map.put(SELECTDEPARTMENT,selectedDepartment);
        map.put(SELECTUSER,selectedUser);
        map.put(SELECTSEMESTER,selectedSemester);
        firebaseFirestore.collection("STUDENT").document(uniqueid).set(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Signup.this, "Note Saved", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Signup.this, "Error" , Toast.LENGTH_SHORT).show();

                    }
                });
    }
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential)
        {

        }

        @Override
        public void onVerificationFailed(FirebaseException e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            codesent = s;
            Toast.makeText(getApplicationContext(),codesent,Toast.LENGTH_LONG).show();
        }
    };
}