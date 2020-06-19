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

    public void abrirLinkRepositorioInstitucional(Context context){
        links.abrirLink("http://ufape.edu.br/br/reposit%C3%B3rio-institucional-monografia-disserta%C3%A7%C3%A3o-tese", context);
    }

    public void abrirLinkAgendaDefesas(Context context){
        links.abrirLink("http://ufape.edu.br/br/agenda-defesas", context);
    }
}
