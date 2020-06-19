package com.solicita.activity.ufape.inicio.inicio;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.solicita.R;
import com.solicita.activity.ufape.MainActivityUfape;
import com.solicita.activity.ufape.inicio.InicioActivityPrincipal;
import com.solicita.activity.ufape.inicio.a_ufape.AUfapeActivity;
import com.solicita.activity.ufape.servicos.ServicosActivityPrincipal;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import info.androidhive.fontawesome.FontDrawable;

public class InicioActivity  extends Fragment {

    private LinearLayout linear_layout_lista_contato;

    public static InicioActivity newInstance() {
        return new InicioActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_ufape_inicio, container, false);

        linear_layout_lista_contato = root.findViewById(R.id.linear_layout_inicio_ufape);

        linear_layout_lista_contato.getViewTreeObserver().addOnGlobalLayoutListener(new
        ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //Remove o listenner para não ser novamente chamado.
                linear_layout_lista_contato.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                //Coloca a largura igual à altura
                float largura = linear_layout_lista_contato.getWidth();
                float altura = linear_layout_lista_contato.getHeight();
                montarLinearLayoutInicio(largura);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private LinearLayout montarElementoLinearLayoutInicio(String titulo, int imagem, boolean is_imagem){

        View imagem_view = null;
        if(is_imagem) {
            LinearLayout.LayoutParams margin_imagem_ufape = new LinearLayout.LayoutParams
                    ((int) LinearLayout.LayoutParams.WRAP_CONTENT, (int) LinearLayout.LayoutParams.WRAP_CONTENT);
            margin_imagem_ufape.width = 180;
            margin_imagem_ufape.height = 180;
            margin_imagem_ufape.gravity = Gravity.CENTER;

            ImageView imagem_ufape = new ImageView(getContext());
            imagem_ufape.setImageResource(imagem);
            imagem_ufape.setLayoutParams(margin_imagem_ufape);
            imagem_view = imagem_ufape;
        }
        else{
            LinearLayout.LayoutParams margin_imagem_ufape = new LinearLayout.LayoutParams
                    ((int) LinearLayout.LayoutParams.WRAP_CONTENT, (int) LinearLayout.LayoutParams.WRAP_CONTENT);
            margin_imagem_ufape.width = 130;
            margin_imagem_ufape.height = 130;
            margin_imagem_ufape.gravity = Gravity.CENTER;

            FontDrawable drawable = new FontDrawable(getContext(), imagem, true, false);
            drawable.setTextColor(Color.rgb(27,45,79));

            ImageView imagem_ufape = new ImageView(getContext());
            imagem_ufape.setLayoutParams(margin_imagem_ufape);
            imagem_ufape.setImageDrawable(drawable);
            imagem_view = imagem_ufape;
        }

        LinearLayout.LayoutParams margin_titulo_ufape = new LinearLayout.LayoutParams
                ((int) LinearLayout.LayoutParams.WRAP_CONTENT, (int) LinearLayout.LayoutParams.WRAP_CONTENT);
        margin_titulo_ufape.gravity = Gravity.CENTER;

        TextView titulo_ufape = new TextView(getContext());
        titulo_ufape.setText(titulo);
        titulo_ufape.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        titulo_ufape.setTextColor(Color.rgb(0, 0, 0));
        titulo_ufape.setPadding(10,10,10,10);
        titulo_ufape.setTypeface(null, Typeface.BOLD);
        titulo_ufape.setLayoutParams(margin_titulo_ufape);

        LinearLayout.LayoutParams margin_ufape = new LinearLayout.LayoutParams
                ((int) LinearLayout.LayoutParams.WRAP_CONTENT, (int) LinearLayout.LayoutParams.WRAP_CONTENT);
        margin_ufape.width = 320;
        margin_ufape.height = 270;
        margin_ufape.leftMargin = 10;
        margin_ufape.rightMargin = 10;
        margin_ufape.topMargin = 10;
        margin_ufape.bottomMargin = 10;

        LinearLayout ufape = new LinearLayout(getContext());
        ufape.setBackgroundResource(R.drawable.ufape_botao_customizado_inicio);
        ufape.setLayoutParams(margin_ufape);
        ufape.setOrientation(LinearLayout.VERTICAL);
        ufape.setGravity(Gravity.CENTER);

        ufape.addView(imagem_view);
        ufape.addView(titulo_ufape);

        return ufape;
    }
    private void montarLinearLayoutInicio(float largura){

        ArrayList<LinearLayout> layouts = new ArrayList<LinearLayout>();

        layouts.add(montarElementoLinearLayoutInicio("Institucional", R.drawable.ufape_logo2, true));
        layouts.get(layouts.size() - 1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InicioActivityPrincipal.getInicioActivityPrincipal().abrirTelaInstitucional();
            }
        });

