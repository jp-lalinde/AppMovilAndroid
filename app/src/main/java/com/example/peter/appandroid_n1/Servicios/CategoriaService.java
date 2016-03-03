package com.example.peter.appandroid_n1.Servicios;

import android.app.Activity;

import com.example.peter.appandroid_n1.Constantes.ConstantesGlobales;
import com.example.peter.appandroid_n1.Models.CategoriaModel;
import com.example.peter.appandroid_n1.Persistence.CategoriaPersistence;
import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import java.util.List;

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
    public void pullCategorias(Activity activity) {
        RestAdapter adapter = new RestAdapter(activity.getApplicationContext(), ConstantesGlobales.URL_SERVER);
        ModelRepository categoriaRepository = adapter.createRepository(ConstantesGlobales.CATEGORIA);
        final Activity activity2 = activity;

        categoriaRepository.findAll(new ListCallback<CategoriaModel>() {
                                        @Override
                                        public void onSuccess(List<CategoriaModel> categorias) {
                                            //TODO Si falla, revisar la forma de recuperar el context de la aplicación
                                            CategoriaPersistence persistencia = new CategoriaPersistence(activity2);
                                            persistencia.truncateTables();
                                            for (int i = 0; i < categorias.size(); i++) {
                                                CategoriaModel actual = categorias.get(i);
                                                persistencia.insertCategoria(actual.getIdCategoria(), actual.getNombre());
                                            }
                                        }

                                        public void onError(Throwable t) {

                                        }
                                    }
        );
    }


}
