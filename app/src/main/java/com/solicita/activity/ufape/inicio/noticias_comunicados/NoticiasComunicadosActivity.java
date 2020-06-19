package com.solicita.activity.ufape.inicio.noticias_comunicados;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.solicita.R;
import com.solicita.activity.ufape.inicio.InicioActivityPrincipal;
import com.solicita.activity.ufape.links.comunicacao.LinksComunicacao;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NoticiasComunicadosActivity extends Fragment {

    public static NoticiasComunicadosActivity newInstance() {
        return new NoticiasComunicadosActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_ufape_noticias_comunicados, container, false);

        LinearLayout botao_voltar = root.findViewById(R.id.botao_voltar);
        botao_voltar.setOnClickListener(clickBotaoVoltar);

        LinearLayout botao_noticias = root.findViewById(R.id.botao_noticias);
        botao_noticias.setOnClickListener(clickNoticias);

        LinearLayout botao_comunicados = root.findViewById(R.id.botao_comunicados);
        botao_comunicados.setOnClickListener(clickComunicados);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private View.OnClickListener clickBotaoVoltar = new View.OnClickListener() {
        public void onClick(View v) {
            InicioActivityPrincipal.getInicioActivityPrincipal().abrirTelaInicio();
        }
    };

    private View.OnClickListener clickNoticias = new View.OnClickListener() {
        public void onClick(View v) {
            LinksComunicacao.getLinksInstitucional().abrirLinkNoticias(getContext());
        }
    };

    private View.OnClickListener clickComunicados = new View.OnClickListener() {
        public void onClick(View v) {
            LinksComunicacao.getLinksInstitucional().abrirLinkComunicados(getContext());
        }
    };
}
