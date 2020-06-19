package com.solicita.activity.ufape.inicio.publicacoes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.solicita.R;
import com.solicita.activity.ufape.inicio.InicioActivityPrincipal;
import com.solicita.activity.ufape.links.publicacoes.LinksPublicacoes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PublicacoesActivity extends Fragment {

    public static PublicacoesActivity newInstance() {
        return new PublicacoesActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_ufape_publicacoes, container, false);

        LinearLayout botao_voltar = root.findViewById(R.id.botao_voltar);
        botao_voltar.setOnClickListener(clickBotaoVoltar);

        LinearLayout botao_repositorio_institucional = (LinearLayout) root.findViewById(R.id.botao_repositorio_institucional);
        botao_repositorio_institucional.setOnClickListener(clickBotaoRepositorioInstitucional);

        LinearLayout botao_agenda_defesas = (LinearLayout) root.findViewById(R.id.botao_agenda_defesas);
        botao_agenda_defesas.setOnClickListener(clickBotaoAgendaDefesas);

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

    private View.OnClickListener clickBotaoRepositorioInstitucional = new View.OnClickListener() {
        public void onClick(View v) {
            LinksPublicacoes.getLinksInstitucional().abrirLinkRepositorioInstitucional(getContext());
        }
    };

    private View.OnClickListener clickBotaoAgendaDefesas = new View.OnClickListener() {
        public void onClick(View v) {
            LinksPublicacoes.getLinksInstitucional().abrirLinkAgendaDefesas(getContext());
        }
    };

}
