package com.solicita.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.solicita.activity.ufape.MainActivityUfape;
import com.solicita.adapter.AdapterDocumentos;
import com.solicita.helper.RecyclerItemClickListener;
import com.solicita.helper.SharedPrefManager;
import com.solicita.model.Solicitacoes;
import com.solicita.network.ApiClient;
import com.solicita.network.ApiInterface;
import com.solicita.network.response.DefaultResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.solicita.R.id;
import static com.solicita.R.layout;
import static com.solicita.R.string.message_exclusao_requisicao;
import static com.solicita.R.string.titulo_exclusao_requisicao;

public class ListarDocumentosSolicitadosActivity extends AppCompatActivity {

    public RecyclerView recyclerRequisicoes;
    public List<Solicitacoes> listaSolicitacoes = new ArrayList<>();
    public AdapterDocumentos adapterDocumentos;
    SharedPrefManager sharedPrefManager;
    ApiInterface apiInterface;
    Context context;
    TextView textNomeUsuario;

    Button buttonLogout, buttonHome, buttonVoltar;

    ArrayList<Solicitacoes> listarRequisicoesArrayList;
    ArrayList<Solicitacoes> listarSolicitadosArrayList;
    ArrayList<Solicitacoes> listarPerfisArrayList;
    ArrayList<Solicitacoes> listarDocumentosArrayList;
    ArrayList<Solicitacoes> listarCursosArrayList;

    ArrayList<String> listarId = new ArrayList<>();
    ArrayList<String> listarData = new ArrayList<>();
    ArrayList<String> listarHora = new ArrayList<>();

    ArrayList<String> listarStatus = new ArrayList<>();
    ArrayList<String> listarDocumentoId = new ArrayList<>();
    ArrayList<String> listarPerfilId = new ArrayList<>();
    ArrayList<String> listarRequisicaoId = new ArrayList<>();
    ArrayList<String> listarDetalhes = new ArrayList<>();

    ArrayList<String> listarCursoPerfil = new ArrayList<>();
    ArrayList<String> listarIdPerfil = new ArrayList<>();
    ArrayList<String> listarCursoId = new ArrayList<>();

    ArrayList<String> listarDocumentos = new ArrayList<>();
    ArrayList<String> listarIdDocumentos = new ArrayList<>();

    ArrayList<String> listarCursos = new ArrayList<>();
    ArrayList<String> listarCursosAbrev = new ArrayList<>();
    ArrayList<String> listarIdCursos = new ArrayList<>();

    ArrayList listaDocs = null;
    ArrayList listaStatus = null;
    ArrayList listaDetalhes = null;

    ArrayList listaElementosDoc = null;
    ArrayList listaElementosStatus = null;
    ArrayList listaElementosDet = null;

