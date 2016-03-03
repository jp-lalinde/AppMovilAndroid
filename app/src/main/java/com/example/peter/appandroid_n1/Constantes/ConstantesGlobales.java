package com.example.peter.appandroid_n1.Constantes;

/**
 * Created by ASUS on 1/03/2016.
 */
public class ConstantesGlobales {

    //URL de servidor Heroku
    public static final String URL_SERVER="http://ofertas-api-rest.herokuapp.com/api/";

    //Nombre de tabla oferta
    public static final String OFERTA="OFERTA";

    //Columnas de la tabla Oferta
    public static final String OFERTA_ID="id";
    public static final String OFERTA_PRECIO="precio";
    public static final String OFERTA_FECHA_INICIO="fecha_inicio";
    public static final String OFERTA_FECHA_FIN="fecha_final";
    public static final String OFERTA_FLYER="flyer";
    public static final String OFERTA_ID_CATEGORIA="id_categoria";

    //Nombre de tabla categoria
    public static final String CATEGORIA="CATEGORIA";

    //Columnas de la tabla Categoria
    public static final String CATEGORIA_ID="id";
    public static final String CATEGORIA_NOMBRE="nombre";

    //Categorias manejadas
    public static final long CATEGORIA_SALUD=0;
    public static final long CATEGORIA_DIVERSION=1;
    public static final long CATEGORIA_ELECTRODOMESTICOS=2;
    public static final long CATEGORIA_MERCADO=3;
    public static final long CATEGORIA_RESTAURANTES=4;

    //Nombre de la tabla cliente
    public static final String CLIENTE ="CLIENTE";

    //Columnas de la tabla cliente
    public static final String CLIENTE_ID="no_id";
    public static final String CLIENTE_AUTH_TOKEN="auth_token";
    public static final String CLIENTE_LOGGED="logged";

    //Telefono Twilio
    public static final String TWILIO_PHONE="12036017650";

}
