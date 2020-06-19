package com.solicita.activity.ufape.links.redes_sociais;

import android.content.Context;

import com.solicita.activity.ufape.links.Links;

public class LinksRedesSociais {

    private static LinksRedesSociais linksInstitucional;
    public static LinksRedesSociais getLinksInstitucional(){
        if(linksInstitucional == null)
            linksInstitucional = new LinksRedesSociais();
        return linksInstitucional;
    }

    private Links links = new Links();

    public void abrirLinkFacebook(Context context){
        links.abrirLink("https://www.facebook.com/ufape.comunica", context);
    }

    public void abrirLinkYoutube(Context context){
        links.abrirLink("https://www.youtube.com/channel/UCPGY8eKRMvAqiGaPoQqfOIw", context);
    }

    public void abrirLinkLinkedin(Context context){
        links.abrirLink("https://www.linkedin.com/company/ufape", context);
    }

    public void abrirLinkInstagram(Context context){
        links.abrirLink("https://www.instagram.com/ufape.oficial/", context);
    }

    public void abrirLinkTwitter(Context context){
        links.abrirLink("https://twitter.com/UFAPE_oficial/", context);
    }
}
