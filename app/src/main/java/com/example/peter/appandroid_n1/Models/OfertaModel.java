package com.example.peter.appandroid_n1.Models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import com.strongloop.android.loopback.Model;

import java.io.ByteArrayOutputStream;


/**
 * Created by peter on 26/02/2016.
 */
public class OfertaModel extends Model{

    //Atributos
    private long id;
    private double precio;
    private String fechaInicio;
    private String fechaFin;
    private Bitmap flyer;
    private long idCategoria;

    //Constructor
    public OfertaModel(long pId, double pPrecio, String pFechaInicio, String pFechaFin, String pFlyer, long pId_categoria)
    {
        id = pId;
        precio = pPrecio;
        fechaInicio = pFechaInicio;
        fechaFin = pFechaFin;
        idCategoria=pId_categoria;

        byte[] decodedByte = Base64.decode(pFlyer, 0);
        //TODO Descomentar cuando se envíe un byte[] válido (no nulo)
        flyer = BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    //Metodos

    public long getIdOferta()
    {
        return id;
    }

    public void setIdOferta(long pId)
    {
        id = pId;
    }

    public double getPrecio()
    {
        return precio;
    }

    public void setPrecio(double pPrecio)
    {
        precio = pPrecio;
    }

    public String getFechaInicio()
    {
        return fechaInicio;
    }

    public void setFechaInicio(String pFechaInicio)
    {
        fechaInicio = pFechaInicio;
    }

    public String getFechaFin()
    {
        return fechaFin;
    }

    public void setFechaFin(String pFechaFin)
    {
        fechaFin = pFechaFin;
    }

    public Bitmap getFlyer()
    {
        return flyer;
    }

    public void setFlyer(byte[] pFlyer)
    {
        flyer = BitmapFactory.decodeByteArray(pFlyer, 0, pFlyer.length);
    }

    public String getEncodedFlyer()
    {
        Bitmap imagex= flyer;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        imagex.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b,Base64.DEFAULT);
        //Debugging
        Log.e("LOOK", imageEncoded);

        return imageEncoded;

    }

    public long getIdCategoria()
    {
        return idCategoria;
    }

    public void setIdCategoria(long pIdCategoria)
    {
        idCategoria=pIdCategoria;
    }


}
