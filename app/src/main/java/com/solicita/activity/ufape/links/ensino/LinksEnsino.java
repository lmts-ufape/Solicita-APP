package com.solicita.activity.ufape.links.ensino;

import android.content.Context;

import com.solicita.activity.ufape.links.Links;

public class LinksEnsino {

    private static LinksEnsino linksInstitucional;
    public static LinksEnsino getLinksInstitucional(){
        if(linksInstitucional == null)
            linksInstitucional = new LinksEnsino();
        return linksInstitucional;
    }

    private Links links = new Links();

    public void abrirLinkCursosGraduacao(Context context){
        links.abrirLink("http://ufape.edu.br/br/graduacao", context);
    }

    public void abrirLinkCursosEspecializacao(Context context){
        links.abrirLink("http://ufape.edu.br/br/cursos-especializa%C3%A7%C3%A3o", context);
    }

    public void abrirLinkCursosMestradoDoutorado(Context context){
        links.abrirLink("http://ufape.edu.br/br/pos-graduacao", context);
    }

    public void abrirLinkProgramasProjetos(Context context){
        links.abrirLink("http://ufape.edu.br/br/programas-projetos-ensino", context);
    }

    public void abrirLinkEditais(Context context){
        links.abrirLink("http://ufape.edu.br/br/editais-ensino", context);
    }
    public void abrirLinkComissaoEnsino(Context context){
        links.abrirLink("http://ufape.edu.br/br/comiss%C3%A3o-ensino", context);
    }

    public void abrirLinkGruposEstudos(Context context){
        links.abrirLink("http://ufape.edu.br/br/grupos-estudo", context);
    }

    public void abrirLinkCalendarioAcademico(Context context){
        links.abrirLink("http://ufape.edu.br/br/calend%C3%A1rio-acad%C3%AAmico", context);
    }

}
