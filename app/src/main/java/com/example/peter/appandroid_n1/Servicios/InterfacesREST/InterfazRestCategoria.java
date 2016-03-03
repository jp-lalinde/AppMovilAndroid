package com.example.peter.appandroid_n1.Servicios.InterfacesREST;

import com.example.peter.appandroid_n1.Models.OfertaModel;
import com.example.peter.appandroid_n1.Servicios.dtos.CountDTO;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by peter on 3/03/2016.
 */
public interface InterfazRestCategoria {

    /**
     * Select ofertas by categoria.
     * @param filters - Conjunto de filtros. ( where, orderby, limit, etc )
     * @return Conjunto de ofertas que cumplen condiciones de filtros.
     */
    @GET("categorias/{id}/ofertas")
    Call<List<OfertaModel>>  selectOfertasByCategoria( @Path("id") long catId ,@QueryMap Map<String,String> filters ) ;

    @GET("categorias/count")
    Call<CountDTO> countCategorias();
}
