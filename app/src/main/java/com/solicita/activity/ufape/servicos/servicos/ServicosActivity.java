package com.solicita.activity.ufape.servicos.servicos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.solicita.R;
import com.solicita.activity.LoginActivity;
import com.solicita.activity.ufape.MainActivityUfape;
import com.solicita.activity.ufape.inicio.InicioActivityPrincipal;
import com.solicita.activity.ufape.servicos.ServicosActivityPrincipal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ServicosActivity extends Fragment {

    public static ServicosActivity newInstance() {
        return new ServicosActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_ufape_servicos, container, false);

        LinearLayout botao_siga = (LinearLayout) root.findViewById(R.id.botao_siga_servicos);
        botao_siga.setOnClickListener(clickBotaoSiga);

        LinearLayout botao_biblioteca = (LinearLayout) root.findViewById(R.id.botao_biblioteca_servicos);
        botao_biblioteca.setOnClickListener(clickBotaoBiblioteca);

        LinearLayout botao_contato = (LinearLayout) root.findViewById(R.id.botao_contato_servicos);
        botao_contato.setOnClickListener(clickBotaoContato);

        LinearLayout botao_solicita = (LinearLayout) root.findViewById(R.id.botao_solicita_servicos);
        botao_solicita.setOnClickListener(clickBotaoSolicita);

        LinearLayout botao_submeta = (LinearLayout) root.findViewById(R.id.botao_submeta_servicos);
        botao_submeta.setOnClickListener(clickBotaoSubmeta);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    private View.OnClickListener clickBotaoSiga = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("https://www.siga.ufrpe.br/ufrpe/index.jsp");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickBotaoBiblioteca = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://www.sib.ufrpe.br/biblioteca-uag");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };

    private View.OnClickListener clickBotaoContato = new View.OnClickListener() {
        public void onClick(View v) {
            ServicosActivityPrincipal.getServicosActivityPrincipal().abrirTelaContato();
        }
    };

    private View.OnClickListener clickBotaoSolicita = new View.OnClickListener() {
        public void onClick(View v) {
            MainActivityUfape.getMainActivityUfape().clickBotaoMenuLateralSolicita();
        }
    };

    private View.OnClickListener clickBotaoSubmeta = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://app.uag.ufrpe.br/submeta");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };
}
