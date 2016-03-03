package com.example.peter.appandroid_n1.Servicios;

import android.app.Activity;

import com.example.peter.appandroid_n1.Constantes.ConstantesGlobales;
import com.example.peter.appandroid_n1.Models.OfertaModel;
import com.example.peter.appandroid_n1.Persistence.OfertaPersistence;
import com.example.peter.appandroid_n1.Servicios.InterfacesREST.InterfazRestOferta;


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
 * Created by peter on 26/02/2016.
 */
public class OfertaService {

    //----------------------------------------------------------------------------------------------
    // Attributes
    //----------------------------------------------------------------------------------------------



    //----------------------------------------------------------------------------------------------
    // Constructores
    //----------------------------------------------------------------------------------------------
    public OfertaService()
    {

    }

    //----------------------------------------------------------------------------------------------
    // Métodos
    //----------------------------------------------------------------------------------------------

    /**
     *
     * Obtiene las categorias del servidor y las guarda en sqlite.
     * pre:
     * post:
     * @param activity - La actividad que hace el llamado
     */
    public void pullAndStoreTopOfertas(final Activity activity)
    {
        // DevMode strong logging
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel( HttpLoggingInterceptor.Level.BODY );
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        InterfazRestOferta caller = new Retrofit.Builder().baseUrl("http://"+ConstantesGlobales.URL_SERVER+"/")
                                        .client(client)
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build()
                                        .create(InterfazRestOferta.class);



        Map<String,String> filtros = new HashMap<String,String>();
        filtros.put( "filter[order]" , "numInteresados DESC" );
        filtros.put( "filter[limit]" , "10" );
        Call<List<OfertaModel>> ofertasCall = caller.selectOfertas( filtros );
        ofertasCall.enqueue(new Callback<List<OfertaModel>>() {
            @Override
            public void onResponse(Call<List<OfertaModel>> call, Response<List<OfertaModel>> response) {
                List<OfertaModel> resultList = response.body();
                System.out.println( "<<<<<<<<<<<< RESPUESTA REST : SUCCESS >>>>>>>>> \n"+ response.raw() + "\n" );
                OfertaPersistence em = new OfertaPersistence( activity );
                em.persistAll( resultList );
            }

            @Override
            public void onFailure(Call<List<OfertaModel>> call, Throwable t) {
                System.out.println( "<<<<<<<<<<<< RESPUESTA REST : ERROR >>>>>>>>> \n"+ t.getMessage() + "\n" );
            }
        });

//
//        RestAdapter adapter = new RestAdapter(activity.getApplicationContext(), ConstantesGlobales.URL_SERVER);
//        ModelRepository ofertaRepository = adapter.createRepository(ConstantesGlobales.OFERTA);
//        final Activity activity2 = activity;
//
//        ofertaRepository.findAll(
//                new ListCallback<OfertaModel>() {
//                    @Override
//                    public void onSuccess(List<OfertaModel> ofertas) {
//                        //TODO Si falla, revisar la forma de recuperar el context de la aplicación
//                        OfertaPersistence persistencia = new OfertaPersistence(activity2);
//                        persistencia.truncateTables();
//                        int limite = 0;
//                        if (ofertas.size() >= 10) {
//                            limite = 10;
//                        } else {
//                            limite = ofertas.size();
//                        }
//                        for (int i = 0; i < limite; i++) {
//                            OfertaModel actual = ofertas.get(i);
//                            persistencia.insertOferta(actual.getIdOferta(), actual.getPrecio(), actual.getFechaInicio(), actual.getFechaFin(), actual.getEncodedFlyer(), actual.getIdCategoria());
//                        }
//                    }
//
//                    public void onError(Throwable t) {
//
//                    }
//                }
//        );
    }


}
