package com.example.yybuilders;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Item> {

    private ArrayList<Item> itemList;
    private Context context;

    public CustomAdapter(ArrayList<Item> itemList, Context context) {
        super(context, R.layout.item_list, itemList);
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Item item = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list, parent, false);
        }

        // Lookup view for data population
        TextView sitenumber = convertView.findViewById(R.id.site_number);
        TextView sitename = convertView.findViewById(R.id.site_name);

        // Populate the data into the template view using the data object
        sitename.setText(item.getName());
        sitenumber.setText(String.valueOf(item.getNumber()));

        // Return the completed view to render on screen
        return convertView;
    }
}
