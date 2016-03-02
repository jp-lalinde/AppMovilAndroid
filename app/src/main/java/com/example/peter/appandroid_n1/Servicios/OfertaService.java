package com.example.peter.appandroid_n1.Servicios;

import android.app.Activity;

import com.example.peter.appandroid_n1.Constantes.ConstantesGlobales;
import com.example.peter.appandroid_n1.Models.OfertaModel;
import com.example.peter.appandroid_n1.Persistence.OfertaPersistence;
import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import java.util.List;

/**
 * Created by peter on 26/02/2016.
 */
public class OfertaService {

    public OfertaService()
    {

    }

    //Métodos

    public void guardarDatosOfertaEnLocal(Activity activity)
    {

        RestAdapter adapter = new RestAdapter(activity.getApplicationContext(), ConstantesGlobales.URL_SERVER);
        ModelRepository ofertaRepository = adapter.createRepository(ConstantesGlobales.OFERTA);
        final Activity activity2 = activity;

        ofertaRepository.findAll(new ListCallback<OfertaModel>(){
                                    @Override
                                    public void onSuccess(List<OfertaModel>ofertas)
                                    {
                                        //TODO Si falla, revisar la forma de recuperar el context de la aplicación
                                        OfertaPersistence persistencia = new OfertaPersistence(activity2);
                                        persistencia.truncateTables();
                                        int limite=0;
                                        if(ofertas.size()>=10)
                                        {
                                            limite=10;
                                        }
                                        else
                                        {
                                           limite =ofertas.size();
                                        }
                                        for(int i=0;i<limite;i++)
                                        {
                                            OfertaModel actual = ofertas.get(i);
                                            persistencia.insertOferta(actual.getIdOferta(),actual.getPrecio(),actual.getFechaInicio(),actual.getFechaFin(),actual.getEncodedFlyer(),actual.getIdCategoria());
                                        }
                                    }
                                    public void onError(Throwable t)
                                    {

                                    }
                                 }
        );

    }

    public List<OfertaModel> getTodasLasOfertasEnLocal(Activity activity)
    {
        final Activity activity2 = activity;
        OfertaPersistence persistence = new OfertaPersistence(activity2);
        return persistence.getTopOfertas();
    }

    public List<OfertaModel> getTodasLasOfertasLocalPorCategoria(Activity activity, long idCategoria)
    {
        final Activity activity2 = activity;
        OfertaPersistence persistence = new OfertaPersistence(activity2);
        return persistence.getOfertaPorCategoria(idCategoria);
    }

    public OfertaModel getOfertaPorId(Activity activity, long idOferta)
    {
        final Activity activity2 = activity;
        OfertaPersistence persistence = new OfertaPersistence(activity2);
        return persistence.getOfertaPorId(idOferta);
    }

    public void truncateTables(Activity activity)
    {
        final Activity activity2 = activity;
        OfertaPersistence persistence = new OfertaPersistence(activity2);
        persistence.truncateTables();
    }

    //Datos Mock
    public void insertarDatosMock(Activity activity)
    {
        final Activity activity2 = activity;
        OfertaPersistence persistence = new OfertaPersistence(activity2);
        persistence.insertarDatosMock();
    }






}
