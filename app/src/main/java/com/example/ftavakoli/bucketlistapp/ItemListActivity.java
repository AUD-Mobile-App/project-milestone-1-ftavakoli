package com.example.ftavakoli.bucketlistapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity {

    ListView listView;
    FloatingActionButton addFab;
    DatabaseReference databaseReference;
    String title;
    boolean status;
    private FirebaseAuth firebaseAuth;
    String TAG = "Hi";

    //creating array of items, each one of them is ItemDataStore Object,
    //and each object has whatever the ItemDataStore has
    ArrayList<ItemDataStore> arrayList;
    ListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);


        listView = findViewById(R.id.listView);
        addFab = findViewById(R.id.addFab);
        arrayList = new ArrayList<>();
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        adapter = new ListAdapter(ItemListActivity.this,arrayList);
        listView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("Students")
        .child(user.getUid());

        // Read from the database
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                arrayList.clear();
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot d : dataSnapshot.getChildren()) {
                    ItemDataStore value = d.getValue(ItemDataStore.class);
                    Log.d(TAG, "Value is: " + value.getName());
                    arrayList.add(value);
                    adapter.notifyDataSetChanged();

                }
            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });



            addFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ItemListActivity.this, AddItemActivity.class);
                    startActivity(intent);

                }
            });



    }
}
