package com.solicita.activity.ufape.mapa.inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.solicita.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.solicita.activity.ufape.inicio.InicioActivityPrincipal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MapsActivity extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    public static MapsActivity newInstance() {
        return new MapsActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_ufape_maps, container, false);

        FragmentManager f = this.getChildFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) f.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        LinearLayout botao_voltar = root.findViewById(R.id.botao_voltar);
        botao_voltar.setOnClickListener(clickBotaoVoltar);

        return root;
    }

    //private MainViewModel mViewModel;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

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

    private View.OnClickListener clickBotaoVoltar = new View.OnClickListener() {
        public void onClick(View v) {
            InicioActivityPrincipal.getInicioActivityPrincipal().abrirTelaInicio();
        }
    };

}
