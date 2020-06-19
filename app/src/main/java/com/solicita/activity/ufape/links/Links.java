package com.solicita.activity.ufape.links;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class Links {

    public void abrirLink(String link, Context context){
        Uri uri = Uri.parse(link);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(intent);
    }

}
