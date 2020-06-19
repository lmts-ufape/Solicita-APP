package com.solicita.activity.ufape.servicos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.solicita.R;
import com.solicita.activity.ufape.servicos.servicos.ServicosActivity;
import com.solicita.activity.ufape.servicos.contato.ContatoActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ServicosActivityPrincipal extends Fragment {

    private static ServicosActivityPrincipal tela;
    public static ServicosActivityPrincipal getServicosActivityPrincipal(){
        return tela;
    }

    public ServicosActivityPrincipal(){
        tela = this;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_ufape_servicos_principal, container, false);

        abrirTelaInicio();

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
                    .replace(R.id.frame_layout_servicos, ServicosActivity.newInstance())
                    .commitNow();
        }
    }

    public void abrirTelaContato(){
        tela_inicio_aberta = false;
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_servicos, ContatoActivity.newInstance())
                .commitNow();
    }
}
