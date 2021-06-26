package com.solicita.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.solicita.R;
import com.solicita.activity.ufape.MainActivityUfape;
import com.solicita.helper.SharedPrefManager;
import com.solicita.helper.ValidacaoEmail;
import com.solicita.model.User;
import com.solicita.network.ApiClient;
import com.solicita.network.ApiInterface;
import com.solicita.network.response.DefaultResponse;
import com.solicita.network.response.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditarPerfilActivity extends AppCompatActivity {

    private TextInputEditText editNomePerfil, editEmailPerfil;
    private Button buttonSalvarAlteracoes;
    private ApiInterface apiInterface;
    private SharedPrefManager sharedPrefManager;
    private Button buttonLogout, buttonHome;
    private TextView textNomeUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        sharedPrefManager = new SharedPrefManager(this);
        apiInterface= ApiClient.getClient().create(ApiInterface.class);

        inicializarComponentes();

        textNomeUsuario.setText(sharedPrefManager.getSPNome());

        buscarInfoJSON();

        buttonHome.setOnClickListener(v -> irHome());

        buttonLogout.setOnClickListener(v -> logoutApp());

        buttonSalvarAlteracoes.setOnClickListener(v -> editarPerfil());
    }
    private void buscarInfoJSON(){
        Call<UserResponse> userResponseCall = apiInterface.getEdit(sharedPrefManager.getSPToken());
        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                User user = response.body().getUser();
                String nome = user.getName();
                String email = user.getEmail();

                editNomePerfil.setText(nome);
                editEmailPerfil.setText(email);
            }
            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
    }
    private void editarPerfil(){

        ValidacaoEmail validacaoEmail = new ValidacaoEmail();

        String name = editNomePerfil.getText().toString();
        String email = editEmailPerfil.getText().toString();

        if (!name.isEmpty()) {
            if (!email.isEmpty()){
                if (validacaoEmail.isValidEmailAddressRegex(email)) {

                String primeiroNome = name;
                String[] s = primeiroNome.trim().split(" ");
                sharedPrefManager.saveSPString(SharedPrefManager.SP_NOME, s[0]);

                Call<DefaultResponse> userResponseCall = apiInterface.postEdit(name, email, sharedPrefManager.getSPToken());
                userResponseCall.enqueue(new Callback<DefaultResponse>() {
                    @Override
                    public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                        if (response.code()==200){
                            DefaultResponse dr = response.body();
                            Toast.makeText(EditarPerfilActivity.this, dr.getMessage(), Toast.LENGTH_LONG).show();
                            startActivity(new Intent(EditarPerfilActivity.this, InformacoesDiscenteActivity.class));
                            finish();
                        }else {

                            Toast.makeText(getApplicationContext(), "Falha na comunicação com o servidor.", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(EditarPerfilActivity.this, LoginActivity.class));
                        }
                    }

                    @Override
                    public void onFailure(Call<DefaultResponse> call, Throwable t) {

                    }
                });

                } else {
                    Toast.makeText(EditarPerfilActivity.this, "Formato de e-mail inválido", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(EditarPerfilActivity.this, "O campo e-mail não pode estar vazio.", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(EditarPerfilActivity.this, "O campo nome não pode estar vazio.", Toast.LENGTH_SHORT).show();
        }
    }

    private void inicializarComponentes(){

        editNomePerfil         = findViewById(R.id.editNomePerfil);
        editEmailPerfil        = findViewById(R.id.editEmailPerfil);
        buttonSalvarAlteracoes = findViewById(R.id.buttonSalvarAlteracoes);
        buttonLogout = findViewById(R.id.buttonLogout);
        buttonHome = findViewById(R.id.buttonHome);
        textNomeUsuario = findViewById(R.id.textNomeUsuario);

    }
    private void logoutApp() {

        Call<DefaultResponse> responseCall = apiInterface.postLogout(sharedPrefManager.getSPToken());

        responseCall.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                DefaultResponse dr = response.body();
                Toast.makeText(EditarPerfilActivity.this, dr.getMessage(), Toast.LENGTH_SHORT).show();
                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_STATUS_LOGIN, false);
                startActivity(new Intent(EditarPerfilActivity.this, LoginActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                clickBotaoHomeUfape();
                finish();
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });

    }
    private void irHome(){
        startActivity(new Intent(EditarPerfilActivity.this, HomeAlunoActivity.class));

    }
    private void clickBotaoHomeUfape(){

        startActivity(new Intent(this, MainActivityUfape.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }

    public void clickBotaoHomeUfape(View view){

        startActivity(new Intent(this, MainActivityUfape.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }

    public void irTelaInformacoesDiscente(View view){
        Intent irTelaInformacoesDiscente = new Intent(getApplicationContext(), InformacoesDiscenteActivity.class);
        startActivity(irTelaInformacoesDiscente);
    }
}
