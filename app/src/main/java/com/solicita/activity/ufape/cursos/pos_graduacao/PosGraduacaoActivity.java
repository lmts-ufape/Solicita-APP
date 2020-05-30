package com.solicita.activity.ufape.cursos.pos_graduacao;

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

public class PosGraduacaoActivity extends Fragment {


    public static PosGraduacaoActivity newInstance() {
        return new PosGraduacaoActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_ufape_cursos_pos_graduacao, container, false);

        LinearLayout botao_voltar = root.findViewById(R.id.botao_voltar);
        botao_voltar.setOnClickListener(clickBotaoVoltar);

        LinearLayout botao_sanidade_reproducao_antigo = root.findViewById(R.id.botao_mestrado_sanidade_reproducao_antigo);
        botao_sanidade_reproducao_antigo.setOnClickListener(clickBotaoMestradoSanidadeReproducaoAntigo);

        LinearLayout botao_sanidade_reproducao_novo = root.findViewById(R.id.botao_mestrado_sanidade_reproducao_novo);
        botao_sanidade_reproducao_novo.setOnClickListener(clickBotaoMestradoSanidadeReproducaoNovo);

        LinearLayout botao_producao_agricula = root.findViewById(R.id.botao_mestrado_producao_agricola);
        botao_producao_agricula.setOnClickListener(clickBotaoMestradoProducaoAgricula);

        LinearLayout botao_ciencia_animal_pastagens = root.findViewById(R.id.botao_programa_ciencia_animal_pastagens);
        botao_ciencia_animal_pastagens.setOnClickListener(clickBotaoPosGraduacaoCienciaAnimalPastagens);

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
            CursosActivityPrincipal.getCursosActivityPrincipal().abrirTelaInicio();
        }
    };

    private View.OnClickListener clickBotaoMestradoSanidadeReproducaoAntigo = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://200.17.137.39/uag/posgraduacao/pgsrr/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickBotaoMestradoSanidadeReproducaoNovo = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://www.pgsrr.ufrpe.br/?q=pt-br/sobre-o-programa");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickBotaoMestradoProducaoAgricula = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://www.ppgpa.ufrpe.br/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickBotaoPosGraduacaoCienciaAnimalPastagens = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://www.pgcap.ufrpe.br/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };
}
