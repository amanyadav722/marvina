package com.example.marvyana_mobilite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

public class ShowSavedLocationsList extends AppCompatActivity {

    ListView lv_savedLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_saved_locations_list);
        lv_savedLocations = findViewById(R.id.lv_wayPoints);
        MyApplication myApplication = (MyApplication) getApplicationContext();
        List<Location> savedLocations = myApplication.getMyLocation();
        lv_savedLocations.setAdapter(new ArrayAdapter<Location>(this, android.R.layout.simple_list_item_1, savedLocations));
    }
}