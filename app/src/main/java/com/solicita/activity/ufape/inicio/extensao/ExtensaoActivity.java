package com.solicita.activity.ufape.inicio.extensao;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.solicita.R;
import com.solicita.activity.ufape.inicio.InicioActivityPrincipal;
import com.solicita.activity.ufape.links.extensao.LinksExtensao;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ExtensaoActivity extends Fragment {

    public static ExtensaoActivity newInstance() {
        return new ExtensaoActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_ufape_extensao, container, false);

        LinearLayout botao_voltar = root.findViewById(R.id.botao_voltar);
        botao_voltar.setOnClickListener(clickBotaoVoltar);

        LinearLayout botao_programas_projetos = (LinearLayout) root.findViewById(R.id.botao_programas_projetos);
        botao_programas_projetos.setOnClickListener(clickBotaoProgramasProjetos);

        LinearLayout botao_editais = (LinearLayout) root.findViewById(R.id.botao_extensao_editais);
        botao_editais.setOnClickListener(clickBotaoEditais);

        LinearLayout botao_comissao_extensao = (LinearLayout) root.findViewById(R.id.botao_comissao_extensao);
        botao_comissao_extensao.setOnClickListener(clickBotaoComissaoExtensao);

        LinearLayout botao_casa_uag = (LinearLayout) root.findViewById(R.id.botao_casa_uag);
        botao_casa_uag.setOnClickListener(clickBotaoCasaUag);

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

    private View.OnClickListener clickBotaoProgramasProjetos = new View.OnClickListener() {
        public void onClick(View v) {
            LinksExtensao.getLinksInstitucional().abrirLinkProgramasProjetos(getContext());
        }
    };

    private View.OnClickListener clickBotaoEditais = new View.OnClickListener() {
        public void onClick(View v) {
            LinksExtensao.getLinksInstitucional().abrirLinkEditais(getContext());
        }
    };

    private View.OnClickListener clickBotaoComissaoExtensao = new View.OnClickListener() {
        public void onClick(View v) {
            LinksExtensao.getLinksInstitucional().abrirLinkComissaoExtensao(getContext());
        }
    };

    private View.OnClickListener clickBotaoCasaUag = new View.OnClickListener() {
        public void onClick(View v) {
            LinksExtensao.getLinksInstitucional().abrirLinkCasaUag(getContext());
        }
    };

}
