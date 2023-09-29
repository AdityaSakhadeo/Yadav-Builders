package com.example.yybuilders;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class site_number extends AppCompatActivity {
    public ListView listView;
    public CustomAdapter customAdapter;
    public ArrayList<Item> itemList = new ArrayList<>();
    public Button site_add;
    public SharedPreferences sharedPreferences;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_number);
        site_add = findViewById(R.id.site_add);
        listView = findViewById(R.id.listView);
        customAdapter = new CustomAdapter(itemList, this);
        listView.setAdapter(customAdapter);
        FirebaseDatabase database = FirebaseDatabase.getInstance();


        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);


        site_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddItemDialog();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item
                Item selectedItem = itemList.get(position);

                // Get the name of the selected item
                String selectedName = selectedItem.getName();

//                 Create an Intent to start the new activity
                Intent intent = new Intent(getApplicationContext(), Enter_Options.class);

                // Pass the selected name as an extra to the new activity
                intent.putExtra("name", selectedName);

                // Start the new activity
                startActivity(intent);
            }
        });


    }

    private void showAddItemDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_add_item, null);
        dialogBuilder.setView(dialogView);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final EditText nameEditText = dialogView.findViewById(R.id.dialog_name);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final EditText numberEditText = dialogView.findViewById(R.id.dialog_numer);

        dialogBuilder.setTitle("Add Item");
        dialogBuilder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String name = nameEditText.getText().toString().trim();
                String numberStr = numberEditText.getText().toString().trim();

                if (!name.isEmpty() && !numberStr.isEmpty()) {
                    try {
                        int number = Integer.parseInt(numberStr);
                        Item newItem = new Item(name, number);
                        itemList.add(newItem);
                        customAdapter.notifyDataSetChanged();
                    } catch (NumberFormatException e) {
                        showToast("Please enter a valid number.");
                    }
                } else {
                    showToast("Please fill in both fields.");
                }
            }
        });


        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Cancelled, do nothing
            }
        });

        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
