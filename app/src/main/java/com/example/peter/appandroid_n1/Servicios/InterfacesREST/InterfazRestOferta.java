package com.example.peter.appandroid_n1.Servicios.InterfacesREST;

import com.example.peter.appandroid_n1.Models.OfertaModel;
import com.strongloop.android.loopback.callbacks.ListCallback;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by peter on 2/03/2016.
 */
public interface InterfazRestOferta {

    /**
     * Select ofertas segun los filtros especificados.
     * @param filters - Conjunto de filtros. ( where, orderby, limit, etc )
     * @return Conjunto de ofertas que cumplen condiciones de filtros.
     */
    @GET("ofertas")
    Call<List<OfertaModel>> selectOfertas( @QueryMap Map<String,String> filters );

}
