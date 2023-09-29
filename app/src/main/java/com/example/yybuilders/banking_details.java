package com.example.yybuilders;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class banking_details extends AppCompatActivity {

    FirebaseUser user;
    FirebaseAuth mAuth;
    TextView email;

    EditText bank_name;
    EditText amount;
    RadioGroup rg;
    RadioButton b1;
    RadioButton b2;
    RadioButton b3;

    Button b;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banking_details);
        mAuth = FirebaseAuth.getInstance();
        user  = mAuth.getCurrentUser();
        email = findViewById(R.id.email_banking);
        bank_name = findViewById(R.id.bankname);
        amount = findViewById(R.id.amount);
        rg = findViewById(R.id.radioGroup);
        b1 = findViewById(R.id.radioButton4);
        b2 = findViewById(R.id.radioButton7);
        b3 = findViewById(R.id.radioButton8);
        b = findViewById(R.id.button);
        if(user != null)
        {
            email.setText(user.getEmail());
        }


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected = rg.getCheckedRadioButtonId();
                String bank_string = bank_name.getText().toString().trim();
                String amount_string = amount.getText().toString().trim();
                String payment_status = null;
                if (selected == -1) {
                    Toast.makeText(banking_details.this, "Please select status of payment", Toast.LENGTH_SHORT).show();
                } else {
                    RadioButton selected_rb = findViewById(selected);
                    payment_status = selected_rb.getText().toString();

                }

                if (bank_string.isEmpty() || amount_string.isEmpty()) {
                    if (bank_string.isEmpty()) {
                        bank_name.setError("Please enter bank name");
                    }
                    if (amount_string.isEmpty()) {
                        amount.setError("Please Enter the amount");
                    }
                }

                DatabaseReference workDetailsRef = FirebaseDatabase.getInstance().getReference()
                        .child("construction_sites")
                        .child("site_id_1") // Replace with the actual site ID
                        .child("banking_details");


// Create a new WorkDetails object (replace with actual values)
                bankingDetails newBankingDetail = new bankingDetails();
                newBankingDetail.setBank_name(bank_string);
                newBankingDetail.setAmount(amount_string);
                newBankingDetail.setPaid_or_not(payment_status);

                workDetailsRef.setValue(newBankingDetail);
                Toast.makeText(banking_details.this, "Banking Details Updated", Toast.LENGTH_SHORT).show();
            }

        });
    }
}