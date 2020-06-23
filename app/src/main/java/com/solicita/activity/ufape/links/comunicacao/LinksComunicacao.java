package com.solicita.activity.ufape.links.comunicacao;

import android.content.Context;

import com.solicita.activity.ufape.links.Links;

public class LinksComunicacao {

    private static LinksComunicacao linksInstitucional;
    public static LinksComunicacao getLinksInstitucional(){
        if(linksInstitucional == null)
            linksInstitucional = new LinksComunicacao();
        return linksInstitucional;
    }

    private Links links = new Links();

    public void abrirLinkDivulgueNoticia(Context context){
        links.abrirLink("http://ufape.edu.br/br/divulgue-sua-not%C3%ADcia", context);
    }

    public void abrirLinkUfapeMidia(Context context){
        links.abrirLink("http://ufape.edu.br/br/ufape-na-m%C3%ADdia", context);
    }

    public void abrirLinkLogomarca(Context context){
        links.abrirLink("http://ufape.edu.br/br/logomarca", context);
    }

    public void abrirLinkModelosDocumentos(Context context){
        links.abrirLink("http://ufape.edu.br/br/modelos-documentos", context);
    }

    public void abrirLinkNoticias(Context context){
        links.abrirLink("http://ufape.edu.br/br/noticias", context);
    }

    public void abrirLinkComunicados(Context context){
        links.abrirLink("http://ufape.edu.br/br/comunicados", context);
    }
}
