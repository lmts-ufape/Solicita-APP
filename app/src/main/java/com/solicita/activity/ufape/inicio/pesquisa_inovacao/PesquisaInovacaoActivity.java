package com.solicita.activity.ufape.inicio.pesquisa_inovacao;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.solicita.R;
import com.solicita.activity.ufape.inicio.InicioActivityPrincipal;
import com.solicita.activity.ufape.links.pesquisa_inovacao.LinksPesquisaInovacao;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PesquisaInovacaoActivity extends Fragment {

    public static PesquisaInovacaoActivity newInstance() {
        return new PesquisaInovacaoActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_ufape_pesquisa_inovacao, container, false);

        LinearLayout botao_voltar = root.findViewById(R.id.botao_voltar);
        botao_voltar.setOnClickListener(clickBotaoVoltar);

        LinearLayout botao_programas_projetos = (LinearLayout) root.findViewById(R.id.botao_programas_projetos);
        botao_programas_projetos.setOnClickListener(clickBotaoProgramasProjetos);

        LinearLayout botao_editais = (LinearLayout) root.findViewById(R.id.botao_pesquisa_inovacao_editais);
        botao_editais.setOnClickListener(clickBotaoEditais);

        LinearLayout botao_comissao_pesquisa = (LinearLayout) root.findViewById(R.id.botao_comissao_pesquisa);
        botao_comissao_pesquisa.setOnClickListener(clickBotaoComissaoPesquisa);

        LinearLayout botao_comite_pibic = (LinearLayout) root.findViewById(R.id.botao_comite_pibic);
        botao_comite_pibic.setOnClickListener(clickBotaoComitePibic);

        LinearLayout botao_grupos_pesquisa = (LinearLayout) root.findViewById(R.id.botao_grupos_pesquisa);
        botao_grupos_pesquisa.setOnClickListener(clickBotaoGruposPesquisa);

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
            LinksPesquisaInovacao.getLinksInstitucional().abrirLinkProgramasProjetos(getContext());
        }
    };

    private View.OnClickListener clickBotaoEditais = new View.OnClickListener() {
        public void onClick(View v) {
            LinksPesquisaInovacao.getLinksInstitucional().abrirLinkEditais(getContext());
        }
    };

    private View.OnClickListener clickBotaoComissaoPesquisa = new View.OnClickListener() {
        public void onClick(View v) {
            LinksPesquisaInovacao.getLinksInstitucional().abrirLinkComissaoPesquisa(getContext());
        }
    };

    private View.OnClickListener clickBotaoComitePibic = new View.OnClickListener() {
        public void onClick(View v) {
            LinksPesquisaInovacao.getLinksInstitucional().abrirLinkComitePibic(getContext());
        }
    };

    private View.OnClickListener clickBotaoGruposPesquisa = new View.OnClickListener() {
        public void onClick(View v) {
            LinksPesquisaInovacao.getLinksInstitucional().abrirLinkGruposPesquisa(getContext());
        }
    };

}
