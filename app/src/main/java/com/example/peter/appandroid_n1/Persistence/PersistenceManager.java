package com.example.peter.appandroid_n1.Persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.peter.appandroid_n1.Models.CategoriaModel;
import com.example.peter.appandroid_n1.Models.OfertaModel;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ASUS on 3/03/2016.
 */
public class PersistenceManager {

    protected static PersistenceManager instance = null;
    private SQLiteDatabase db;
    private DBHelper helper;

    protected PersistenceManager(Context ctx)
    {
        this.helper = new DBHelper(ctx.getApplicationContext());
        this.db = helper.getWritableDatabase();
    }

    /**
     * Métodos
     */

    protected static PersistenceManager getInstance(Context ctx)
    {
        if( instance == null ){
            instance = new PersistenceManager(ctx);
        }
        return instance;
    }


    public void beginTran(){
        db.beginTransaction();
    }

    public void commit(){
        db.endTransaction();
    }


    /**
     *
     */
    public void openDBConn() throws SQLException
    {
        db = helper.getWritableDatabase();
    }

    /**
     *
     */
    public void closeDBConn()
    {
        db.close();
    }


    protected SQLiteDatabase getDb() {
        return db;
    }


}
