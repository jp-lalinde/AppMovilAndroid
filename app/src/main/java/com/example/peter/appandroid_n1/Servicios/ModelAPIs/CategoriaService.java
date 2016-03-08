package com.example.peter.appandroid_n1.Servicios.ModelAPIs;

import android.app.Activity;

import com.example.peter.appandroid_n1.Activities.IndexActivity;
import com.example.peter.appandroid_n1.Constantes.ConstantesGlobales;
import com.example.peter.appandroid_n1.Models.CategoriaModel;
import com.example.peter.appandroid_n1.Persistence.CategoriaPersistence;
import com.example.peter.appandroid_n1.Persistence.PersistenceManager;
import com.example.peter.appandroid_n1.Servicios.InterfacesREST.InterfazRestCategoria;
import com.example.peter.appandroid_n1.Servicios.RestAdapter.RestRequest;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ASUS on 1/03/2016.
 */
public class CategoriaService {

    //-----------------------------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------------------------



    //-----------------------------------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------------------------------
    public CategoriaService() {

    }

    //-----------------------------------------------------------------------------------
    // Metodos (remote calls)
    //-----------------------------------------------------------------------------------


    /**
     *
     * Obtiene las categorias del servidor y las guarda en sqlite.
     * pre:
     * post:
     * @param activity - La actividad que hace el llamado
     */
    public void pullAndStoreCategorias(final Activity activity) {

        InterfazRestCategoria caller =
                RestRequest.construct( ConstantesGlobales.URL_SERVER , true ).create( InterfazRestCategoria.class );

        Map<String,String> filtros = new HashMap<String,String>();
        Call<List<CategoriaModel>> categoriasCall = caller.selectCategorias(filtros);

        try{
            List<CategoriaModel> lista = categoriasCall.execute().body();
            CategoriaPersistence em = new CategoriaPersistence(IndexActivity.appContext);
            em.beginTran();
            em.persistAll( lista );
            em.commit();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
