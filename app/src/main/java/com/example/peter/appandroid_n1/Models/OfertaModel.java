package com.example.peter.appandroid_n1.Models;



/**
 * Created by peter on 26/02/2016.
 */
public class OfertaModel {

    //----------------------------------------------------------------------------------------------------------------------
    //Atributos
    //----------------------------------------------------------------------------------------------------------------------

    long id;
    double precio;
    String fecha_inicio;
    String fecha_final;
    int tickets_disponibles;
    boolean abierta;
    int numInteresados;
    String flyer;
    long categoriaId;


    //----------------------------------------------------------------------------------------------------------------------

    //Constructor
    //----------------------------------------------------------------------------------------------------------------------
    public OfertaModel(long pId, double pPrecio, String pFechaInicio, String pFechaFin, String pFlyer, long pId_categoria)
    {
        id = pId;
        precio = pPrecio;
        fecha_inicio = pFechaInicio;
        fecha_final = pFechaFin;
        categoriaId=pId_categoria;
        flyer=pFlyer;
    }


    public OfertaModel(){ }

    //----------------------------------------------------------------------------------------------------------------------
    //Metodos
    //----------------------------------------------------------------------------------------------------------------------

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
        return fecha_inicio;
    }

    public void setFechaInicio(String pFechaInicio)
    {
        fecha_inicio = pFechaInicio;
    }

    public String getFechaFin()
    {
        return fecha_final;
    }

    public void setFechaFin(String pFechaFin)
    {
        fecha_final = pFechaFin;
    }

    public String getFlyer()
    {
        return flyer;
    }

    public void setFlyer(String pFlyer)
    {
        flyer =  pFlyer ;

    }


    public long getIdCategoria()
    {
        return categoriaId;
    }

    public void setIdCategoria(long pIdCategoria)
    {
        categoriaId=pIdCategoria;
    }


}
