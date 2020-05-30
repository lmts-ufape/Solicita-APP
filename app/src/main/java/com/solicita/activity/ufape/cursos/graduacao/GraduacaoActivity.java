package com.solicita.activity.ufape.cursos.graduacao;

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

public class GraduacaoActivity extends Fragment {


    public static GraduacaoActivity newInstance() {
        return new GraduacaoActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_ufape_cursos_graduacao, container, false);

        LinearLayout botao_voltar = root.findViewById(R.id.botao_voltar);
        botao_voltar.setOnClickListener(clickBotaoVoltar);

        LinearLayout botao_agronomia = root.findViewById(R.id.botao_agronomia);
        botao_agronomia.setOnClickListener(clickBotaoAgronomia);

        LinearLayout botao_ciencia_computacao = root.findViewById(R.id.botao_ciencia_computacao);
        botao_ciencia_computacao.setOnClickListener(clickBotaoCienciaComputacao);

        LinearLayout botao_zootecnia = root.findViewById(R.id.botao_zootecnia);
        botao_zootecnia.setOnClickListener(clickBotaoZootecnia);

        LinearLayout botao_alimentos = root.findViewById(R.id.botao_engenharia_alimentos);
        botao_alimentos.setOnClickListener(clickBotaoEngenhariaAlimentos);

        LinearLayout botao_letras = root.findViewById(R.id.botao_letras);
        botao_letras.setOnClickListener(clickBotaoLetras);

        LinearLayout botao_pedagogia = root.findViewById(R.id.botao_pedagoria);
        botao_pedagogia.setOnClickListener(clickBotaoPedagogia);

        LinearLayout botao_veterinaria = root.findViewById(R.id.botao_medicina_veterinaria);
        botao_veterinaria.setOnClickListener(clickBotaoMedicinaVeterinaria);

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

    private View.OnClickListener clickBotaoAgronomia = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://ww3.uag.ufrpe.br/content/bacharelado-em-agronomia");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickBotaoCienciaComputacao = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://ww3.uag.ufrpe.br/content/bacharelado-em-ci%C3%AAncias-da-computa%C3%A7%C3%A3o");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickBotaoZootecnia = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://ww3.uag.ufrpe.br/content/bacharelado-em-zootecnia");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickBotaoEngenhariaAlimentos = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://ww3.uag.ufrpe.br/content/engenharia-de-alimentos");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickBotaoLetras = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://ww3.uag.ufrpe.br/content/licenciatura-em-letras");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickBotaoPedagogia = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://ww3.uag.ufrpe.br/content/licenciatura-em-pedagogia");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickBotaoMedicinaVeterinaria = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://ww3.uag.ufrpe.br/content/medicina-veterin%C3%A1ria");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };

}
