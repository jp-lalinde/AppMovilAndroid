package com.example.peter.appandroid_n1.Servicios.RestAdapter;

import com.example.peter.appandroid_n1.Constantes.ConstantesGlobales;
import com.example.peter.appandroid_n1.Servicios.InterfacesREST.InterfazRestCategoria;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by peter on 3/03/2016.
 */
public class RestRequest {

    /**
     *
     * @param urlServer - url del servidor
     * @param client - tipo de cliente http
     * @return
     */
    public static Retrofit  construct( String urlServer , boolean logging ){
       if ( logging ){
           // DevMode strong logging
           HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
           interceptor.setLevel( HttpLoggingInterceptor.Level.BODY );
           OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

           return new Retrofit.Builder().baseUrl(urlServer)
                   .client(client)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();
       }else {
           return new Retrofit.Builder().baseUrl(urlServer)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();
       }
    }

}
