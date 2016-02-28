package com.example.peter.appandroid_n1.Persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by peter on 26/02/2016.
 */
public class ClientePersistence {

    private SQLiteDatabase db;

    public ClientePersistence(Context ctx){
        DBHelper helper = new DBHelper(ctx.getApplicationContext());
        db = helper.getWritableDatabase();
    }

    //--------------------------------------------------------------------
    // Metodos
    //--------------------------------------------------------------------


}
