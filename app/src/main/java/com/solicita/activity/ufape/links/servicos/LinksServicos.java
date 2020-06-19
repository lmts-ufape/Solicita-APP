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
        links.abrirLink("https://www.siga.ufrpe.br/ufrpe/index.jsp", context);
    }

    public void abrirLinkSubmeta(Context context){
        links.abrirLink("http://app.uag.ufrpe.br/submeta", context);
    }

    public void abrirLinkLMTS(Context context){
        links.abrirLink("http://lmts.uag.ufrpe.br/", context);
    }
}
