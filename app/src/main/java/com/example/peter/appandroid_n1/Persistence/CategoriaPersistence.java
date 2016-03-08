package com.example.peter.appandroid_n1.Persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.peter.appandroid_n1.Constantes.ConstantesGlobales;
import com.example.peter.appandroid_n1.Models.CategoriaModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 26/02/2016.
 */
public class CategoriaPersistence {

    private PersistenceManager pm;
    public CategoriaPersistence(Context ctx){
        pm = PersistenceManager.getInstance(ctx)  ;
    }

    //--------------------------------------------------------------------
    // Metodos
    //--------------------------------------------------------------------


    public List<CategoriaModel> getCategorias()
    {
        List<CategoriaModel> categorias = new ArrayList<CategoriaModel>();
        SQLiteDatabase db = pm.getDb();
        Cursor c = db.rawQuery("select * from "+ ConstantesGlobales.CATEGORIA,null);

        if (c.moveToFirst()) {

            while (c.isAfterLast() == false) {

                CategoriaModel categoria = new CategoriaModel(
                        c.getInt(0),
                        c.getString(1)
                );
                categorias.add(categoria);
                c.moveToNext();
            }
        }
        c.close();
        return categorias;
    }

    public void truncateTables()
    {
        pm.getDb().execSQL("DELETE FROM " + ConstantesGlobales.CATEGORIA);
    }

    public void insertCategoria(long id, String nombre)
    {
        pm.getDb().execSQL("INSERT INTO " + ConstantesGlobales.CATEGORIA
                        + " (" + ConstantesGlobales.CATEGORIA_ID + "," + ConstantesGlobales.CATEGORIA_NOMBRE + ") "
                        + "VALUES("
                        + id + ", \'" + nombre + "\')"
        );
    }

    public String getNombreCategoria(long id)
    {
        Cursor c = pm.getDb().rawQuery("SELECT " + ConstantesGlobales.CATEGORIA_NOMBRE +
                " FROM " + ConstantesGlobales.CATEGORIA +
                " WHERE " + ConstantesGlobales.CATEGORIA_ID + "=" + id, null);

        if(c.moveToFirst())
        {
            String nombre = c.getString(0);
            c.close();
            return nombre;
        }
        else
        {
            c.close();
            return "";
        }
    }

    /**
     * Persiste una lista de objetos categoriaModel
     * @param list - lista de ofertas que se va a guardar.
     */
    public void persistAll(List<CategoriaModel> list){
        for( CategoriaModel model : list ){
            String nombre = model.getNombre();
            long id = model.getIdCategoria();

            pm.getDb().execSQL("INSERT INTO " + ConstantesGlobales.CATEGORIA
                            + " (" + ConstantesGlobales.CATEGORIA_ID + "," + ConstantesGlobales.CATEGORIA_NOMBRE + ") "
                            + "VALUES("
                            + id + ", \'" + nombre + "\')"
            );
            System.out.println(" << Categoria[id =" + id + "] was saved >> ") ;
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------
    // Extensiones
    //---------------------------------------------------------------------------------------------------------------------------


    public void beginTran(){
        pm.beginTran();
    }

    public void commit(){
        pm.commit();
    }


    /**
     *
     */
    public void openDBConn() throws SQLException
    {
        pm.openDBConn();
    }

    /**
     *
     */
    public void closeDBConn()
    {
        pm.closeDBConn();
    }
}
