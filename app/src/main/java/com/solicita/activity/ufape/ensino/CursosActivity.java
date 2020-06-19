package com.solicita.activity.ufape.ensino;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.solicita.R;
import com.solicita.activity.ufape.links.ensino.LinksEnsino;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CursosActivity extends Fragment {

    private static CursosActivity tela;
    public static CursosActivity getCursosActivityPrincipal(){
        return tela;
    }

    public CursosActivity(){
        tela = this;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_ufape_ensino, container, false);

        LinearLayout botao_cursos_graduacao = (LinearLayout) root.findViewById(R.id.botao_cursos_graduacao);
        botao_cursos_graduacao.setOnClickListener(clickBotaoCursosGraduacao);

        LinearLayout botao_cursos_especializacao = (LinearLayout) root.findViewById(R.id.botao_cursos_especializacao);
        botao_cursos_especializacao.setOnClickListener(clickBotaoCursosEspecializacao);

        LinearLayout botao_cursos_mestrado_doutorados = (LinearLayout) root.findViewById(R.id.botao_cursos_mestrado_doutorado);
        botao_cursos_mestrado_doutorados.setOnClickListener(clickBotaoCursosMestradoDoutorado);

        LinearLayout botao_programas_projetos = (LinearLayout) root.findViewById(R.id.botao_programas_projetos);
        botao_programas_projetos.setOnClickListener(clickBotaoProgramasProjetos);

        LinearLayout botao_editais = (LinearLayout) root.findViewById(R.id.botao_ensino_editais);
        botao_editais.setOnClickListener(clickBotaoEditais);

        LinearLayout botao_comissao_ensino = (LinearLayout) root.findViewById(R.id.botao_comissao_ensino);
        botao_comissao_ensino.setOnClickListener(clickBotaoComissaoEstudo);

        LinearLayout botao_grupos_estudo = (LinearLayout) root.findViewById(R.id.botao_grupos_estudo);
        botao_grupos_estudo.setOnClickListener(clickBotaoGruposEstudo);

        LinearLayout botao_calendario_academico = (LinearLayout) root.findViewById(R.id.botao_calendario_academico);
        botao_calendario_academico.setOnClickListener(clickBotaoCalendarioAcademico);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void abrirLink(String link){
        Uri uri = Uri.parse(link);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private View.OnClickListener clickBotaoCursosGraduacao = new View.OnClickListener() {
        public void onClick(View v) {
            LinksEnsino.getLinksInstitucional().abrirLinkCursosGraduacao(getContext());
        }
    };

    private View.OnClickListener clickBotaoCursosEspecializacao = new View.OnClickListener() {
        public void onClick(View v) {
            LinksEnsino.getLinksInstitucional().abrirLinkCursosEspecializacao(getContext());
        }
    };

    private View.OnClickListener clickBotaoCursosMestradoDoutorado = new View.OnClickListener() {
        public void onClick(View v) {
            LinksEnsino.getLinksInstitucional().abrirLinkCursosMestradoDoutorado(getContext());
        }
    };

    private View.OnClickListener clickBotaoProgramasProjetos = new View.OnClickListener() {
        public void onClick(View v) {
            LinksEnsino.getLinksInstitucional().abrirLinkProgramasProjetos(getContext());
        }
    };

    private View.OnClickListener clickBotaoEditais = new View.OnClickListener() {
        public void onClick(View v) {
            LinksEnsino.getLinksInstitucional().abrirLinkEditais(getContext());
        }
    };

    private View.OnClickListener clickBotaoComissaoEstudo = new View.OnClickListener() {
        public void onClick(View v) {
            LinksEnsino.getLinksInstitucional().abrirLinkComissaoEnsino(getContext());
        }
    };

    private View.OnClickListener clickBotaoGruposEstudo = new View.OnClickListener() {
        public void onClick(View v) {
            LinksEnsino.getLinksInstitucional().abrirLinkGruposEstudos(getContext());
        }
    };

    private View.OnClickListener clickBotaoCalendarioAcademico = new View.OnClickListener() {
        public void onClick(View v) {
            LinksEnsino.getLinksInstitucional().abrirLinkCalendarioAcademico(getContext());
        }
    };

}
