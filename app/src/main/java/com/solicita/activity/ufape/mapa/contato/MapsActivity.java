package com.solicita.activity.ufape.mapa.contato;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;
import com.solicita.R;
import com.solicita.activity.ufape.MainActivityUfape;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    // tela = 1 é mapa da ufape, tela = 2 é mapa da clinica de bolvinos
    private String tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ufape_maps_contato);

        Intent it = getIntent();
        tela = it.getStringExtra("tela");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        TextView nome = (TextView) findViewById(R.id.nome_mapa_contato);

        if(tela.equals("1")){
            nome.setText("Mapa da UFAPE");
            montarMapaUfape();
        }
        else{
            nome.setText("Mapa da Clínica de Bovinos");
            montarMapaClinicaBovinos();
        }

    }
    private void montarMapaUfape(){

        LatLng c_ufape = new LatLng(-8.906756, -36.494305);
        mMap.addMarker(new MarkerOptions().position(c_ufape).title("UFAPE"));

        LatLng c_predio_professores = new LatLng(-8.905601, -36.494442);
        mMap.addMarker(new MarkerOptions().position(c_predio_professores).title("Prédio dos Professores"));

        LatLng c_predio_en_alimentos = new LatLng(-8.905094, -36.494140);
        mMap.addMarker(new MarkerOptions().position(c_predio_en_alimentos).title("Prédio Engenharia de Alimentos"));

        LatLng c_predio_escolaridade = new LatLng(-8.908065, -36.494397);
        mMap.addMarker(new MarkerOptions().position(c_predio_escolaridade).title("Prédio Escolaridade"));

        LatLng c_predio_biblioteca = new LatLng(-8.907032, -36.494491);
        mMap.addMarker(new MarkerOptions().position(c_predio_biblioteca).title("Prédio Biblioteca"));

        float zoomLevel = 17f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(c_ufape, zoomLevel));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
    private void montarMapaClinicaBovinos(){
        LatLng c_clinica = new LatLng(-8.910410, -36.494243);
        mMap.addMarker(new MarkerOptions().position(c_clinica).title("Clínica de Bovinos"));

        float zoomLevel = 18.5f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(c_clinica, zoomLevel));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    public void clickBotaoClose(View view){
        finish();
    }
}
