package com.example.peter.appandroid_n1.Persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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

        Cursor c = db.rawQuery("select * from CATEGORIA",null);

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

        return categorias;
    }
}