        layouts.add(montarElementoLinearLayoutInicio("Notícias e Comunicados", R.string.fa_newspaper_solid, false));
        layouts.get(layouts.size() - 1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InicioActivityPrincipal.getInicioActivityPrincipal().abrirTelaNoticiasComunicados();
            }
        });

        layouts.add(montarElementoLinearLayoutInicio("Ensino", R.string.fa_graduation_cap_solid, false));
        layouts.get(layouts.size() - 1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityUfape.getMainActivityUfape().clickBotaoRodapeCursos();
            }
        });

        layouts.add(montarElementoLinearLayoutInicio("Pesquisa e Inovação", R.string.fa_search_solid, false));
        layouts.get(layouts.size() - 1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InicioActivityPrincipal.getInicioActivityPrincipal().abrirTelaPesquisaInovacao();
            }
        });

        layouts.add(montarElementoLinearLayoutInicio("Extensão", R.string.fa_globe_solid, false));
        layouts.get(layouts.size() - 1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InicioActivityPrincipal.getInicioActivityPrincipal().abrirTelaExtensao();
            }
        });

        layouts.add(montarElementoLinearLayoutInicio("Estudantes", R.string.fa_user_graduate_solid, false));
        layouts.get(layouts.size() - 1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityUfape.getMainActivityUfape().clickBotaoRodapeEstudantes();
            }
        });

        layouts.add(montarElementoLinearLayoutInicio("Concursos", R.string.fa_file, false));
        layouts.get(layouts.size() - 1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InicioActivityPrincipal.getInicioActivityPrincipal().abrirTelaConcursos();
            }
        });

        layouts.add(montarElementoLinearLayoutInicio("Publicações", R.string.fa_book_solid, false));
        layouts.get(layouts.size() - 1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InicioActivityPrincipal.getInicioActivityPrincipal().abrirTelaPublicacoes();
            }
        });

        layouts.add(montarElementoLinearLayoutInicio("Comunicação", R.string.fa_pager_solid, false));
        layouts.get(layouts.size() - 1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InicioActivityPrincipal.getInicioActivityPrincipal().abrirTelaComunicacao();
            }
        });

        layouts.add(montarElementoLinearLayoutInicio("Serviços", R.string.fa_tools_solid, false));
        layouts.get(layouts.size() - 1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityUfape.getMainActivityUfape().clickBotaoRodapeServicos();
            }
        });

        layouts.add(montarElementoLinearLayoutInicio("Contatos", R.string.fa_phone_solid, false));
        layouts.get(layouts.size() - 1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityUfape.getMainActivityUfape().clickBotaoRodapeServicos();
                ServicosActivityPrincipal.getServicosActivityPrincipal().abrirTelaContato();
            }
        });

        layouts.add(montarElementoLinearLayoutInicio("Mapa", R.string.fa_map_marker_alt_solid, false));
        layouts.get(layouts.size() - 1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InicioActivityPrincipal.getInicioActivityPrincipal().abrirTelaMapa();
            }
        });

        LinearLayout.LayoutParams margin = new LinearLayout.LayoutParams
                ((int) LinearLayout.LayoutParams.WRAP_CONTENT, (int) LinearLayout.LayoutParams.WRAP_CONTENT);
        margin.gravity = Gravity.LEFT;

        LinearLayout layout = new LinearLayout(getContext());
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setLayoutParams(margin);

        LinearLayout.LayoutParams margin2 = new LinearLayout.LayoutParams
                ((int) LinearLayout.LayoutParams.WRAP_CONTENT, (int) LinearLayout.LayoutParams.WRAP_CONTENT);
        margin2.gravity = Gravity.CENTER;

        LinearLayout l = new LinearLayout(getContext());
        l.setOrientation(LinearLayout.VERTICAL);
        l.setLayoutParams(margin2);

        float width = 0;
        boolean flag = false;

        for(int i = 0; i < layouts.size(); i++){
            flag = false;
            if(width + 340 < largura) {
                layout.addView(layouts.get(i));
                width+= 340;
            }else {
                l.addView(layout);
                layout = new LinearLayout(getContext());
                layout.setOrientation(LinearLayout.HORIZONTAL);
                layout.setLayoutParams(margin);
                width = 0;
                flag = true;
                i--;
            }
        }

        if(!flag)
            l.addView(layout);

        linear_layout_lista_contato.addView(l);
    }
}
