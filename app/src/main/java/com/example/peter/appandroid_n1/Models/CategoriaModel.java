package com.example.peter.appandroid_n1.Models;

/**
 * Created by peter on 26/02/2016.
 */
public class CategoriaModel {

    //Atributos
    private int id;
    private String nombre;

    //Constructor
    public CategoriaModel(int pId, String pNombre)
    {
        id = pId;
        nombre = pNombre;
    }

    //Metodos
    public int getId()
    {
        return id;
    }

    public void setId(int pId)
    {
        id = pId;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String pNombre)
    {
        nombre = pNombre;
    }
}