package com.example.marvyanamobilite;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    Button btnLogout;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private Button btn;
    private TextView textView;
    private FusedLocationProviderClient fusedLocationProviderClient;

    private Button WebApp_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        btn = findViewById(R.id.Location_btn);
        textView = findViewById(R.id.Location_text);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

                     if (getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED){

                        //get the location here
                        fusedLocationProviderClient.getLastLocation()
                                .addOnSuccessListener(new OnSuccessListener<Location>() {
                                    @Override
                                    public void onSuccess(Location location) {
                                        if (location != null){
                                            Double lat = location.getLatitude();
                                            Double longt= location.getLongitude();

                                            textView.setText(lat+" , "+longt);
                                            Toast.makeText(HomeActivity.this, "Success", Toast.LENGTH_SHORT).show();

                                        }

                                    }
                                });

                    }else {
                        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
                    }
                }
            }
        });


        btnLogout = findViewById(R.id.logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intToMain);
                gotoUrl("https://www.epsi.fr/");
            }
        });

        WebApp_button = (Button) findViewById(R.id.WebApp_button);
        WebApp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity_web_page();
            }
        });

    }

    public void openactivity_web_page() {
        Intent intent = new Intent(this, activity_Web_Page.class);
        startActivity(intent);
    }


    private void gotoUrl(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}