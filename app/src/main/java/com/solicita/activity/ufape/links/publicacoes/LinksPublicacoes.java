package com.solicita.activity.ufape.links.publicacoes;

import android.content.Context;

import com.solicita.activity.ufape.links.Links;

public class LinksPublicacoes {

    private static LinksPublicacoes linksInstitucional;
    public static LinksPublicacoes getLinksInstitucional(){
        if(linksInstitucional == null)
            linksInstitucional = new LinksPublicacoes();
        return linksInstitucional;
    }

    private Links links = new Links();

    public void abrirLinkMonografiaDissertacoesTeses(Context context){
        links.abrirLink("http://ufape.edu.br/br/monografias-disserta%C3%A7%C3%B5es-teses", context);
    }

    public void abrirLinkAgendaDefesas(Context context){
        links.abrirLink("http://ufape.edu.br/br/agenda-defesas", context);
    }
}
