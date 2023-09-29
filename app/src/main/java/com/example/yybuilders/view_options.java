package com.example.yybuilders;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class view_options extends AppCompatActivity {


    DatabaseReference reference;
    public Button whole_day;
    public TextView display1;
    public TextView display;
    public TextView display2;
    public TextView display3;
    public TextView display4;
    public TextView display5;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_options);
        whole_day = findViewById(R.id.whole_day);
        DatePicker datePicker;
        datePicker = findViewById(R.id.datePicker2);
        display = findViewById(R.id.display);
        display1 = findViewById(R.id.display1);
        display2 = findViewById(R.id.display2);
        display3 = findViewById(R.id.display3);
        display4 = findViewById(R.id.display4);
        display5 = findViewById(R.id.display5);

        whole_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;
                int year = datePicker.getYear();
                String Date = day + "-" + month + "-" + year;

                readData(Date);

            }
        });
        }

    private void readData(String date) {
        reference = FirebaseDatabase.getInstance().getReference("construction_sites/site_id_1/work_details");
        reference.child(date).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                if(task.isSuccessful())
                {
                    if(task.getResult().exists())
                    {
                        DataSnapshot snap = task.getResult();
                        String descrip = String.valueOf(snap.child("work_description").getValue());
                        String raw_material = String.valueOf(snap.child("raw_material").getValue());
                        String raw_cost = String.valueOf(snap.child("raw_expense").getValue());
                        String raw_quan = String.valueOf(snap.child("raw_quan").getValue());
                        String additional_work = String.valueOf(snap.child("additional_work").getValue());
                        String additional_cost= String.valueOf(snap.child("additional_cost").getValue());
                        display.setText(descrip);
                        display5.setText(raw_material);
                        display1.setText(raw_cost);
                        display2.setText(raw_quan);
                        display4.setText(additional_work);
                        display3.setText(additional_cost);
                    }
                    else
                    {
                        Toast.makeText(view_options.this, "No Entry for the selected Date", Toast.LENGTH_SHORT).show();

                    }
                }
                else {
                    Toast.makeText(view_options.this, "Fetching Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

