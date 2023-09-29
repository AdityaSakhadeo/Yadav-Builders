package com.example.yybuilders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registration extends AppCompatActivity {

    TextView login_now;
    EditText email;
    EditText password;

    Button register;
    FirebaseAuth mAuth;

    ProgressBar pg1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        email = findViewById(R.id.registeremail);
        password = findViewById(R.id.registerpass);
        register = findViewById(R.id.registerform);
        pg1 = findViewById(R.id.progress);
        login_now = findViewById(R.id.click_to_login);
        mAuth = FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pg1.setVisibility(View.VISIBLE);
                String email_str = email.getText().toString();
                String pass_str = password.getText().toString();
                if (TextUtils.isEmpty(email_str)){
                    Toast.makeText(registration.this,"Email is mandatory",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pass_str)){
                    Toast.makeText(registration.this,"Password is mandatory",Toast.LENGTH_SHORT).show();
                    return;
                }


                login_now.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent3 = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent3);
                        finish();
                    }
                });

                mAuth.createUserWithEmailAndPassword(email_str, pass_str)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                pg1.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Intent intent5 = new Intent(getApplicationContext(),MainActivity.class);
                                    startActivity(intent5);
                                    finish();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(registration.this, "Invalid Email or Password.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}