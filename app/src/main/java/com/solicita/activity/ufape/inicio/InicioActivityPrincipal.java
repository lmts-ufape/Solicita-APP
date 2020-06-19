package com.solicita.activity.ufape.inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.solicita.R;
import com.solicita.activity.ufape.inicio.a_ufape.AUfapeActivity;
import com.solicita.activity.ufape.inicio.comunicacao.ComunicacaoActivity;
import com.solicita.activity.ufape.inicio.concursos.ConcursosActivity;
import com.solicita.activity.ufape.inicio.extensao.ExtensaoActivity;
import com.solicita.activity.ufape.inicio.inicio.InicioActivity;
import com.solicita.activity.ufape.inicio.institucional.InstitucionalActivity;
import com.solicita.activity.ufape.inicio.noticias_comunicados.NoticiasComunicadosActivity;
import com.solicita.activity.ufape.inicio.pesquisa_inovacao.PesquisaInovacaoActivity;
import com.solicita.activity.ufape.inicio.publicacoes.PublicacoesActivity;
import com.solicita.activity.ufape.mapa.inicio.MapsActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class InicioActivityPrincipal extends Fragment {

    /*public static InicioActivityPrincipal newInstance() {
        return new InicioActivityPrincipal();
    }*/

    public static boolean carrega_tela_inicial = true;

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

        if(carrega_tela_inicial)
            abrirTelaInicio();
        else {
            carrega_tela_inicial = true;
            abrirTelaPublicacoes();
        }

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private boolean tela_inicio_aberta = false;
    public void abrirTelaInicio(){
        if(!tela_inicio_aberta) {
            tela_inicio_aberta = true;
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout_inicio, InicioActivity.newInstance())
                    .commitNow();
        }
    }

    public void abrirTelaInstitucional(){
        tela_inicio_aberta = false;
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_inicio, InstitucionalActivity.newInstance())
                .commitNow();
    }

    public void abrirTelaNoticiasComunicados(){
        tela_inicio_aberta = false;
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_inicio, NoticiasComunicadosActivity.newInstance())
                .commitNow();
    }

    public void abrirTelaPesquisaInovacao(){
        tela_inicio_aberta = false;
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_inicio, PesquisaInovacaoActivity.newInstance())
                .commitNow();
    }

    public void abrirTelaExtensao(){
        tela_inicio_aberta = false;
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_inicio, ExtensaoActivity.newInstance())
                .commitNow();
    }

    public void abrirTelaConcursos(){
        tela_inicio_aberta = false;
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_inicio, ConcursosActivity.newInstance())
                .commitNow();
    }

    public void abrirTelaPublicacoes(){
        tela_inicio_aberta = false;
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_inicio, PublicacoesActivity.newInstance())
                .commitNow();
    }

        public void abrirTelaComunicacao(){
        tela_inicio_aberta = false;
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_inicio, ComunicacaoActivity.newInstance())
                .commitNow();
    }

    public void abrirTelaMapa(){
        tela_inicio_aberta = false;
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_inicio, MapsActivity.newInstance())
                .commitNow();
    }
}
