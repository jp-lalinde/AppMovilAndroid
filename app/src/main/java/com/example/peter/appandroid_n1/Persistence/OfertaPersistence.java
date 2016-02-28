package com.example.peter.appandroid_n1.Persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.peter.appandroid_n1.Models.OfertaModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 26/02/2016.
 */
public class OfertaPersistence {

    private SQLiteDatabase db;

    public OfertaPersistence(Context ctx){
        DBHelper helper = new DBHelper(ctx.getApplicationContext());
        db = helper.getWritableDatabase();
    }

    //--------------------------------------------------------------------
    // Metodos
    //--------------------------------------------------------------------

    public List<OfertaModel> getTopOfertas() {

        List<OfertaModel> ofertas = new ArrayList<OfertaModel>();
        Cursor c = db.rawQuery("select * from OFERTA",null);

        if (c.moveToFirst()) {

            while (c.isAfterLast() == false) {

                OfertaModel oferta = new OfertaModel(
                        c.getInt(0),
                        c.getDouble(1),
                        c.getString(2),
                        c.getString(3),
                        c.getBlob(4)
                );
                ofertas.add(oferta);
                c.moveToNext();
            }
        }
         return ofertas;
    }

}
