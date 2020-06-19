package com.solicita.activity.ufape.links.institucional;

import android.content.Context;

import com.solicita.activity.ufape.links.Links;

public class LinksInstitucional {

    private static LinksInstitucional linksInstitucional;
    public static LinksInstitucional getLinksInstitucional(){
        if(linksInstitucional == null)
            linksInstitucional = new LinksInstitucional();
        return linksInstitucional;
    }

    private Links links = new Links();

    public void abrirLinkAUfape(Context context){
        links.abrirLink("http://ufape.edu.br/br/hist%C3%B3ria", context);
    }

    public void abrirLinkAReitoria(Context context){
        links.abrirLink("http://ufape.edu.br/br/reitoria", context);
    }

    public void abrirLinkEstruturaAdministrativa(Context context){
        links.abrirLink("http://ufape.edu.br/br/estrutura-administrativa", context);
    }

    public void abrirLinkConselhosSuperiores(Context context){
        links.abrirLink("http://ufape.edu.br/br/conselhos-superiores", context);
    }

    public void abrirLinkEstatuinte(Context context){
        links.abrirLink("http://ufape.edu.br/br/estatuinte", context);
    }

    public void abrirLinkDecisoesResolucoesPortarias(Context context){
        links.abrirLink("http://ufape.edu.br/br/decis%C3%B5es-resolu%C3%A7%C3%B5es-portarias", context);
    }

    public void abrirLinkComissoes(Context context){
        links.abrirLink("http://ufape.edu.br/br/comissoes", context);
    }

    public void abrirLinkBiblioteca(Context context){
        links.abrirLink("http://ufape.edu.br/br/biblioteca-ariano-suassuna", context);
    }

    public void abrirLinkHospitalVeterinario(Context context){
        links.abrirLink("http://ufape.edu.br/br/hospital-veterin%C3%A1rio-universit%C3%A1rio", context);
    }

    public void abrirLinkLaboratorios(Context context){
        links.abrirLink("http://ufape.edu.br/br/laborat%C3%B3rios", context);
    }

    public void abrirLinkCooperacaoNacionalInternacional(Context context){
        links.abrirLink("http://ufape.edu.br/br/coopera%C3%A7%C3%A3o-nacional-internacional", context);
    }

    public void abrirLinkEmancipacao(Context context){
        links.abrirLink("http://ufape.edu.br/br/dia-dia-emancipa%C3%A7%C3%A3o", context);
    }

    public void abrirLinkAcessoInformacao(Context context){
        links.abrirLink("http://ufape.edu.br/br/acesso-%C3%A0-informa%C3%A7%C3%A3o", context);
    }

    public void abrirLinkOuvidoria(Context context){
        links.abrirLink("http://ufape.edu.br/br/ouvidoria", context);
    }

    public void abrirLinkBoletinsServicos(Context context){
        links.abrirLink("http://ufape.edu.br/br/boletins-de-servicos", context);
    }

    public void abrirLinkDocumentosRelatorios(Context context){
        links.abrirLink("http://ufape.edu.br/br/relat%C3%B3rio-institucional", context);
    }
}
