package com.example.peter.appandroid_n1.Models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


/**
 * Created by peter on 26/02/2016.
 */
public class OfertaModel {

    //Atributos
    private long id;
    private double precio;
    private String fechaInicio;
    private String fechaFin;
    private Bitmap flyer;

    //Constructor
    public OfertaModel(long pId, double pPrecio, String pFechaInicio, String pFechaFin, byte[] pFlyer)
    {
        id = pId;
        precio = pPrecio;
        fechaInicio = pFechaInicio;
        fechaFin = pFechaFin;
        flyer = BitmapFactory.decodeByteArray(pFlyer, 0, pFlyer.length);
    }

    //Metodos

    public long getId()
    {
        return id;
    }

    public void setId(long pId)
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


}
