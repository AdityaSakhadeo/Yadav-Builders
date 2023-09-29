package com.example.yybuilders;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class work_details extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_details);
        Button submit_work;
        EditText normal_expense;
        EditText nor_quan;
        EditText add_mat;
        EditText add_cost;
        EditText add_quan;
        EditText work_des;
        DatePicker datePicker;
        final String[] selectedItem = {"None"};
        submit_work = findViewById(R.id.site_button2);
        work_des = findViewById(R.id.work_description);
        normal_expense = findViewById(R.id.expense_normal);
        nor_quan = findViewById(R.id.quantity);
        add_mat = findViewById(R.id.add_material);
        add_quan = findViewById(R.id.add_quan);
        add_cost = findViewById(R.id.add_cost);
        datePicker = findViewById(R.id.datePicker2);


        // Define an array of items to display in the Spinner
        String[] items = {"Cement", "Grit", "3/4' Khadi", "Steel","Plumbing","Plaster","Sand"};

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Get a reference to the Spinner and set the adapter
        Spinner spinner = findViewById(R.id.spinner2);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Get the selected item
                selectedItem[0] = (String) parentView.getItemAtPosition(position);

                // Now, selectedItem is accessible outside this function
                Toast.makeText(getApplicationContext(), "Selected Item: " + selectedItem[0], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle the case when nothing is selected
                selectedItem[0] = "None";
            }
        });

        submit_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = work_des.getText().toString();
                String expense = normal_expense.getText().toString();
                String nQuan = nor_quan.getText().toString();
                String additional = add_mat.getText().toString();
                String additional_cost = add_cost.getText().toString();
                String addQuan = add_quan.getText().toString();
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;
                int year = datePicker.getYear();
                String selectedDate = day + "-" + month + "-" + year;


// Create WorkDetails objects for yyyy-mm-dd-1 and yyyy-mm-dd-2

                DatabaseReference workDetailsRef2 = FirebaseDatabase.getInstance().getReference()
                        .child("construction_sites")
                        .child("site_id_1") // Replace with the actual site ID
                        .child("work_details");

// Create a new WorkDetails object (replace with actual values)
                workDetails newWorkDetail = new workDetails();
                newWorkDetail.setWork_description(description);
                newWorkDetail.setRaw_material(selectedItem[0]);
                newWorkDetail.setRaw_expense(expense);
                newWorkDetail.setRaw_quan(nQuan);
                newWorkDetail.setAdditional_work(additional);
                newWorkDetail.setAdditional_cost(additional_cost);
                newWorkDetail.setAdditional_quan(addQuan);

// Push the new work detail entry to Firebase
                workDetailsRef2.child(selectedDate).setValue(newWorkDetail);
                Toast.makeText(work_details.this, "Work Details Updated", Toast.LENGTH_SHORT).show();



            }
        });

    }
}