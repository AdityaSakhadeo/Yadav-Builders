package com.example.yybuilders;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity {

    Button logout;
    FirebaseAuth mAuth;
    FirebaseUser user;
    TextView welcome;
    ImageView enter;
    ImageView view;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        logout = findViewById(R.id.logout);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        welcome = findViewById(R.id.loggeduser);
        enter = findViewById(R.id.img_enter);
        view = findViewById(R.id.img_view);
        if (user!=null)
        {
            welcome.setText(user.getEmail());
        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                Intent intent6 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent6);
                finish();
            }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent enter_intent = new Intent(getApplicationContext(),site_number.class);
                startActivity(enter_intent);
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view_intent = new Intent(getApplicationContext(),view_options.class);
                startActivity(view_intent);
            }
        });
    }
}