package com.example.peter.appandroid_n1.Activities;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.peter.appandroid_n1.Constantes.ConstantesGlobales;
import com.example.peter.appandroid_n1.Models.CategoriaModel;
import com.example.peter.appandroid_n1.Models.OfertaModel;
import com.example.peter.appandroid_n1.PageAdapters.CategoriaPagerAdapter;
import com.example.peter.appandroid_n1.Persistence.CategoriaPersistence;
import com.example.peter.appandroid_n1.Persistence.OfertaPersistence;
import com.example.peter.appandroid_n1.Persistence.PersistenceManager;
import com.example.peter.appandroid_n1.R;
import com.example.peter.appandroid_n1.Servicios.CategoriaService;
import com.example.peter.appandroid_n1.Servicios.InterfacesREST.InterfazRestCategoria;
import com.example.peter.appandroid_n1.Servicios.InterfacesREST.InterfazRestOferta;
import com.example.peter.appandroid_n1.Servicios.OfertaService;
import com.example.peter.appandroid_n1.Servicios.RestAdapter.RestRequest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IndexActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private CategoriaPagerAdapter mPagerAdapter;
    private TabLayout mTabLayout;

    private CategoriaPersistence categoriaPersistence;
    private OfertaPersistence ofertaPersistence;


    //Contexto estático de la aplicación
    public static Context appContext;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    /**
     *  CODIGO PARA INICIALIZAR PRUEBAS
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Variables init
        //CategoriaService categoriaService = new CategoriaService();
        //categoriaService.pullAndStoreCategorias( this );
        categoriaPersistence = new CategoriaPersistence(this.getApplicationContext());
        ofertaPersistence = new OfertaPersistence(this.getApplicationContext());

        try
        {
            categoriaPersistence.openDBConn();
        }
        catch(SQLException e)
        {

        }
        Map<String,String>f = new HashMap<String,String>();
        Call<List<CategoriaModel>> call =
                RestRequest.construct(ConstantesGlobales.URL_SERVER,true).create(InterfazRestCategoria.class).selectCategorias(f);
        call.enqueue(new Callback<List<CategoriaModel>>() {
            @Override
            public void onResponse(Call<List<CategoriaModel>> call, Response<List<CategoriaModel>> response) {
                try {
                    categoriaPersistence.persistAll(response.body());
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<List<CategoriaModel>> call, Throwable t) {
            }
        });

        Call<List<OfertaModel>> callOferta=
                RestRequest.construct(ConstantesGlobales.URL_SERVER,true).create(InterfazRestOferta.class).selectOfertas(f);
        callOferta.enqueue(new Callback<List<OfertaModel>>() {
            @Override
            public void onResponse(Call<List<OfertaModel>> call, Response<List<OfertaModel>> response) {
                try
                {
                    ofertaPersistence.persistAll(response.body());
                }catch (Exception e)
                {

                }
                inicializacionGUI();
            }

            @Override
            public void onFailure(Call<List<OfertaModel>> call, Throwable t) {
                inicializacionGUI();
            }
        });

        super.onCreate(savedInstanceState);
        appContext = this.getApplicationContext();

        setContentView(R.layout.activity_index);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_index, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     *
     */
    @Override
    protected void onResume()
    {
        try
        {
            categoriaPersistence.openDBConn();
        }
        catch(SQLException e)
        {

        }
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        //persistenceManager.closeDBConn();
        super.onPause();
    }

    /**
     *
     */
    private void inicializacionGUI() {
        System.out.println("Construyo GUI");
        mPagerAdapter = new CategoriaPagerAdapter(getSupportFragmentManager());
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setTabsFromPagerAdapter(mPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

    }


}
