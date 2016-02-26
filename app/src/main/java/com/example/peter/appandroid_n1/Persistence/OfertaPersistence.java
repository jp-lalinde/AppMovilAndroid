package com.example.peter.appandroid_n1.Persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.peter.appandroid_n1.Models.OfertaModel;

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

    public List<OfertaModel> getTopOfertas(){
        return null;
    }

}
