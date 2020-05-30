package com.solicita.activity.ufape.cursos.cursos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.solicita.R;
import com.solicita.activity.ufape.cursos.CursosActivityPrincipal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CursosActivity extends Fragment {


    public static CursosActivity newInstance() {
        return new CursosActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_ufape_cursos, container, false);

        LinearLayout botao_graduacao = (LinearLayout) root.findViewById(R.id.botao_graduacao_cursos);
        botao_graduacao.setOnClickListener(clickBotaoGraduacao);

        LinearLayout botao_pos_graduacao = (LinearLayout) root.findViewById(R.id.botao_pos_graduacao_cursos);
        botao_pos_graduacao.setOnClickListener(clickBotaoPosGraduacao);

        LinearLayout botao_ead = (LinearLayout) root.findViewById(R.id.botao_ead_cursos);
        botao_ead.setOnClickListener(clickBotaoEad);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    private View.OnClickListener clickBotaoGraduacao = new View.OnClickListener() {
        public void onClick(View v) {
            CursosActivityPrincipal.getCursosActivityPrincipal().abrirTelaGruaduacao();
        }
    };

    private View.OnClickListener clickBotaoPosGraduacao = new View.OnClickListener() {
        public void onClick(View v) {
            CursosActivityPrincipal.getCursosActivityPrincipal().abrirTelaPosGruaduacao();
        }
    };

    private View.OnClickListener clickBotaoEad = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://ava.ufrpe.br/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };
}
