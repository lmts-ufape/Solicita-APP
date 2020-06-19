package com.solicita.activity.ufape.inicio.institucional;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.solicita.R;
import com.solicita.activity.ufape.inicio.InicioActivityPrincipal;
import com.solicita.activity.ufape.links.institucional.LinksInstitucional;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class InstitucionalActivity extends Fragment {

    public static InstitucionalActivity newInstance() {
        return new InstitucionalActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_ufape_institucional, container, false);

        LinearLayout botao_voltar = root.findViewById(R.id.botao_voltar);
        botao_voltar.setOnClickListener(clickBotaoVoltar);

        LinearLayout botao_a_ufape = (LinearLayout) root.findViewById(R.id.botao_a_ufape);
        botao_a_ufape.setOnClickListener(clickBotaoAUfape);

        LinearLayout botao_a_reitoria = (LinearLayout) root.findViewById(R.id.botao_a_reitoria);
        botao_a_reitoria.setOnClickListener(clickBotaoAReitoria);

        LinearLayout botao_estrutura_administrativa = (LinearLayout) root.findViewById(R.id.botao_estrutura_administrativa);
        botao_estrutura_administrativa.setOnClickListener(clickBotaoEstrutuaAdministrativa);

        LinearLayout botao_conselhos_superiores = (LinearLayout) root.findViewById(R.id.botao_conselhos_superiores);
        botao_conselhos_superiores.setOnClickListener(clickBotaoConselhosSuperiores);

        LinearLayout botao_estatuinte = (LinearLayout) root.findViewById(R.id.botao_estatuinte);
        botao_estatuinte.setOnClickListener(clickBotaoEstatuinte);

        LinearLayout botao_decisoes_resolucoes_portarias = (LinearLayout) root.findViewById(R.id.botao_decicoes_resolucoes_portarias);
        botao_decisoes_resolucoes_portarias.setOnClickListener(clickBotaoDecisoesResolucoesPortarias);

        LinearLayout botao_comissoes = (LinearLayout) root.findViewById(R.id.botao_comissoes);
        botao_comissoes.setOnClickListener(clickBotaoComissoes);

        LinearLayout botao_biblioteca = (LinearLayout) root.findViewById(R.id.botao_biblioteca);
        botao_biblioteca.setOnClickListener(clickBotaoBiblioteca);

        LinearLayout botao_hospital_veterinario = (LinearLayout) root.findViewById(R.id.botao_hospital_veterinario);
        botao_hospital_veterinario.setOnClickListener(clickBotaoHospitalVeterinario);

        LinearLayout botao_laboratorios = (LinearLayout) root.findViewById(R.id.botao_laboratorios);
        botao_laboratorios.setOnClickListener(clickBotaoLaboratorios);

        LinearLayout botao_cooperacao_nacional_internacional = (LinearLayout) root.findViewById(R.id.botao_cooperacao_nacional_internacional);
        botao_cooperacao_nacional_internacional.setOnClickListener(clickBotaoCooperacaoNacionalInternacional);

        LinearLayout botao_emacipacao = (LinearLayout) root.findViewById(R.id.botao_emacipacao);
        botao_emacipacao.setOnClickListener(clickBotaoEmancipacao);

        LinearLayout botao_acesso_informacao = (LinearLayout) root.findViewById(R.id.botao_acesso_informacao);
        botao_acesso_informacao.setOnClickListener(clickBotaoAcessoInformatica);

        LinearLayout botao_ouvidoria = (LinearLayout) root.findViewById(R.id.botao_ouvidoria);
        botao_ouvidoria.setOnClickListener(clickBotaoOuvidoria);

        LinearLayout botao_boletins_servicos = (LinearLayout) root.findViewById(R.id.botao_boletins_servicos);
        botao_boletins_servicos.setOnClickListener(clickBotaoBoletinsServicos);

        LinearLayout botao_documentos_relatorios = (LinearLayout) root.findViewById(R.id.botao_documentos_relatorios);
        botao_documentos_relatorios.setOnClickListener(clickBotaoDocumentosRelatorios);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    private View.OnClickListener clickBotaoVoltar = new View.OnClickListener() {
        public void onClick(View v) {
            InicioActivityPrincipal.getInicioActivityPrincipal().abrirTelaInicio();
        }
    };

    private View.OnClickListener clickBotaoAUfape = new View.OnClickListener() {
        public void onClick(View v) {
            LinksInstitucional.getLinksInstitucional().abrirLinkAUfape(getContext());
        }
    };

    private View.OnClickListener clickBotaoAReitoria = new View.OnClickListener() {
        public void onClick(View v) {
            LinksInstitucional.getLinksInstitucional().abrirLinkAReitoria(getContext());
        }
    };

    private View.OnClickListener clickBotaoEstrutuaAdministrativa = new View.OnClickListener() {
        public void onClick(View v) {
            LinksInstitucional.getLinksInstitucional().abrirLinkEstruturaAdministrativa(getContext());
        }
    };

    private View.OnClickListener clickBotaoConselhosSuperiores = new View.OnClickListener() {
        public void onClick(View v) {
            LinksInstitucional.getLinksInstitucional().abrirLinkConselhosSuperiores(getContext());
        }
    };

    private View.OnClickListener clickBotaoEstatuinte = new View.OnClickListener() {
        public void onClick(View v) {
            LinksInstitucional.getLinksInstitucional().abrirLinkEstatuinte(getContext());
        }
    };

    private View.OnClickListener clickBotaoDecisoesResolucoesPortarias = new View.OnClickListener() {
        public void onClick(View v) {
            LinksInstitucional.getLinksInstitucional().abrirLinkDecisoesResolucoesPortarias(getContext());
        }
    };

    private View.OnClickListener clickBotaoComissoes = new View.OnClickListener() {
        public void onClick(View v) {
            LinksInstitucional.getLinksInstitucional().abrirLinkComissoes(getContext());
        }
    };

    private View.OnClickListener clickBotaoBiblioteca = new View.OnClickListener() {
        public void onClick(View v) {
            LinksInstitucional.getLinksInstitucional().abrirLinkBiblioteca(getContext());
        }
    };

    private View.OnClickListener clickBotaoHospitalVeterinario = new View.OnClickListener() {
        public void onClick(View v) {
            LinksInstitucional.getLinksInstitucional().abrirLinkHospitalVeterinario(getContext());
        }
    };

    private View.OnClickListener clickBotaoLaboratorios = new View.OnClickListener() {
        public void onClick(View v) {
            LinksInstitucional.getLinksInstitucional().abrirLinkLaboratorios(getContext());
        }
    };

    private View.OnClickListener clickBotaoCooperacaoNacionalInternacional = new View.OnClickListener() {
        public void onClick(View v) {
            LinksInstitucional.getLinksInstitucional().abrirLinkCooperacaoNacionalInternacional(getContext());
        }
    };

    private View.OnClickListener clickBotaoEmancipacao = new View.OnClickListener() {
        public void onClick(View v) {
            LinksInstitucional.getLinksInstitucional().abrirLinkEmancipacao(getContext());
        }
    };

    private View.OnClickListener clickBotaoAcessoInformatica = new View.OnClickListener() {
        public void onClick(View v) {
            LinksInstitucional.getLinksInstitucional().abrirLinkAcessoInformacao(getContext());
        }
    };

    private View.OnClickListener clickBotaoOuvidoria = new View.OnClickListener() {
        public void onClick(View v) {
            LinksInstitucional.getLinksInstitucional().abrirLinkOuvidoria(getContext());
        }
    };

    private View.OnClickListener clickBotaoBoletinsServicos = new View.OnClickListener() {
        public void onClick(View v) {
            LinksInstitucional.getLinksInstitucional().abrirLinkBoletinsServicos(getContext());
        }
    };

    private View.OnClickListener clickBotaoDocumentosRelatorios = new View.OnClickListener() {
        public void onClick(View v) {
            LinksInstitucional.getLinksInstitucional().abrirLinkDocumentosRelatorios(getContext());
        }
    };
}
