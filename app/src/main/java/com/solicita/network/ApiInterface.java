package com.solicita.network;

import com.solicita.model.User;
import com.solicita.network.response.PerfilResponse;
import com.solicita.network.response.SolicitacaoResponse;
import com.solicita.network.response.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    //@POST("api/auth/login")
    @POST("api/login")
    Call<UserResponse> postLogin(@Field("email") String email,
                                 @Field("password") String password);
    @FormUrlEncoded
    @POST("api/cadastrar")
    Call<UserResponse> postCadastro(@Field("name") String name, @Field("cpf") String cpf, @Field("vinculo") String vinculo, @Field("unidade") String unidade, @Field("cursos") String cursos, @Field("email") String email, @Field("password") String password);

    @GET("api/auth/me")
    Call<User> getUser(@Header("Authorization") String token);

    @POST("api/auth/refresh")
    Call<UserResponse> refreshToken(@Header("Authorization") String token);

    @GET("api/cursos")
    Call<String> getCursoJSONString();

    @GET("api/unidades")
    Call<String> getUnidadeJSONString();

    @GET("api/documentos/")
    Call<String> getDocumentoJSONString();

    @GET("api/requisicaos/preparaNovaRequisicao")
    Call<String> getUserPerfil(@Header("Authorization") String token);

    @FormUrlEncoded
    @POST("api/requisicaos/novaRequisicao")
    Call<SolicitacaoResponse> postSolicitacao(@Field("default") int defaultt, @Field("declaracaoVinculo") String declaracaoVinculo, @Field("comprovanteMatricula") String comprovanteMatricula, @Field("historico") String historico, @Field("programaDisciplina") String programaDisciplina, @Field("outros") String outros, @Field("requisicaoPrograma") String requisicaoPrograma, @Field("requisicaoOutros") String requisicaoOutros, @Header("Authorization") String token);

    @GET("api/requisicaos/listarRequisicoes")
    Call<String> getRequisicoesJSONString(@Header("Authorization") String token);

    @POST("api/perfils")
    Call<String> getPerfilInfoJSONString(@Header("Authorization") String token);

    @POST("api/perfils/editarInfo")
    Call<UserResponse> getEdit(@Header("Authorization") String token);

    @FormUrlEncoded
    @POST("api/perfils/storeEditarInfo")
    Call<UserResponse> postEdit(@Field("name") String name, @Field("email") String email, @Header("Authorization") String token);

    @FormUrlEncoded
    @POST("api/perfils/storeAlterarSenha")
    Call<UserResponse> postEditSenha(@Field("atual") String atual, @Field("password") String password, @Field("password_confirmation") String password_confirmation, @Header("Authorization") String token);
}
