package com.solicita.activity.ufape;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.solicita.activity.LoginActivity;
import com.solicita.activity.ufape.ensino.CursosActivity;
import com.solicita.activity.ufape.estudantes.EstudantesActivity;
import com.solicita.activity.ufape.inicio.InicioActivityPrincipal;
import com.solicita.activity.ufape.links.institucional.LinksInstitucional;
import com.solicita.activity.ufape.links.publicacoes.LinksPublicacoes;
import com.solicita.activity.ufape.links.redes_sociais.LinksRedesSociais;
import com.solicita.activity.ufape.links.servicos.LinksServicos;
import com.solicita.activity.ufape.servicos.ServicosActivityPrincipal;
import com.google.android.material.navigation.NavigationView;
import com.solicita.R;
import com.solicita.activity.ufape.sobre.SobreActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivityUfape extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static MainActivityUfape tela_principal;
    public static MainActivityUfape getMainActivityUfape(){
        return tela_principal;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ufape_main);

        tela_principal = this;

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        /*if (id == R.id.nav_home) {

        } else if(id == R.id.nav_solicita){

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (mPager.getCurrentItem() == 0) {
                this.moveTaskToBack(true);
            } else {
                mPager.setCurrentItem(mPager.getCurrentItem() - 1);
            }
        }
    }

    //region Botoes Redes Sociais

    public void clickBotaoFacebook(View view){
        fecharMenuLateral();
        LinksRedesSociais.getLinksInstitucional().abrirLinkFacebook(this);
    }

    public void clickBotaoYoutube(View view){
        fecharMenuLateral();
        LinksRedesSociais.getLinksInstitucional().abrirLinkYoutube(this);
    }

    public void clickBotaoLinkedin(View view){
        fecharMenuLateral();
        LinksRedesSociais.getLinksInstitucional().abrirLinkLinkedin(this);
    }

    public void clickBotaoInstagram(View view){
        fecharMenuLateral();
        LinksRedesSociais.getLinksInstitucional().abrirLinkInstagram(this);
    }

    public void clickBotaoTwitter(View view){
        fecharMenuLateral();
        LinksRedesSociais.getLinksInstitucional().abrirLinkTwitter(this);
    }

    //endregion

    //region Botoes do Menu Lateral

    private void fecharMenuLateral(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    public void clickBotaoMenuLateral(View view) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.openDrawer(GravityCompat.START);
    }

    private void setarCorPadraoBotoesMenuLateral(View botao){
        //botao.setBackgroundResource(R.drawable.ufape_botao_customizado_menu_lateral);
    }
    public void ajustarCorBotoesMenuLateral(View view){
        /*setarCorPadraoBotoesMenuLateral((LinearLayout) findViewById(R.id.botao_menu_lateral_inicio));
        setarCorPadraoBotoesMenuLateral((LinearLayout) findViewById(R.id.botao_menu_lateral_contato));
        setarCorPadraoBotoesMenuLateral((LinearLayout) findViewById(R.id.botao_menu_lateral_editais));
        setarCorPadraoBotoesMenuLateral((LinearLayout) findViewById(R.id.botao_menu_lateral_solicita));
        setarCorPadraoBotoesMenuLateral((LinearLayout) findViewById(R.id.botao_menu_lateral_submeta));
        setarCorPadraoBotoesMenuLateral((LinearLayout) findViewById(R.id.botao_menu_lateral_sobre));

        view.setBackgroundResource(R.drawable.ufape_botao_customizado_clicado_menu_lateral);*/
    }

    public void clickBotaoMenuLateralInicio(View view){
        fecharMenuLateral();
        ajustarCorBotoesMenuLateral(view);
        clickBotaoRodapeInicio(view);
    }

    public void clickBotaoMenuLateralSiga(View view){
        fecharMenuLateral();
        LinksServicos.getLinksInstitucional().abrirLinkSiga(this);
    }

    public void clickBotaoMenuLateralAva(View view){
        fecharMenuLateral();
        LinksServicos.getLinksInstitucional().abrirLinkAva(this);
    }

    public void clickBotaoMenuLateralBiblioteca(View view){
        fecharMenuLateral();
        LinksInstitucional.getLinksInstitucional().abrirLinkBiblioteca(this);
    }

    public void clickBotaoMenuLateralSolicita(){
        LoginActivity l = new LoginActivity();
        startActivity(new Intent(MainActivityUfape.this, l.getClass()));
    }
    public void clickBotaoMenuLateralSolicita(View view){
        fecharMenuLateral();
        clickBotaoMenuLateralSolicita();
    }

    public void clickBotaoMenuLateralSubmeta(View view){
        fecharMenuLateral();
        LinksServicos.getLinksInstitucional().abrirLinkSubmeta(this);
    }

    public void clickBotaoMenuLateralAcessoInformacao(View view){
        fecharMenuLateral();
        LinksServicos.getLinksInstitucional().abrirLinkAcessoInformacao(this);
    }

    public void clickBotaoMenuLateralContato(View view){
        fecharMenuLateral();
        ajustarCorBotoesMenuLateral(view);
        clickBotaoRodapeServicos();
        ServicosActivityPrincipal.getServicosActivityPrincipal().abrirTelaContato();
    }

    public void clickBotaoMenuLateralSobre(View view){
        fecharMenuLateral();
        ajustarCorBotoesMenuLateral(view);
        startActivity(new Intent(MainActivityUfape.this, SobreActivity.class));
    }

    //endregion

    //region Botoes de Rodapé

    public void clickLinkLMTS(View view){
        LinksServicos.getLinksInstitucional().abrirLinkLMTS(this);
    }

    public void ajustarCorBotoesRodape(){
        try {
            int i = mPager.getCurrentItem();
            if (i == 0)
                ajustarCorBotoesRodape(findViewById(R.id.botao_rodape_inicio));
            else if (i == 1)
                ajustarCorBotoesRodape(findViewById(R.id.botao_rodape_cursos));
            else if (i == 2)
                ajustarCorBotoesRodape(findViewById(R.id.botao_rodape_servicos));
            else if (i == 3)
                ajustarCorBotoesRodape(findViewById(R.id.botao_rodape_estudantes));
        }catch (Exception e){}
    }

    private void setarCorPadraoBotoesRodape(LinearLayout botao){
        botao.setBackground(null);
    }
    public void ajustarCorBotoesRodape(View view){

        setarCorPadraoBotoesRodape((LinearLayout) findViewById(R.id.botao_rodape_inicio));
        setarCorPadraoBotoesRodape((LinearLayout) findViewById(R.id.botao_rodape_cursos));
        setarCorPadraoBotoesRodape((LinearLayout) findViewById(R.id.botao_rodape_servicos));
        setarCorPadraoBotoesRodape((LinearLayout) findViewById(R.id.botao_rodape_estudantes));

        LinearLayout b = (LinearLayout) view;
        b.setBackgroundColor(Color.rgb(27,45,79));
    }

    public void clickBotaoRodapeInicio(){
        /*getSupportFragmentManager().beginTransaction()
                .replace(R.id.containe, InicioActivityPrincipal.newInstance())
                .commitNow();*/
        mPager.setCurrentItem(0);
        InicioActivityPrincipal.getInicioActivityPrincipal().abrirTelaInicio();
    }
    public void clickBotaoRodapeInicio(View view){
        clickBotaoRodapeInicio();
    }

    public void clickBotaoRodapeCursos(){
        mPager.setCurrentItem(1);
    }
    public void clickBotaoRodapeCursos(View view){
        clickBotaoRodapeCursos();
    }

    public void clickBotaoRodapeServicos(){
        mPager.setCurrentItem(2);
        ServicosActivityPrincipal.getServicosActivityPrincipal().abrirTelaInicio();
    }
    public void clickBotaoRodapeServicos(View view){
        clickBotaoRodapeServicos();
    }

    public void clickBotaoRodapeEstudantes(){
        mPager.setCurrentItem(3);
    }
    public void clickBotaoRodapeEstudantes(View view){
        clickBotaoRodapeEstudantes();
    }

    private static final int NUM_PAGES = 4;
    private ViewPager mPager;
    private PagerAdapter pagerAdapter;

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0)
                return new InicioActivityPrincipal();
            else if(position == 1)
                return new CursosActivity();
            else if(position == 2)
                return new ServicosActivityPrincipal();
            else if(position == 3)
                return new EstudantesActivity();


            return new InicioActivityPrincipal();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            ajustarCorBotoesRodape();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }

    //endregion
}
