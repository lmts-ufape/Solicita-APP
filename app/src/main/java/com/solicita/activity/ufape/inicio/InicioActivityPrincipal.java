package com.solicita.activity.ufape.inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.solicita.R;
import com.solicita.activity.ufape.inicio.a_ufape.AUfapeActivity;
import com.solicita.activity.ufape.inicio.inicio.InicioActivity;
import com.solicita.activity.ufape.inicio.noticias_comunicados.NoticiasComunicadosActivity;
import com.solicita.activity.ufape.mapa.inicio.MapsActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class InicioActivityPrincipal extends Fragment {

    /*public static InicioActivityPrincipal newInstance() {
        return new InicioActivityPrincipal();
    }*/

    private static InicioActivityPrincipal tela;
    public static InicioActivityPrincipal getInicioActivityPrincipal(){
        return tela;
    }

    public InicioActivityPrincipal(){
        tela = this;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_ufape_inicio_principal, container, false);

        abrirTelas();

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private static int tela_aberta = -1;

    public void abrirTelas(){
        if(tela_aberta == 1)
            abrirTelaAUfape();
        else if(tela_aberta == 2)
            abrirTelaNoticiasComunicados();
        else if(tela_aberta == 3)
            abrirTelaMapa();
        else
            abrirTelaInicio();
    }

    public void abrirTelaInicio(){
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_inicio, InicioActivity.newInstance())
                .commitNow();
        tela_aberta = 0;
    }

    public void abrirTelaAUfape(){
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_inicio, AUfapeActivity.newInstance())
                .commitNow();
        tela_aberta = 1;
    }

    public void abrirTelaNoticiasComunicados(){
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_inicio, NoticiasComunicadosActivity.newInstance())
                .commitNow();
        tela_aberta = 2;
    }

    public void abrirTelaMapa(){
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_inicio, MapsActivity.newInstance())
                .commitNow();
        tela_aberta = 3;
    }
}
