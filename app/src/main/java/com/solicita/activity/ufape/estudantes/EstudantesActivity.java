package com.solicita.activity.ufape.estudantes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.solicita.R;
import com.solicita.activity.ufape.links.estudantes.LinksEstudantes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EstudantesActivity extends Fragment {


    public static EstudantesActivity newInstance() {
        return new EstudantesActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_ufape_estudantes, container, false);

        LinearLayout botao_formas_ingressos = (LinearLayout) root.findViewById(R.id.botao_formas_ingresso);
        botao_formas_ingressos.setOnClickListener(clickBotaoFormasIngressos);

        LinearLayout botao_assistencia_estudantil = (LinearLayout) root.findViewById(R.id.botao_assistencia_estudantil);
        botao_assistencia_estudantil.setOnClickListener(clickBotaoAssistenciaEstudantil);

        LinearLayout botao_editais = (LinearLayout) root.findViewById(R.id.botao_estudantes_editais);
        botao_editais.setOnClickListener(clickBotaoEditais);

        LinearLayout botao_escolaridade = (LinearLayout) root.findViewById(R.id.botao_escolaridade);
        botao_escolaridade.setOnClickListener(clickBotaoEscolaridade);

        LinearLayout botao_estagios = (LinearLayout) root.findViewById(R.id.botao_estagios);
        botao_estagios.setOnClickListener(clickBotaoEstagios);

        LinearLayout botao_horario_letivo = (LinearLayout) root.findViewById(R.id.botao_horario_letivo);
        botao_horario_letivo.setOnClickListener(clickBotaoHorarioLetivo);

        LinearLayout botao_egressos = (LinearLayout) root.findViewById(R.id.botao_egressos);
        botao_egressos.setOnClickListener(clickBotaoEgressos);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    private View.OnClickListener clickBotaoFormasIngressos = new View.OnClickListener() {
        public void onClick(View v) {
            LinksEstudantes.getLinksInstitucional().abrirLinkFormasIngresso(getContext());
        }
    };

    private View.OnClickListener clickBotaoAssistenciaEstudantil = new View.OnClickListener() {
        public void onClick(View v) {
            LinksEstudantes.getLinksInstitucional().abrirLinkAssistenciaEstudantil(getContext());
        }
    };

    private View.OnClickListener clickBotaoEditais = new View.OnClickListener() {
        public void onClick(View v) {
            LinksEstudantes.getLinksInstitucional().abrirLinkEditais(getContext());
        }
    };

    private View.OnClickListener clickBotaoEscolaridade = new View.OnClickListener() {
        public void onClick(View v) {
            LinksEstudantes.getLinksInstitucional().abrirLinkEscolaridade(getContext());
        }
    };

    private View.OnClickListener clickBotaoEstagios = new View.OnClickListener() {
        public void onClick(View v) {
            LinksEstudantes.getLinksInstitucional().abrirLinkEstagios(getContext());
        }
    };

    private View.OnClickListener clickBotaoHorarioLetivo = new View.OnClickListener() {
        public void onClick(View v) {
            LinksEstudantes.getLinksInstitucional().abrirLinkHorarioLetivo(getContext());
        }
    };

    private View.OnClickListener clickBotaoEgressos = new View.OnClickListener() {
        public void onClick(View v) {
            LinksEstudantes.getLinksInstitucional().abrirLinkEgressos(getContext());
        }
    };
}
