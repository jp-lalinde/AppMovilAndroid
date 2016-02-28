package com.example.peter.appandroid_n1.Models;

/**
 * Created by peter on 26/02/2016.
 */
public class ClienteModel {

    //Atributos
    private int noId;
    private String authToken;
    private boolean logged;

    //Constructor
    public ClienteModel(int pId, String pToken, boolean pLogged)
    {
        noId = pId;
        authToken = pToken;
        logged = pLogged;
    }

    //Metodos

    public int getId()
    {
        return noId;
    }

    public void setId(int pId)
    {
        noId = pId;
    }

    public String getAuthToken()
    {
        return authToken;
    }

    public void setAuthToken(String pToken)
    {
        authToken=pToken;
    }

    public boolean isLogged()
    {
        return logged;
    }

    public void setLogged(boolean pLogged)
    {
        logged=pLogged;
    }
}
