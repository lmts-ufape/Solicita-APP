package com.solicita.activity.ufape.sobre;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.solicita.R;

public class SobreActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ufape_sobre);

        montarTextoSobre((com.bluejamesbond.text.DocumentView) findViewById(R.id.texto_sobre));
    }

    private void montarTextoSobre(com.bluejamesbond.text.DocumentView textView){
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

    public void clickBotaoClose(View view){
        finish();
    }
}
