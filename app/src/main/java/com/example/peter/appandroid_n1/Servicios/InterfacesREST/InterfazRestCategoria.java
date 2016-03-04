package com.example.peter.appandroid_n1.Servicios.InterfacesREST;


import com.example.peter.appandroid_n1.Models.OfertaModel;
import com.example.peter.appandroid_n1.Servicios.dtos.CountDTO;

import com.example.peter.appandroid_n1.Models.CategoriaModel;

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

    /**
     *  Size de las categorias.
     * @return
     */
    @GET("categorias/count")
    Call<CountDTO> countCategorias();

    /**
     * Select todas las categorias categorias segun los filtros especificados.
     * @param filters Conjunto de filtros ( where, orderby, limit, etc )
     * @return Las categorias que cumplen con los filtros.
     */
    @GET("categorias")
    Call<List<CategoriaModel>> selectCategorias( @QueryMap Map<String,String> filters );

}
