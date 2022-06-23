package com.example.ordinario.Mapa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ordinario.MainActivity;
import com.example.ordinario.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private Intent intent;
    private double log, la;
    private String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        intent = getIntent();
        log = intent.getDoubleExtra("Longitud", 0);
        la = intent.getDoubleExtra("Latitud",0);
        nombre = intent.getStringExtra("Nombre");
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        LatLng escuela = new LatLng(log, la);
        mMap.addMarker(new MarkerOptions().position(escuela).title(nombre));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(escuela));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.builder().target(escuela).zoom(14).build()));

    }
}