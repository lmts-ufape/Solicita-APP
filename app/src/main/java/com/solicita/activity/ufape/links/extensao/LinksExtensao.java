package com.solicita.activity.ufape.links.extensao;

import android.content.Context;

import com.solicita.activity.ufape.links.Links;

public class LinksExtensao {

    private static LinksExtensao linksInstitucional;
    public static LinksExtensao getLinksInstitucional(){
        if(linksInstitucional == null)
            linksInstitucional = new LinksExtensao();
        return linksInstitucional;
    }

    private Links links = new Links();

    public void abrirLinkProgramasProjetos(Context context){
        links.abrirLink("http://ufape.edu.br/br/programas-projetos-extens%C3%A3o", context);
    }

    public void abrirLinkEditais(Context context){
        links.abrirLink("http://ufape.edu.br/br/editais-extens%C3%A3o", context);
    }

    public void abrirLinkComissaoExtensao(Context context){
        links.abrirLink("http://ufape.edu.br/br/comiss%C3%A3o-extens%C3%A3o", context);
    }

    public void abrirLinkCasaUag(Context context){
        links.abrirLink("http://ufape.edu.br/br/casa-uag", context);
    }
}
