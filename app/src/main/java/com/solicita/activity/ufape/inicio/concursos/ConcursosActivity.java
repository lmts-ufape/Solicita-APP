package com.solicita.activity.ufape.inicio.concursos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.solicita.R;
import com.solicita.activity.ufape.inicio.InicioActivityPrincipal;
import com.solicita.activity.ufape.links.concursos.LinksConcursos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ConcursosActivity extends Fragment {

    public static ConcursosActivity newInstance() {
        return new ConcursosActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_ufape_concursos, container, false);

        LinearLayout botao_voltar = root.findViewById(R.id.botao_voltar);
        botao_voltar.setOnClickListener(clickBotaoVoltar);

        LinearLayout botao_professores_magisterio_superior = (LinearLayout) root.findViewById(R.id.botao_professores_magisterio_superior);
        botao_professores_magisterio_superior.setOnClickListener(clickBotaoProfessorMagisterioSuperior);

        LinearLayout botao_tecnicos_administrativos = (LinearLayout) root.findViewById(R.id.botao_tecnicos_administrativos);
        botao_tecnicos_administrativos.setOnClickListener(clickBotaoTecnicosAdministrativos);

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

        private View.OnClickListener clickBotaoProfessorMagisterioSuperior = new View.OnClickListener() {
        public void onClick(View v) {
            LinksConcursos.getLinksInstitucional().abrirLinkProfessorMagisterioSuperior(getContext());
        }
    };

    private View.OnClickListener clickBotaoTecnicosAdministrativos = new View.OnClickListener() {
        public void onClick(View v) {
            LinksConcursos.getLinksInstitucional().abrirLinkTecnicosAdministrativos(getContext());
        }
    };

}
