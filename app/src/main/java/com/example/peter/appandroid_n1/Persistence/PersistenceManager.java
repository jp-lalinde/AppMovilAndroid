package com.example.peter.appandroid_n1.Persistence;

import android.content.Context;

/**
 * Created by ASUS on 3/03/2016.
 */
public class PersistenceManager {

    private static PersistenceManager instance = null;
    private CategoriaPersistence categoriaPersistence;
    private OfertaPersistence ofertaPersistence;

    public PersistenceManager(Context ctx)
    {
        DBHelper helper = new DBHelper(ctx.getApplicationContext());
        categoriaPersistence = new CategoriaPersistence(helper);
        ofertaPersistence = new OfertaPersistence(helper);
        instance=this;
    }

    /**
     * Métodos
     */

    public static PersistenceManager getInstance()
    {
        return instance;
    }

    public CategoriaPersistence getCategoriaPersistence()
    {
        return categoriaPersistence;
    }

    public OfertaPersistence getOfertaPersistence()
    {
        return ofertaPersistence;
    }
}
