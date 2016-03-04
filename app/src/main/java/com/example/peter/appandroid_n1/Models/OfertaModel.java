package com.example.peter.appandroid_n1.Models;



/**
 * Created by peter on 26/02/2016.
 */
public class OfertaModel {

    //----------------------------------------------------------------------------------------------------------------------
    //Atributos
<<<<<<< HEAD
    //----------------------------------------------------------------------------------------------------------------------
    long id;
    double precio;
    String fecha_inicio;
    String fecha_fin;
=======
    long id;
    double precio;
    String fecha_inicio;
    String fecha_final;
>>>>>>> origin
    int tickets_disponibles;
    boolean abierta;
    int numInteresados;
    String flyer;
    long categoriaId;

<<<<<<< HEAD
    //----------------------------------------------------------------------------------------------------------------------
=======
>>>>>>> origin
    //Constructor
    //----------------------------------------------------------------------------------------------------------------------
    public OfertaModel(long pId, double pPrecio, String pFechaInicio, String pFechaFin, String pFlyer, long pId_categoria)
    {
        id = pId;
        precio = pPrecio;
        fecha_inicio = pFechaInicio;
<<<<<<< HEAD
        fecha_fin = pFechaFin;
        categoriaId=pId_categoria;
        flyer = pFlyer ;
=======
        fecha_final = pFechaFin;
        categoriaId=pId_categoria;
        flyer=pFlyer;
    }

    public OfertaModel()
    {

>>>>>>> origin
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
<<<<<<< HEAD
        return fecha_fin;
=======
        return fecha_final;
>>>>>>> origin
    }

    public void setFechaFin(String pFechaFin)
    {
<<<<<<< HEAD
        fecha_fin = pFechaFin;
=======
        fecha_final = pFechaFin;
>>>>>>> origin
    }

    public String getFlyer()
    {
        return flyer;
    }

    public void setFlyer(String pFlyer)
    {
<<<<<<< HEAD
        flyer =  pFlyer ;
=======
        flyer = pFlyer;
>>>>>>> origin
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
