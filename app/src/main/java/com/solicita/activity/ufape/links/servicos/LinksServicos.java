package com.solicita.activity.ufape.links.servicos;

import android.content.Context;

import com.solicita.activity.ufape.links.Links;

public class LinksServicos {

    private static LinksServicos linksInstitucional;
    public static LinksServicos getLinksInstitucional(){
        if(linksInstitucional == null)
            linksInstitucional = new LinksServicos();
        return linksInstitucional;
    }

    private Links links = new Links();

    public void abrirLinkSiga(Context context){
        links.abrirLink("https://www.siga.ufrpe.br/", context);
    }

    public void abrirLinkAva(Context context){
        links.abrirLink("http://ava.ufrpe.br/", context);
    }

    public void abrirLinkSubmeta(Context context){
        links.abrirLink("http://app.uag.ufrpe.br/submeta", context);
    }

    public void abrirLinkLMTS(Context context){
        links.abrirLink("http://lmts.uag.ufrpe.br/", context);
    }

    public void abrirLinkAcessoInformacao(Context context){
        links.abrirLink("http://ufape.edu.br/br/acesso-%C3%A0-informa%C3%A7%C3%A3o", context);
    }
}
