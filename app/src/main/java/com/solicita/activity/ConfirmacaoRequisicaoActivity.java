package com.solicita.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.solicita.R;
import com.solicita.activity.ufape.MainActivityUfape;
import com.solicita.helper.SharedPrefManager;
import com.solicita.network.ApiClient;
import com.solicita.network.ApiInterface;
import com.solicita.network.response.DefaultResponse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmacaoRequisicaoActivity extends AppCompatActivity {


    private TextView textProtNome, textProtCurso, textProtVinculo, textProtData, textProtDocumentos, textNomeUsuario;
    private SharedPrefManager sharedPrefManager;
    private Button buttonLogout, buttonHome, buttonVoltar;
    private ApiInterface apiInterface;
    private ArrayList listaDocsSolicitados = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao_requisicao);

        sharedPrefManager = new SharedPrefManager(this);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        inicializarComponentes();

        textNomeUsuario.setText(sharedPrefManager.getSPNome());

        buttonHome.setOnClickListener(v -> irHome());

        buttonLogout.setOnClickListener(v -> logoutApp());

        buttonVoltar.setOnClickListener(v -> irHome());

        Bundle dados = getIntent().getExtras();

        String curso = dados.getString("curso");
        String situacao = dados.getString("situacao");


        String data = dados.getString("data");
        SimpleDateFormat conversaoData = new SimpleDateFormat("dd/MM/yyyy");
        String novaData = (conversaoData.format(new Date()));
        System.out.println("Nova data: " + novaData);

        String hora = dados.getString("hora");
        ArrayList solicitados = (ArrayList<String>) dados.getSerializable("solicitados");

        listaDocsSolicitados = new ArrayList<>();

        for (int i=0; i<solicitados.size(); i++){
            String documentosSol = "\u2022 " + solicitados.get(i).toString();
            listaDocsSolicitados.add(documentosSol);
        }

        String convert = listaDocsSolicitados.toString().replace("[", " ").replace("]", "").replace(",", "\n");

        for(int i=0; i<solicitados.size(); i++){
            System.out.println(solicitados.get(i));
        }
        textProtNome.setText(sharedPrefManager.getSPNome());
        textProtData.setText(novaData + ", " + hora);
        textProtDocumentos.setText(convert);
        textProtCurso.setText(curso);
        textProtVinculo.setText(situacao);
    }
    private void inicializarComponentes(){

        textProtNome = findViewById(R.id.textProtNome);
        textProtCurso = findViewById(R.id.textProtCurso);
        textProtVinculo = findViewById(R.id.textProtVinculo);
        textProtData = findViewById(R.id.textProtData);
        textProtDocumentos = findViewById(R.id.textProtDocumentos);
        buttonLogout = findViewById(R.id.buttonLogout);
        buttonHome = findViewById(R.id.buttonHome);
        buttonVoltar = findViewById(R.id.buttonVoltar);
        textNomeUsuario = findViewById(R.id.textNomeUsuario);
    }
    private void logoutApp() {

        Call<DefaultResponse> responseCall = apiInterface.postLogout(sharedPrefManager.getSPToken());

        responseCall.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                DefaultResponse dr = response.body();
                Toast.makeText(ConfirmacaoRequisicaoActivity.this, dr.getMessage(), Toast.LENGTH_SHORT).show();
                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_STATUS_LOGIN, false);
                startActivity(new Intent(ConfirmacaoRequisicaoActivity.this, LoginActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                clickBotaoHomeUfape();
                finish();
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });

    }
    private void clickBotaoHomeUfape(){

        startActivity(new Intent(this, MainActivityUfape.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }

    public void clickBotaoHomeUfape(View view){

        startActivity(new Intent(this, MainActivityUfape.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
    private void irHome(){
        startActivity(new Intent(ConfirmacaoRequisicaoActivity.this, HomeAlunoActivity.class));

    }
}