package com.solicita.activity.ufape.inicio.a_ufape;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.solicita.R;
import com.solicita.activity.ufape.inicio.InicioActivityPrincipal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AUfapeActivity extends Fragment {

    public static AUfapeActivity newInstance() {
        return new AUfapeActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_ufape_a_ufape, container, false);

        LinearLayout botao_voltar = root.findViewById(R.id.botao_voltar);
        botao_voltar.setOnClickListener(clickBotaoVoltar);

        montarTextoCorpo((com.bluejamesbond.text.DocumentView) root.findViewById(R.id.texto_historia_ufape));

        TextView botao = root.findViewById(R.id.botao_mais_informacoes_a_ufape_ufape);
        botao.setOnClickListener(maisInformacoesAUfape);

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

    private View.OnClickListener maisInformacoesAUfape = new View.OnClickListener() {
        public void onClick(View v) {
            Uri uri = Uri.parse("http://ufape.edu.br/br/hist%C3%B3ria");

            Intent intent = new Intent(Intent.ACTION_VIEW, uri);

            startActivity(intent);
        }
    };

    private void montarTextoCorpo(com.bluejamesbond.text.DocumentView textView){
        String texto =
                    "   A Universidade Federal do Agreste de Pernambuco (UFAPE) tem sua origem no ano de 2018, a partir da Lei Nº 13.651, de 11 de abril de 2018, através do desmembramento da Universidade Federal Rural de Pernambuco (UFRPE) / Unidade Acadêmica de Garanhuns (UAG); Unidade esta que foi criada no ano de 2005, por meio de programa de expansão universitária.\n" +
                    "\n\n" +
                    "   Desta forma, a UFAPE vem a assumir toda a estrutura física, patrimonial e de pessoal da até então UAG/UFRPE.\n" +
                    "\n\n" +
                    "   Em 27 de dezembro de 2018, teve início a vigência do Termo de Colaboração Técnica, celebrado entre o Ministério da Educação (MEC), por intermédio da Secretaria de Educação Superior, e a UFRPE, para a implantação da UFAPE, com vigência de 12 (doze) meses, podendo ser prorrogado, mediante celebração de Termo Aditivo, por acordo dos partícipes.\n" +
                    "\n\n" +
                    "   Em 1º de janeiro de 2019, por meio do Decreto Nº 9.660, o Poder Executivo vinculou a UFAPE como entidade da administração publica federal.\n" +
                    "\n\n" +
                    "   No dia 24 de janeiro de 2019, no auditório da Sala dos Conselhos Superiores da UFRPE, no Campus Recife/Dois Irmãos, foram iniciados os trabalhos das equipes técnicas envolvidas no processo de transição que deverá culminar com a completa autonomia desta nova Universidade Federal.\n" +
                    "\n\n" +
                    "   No dia 30 de janeiro de 2019, a Reitoria da UFRPE publicou a Portaria Nº 132/2019-GR, que instituiu a comissão de transição para a implantação da UFAPE; comissão que é composta tanto por servidores da Sede/UFRPE quanto por servidores da UAG/UFRPE (UFAPE). \n" +
                    "\n\n" +
                    "   Em solenidade realizada no MEC, em Brasília-DF, no dia 12 de dezembro de 2019, o prof. Dr. Airon Aparecido Silva de Melo, até então Diretor Geral e Acadêmico da UAG/UFRPE, toma posse como o primeiro Reitor da UFAPE.";

        textView.setText(texto);

    }
}
