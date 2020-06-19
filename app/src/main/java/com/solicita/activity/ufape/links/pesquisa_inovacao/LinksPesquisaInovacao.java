package com.solicita.activity.ufape.links.pesquisa_inovacao;

import android.content.Context;

import com.solicita.activity.ufape.links.Links;

public class LinksPesquisaInovacao {

    private static LinksPesquisaInovacao linksInstitucional;
    public static LinksPesquisaInovacao getLinksInstitucional(){
        if(linksInstitucional == null)
            linksInstitucional = new LinksPesquisaInovacao();
        return linksInstitucional;
    }

    private Links links = new Links();

    public void abrirLinkProgramasProjetos(Context context){
        links.abrirLink("http://ufape.edu.br/br/programas-projetos-pesquisa", context);
    }

    public void abrirLinkEditais(Context context){
        links.abrirLink("http://ufape.edu.br/br/editais-pesquisa", context);
    }

    public void abrirLinkComissaoPesquisa(Context context){
        links.abrirLink("http://ufape.edu.br/br/comiss%C3%A3o-pesquisa", context);
    }

    public void abrirLinkComitePibic(Context context){
        links.abrirLink("http://ufape.edu.br/br/comit%C3%AA-pibic", context);
    }

    public void abrirLinkGruposPesquisa(Context context){
        links.abrirLink("http://ufape.edu.br/br/grupos-pesquisa", context);
    }

}
