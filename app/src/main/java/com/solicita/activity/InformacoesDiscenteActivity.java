package com.solicita.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.solicita.R;
import com.solicita.activity.ufape.MainActivityUfape;
import com.solicita.helper.SharedPrefManager;
import com.solicita.model.Aluno;
import com.solicita.model.Perfil;
import com.solicita.model.Unidade;
import com.solicita.model.User;
import com.solicita.network.ApiClient;
import com.solicita.network.ApiInterface;
import com.solicita.network.response.DefaultResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InformacoesDiscenteActivity extends AppCompatActivity {

    public TextView textInfoNome, textInfoCPF, textInfoVinculo, textInfoUnidadeAcademica, textInfoCurso, textInfoEmail, textNomeUsuario;

    private Button buttonAlterarPerfil;
    private ApiInterface apiInterface;
    private SharedPrefManager sharedPrefManager;
    private Context context;

    private ArrayList<Perfil> listarPerfilArrayList;
    private ArrayList<Unidade> listarUnidadesArrayList;
    private ArrayList<Aluno> listarAlunoArrayList;
    private ArrayList<User> listarUserArrayList;

    private LinearLayout linearLayout;
    private RadioGroup radioGroup;

    private ArrayList<Perfil> perfilArrayList;
    private ArrayList<String> perfil = new ArrayList<>();

    private Button buttonExcluirPerfil, buttonLogout, buttonHome;

    private String idPerfil = "";
    private String idPerfilDefault = "";

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes_discente);

        sharedPrefManager = new SharedPrefManager(this);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        context = this;

        inicializarComponentes();

        textNomeUsuario.setText(sharedPrefManager.getSPNome());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Carregando...");
        progressDialog.setCancelable(false);

        buscarPerfisJSON();
        buscarInfoJSON();

        buttonHome.setOnClickListener(v -> irHome());

        buttonLogout.setOnClickListener(v -> logoutApp());

        buttonExcluirPerfil.setOnClickListener(v -> excluirPerfil());

         buttonAlterarPerfil.setOnClickListener(v -> alterarPerfilDefault());

    }

    private void radioGroupJSON(String response) {
        try {
            JSONObject object = new JSONObject(response);
            perfilArrayList = new ArrayList<>();
            JSONArray jsonArray = object.getJSONArray("perfil");


            for (int i = 0; i < jsonArray.length(); i++) {
                Perfil perfil = new Perfil();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                perfil.setCurso(jsonObject.getString("default"));
                perfil.setSituacao(jsonObject.getString("situacao"));
                perfil.setId(jsonObject.getString("id"));

                perfilArrayList.add(perfil);
            }
            for (int i = 0; i < perfilArrayList.size(); i++) {
                perfil.add(perfilArrayList.get(i).getCurso() + " - " + perfilArrayList.get(i).getSituacao());
            }

            radioGroup = new RadioGroup(this);
            radioGroup.setOrientation(RadioGroup.VERTICAL);


            for (int i = 0; i < perfil.size(); i++) {
                RadioGroup.LayoutParams rl2;
                RadioButton radioButton = new RadioButton(this);
                radioButton.setText(perfil.get(i));

                rl2 = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.MATCH_PARENT);
                radioGroup.addView(radioButton, rl2);
            }
            linearLayout.addView(radioGroup);

            radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(getApplicationContext(), radioButton.getText(), Toast.LENGTH_LONG).show();

                for (int i = 0; i < perfilArrayList.size(); i++) {
                    if (radioButton.getText().equals(perfilArrayList.get(i).getCurso() + " - " + perfilArrayList.get(i).getSituacao())) {
                        System.out.println("Valor do ID: " + perfilArrayList.get(i).getId() + " Índice: " + i);
                        idPerfil = perfilArrayList.get(i).getId();
                    }
                }
                for (int j = 0; j < perfilArrayList.size(); j++) {
                    if (radioButton.getText().equals(perfilArrayList.get(j).getCurso() + " - " + perfilArrayList.get(j).getSituacao())) {
                        System.out.println("Valor do ID: " + perfilArrayList.get(j).getId());
                             idPerfilDefault=perfilArrayList.get(j).getId();
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void buscarPerfisJSON() {

        Call<String> stringCall = apiInterface.getUserPerfil(sharedPrefManager.getSPToken());
        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.code() == 200) {
                    String jsonResponse = response.body();
                    radioGroupJSON(jsonResponse);

                } else {

                    Toast.makeText(getApplicationContext(), "Falha na comunicação com o servidor.", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(InformacoesDiscenteActivity.this, LoginActivity.class));

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }

    private void buscarInfoJSON() {

        Call<String> perfilCall = apiInterface.getPerfilInfoJSONString(sharedPrefManager.getSPToken());
        perfilCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.code() == 200) {

                    String jsonResponse = response.body();
                    buscarInfo(jsonResponse);

                } else {

                    Toast.makeText(getApplicationContext(), "Falha na comunicação com o servidor.", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(InformacoesDiscenteActivity.this, LoginActivity.class));

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    private void buscarInfo(String response) {

        progressDialog.show();
        try {
            JSONObject object = new JSONObject(response);

            listarPerfilArrayList = new ArrayList<>();
            listarUnidadesArrayList = new ArrayList<>();
            listarAlunoArrayList = new ArrayList<>();
            listarUserArrayList = new ArrayList<>();

            JSONArray jsonArrayPerfil = object.getJSONArray("perfil");
            JSONArray jsonArrayUnidades = object.getJSONArray("unidades");
            JSONArray jsonArrayAluno = object.getJSONArray("aluno");
            JSONArray jsonArrayUser = object.getJSONArray("user");

            for (int i = 0; i < jsonArrayPerfil.length(); i++) {
                Perfil perfil = new Perfil();
                JSONObject jsonObject = jsonArrayPerfil.getJSONObject(i);
                perfil.setUnidade_id(jsonObject.getString("unidade_id"));
                perfil.setCurso(jsonObject.getString("default"));
                perfil.setSituacao(jsonObject.getString("situacao"));

                listarPerfilArrayList.add(perfil);

            }
            for (int i = 0; i < jsonArrayUnidades.length(); i++) {
                Unidade unidade = new Unidade();
                JSONObject jsonObject = jsonArrayUnidades.getJSONObject(i);
                unidade.setNome(jsonObject.getString("nome"));
                unidade.setInstituicao_id(jsonObject.getString("instituicao_id"));

                listarUnidadesArrayList.add(unidade);
            }

            for (int i = 0; i < jsonArrayAluno.length(); i++) {
                Aluno aluno = new Aluno();
                JSONObject jsonObject = jsonArrayAluno.getJSONObject(i);
                aluno.setCpf(jsonObject.getString("cpf"));

                listarAlunoArrayList.add(aluno);
            }
            for (int i = 0; i < jsonArrayUser.length(); i++) {
                User user = new User();
                JSONObject jsonObject = jsonArrayUser.getJSONObject(i);
                user.setName(jsonObject.getString("name"));
                user.setEmail(jsonObject.getString("email"));

                listarUserArrayList.add(user);

            }

            for (int i = 0; i < jsonArrayPerfil.length(); i++) {
                for (int j = 0; j < jsonArrayUnidades.length(); j++) {
                    for (int k = 0; k < jsonArrayAluno.length(); k++) {
                        for (int l = 0; l < jsonArrayUser.length(); l++) {
                            if (listarPerfilArrayList.get(i).getUnidade_id().equals(listarUnidadesArrayList.get(j).getInstituicao_id())) {
                                textInfoUnidadeAcademica.setText(listarUnidadesArrayList.get(j).getNome());
                                textInfoCurso.setText(listarPerfilArrayList.get(i).getCurso());
                                textInfoVinculo.setText(listarPerfilArrayList.get(i).getSituacao());
                                textInfoCPF.setText(listarAlunoArrayList.get(k).getCpf());
                                textInfoNome.setText(listarUserArrayList.get(l).getName());
                                textInfoEmail.setText(listarUserArrayList.get(l).getEmail());
                            }
                        }
                    }
                }
            }progressDialog.dismiss();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void inicializarComponentes() {

        textInfoNome = findViewById(R.id.textProtNome);
        textInfoCPF = findViewById(R.id.textInfoCPF);
        textInfoVinculo = findViewById(R.id.textProtVinculo);
        textInfoUnidadeAcademica = findViewById(R.id.textInfoUnidadeAcademica);
        textInfoCurso = findViewById(R.id.textCursoAdap);
        textInfoEmail = findViewById(R.id.textInfoEmail);
        linearLayout = findViewById(R.id.linearLayout);
        buttonExcluirPerfil = findViewById(R.id.buttonExcluirPerfil);
        buttonLogout = findViewById(R.id.buttonLogout);
        buttonHome = findViewById(R.id.buttonHome);
        textNomeUsuario = findViewById(R.id.textNomeUsuario);
        buttonAlterarPerfil = findViewById(R.id.buttonAlterarPerfil);
    }

    private void logoutApp() {

        Call<DefaultResponse> responseCall = apiInterface.postLogout(sharedPrefManager.getSPToken());

        responseCall.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                DefaultResponse dr = response.body();
                Toast.makeText(InformacoesDiscenteActivity.this, dr.getMessage(), Toast.LENGTH_SHORT).show();
                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_STATUS_LOGIN, false);
                startActivity(new Intent(InformacoesDiscenteActivity.this, LoginActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                clickBotaoHomeUfape();
                finish();
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });

    }

    private void irHome() {
        startActivity(new Intent(InformacoesDiscenteActivity.this, HomeAlunoActivity.class));

    }

    public void irTelaEditarPerfil(View view) {
        Intent irTelaEditarPerfil = new Intent(getApplicationContext(), EditarPerfilActivity.class);
        startActivity(irTelaEditarPerfil);
    }

    public void irTelaAlterarSenha(View view) {
        Intent irTelaAlterarSenha = new Intent(getApplicationContext(), AlterarSenhaActivity.class);
        startActivity(irTelaAlterarSenha);
    }

    public void irTelaAdicionarPerfil(View view) {
        Intent irTelaAdicionarPerfil = new Intent(getApplicationContext(), AdicionarPerfilActivity.class);
        startActivity(irTelaAdicionarPerfil);
    }

    private void excluirPerfil() {

        if (idPerfil.equals("")) {
            Toast.makeText(getApplicationContext(), "Selecione um perfil.", Toast.LENGTH_LONG).show();
        } else {

            AlertDialog dialogExluirPerfil = new AlertDialog.Builder(InformacoesDiscenteActivity.this).create();
            View mView = getLayoutInflater().inflate(R.layout.dialog_confirmacao, null);

            TextView tvTitulo = mView.findViewById(R.id.tvTitulo);
            TextView tvMensagem = mView.findViewById(R.id.tvMensagem);
            Button buttonConfirmar = mView.findViewById(R.id.buttonConfirmar);
            Button buttonCancelar = mView.findViewById(R.id.buttonCancelar);

            tvTitulo.setText(R.string.titulo_exclusao_perfil);
            tvMensagem.setText(R.string.mensagem_exclusao_perfil);

            dialogExluirPerfil.setView(mView);

            buttonCancelar.setOnClickListener(v -> dialogExluirPerfil.dismiss());

            buttonConfirmar.setOnClickListener(v -> {
                Call<DefaultResponse> callExcluir = apiInterface.postExcluirPerfil(idPerfil, sharedPrefManager.getSPToken());
                callExcluir.enqueue(new Callback<DefaultResponse>() {
                    @Override
                    public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                        DefaultResponse dr = response.body();
                        if (response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), dr.getMessage(), Toast.LENGTH_LONG).show();
                            if (response.code() == 201) {
                                Toast.makeText(getApplicationContext(), dr.getMessage(), Toast.LENGTH_LONG).show();
                                startActivity(new Intent(InformacoesDiscenteActivity.this, InformacoesDiscenteActivity.class));
                            }else{
                                System.out.println("Else 201");
                            }
                        }else {

                            Toast.makeText(getApplicationContext(), "Falha na comunicação com o servidor.", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(InformacoesDiscenteActivity.this, LoginActivity.class));

                        }
                    }

                    @Override
                    public void onFailure(Call<DefaultResponse> call, Throwable t) {
                    }
                });
            });
            dialogExluirPerfil.show();

        }
    }
    private void alterarPerfilDefault() {

        if (idPerfilDefault.equals("")) {
            Toast.makeText(getApplicationContext(), "Selecione um perfil.", Toast.LENGTH_LONG).show();
        } else {

            AlertDialog dialogAlterarPerfil = new AlertDialog.Builder(InformacoesDiscenteActivity.this).create();

            View mView2 = getLayoutInflater().inflate(R.layout.dialog_confirmacao, null);

            TextView tvTitulo = mView2.findViewById(R.id.tvTitulo);
            TextView tvMensagem = mView2.findViewById(R.id.tvMensagem);
            Button buttonConfirmar = mView2.findViewById(R.id.buttonConfirmar);
            Button buttonCancelar = mView2.findViewById(R.id.buttonCancelar);

            tvTitulo.setText(R.string.titulo_alteracao_perfil);
            tvMensagem.setText(R.string.mensagem_alteracao_perfil);

            dialogAlterarPerfil.setView(mView2);

            buttonCancelar.setOnClickListener(v -> dialogAlterarPerfil.dismiss());

            buttonConfirmar.setOnClickListener(v -> {

                Call<DefaultResponse> callAlterar = apiInterface.postAlterarPerfil(idPerfilDefault, sharedPrefManager.getSPToken());
                callAlterar.enqueue(new Callback<DefaultResponse>() {
                    @Override
                    public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                        if (response.code() == 200) {

                            DefaultResponse dr = response.body();
                            Toast.makeText(getApplicationContext(), dr.getMessage(), Toast.LENGTH_LONG).show();
                            startActivity(new Intent(InformacoesDiscenteActivity.this, InformacoesDiscenteActivity.class));

                        } else {

                            Toast.makeText(getApplicationContext(), "Falha na comunicação com o servidor.", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(InformacoesDiscenteActivity.this, LoginActivity.class));

                        }
                    }
                    @Override
                    public void onFailure(Call<DefaultResponse> call, Throwable t) {

                    }
                });
            });
            dialogAlterarPerfil.show();
        }
    }

    private void clickBotaoHomeUfape(){

        startActivity(new Intent(this, MainActivityUfape.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }

    public void clickBotaoHomeUfape(View view){

        startActivity(new Intent(this, MainActivityUfape.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}