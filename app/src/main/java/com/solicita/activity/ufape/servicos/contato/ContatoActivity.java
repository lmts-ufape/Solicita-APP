package com.solicita.activity.ufape.servicos.contato;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.solicita.R;
import com.solicita.activity.ufape.MainActivityUfape;
import com.solicita.activity.ufape.mapa.contato.MapsActivity;
import com.solicita.activity.ufape.servicos.ServicosActivityPrincipal;
import com.solicita.activity.ufape.servicos.servicos.ServicosActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ContatoActivity extends Fragment {

    public static ContatoActivity newInstance() {
        return new ContatoActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_ufape_contato, container, false);

        LinearLayout botao_voltar = root.findViewById(R.id.botao_voltar);
        botao_voltar.setOnClickListener(clickBotaoVoltar);

        TextView lista_email = root.findViewById(R.id.botao_lista_email_ufape);
        lista_email.setOnClickListener(listaEmailUfape);

        LinearLayout botao_mapa_ufape = root.findViewById(R.id.botao_mapa_ufape);
        botao_mapa_ufape.setOnClickListener(clickBotaoMapaUfape);

        LinearLayout botao_mapa_clinica = root.findViewById(R.id.botao_mapa_clinica_bovinos);
        botao_mapa_clinica.setOnClickListener(clickBotaoMapaClinicaBovinos);

        TextView mais_informacoes = root.findViewById(R.id.botao_mais_informacoes_contato_ufape);
        mais_informacoes.setOnClickListener(maisInformacoesContatoUfape);

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
            ServicosActivityPrincipal.getServicosActivityPrincipal().abrirTelaInicio();
        }
    };

    private View.OnClickListener listaEmailUfape = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://nti.ufrpe.br/emails-ufrpe");

            Intent intent = new Intent(Intent.ACTION_VIEW, uri);

            startActivity(intent);
        }
    };

    private View.OnClickListener maisInformacoesContatoUfape = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://ww3.uag.ufrpe.br/content/contato");

            Intent intent = new Intent(Intent.ACTION_VIEW, uri);

            startActivity(intent);
        }
    };

    private View.OnClickListener clickBotaoMapaUfape = new View.OnClickListener() {
        public void onClick(View v) {
            Intent it = new Intent(MainActivityUfape.getMainActivityUfape(), MapsActivity.class);
            it.putExtra("tela", "1");
            startActivity(it);
        }
    };

    private View.OnClickListener clickBotaoMapaClinicaBovinos = new View.OnClickListener() {
        public void onClick(View v) {
            Intent it = new Intent(MainActivityUfape.getMainActivityUfape(), MapsActivity.class);
            it.putExtra("tela", "2");
            startActivity(it);
        }
    };
}
