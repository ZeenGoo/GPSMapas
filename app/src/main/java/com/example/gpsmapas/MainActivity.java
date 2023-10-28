package com.example.gpsmapas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener{

    EditText txt_Latitud, txt_Longitud; //declaran e inicializan las variables
    GoogleMap mMap;// Objeto googleMap que se utilizara para interactuar con el mapa
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_Latitud=findViewById(R.id.txt_Latitud);
        txt_Longitud=findViewById(R.id.txt_Longitud);
        //se llama el fragmento mapa para asegurar que el mapa este listo para su uso
        SupportMapFragment mapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap){
        mMap=googleMap;//Se inicializa el objeto mMap con googleMao
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);
        //
        LatLng Chile = new LatLng(-35.675147, -71.542969);
        mMap.addMarker(new MarkerOptions().position(Chile).title("Chilito"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Chile));
    }
    @Override
    public void onMapClick(@NonNull LatLng latLng){
        txt_Latitud.setText(""+latLng.latitude);
        txt_Longitud.setText(""+latLng.longitude);
    }
    @Override
    public void onMapLongClick(@NonNull LatLng latLng){
        txt_Latitud.setText(""+latLng.latitude);
        txt_Longitud.setText(""+latLng.longitude);
    }
}