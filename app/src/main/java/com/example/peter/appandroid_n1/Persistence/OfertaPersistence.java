package com.example.peter.appandroid_n1.Persistence;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.peter.appandroid_n1.Constantes.ConstantesGlobales;
import com.example.peter.appandroid_n1.Models.OfertaModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 26/02/2016.
 */
public class OfertaPersistence {

    private PersistenceManager pm;

    public OfertaPersistence(Context ctx){
        pm = PersistenceManager.getInstance(ctx)  ;
    }

    //--------------------------------------------------------------------
    // Metodos
    //--------------------------------------------------------------------


    public List<OfertaModel> getTopOfertas() {

        List<OfertaModel> ofertas = new ArrayList<OfertaModel>();
        Cursor c = pm.getDb().rawQuery("select * from " + ConstantesGlobales.OFERTA, null);

        if (c.moveToFirst()) {

            while (c.isAfterLast() == false) {

                OfertaModel oferta = new OfertaModel(
                        c.getInt(0),
                        c.getDouble(1),
                        c.getString(2),
                        c.getString(3),
                        c.getString(4),
                        c.getInt(5)
                );
                ofertas.add(oferta);
                c.moveToNext();
            }
        }
        c.close();
        return ofertas;
    }

    public void truncateTables()
    {
        pm.getDb().execSQL("DELETE FROM " + ConstantesGlobales.OFERTA);
    }

    public void insertOferta(long id, double precio, String fechaInicio, String fechaFin, String flyer, long idCategoria)
    {
        pm.getDb().execSQL("INSERT INTO" + ConstantesGlobales.OFERTA
                        + " (" + ConstantesGlobales.OFERTA_ID + "," + ConstantesGlobales.OFERTA_PRECIO + ","
                        + ConstantesGlobales.OFERTA_FECHA_INICIO + "," + ConstantesGlobales.OFERTA_FECHA_FIN + ","
                        + ConstantesGlobales.OFERTA_FLYER + "," + ConstantesGlobales.OFERTA_ID_CATEGORIA + ") "
                        + "VALUES("
                        + id + ", " + precio + ", \'" + fechaInicio + "\', \'" + fechaFin + "\', \'" + flyer + "\', " + idCategoria + ")"
        );
    }

    public List<OfertaModel> getOfertaPorCategoria(long idCategoria)
    {
        Cursor c = pm.getDb().rawQuery("SELECT * FROM " + ConstantesGlobales.OFERTA +
                " WHERE " + ConstantesGlobales.OFERTA_ID_CATEGORIA +
                "=" + idCategoria, null);
        List<OfertaModel> ofertas = new ArrayList<OfertaModel>();
        if(c.moveToFirst())
        {
            while(c.isAfterLast()==false)
            {
                OfertaModel oferta = new OfertaModel(
                        c.getInt(0),
                        c.getDouble(1),
                        c.getString(2),
                        c.getString(3),
                        c.getString(4),
                        c.getInt(5)
                );
                ofertas.add(oferta);
                c.moveToNext();
            }
        }
        c.close();
        return ofertas;
    }

    public OfertaModel getOfertaPorId(Long idOferta)
    {
        Cursor c = pm.getDb().rawQuery("SELECT * FROM " + ConstantesGlobales.OFERTA + " WHERE " + ConstantesGlobales.OFERTA_ID + "=" + idOferta, null);
        OfertaModel oferta = null;
        Log.d("EN PERSISTENCE","");
        if(c.moveToFirst())
        {
            Log.d("C MOVE FIRST:","");
            oferta= new OfertaModel(
                    c.getInt(0),
                    c.getDouble(1),
                    c.getString(2),
                    c.getString(3),
                    c.getString(4),
                    c.getInt(5)
            );
        }
        c.close();
        return oferta;
    }


    /**
     * Persiste una lista de objetos oferteModel
     * @param list - lista de ofertas que se va a guardar.
     */
    public void persistAll(List<OfertaModel> list){
        for( OfertaModel model : list ){
            long id = (long) model.getIdOferta();
            double precio = model.getPrecio() ;
            String fechaInicio = model.getFechaInicio();
            String fechaFin = model.getFechaFin();
            String flyer = model.getFlyer();
            long idCategoria = model.getIdCategoria() ;
            pm.getDb(). execSQL("INSERT INTO " + ConstantesGlobales.OFERTA
                            + " (" + ConstantesGlobales.OFERTA_ID + "," + ConstantesGlobales.OFERTA_PRECIO + ","
                            + ConstantesGlobales.OFERTA_FECHA_INICIO + "," + ConstantesGlobales.OFERTA_FECHA_FIN + ","
                            + ConstantesGlobales.OFERTA_FLYER + "," + ConstantesGlobales.OFERTA_ID_CATEGORIA + ") "
                            + "VALUES("
                            + id + ", " + precio + ", \'" + fechaInicio + "\', \'" + fechaFin + "\', \'" + flyer + "\', " + idCategoria + ")"
            );
            System.out.println( " << Oferta[id ="+ id +"] was saved >> ") ;
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