    ProgressDialog progressDialog;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_listar_documetos_solicitados);

        sharedPrefManager = new SharedPrefManager(this);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        context = this;
        inicializarComponentes();

        textNomeUsuario.setText(sharedPrefManager.getSPNome());

        buttonHome.setOnClickListener(v -> irHome());

        buttonLogout.setOnClickListener(v -> logoutApp());

        buttonVoltar.setOnClickListener(v -> irHome());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Carregando...");
        progressDialog.setCancelable(false);

        this.buscarJSON();

    }

    public void configurarRecycler() {

        recyclerRequisicoes.setLayoutManager(new LinearLayoutManager(this));
        recyclerRequisicoes.setHasFixedSize(true);
        adapterDocumentos = new AdapterDocumentos(listaSolicitacoes, this);
        recyclerRequisicoes.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerRequisicoes.setAdapter(adapterDocumentos);

        recyclerRequisicoes.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerRequisicoes, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Solicitacoes solicitacoes = listaSolicitacoes.get(position);

                AlertDialog alertDialog = new AlertDialog.Builder(ListarDocumentosSolicitadosActivity.this).create();

                View mView = getLayoutInflater().inflate(layout.dialog_info_solicitacoes, null);

                TextView tvID =  mView.findViewById(id.tvID);
                TextView tvCurso =  mView.findViewById(id.tvCurso);
                TextView tvData =  mView.findViewById(id.tvData);
                TextView tvDocumentos =  mView.findViewById(id.tvDocumentos);
                TextView tvStatus =  mView.findViewById(id.tvStatus);
                TextView tvDetalhes =  mView.findViewById(id.tvDetalhes);
                TextView textViewDetalhes =  mView.findViewById(id.textViewDetalhes);
                Button buttonOk = mView.findViewById(id.buttonOk);
                Button buttonExcluir = mView.findViewById(id.buttonExcluir);

                tvID.setText(solicitacoes.getId());
                tvCurso.setText(solicitacoes.getCurso());
                String dataSolic = solicitacoes.getData_pedido() + ", " + solicitacoes.getHora_pedido();
                tvData.setText(dataSolic);
                tvDocumentos.setText(solicitacoes.getArrayDocumentos().toString().replace("[", "").replace("]", ""));
                tvStatus.setText(solicitacoes.getArrayStatus().toString().replace("[", "").replace("]", ""));
                if (solicitacoes.getArrayDetalhes().size()==0){
                    tvDetalhes.setVisibility(View.GONE);
                    textViewDetalhes.setVisibility(View.GONE);
                }else{
                    tvDetalhes.setText(solicitacoes.getArrayDetalhes().toString().replace("[","").replace("]", ""));
                }

                buttonOk.setOnClickListener(v -> alertDialog.dismiss());

                buttonExcluir.setOnClickListener(v -> {

                    AlertDialog dialogExluirPerfil = new AlertDialog.Builder(ListarDocumentosSolicitadosActivity.this).create();

                    View mView2 = getLayoutInflater().inflate(layout.dialog_confirmacao, null);

                    TextView tvTitulo = mView2.findViewById(id.tvTitulo);
                    TextView tvMensagem = mView2.findViewById(id.tvMensagem);
                    Button buttonConfirmar = mView2.findViewById(id.buttonConfirmar);
                    Button buttonCancelar = mView2.findViewById(id.buttonCancelar);

                    tvTitulo.setText(titulo_exclusao_requisicao);
                    tvMensagem.setText(message_exclusao_requisicao);

                    dialogExluirPerfil.setView(mView2);

                    buttonCancelar.setOnClickListener(v1 -> {
                        alertDialog.dismiss();
                        dialogExluirPerfil.dismiss();
                    });

                    buttonConfirmar.setOnClickListener(v12 -> {
                        String idRequisicao = solicitacoes.getId();
                        System.out.println("Valor do ID: "+ idRequisicao);

                        Call<DefaultResponse> defaultResponseCall = apiInterface.postExcluirRequisicao(idRequisicao, sharedPrefManager.getSPToken());
                        defaultResponseCall.enqueue(new Callback<DefaultResponse>() {
                            @Override
                            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                                DefaultResponse dr = response.body();
                                if (response.code()==201){
                                    Toast.makeText(context.getApplicationContext(), dr.getMessage(), Toast.LENGTH_LONG).show();
                                    alertDialog.dismiss();
                                    dialogExluirPerfil.dismiss();
                                    adapterDocumentos.removerItem(position);

                                }else{
                                    alertDialog.dismiss();
                                    dialogExluirPerfil.dismiss();
                                    Toast.makeText(context.getApplicationContext(), dr.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<DefaultResponse> call, Throwable t) {

                            }
                        });
                    });
                    dialogExluirPerfil.show();
                });

                alertDialog.setView(mView);
                alertDialog.show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                   Toast.makeText(getApplicationContext(), "Click longo", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
    }

    private void buscarJSON() {

        progressDialog.show();

        Call<String> getRequisicoesJSONString = apiInterface.getRequisicoesJSONString(sharedPrefManager.getSPToken());
        getRequisicoesJSONString.enqueue(new Callback<String>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                progressDialog.dismiss();
                if (response.code() == 200) {
                    String jsonResponse = response.body();
                    listarSolicitacoes(jsonResponse);
                    configurarRecycler();

                } else {

                    Toast.makeText(getApplicationContext(), "Falha na comunicação com o servidor.", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(ListarDocumentosSolicitadosActivity.this, LoginActivity.class));

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void listarSolicitacoes(String response) {
        try {
            JSONObject object = new JSONObject(response);
            listarRequisicoesArrayList = new ArrayList<>();
            listarSolicitadosArrayList = new ArrayList<>();

            listarPerfisArrayList = new ArrayList<>();
            listarDocumentosArrayList = new ArrayList<>();
            listarCursosArrayList = new ArrayList<>();

            JSONArray jsonArrayRequisicoes = object.getJSONArray("requisicoes");
            JSONArray jsonArraySolicitados = object.getJSONArray("solicitados");
            JSONArray jsonArrayPerfis = object.getJSONArray("perfil");
            JSONArray jsonArrayDocumentos = object.getJSONArray("documentos");
            JSONArray jsonArrayCursos = object.getJSONArray("cursos");

            for (int i = 0; i < jsonArrayRequisicoes.length(); i++) {
                Solicitacoes requisicoes = new Solicitacoes();
                JSONObject jsonObject = jsonArrayRequisicoes.getJSONObject(i);
                requisicoes.setId(jsonObject.getString("id"));
                requisicoes.setData_pedido(jsonObject.getString("data_pedido"));
                requisicoes.setHora_pedido(jsonObject.getString("hora_pedido"));
                requisicoes.setPerfilId(jsonObject.getString("perfil_id"));

                listarRequisicoesArrayList.add(requisicoes);
            }
            for (int i = 0; i < listarRequisicoesArrayList.size(); i++) {
                listarId.add(listarRequisicoesArrayList.get(i).getId());
                listarData.add(listarRequisicoesArrayList.get(i).getData_pedido());
                listarHora.add(listarRequisicoesArrayList.get(i).getHora_pedido());
                listarPerfilId.add(listarRequisicoesArrayList.get(i).getPerfilId());
            }
            System.out.println("ID: " + listarId + " Data: " + listarData + " Hora: " + listarHora + " ID Perfil: " + listarPerfilId);

            for (int i = 0; i < jsonArraySolicitados.length(); i++) {
                Solicitacoes solicitados = new Solicitacoes();
                JSONObject jsonObject = jsonArraySolicitados.getJSONObject(i);
                solicitados.setStatus(jsonObject.getString("status"));
                solicitados.setDocumentoId(jsonObject.getString("documento_id"));
                solicitados.setRequisicaoId(jsonObject.getString("requisicao_id"));
                solicitados.setDetalhes(jsonObject.getString("detalhes"));

                listarSolicitadosArrayList.add(solicitados);
            }
            for (int i = 0; i < listarSolicitadosArrayList.size(); i++) {
                listarStatus.add(listarSolicitadosArrayList.get(i).getStatus());
                listarDocumentoId.add(listarSolicitadosArrayList.get(i).getDocumentoId());
                listarRequisicaoId.add(listarSolicitadosArrayList.get(i).getRequisicaoId());
                listarDetalhes.add(listarSolicitadosArrayList.get(i).getDetalhes());
            }
            System.out.println("Status: " + listarStatus + " ID Documento: " + listarDocumentoId + " ID Requisicao: " + listarRequisicaoId
                    + " Detalhes: " + listarDetalhes);

            for (int i = 0; i < jsonArrayPerfis.length(); i++) {
                Solicitacoes perfis = new Solicitacoes();
                JSONObject jsonObject = jsonArrayPerfis.getJSONObject(i);
                perfis.setCurso(jsonObject.getString("default"));
                perfis.setIdPerfil(jsonObject.getString("id"));
                perfis.setCursoId(jsonObject.getString("curso_id"));

                listarPerfisArrayList.add(perfis);
            }

            for (int i = 0; i < listarPerfisArrayList.size(); i++) {
                listarCursoPerfil.add(listarPerfisArrayList.get(i).getCurso());
                listarIdPerfil.add(listarPerfisArrayList.get(i).getIdPerfil());
                listarCursoId.add(listarPerfisArrayList.get(i).getCursoId());
            }
            System.out.println("ID: " + listarIdPerfil + " Curso: " + listarCursoPerfil + " Curso ID: " + listarCursoId);

            for (int i = 0; i < jsonArrayDocumentos.length(); i++) {
                Solicitacoes documentos = new Solicitacoes();
                JSONObject jsonObject = jsonArrayDocumentos.getJSONObject(i);
                documentos.setDocumento(jsonObject.getString("tipo"));
                documentos.setIdDocumento(jsonObject.getString("id"));

                listarDocumentosArrayList.add(documentos);

            }
            for (int i = 0; i < listarDocumentosArrayList.size(); i++) {
                listarDocumentos.add(listarDocumentosArrayList.get(i).getDocumento());
                listarIdDocumentos.add(listarDocumentosArrayList.get(i).getIdDocumento());
            }
            System.out.println("ID: " + listarIdDocumentos + " Documentos: " + listarDocumentos);

            for (int i = 0; i < jsonArrayCursos.length(); i++) {
                Solicitacoes cursos = new Solicitacoes();
                JSONObject jsonObject = jsonArrayCursos.getJSONObject(i);
                cursos.setIdCurso(jsonObject.getString("id"));
                cursos.setCurso(jsonObject.getString("nome"));
                cursos.setAbreviatura(jsonObject.getString("abreviatura"));

                listarCursosArrayList.add(cursos);
            }

            for (int i = 0; i < listarCursosArrayList.size(); i++) {
                listarCursos.add(listarCursosArrayList.get(i).getCurso());
                listarCursosAbrev.add(listarCursosArrayList.get(i).getAbreviatura());
                listarIdCursos.add(listarCursosArrayList.get(i).getIdCurso());
            }

            System.out.println("ID: " + listarIdCursos + " Curso: " + listarCursos + " Abreviatura " + listarCursosAbrev);

            for (int i = 0; i < jsonArrayRequisicoes.length(); i++) {
                for (int j = 0; j < jsonArrayPerfis.length(); j++) {
                    for (int k = 0; k < jsonArrayCursos.length(); k++) {

                        if (listarRequisicoesArrayList.get(i).getPerfilId().equals(listarPerfisArrayList.get(j).getIdPerfil())) {
                            if (listarPerfisArrayList.get(j).getCursoId().equals(listarCursosArrayList.get(k).getIdCurso())) {
                                listaDocs = new ArrayList<>();
                                listaStatus = new ArrayList();
                                listaDetalhes = new ArrayList();
                                for (int l = 0; l < jsonArraySolicitados.length(); l++) {
                                    for (int m = 0; m < jsonArrayDocumentos.length(); m++) {
                                        if (listarRequisicoesArrayList.get(i).getId().equals(listarSolicitadosArrayList.get(l).getRequisicaoId())) {
                                            if (listarSolicitadosArrayList.get(l).getDocumentoId().equals(listarDocumentosArrayList.get(m).getIdDocumento())) {
                                                listaDocs.add(listarDocumentosArrayList.get(m).getDocumento());
                                                listaStatus.add(listarSolicitadosArrayList.get(l).getStatus());
                                                listaDetalhes.add(listarSolicitadosArrayList.get(l).getDetalhes());
                                            }
                                        }
                                    }
                                }
                                listaElementosDoc = new ArrayList<>();
                                listaElementosStatus = new ArrayList<>();
                                listaElementosDet = new ArrayList<>();
                                for (int a=0;a<listaDocs.size(); a++){
                                    String elementosDoc = (a+1) + ". " + listaDocs.get(a).toString();
                                    String elementosStat = (a+1) + ". " + listaStatus.get(a).toString();
                                    if (!listaDetalhes.get(a).equals("")){
                                        String elementosDet = (a+1) + ". " + listaDetalhes.get(a).toString();
                                        listaElementosDet.add(elementosDet);
                                    }
                                    listaElementosDoc.add(elementosDoc);
                                    listaElementosStatus.add(elementosStat);
                                    System.out.println(listaElementosDet);

                                }
                                System.out.println(listaElementosDoc);
                                System.out.println(listaElementosStatus);
                                String convertDocs = listaElementosDoc.toString().replace("[", "").replace("]", "").replace(",", "\n");
                                String convertStatus = listaElementosStatus.toString().replace("[", " ").replace("]", "").replace(",", "\n");
                                String convertDetalhes = listaDetalhes.toString().replace("[", "").replace("]", "").replace(",", "\n");
                                String data = listarRequisicoesArrayList.get(i).getData_pedido();
                                SimpleDateFormat conversaoData = new SimpleDateFormat("yyyy-MM-dd");
                                Date date = conversaoData.parse(data);
                                conversaoData.applyPattern("dd/MM/yyyy");
                                String novaData = (conversaoData.format(date));

                                Solicitacoes solicitacoes = new Solicitacoes(listarRequisicoesArrayList.get(i).getId(), listarCursosArrayList.get(k).getCurso(),
                                        listarCursosArrayList.get(k).getAbreviatura(), novaData, listarRequisicoesArrayList.get(i).getHora_pedido(), convertDocs,
                                        convertDetalhes, convertStatus, listaElementosDoc, listaElementosStatus, listaElementosDet);
                                listaSolicitacoes.add(solicitacoes);
                            }
                        }
                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void logoutApp() {

        Call<DefaultResponse> responseCall = apiInterface.postLogout(sharedPrefManager.getSPToken());

        responseCall.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                DefaultResponse dr = response.body();
                Toast.makeText(ListarDocumentosSolicitadosActivity.this, dr.getMessage(), Toast.LENGTH_SHORT).show();
                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_STATUS_LOGIN, false);
                startActivity(new Intent(ListarDocumentosSolicitadosActivity.this, LoginActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                clickBotaoHomeUfape();
                finish();
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });

    }

    public void irHome() {
        startActivity(new Intent(ListarDocumentosSolicitadosActivity.this, HomeAlunoActivity.class));

    }
    public void clickBotaoHomeUfape(){

        startActivity(new Intent(this, MainActivityUfape.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }

    public void clickBotaoHomeUfape(View view){

        startActivity(new Intent(this, MainActivityUfape.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }

    public void inicializarComponentes() {
        recyclerRequisicoes = findViewById(id.recyclerRequisicoes);
        buttonLogout = findViewById(id.buttonLogout);
        buttonHome = findViewById(id.buttonHome);
        textNomeUsuario = findViewById(id.textNomeUsuario);
        buttonVoltar = findViewById(id.buttonVoltar);


    }
}