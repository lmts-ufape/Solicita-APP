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
                "   O AppUFAPE é um aplicativo para o sistema operacional Android que viabiliza o rápido acesso a informações da " +
                        "Universidade Federal do Agreste de Pernambuco (UFAPE), desde aquelas alimentadas em seu portal " +
                        "institucional, assim como aos sistemas que utiliza internamente como o AVA, Sig@, Solicita e Submeta. " +
                        "O sistema foi desenvolvido pelo Laboratório Multidisciplinar de Tecnologias Sociais da UFAPE.";
        textView.setText(texto);

    }

    public void clickBotaoClose(View view){
        finish();
    }
}
