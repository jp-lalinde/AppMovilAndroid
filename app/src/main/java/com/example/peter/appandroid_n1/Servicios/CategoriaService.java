package com.example.peter.appandroid_n1.Servicios;

import android.app.Activity;

import com.example.peter.appandroid_n1.Constantes.ConstantesGlobales;
import com.example.peter.appandroid_n1.Models.CategoriaModel;
import com.example.peter.appandroid_n1.Persistence.CategoriaPersistence;
import com.example.peter.appandroid_n1.Servicios.InterfacesREST.InterfazRestCategoria;


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
        // DevMode strong logging
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel( HttpLoggingInterceptor.Level.BODY );
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        InterfazRestCategoria caller = new Retrofit.Builder().baseUrl(ConstantesGlobales.URL_SERVER)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(InterfazRestCategoria.class);



        Map<String,String> filtros = new HashMap<String,String>();
        //filtros.put( "filter[order]" , "numInteresados DESC" );
        //filtros.put( "filter[limit]" , "10" );
        Call<List<CategoriaModel>> categoriasCall = caller.selectCategorias(filtros);
        categoriasCall.enqueue(new Callback<List<CategoriaModel>>() {
            @Override
            public void onResponse(Call<List<CategoriaModel>> call, Response<List<CategoriaModel>> response) {
                List<CategoriaModel> resultList = response.body();
                System.out.println( "<<<<<<<<<<<< RESPUESTA REST : SUCCESS >>>>>>>>> \n"+ response.raw() + "\n" );
                CategoriaPersistence em = new CategoriaPersistence( activity );
                em.persistAll( resultList );
            }

            @Override
            public void onFailure(Call<List<CategoriaModel>> call, Throwable t) {
                System.out.println( "<<<<<<<<<<<< RESPUESTA REST : ERROR >>>>>>>>> \n"+ t.getMessage() + "\n" );
            }
        });

    }


}
