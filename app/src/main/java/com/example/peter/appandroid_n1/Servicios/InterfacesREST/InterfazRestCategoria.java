package com.example.peter.appandroid_n1.Servicios.InterfacesREST;

import com.example.peter.appandroid_n1.Models.CategoriaModel;
import com.example.peter.appandroid_n1.Models.OfertaModel;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by ASUS on 3/03/2016.
 */
public interface InterfazRestCategoria {

    /**
     * Select todas las categorias categorias segun los filtros especificados.
     * @param filters Conjunto de filtros ( where, orderby, limit, etc )
     * @return Las categorias que cumplen con los filtros.
     */
    @GET("categorias")
    Call<List<CategoriaModel>> selectCategorias( @QueryMap Map<String,String> filters );
}
