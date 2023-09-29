package com.example.yybuilders;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class site_details extends AppCompatActivity {

    FirebaseUser user;
    FirebaseAuth mAuth;
    TextView email;
    EditText sitename;
    EditText siteaddress;
    EditText length;
    EditText width;
    EditText ownername;
    EditText ownercontact;
    Button site_button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_details);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        email = findViewById(R.id.top_user_1);
        sitename = findViewById(R.id.sitename);
        siteaddress = findViewById(R.id.siteaddress);
        length = findViewById(R.id.length);
        width = findViewById(R.id.width);
        ownername = findViewById(R.id.ownername);
        ownercontact = findViewById(R.id.ownercontact);
        site_button = findViewById(R.id.site_button);

        if(user!=null)
        {
            email.setText(user.getEmail());
        }

        site_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float area;
                String sname = sitename.getText().toString().trim();
                String sadd = siteaddress.getText().toString().trim();
                String len = length.getText().toString().trim();
                String wid = width.getText().toString().trim();
                String oname = ownername.getText().toString().trim();
                String ocontact = ownercontact.getText().toString().trim();

                DatabaseReference siteDetailsRef = FirebaseDatabase.getInstance().getReference()
                        .child("construction_sites")
                        .child("site_id_1") // Replace with the actual site ID
                        .child("site_details");


// Create a new WorkDetails object (replace with actual values)
                construtionDetails newConstrutionDetail = new construtionDetails();
                newConstrutionDetail.setSite_name(sname);
                newConstrutionDetail.setSite_address(sadd);
                newConstrutionDetail.setHeight(len);
                newConstrutionDetail.setWidth(wid);
                newConstrutionDetail.setOwner_name(oname);
                newConstrutionDetail.setOwner_contact(ocontact);

                siteDetailsRef.setValue(newConstrutionDetail);
                Toast.makeText(site_details.this, "Site Details Updated", Toast.LENGTH_SHORT).show();
            }
        });


    }
}