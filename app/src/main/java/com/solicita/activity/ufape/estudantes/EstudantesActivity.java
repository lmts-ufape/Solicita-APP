package com.solicita.activity.ufape.estudantes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.solicita.R;

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

        LinearLayout botao_anexos = (LinearLayout) root.findViewById(R.id.botao_anexos);
        botao_anexos.setOnClickListener(clickBotaoAnexos);

        LinearLayout botao_editais = (LinearLayout) root.findViewById(R.id.botao_editais);
        botao_editais.setOnClickListener(clickBotaoEditais);

        LinearLayout botao_formulario = (LinearLayout) root.findViewById(R.id.botao_formulario_psicologico);
        botao_formulario.setOnClickListener(clickBotaoFormularioPsicologico);

        LinearLayout botao_incricoes = (LinearLayout) root.findViewById(R.id.botao_inscricoes_online);
        botao_incricoes.setOnClickListener(clickBotaoInscricoesOnLine);

        LinearLayout botao_resolucoes = (LinearLayout) root.findViewById(R.id.botao_resolucoes);
        botao_resolucoes.setOnClickListener(clickBotaoResolucoes);

        LinearLayout botao_resultados= (LinearLayout) root.findViewById(R.id.botao_resultados);
        botao_resultados.setOnClickListener(clickBotaoResultados);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    private View.OnClickListener clickBotaoAnexos = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://ww3.uag.ufrpe.br/content/anexos");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickBotaoEditais = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://ww3.uag.ufrpe.br/content/editais");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickBotaoFormularioPsicologico = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://ww3.uag.ufrpe.br/content/atendimento-psicol%C3%B3gico-online");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickBotaoInscricoesOnLine = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://www.progesti.ufrpe.br/br/inscricao-online-progesti#");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickBotaoResolucoes = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://ww3.uag.ufrpe.br/content/resolu%C3%A7%C3%B5es");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickBotaoResultados = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://ww3.uag.ufrpe.br/content/resultados");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };
}
