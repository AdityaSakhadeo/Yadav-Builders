package com.example.yybuilders;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Enter_Options extends AppCompatActivity {

    FirebaseUser user;
    FirebaseAuth mAuth;

    Button banking,constructions,material;
    TextView email;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_options);
        mAuth = FirebaseAuth.getInstance();
        user  = mAuth.getCurrentUser();
        email = findViewById(R.id.email_enter);
        banking = findViewById(R.id.banking_details);
        constructions = findViewById(R.id.constrution_details);
        material = findViewById(R.id.material_design);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        if (user != null)
        {
            email.setText(user.getEmail());
        }

        banking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent banking = new Intent(getApplicationContext(),banking_details.class);
                startActivity(banking);
            }
        });

        constructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent construction = new Intent(getApplicationContext(),site_details.class);
                startActivity(construction);
            }
        });

        material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent work = new Intent(getApplicationContext(),work_details.class);
                startActivity(work);
            }
        });
    }
}