package com.solicita.activity.ufape.links.concursos;

import android.content.Context;

import com.solicita.activity.ufape.links.Links;

public class LinksConcursos {

    private static LinksConcursos linksInstitucional;
    public static LinksConcursos getLinksInstitucional(){
        if(linksInstitucional == null)
            linksInstitucional = new LinksConcursos();
        return linksInstitucional;
    }

    private Links links = new Links();

    public void abrirLinkProfessorMagisterioSuperior(Context context){
        links.abrirLink("http://ufape.edu.br/br/professor-magist%C3%A9rio-superior-concurso", context);
    }

    public void abrirLinkTecnicosAdministrativos(Context context){
        links.abrirLink("http://ufape.edu.br/br/t%C3%A9cnicos-administrativos-concurso", context);
    }
}
