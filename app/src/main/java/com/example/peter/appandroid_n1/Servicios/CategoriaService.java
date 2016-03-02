package com.example.peter.appandroid_n1.Servicios;

import android.app.Activity;

import com.example.peter.appandroid_n1.Constantes.ConstantesGlobales;
import com.example.peter.appandroid_n1.Models.CategoriaModel;
import com.example.peter.appandroid_n1.Models.OfertaModel;
import com.example.peter.appandroid_n1.Persistence.CategoriaPersistence;
import com.example.peter.appandroid_n1.Persistence.OfertaPersistence;
import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import java.util.List;

/**
 * Created by ASUS on 1/03/2016.
 */
public class CategoriaService {

    public CategoriaService()
    {

    }

    //Metodos

    public void guardarDatosCategoria(Activity activity)
    {
        RestAdapter adapter = new RestAdapter(activity.getApplicationContext(), ConstantesGlobales.URL_SERVER);
        ModelRepository categoriaRepository = adapter.createRepository(ConstantesGlobales.CATEGORIA);
        final Activity activity2 = activity;

        categoriaRepository.findAll(new ListCallback<CategoriaModel>(){
                                     @Override
                                     public void onSuccess(List<CategoriaModel> categorias)
                                     {
                                         //TODO Si falla, revisar la forma de recuperar el context de la aplicación
                                         CategoriaPersistence persistencia = new CategoriaPersistence(activity2);
                                         persistencia.truncateTables();
                                         for(int i=0;i<categorias.size();i++)
                                         {
                                             CategoriaModel actual = categorias.get(i);
                                             persistencia.insertCategoria(actual.getIdCategoria(), actual.getNombre());
                                         }

                                     }
                                     public void onError(Throwable t)
                                     {

                                     }
                                 }
        );
    }

    public String getNombreCategoriaPorId(Activity activity, long id)
    {
        final Activity activity2 = activity;
        CategoriaPersistence persistencia = new CategoriaPersistence(activity2);
        return persistencia.getNombreCategoria(id);
    }

    public void truncateTables(Activity activity)
    {
        final Activity activity2 = activity;
        CategoriaPersistence persistence = new CategoriaPersistence(activity2);
        persistence.truncateTables();
    }

    //DAtos Mock
    public void insertarDatosMock(Activity activity)
    {
        final Activity activity2 = activity;
        CategoriaPersistence persistence = new CategoriaPersistence(activity2);
        persistence.insertarDatosMock();
    }
}
