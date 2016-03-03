package com.example.peter.appandroid_n1.Servicios;

import android.app.Activity;

import com.example.peter.appandroid_n1.Constantes.ConstantesGlobales;
import com.example.peter.appandroid_n1.Models.OfertaModel;
import com.example.peter.appandroid_n1.Persistence.OfertaPersistence;
import com.example.peter.appandroid_n1.Servicios.InterfacesREST.InterfazRestCategoria;
import com.example.peter.appandroid_n1.Servicios.RestAdapter.RestRequest;
import com.example.peter.appandroid_n1.Servicios.dtos.CountDTO;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * Obtiene ofertas de una categoria especifica del servidor y las guarda en sqlite.
     * pre:
     * post:
     * @param activity - La actividad que hace el llamado
     */
    public void pullAndSave_TopOfertasByCategoria(final Activity activity)
    {
        InterfazRestCategoria categoriasApi =
                RestRequest.construct( ConstantesGlobales.URL_SERVER, true ).create(InterfazRestCategoria.class);
        OfertaPersistence em = new OfertaPersistence( activity ) ;
        try {
            CountDTO countdto = categoriasApi.countCategorias().execute().body();
            Map<String,String> filtros = new HashMap<String,String>();
            filtros.put( "filter[order]" , "numInteresados DESC" );
            filtros.put("filter[limit]", "10");

            em.getDb().beginTransaction();
            for( int i = 1 ; i <= countdto.getCount() ; i++ ) {
                List<OfertaModel> lista = categoriasApi.selectOfertasByCategoria(i, filtros).execute().body();
                em.persistAll( lista );
            }
            em.getDb().endTransaction();
        }catch( IOException e ){
            e.printStackTrace();
        }
    }


}
