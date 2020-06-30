package com.solicita.activity.ufape.inicio.comunicacao;

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

public class ComunicacaoActivity extends Fragment {

    public static ComunicacaoActivity newInstance() {
        return new ComunicacaoActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_ufape_comunicacao, container, false);

        LinearLayout botao_voltar = root.findViewById(R.id.botao_voltar);
        botao_voltar.setOnClickListener(clickBotaoVoltar);

        LinearLayout botao_divulgue_noticia = (LinearLayout) root.findViewById(R.id.botao_divulgue_noticia);
        botao_divulgue_noticia.setOnClickListener(clickBotaoDivulgueNoticias);

        LinearLayout botao_ufape_midia = (LinearLayout) root.findViewById(R.id.botao_ufape_midia);
        botao_ufape_midia.setOnClickListener(clickBotaoUfapeMidia);

        LinearLayout botao_logomarca = (LinearLayout) root.findViewById(R.id.botao_logomarca);
        botao_logomarca.setOnClickListener(clickBotaoLogomarca);

        LinearLayout botao_modelo_documentos = (LinearLayout) root.findViewById(R.id.botao_modelos_documentos);
        botao_modelo_documentos.setOnClickListener(clickBotaoModelosDocumentos);

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

        private View.OnClickListener clickBotaoDivulgueNoticias = new View.OnClickListener() {
        public void onClick(View v) {
            LinksComunicacao.getLinksInstitucional().abrirLinkDivulgueNoticia(getContext());
        }
    };

    private View.OnClickListener clickBotaoUfapeMidia = new View.OnClickListener() {
        public void onClick(View v) {
            LinksComunicacao.getLinksInstitucional().abrirLinkUfapeMidia(getContext());
        }
    };

    private View.OnClickListener clickBotaoLogomarca = new View.OnClickListener() {
        public void onClick(View v) {
            LinksComunicacao.getLinksInstitucional().abrirLinkLogomarca(getContext());
        }
    };

    private View.OnClickListener clickBotaoModelosDocumentos = new View.OnClickListener() {
        public void onClick(View v) {
            LinksComunicacao.getLinksInstitucional().abrirLinkModelosDocumentos(getContext());
        }
    };

}
