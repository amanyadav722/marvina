package com.example.marvyana_mobilite;

import android.location.Location;

import java.util.ArrayList;
import java.util.List;

public class MyApplication {

    private final List<Location> myLocations;
    private static MyApplication extends Application {

        private static MyApplication singleton;

        private List<Location> myLocations;

        public List<Location> getMyLocations() {
            return myLocations;
        }

        public void setMyLocations(List<Location> myLocations){
            this.myLocations = myLocations;
        }

        public MyApplication getInstance() {
            return singleton;
        }

        public void onCreate() {
            super.onCreate();
            singleton = this;
            myLocations = new ArrayList<>();
        }
    }

    public List<Location> getMyLocations() {
    }
}
