package com.example.ftavakoli.bucketlistapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by FTavakoli on 3/22/18.
 */

public class ListAdapter extends ArrayAdapter {

    private final Activity context;
    private final ArrayList<ItemDataStore> listOfItems;
   // private final ArrayList<ItemDataStore> iconID;

    public ListAdapter(Activity context, ArrayList<ItemDataStore> items) {
        super(context, R.layout.list,items);
        this.context = context;
        this.listOfItems = items;
        //this.iconID = iconId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list, null, true);
        ImageView imageView = rowView.findViewById(R.id.iconImageView);
        TextView textView = rowView.findViewById(R.id.titleTextView);
        CheckBox checkBox = rowView.findViewById(R.id.checkBox);
        textView.setText(listOfItems.get(position).getName());
        checkBox.setChecked(listOfItems.get(position).isStatus());
        //imageView.setImageResource(iconID[position]);

        return rowView;
    }
}
