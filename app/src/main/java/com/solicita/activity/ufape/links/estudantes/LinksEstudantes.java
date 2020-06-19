package com.solicita.activity.ufape.links.estudantes;

import android.content.Context;

import com.solicita.activity.ufape.links.Links;

public class LinksEstudantes {

    private static LinksEstudantes linksInstitucional;
    public static LinksEstudantes getLinksInstitucional(){
        if(linksInstitucional == null)
            linksInstitucional = new LinksEstudantes();
        return linksInstitucional;
    }

    private Links links = new Links();

    public void abrirLinkFormasIngresso(Context context){
        links.abrirLink("http://ufape.edu.br/br/formas-ingresso", context);
    }

    public void abrirLinkAssistenciaEstudantil(Context context){
        links.abrirLink("http://ufape.edu.br/br/assist%C3%AAncia-estudantil", context);
    }

    public void abrirLinkEditais(Context context){
        links.abrirLink("http://ufape.edu.br/br/editais-estudantes", context);
    }

    public void abrirLinkEscolaridade(Context context){
        links.abrirLink("http://ufape.edu.br/br/escolaridade", context);
    }

    public void abrirLinkEstagios(Context context){
        links.abrirLink("http://ufape.edu.br/br/est%C3%A1gios", context);
    }

    public void abrirLinkHorarioLetivo(Context context){
        links.abrirLink("http://ufape.edu.br/br/hor%C3%A1rio-letivo", context);
    }

    public void abrirLinkEgressos(Context context){
        links.abrirLink("http://ufape.edu.br/br/egressos", context);
    }
}
