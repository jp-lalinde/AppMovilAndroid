package com.example.peter.appandroid_n1.Persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.peter.appandroid_n1.Constantes.ConstantesGlobales;
import com.example.peter.appandroid_n1.Models.OfertaModel;
import com.example.peter.appandroid_n1.Servicios.OfertaService;

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
        Cursor c = db.rawQuery("select * from "+ConstantesGlobales.OFERTA,null);

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
        db.execSQL("DELETE FROM " + ConstantesGlobales.OFERTA);
    }

    public void insertOferta(long id, double precio, String fechaInicio, String fechaFin, String flyer, long idCategoria)
    {
        db.execSQL("INSERT INTO" + ConstantesGlobales.OFERTA
                        + " (" + ConstantesGlobales.OFERTA_ID + "," + ConstantesGlobales.OFERTA_PRECIO + ","
                        + ConstantesGlobales.OFERTA_FECHA_INICIO + "," + ConstantesGlobales.OFERTA_FECHA_FIN + ","
                        + ConstantesGlobales.OFERTA_FLYER + ","+ConstantesGlobales.OFERTA_ID_CATEGORIA+") "
                        + "VALUES("
                        + id + ", " + precio + ", \'" + fechaInicio + "\', \'" + fechaFin + "\', \'" + flyer + "\', "+idCategoria+")"
        );
    }

    public List<OfertaModel> getOfertaPorCategoria(long idCategoria)
    {
        Cursor c = db.rawQuery("SELECT * FROM "+ConstantesGlobales.OFERTA+
                                " WHERE "+ConstantesGlobales.OFERTA_ID_CATEGORIA+
                                "="+idCategoria,null);
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
        Cursor c = db.rawQuery("SELECT * FROM "+ConstantesGlobales.OFERTA+" WHERE "+ConstantesGlobales.OFERTA_ID+"="+idOferta, null);
        OfertaModel oferta = null;
        if(c.moveToFirst())
        {
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

    //Datos mock
    public void insertarDatosMock()
    {
        System.out.println("Meto datos en la tabla de ofertas.");
        db.execSQL("INSERT INTO " + ConstantesGlobales.OFERTA
                        + " (" + ConstantesGlobales.OFERTA_ID + "," + ConstantesGlobales.OFERTA_PRECIO + ","
                        + ConstantesGlobales.OFERTA_FECHA_INICIO + "," + ConstantesGlobales.OFERTA_FECHA_FIN + ","
                        + ConstantesGlobales.OFERTA_FLYER +","+ ConstantesGlobales.OFERTA_ID_CATEGORIA+") "
                        + "VALUES("
                        + 1 + ", " + 1000 + ", \'2016/03/03\', \'2016/04/03\', \'" + ConstantesGlobales.imgMock + "\', "+0+")"
        );
    }

}
