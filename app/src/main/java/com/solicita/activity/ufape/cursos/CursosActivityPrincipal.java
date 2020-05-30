package com.solicita.activity.ufape.cursos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.solicita.R;
import com.solicita.activity.ufape.cursos.cursos.CursosActivity;
import com.solicita.activity.ufape.cursos.graduacao.GraduacaoActivity;
import com.solicita.activity.ufape.cursos.pos_graduacao.PosGraduacaoActivity;
import com.solicita.activity.ufape.servicos.contato.ContatoActivity;
import com.solicita.activity.ufape.servicos.servicos.ServicosActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CursosActivityPrincipal extends Fragment {

    private static CursosActivityPrincipal tela;
    public static CursosActivityPrincipal getCursosActivityPrincipal(){
        return tela;
    }

    public CursosActivityPrincipal(){
        tela = this;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_ufape_cursos_principal, container, false);

        abrirTelas();

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private static int tela_aberta = -1;

    public void abrirTelas(){
        if(tela_aberta == 1)
            abrirTelaGruaduacao();
        else if(tela_aberta == 2)
            abrirTelaPosGruaduacao();
        else
            abrirTelaInicio();
    }

    public void abrirTelaInicio(){
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_cursos, CursosActivity.newInstance())
                .commitNow();
        tela_aberta = 0;
    }

    public void abrirTelaGruaduacao(){
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_cursos, GraduacaoActivity.newInstance())
                .commitNow();
        tela_aberta = 1;
    }

    public void abrirTelaPosGruaduacao(){
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_cursos, PosGraduacaoActivity.newInstance())
                .commitNow();
        tela_aberta = 2;
    }
}
