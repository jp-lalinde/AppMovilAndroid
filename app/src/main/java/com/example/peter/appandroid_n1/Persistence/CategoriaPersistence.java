package com.example.peter.appandroid_n1.Persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.peter.appandroid_n1.Constantes.ConstantesGlobales;
import com.example.peter.appandroid_n1.Models.CategoriaModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 26/02/2016.
 */
public class CategoriaPersistence {

    private SQLiteDatabase db;

    public CategoriaPersistence(Context ctx){
        DBHelper helper = new DBHelper(ctx.getApplicationContext());
        db = helper.getWritableDatabase();
    }

    //--------------------------------------------------------------------
    // Metodos
    //--------------------------------------------------------------------

    public List<CategoriaModel> getCategorias()
    {
        List<CategoriaModel> categorias = new ArrayList<CategoriaModel>();

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
        db.execSQL("DELETE FROM " + ConstantesGlobales.CATEGORIA);
    }

    public void insertCategoria(long id, String nombre)
    {
        db.execSQL("INSERT INTO" + ConstantesGlobales.CATEGORIA
                        + " (" + ConstantesGlobales.CATEGORIA_ID + "," + ConstantesGlobales.CATEGORIA_NOMBRE + ") "
                        + "VALUES("
                        + id + ", \'" + nombre + "\')"
        );
    }

    public String getNombreCategoria(long id)
    {
        Cursor c = db.rawQuery("SELECT "+ConstantesGlobales.CATEGORIA_NOMBRE+
                " FROM "+ConstantesGlobales.CATEGORIA+
                " WHERE "+ConstantesGlobales.CATEGORIA_ID+"="+id,null);

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

    //Datos mock
    public void insertarDatosMock()
    {
        System.out.println("Meto datos en la tabla de categoria");
        //Datos Mock
        db.execSQL("INSERT INTO "+ ConstantesGlobales.CATEGORIA+
                        " (" + ConstantesGlobales.CATEGORIA_ID + "," + ConstantesGlobales.CATEGORIA_NOMBRE + ") "
                        + "VALUES("
                        + 0 + ", \'Salud\')"
        );
    }
}
