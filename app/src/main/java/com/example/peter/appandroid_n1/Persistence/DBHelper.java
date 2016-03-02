package com.example.peter.appandroid_n1.Persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.peter.appandroid_n1.Constantes.ConstantesGlobales;

/**
 * Created by peter on 26/02/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context){
        super(context,"myDb",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("Creo la tabla oferta");
        db.execSQL("CREATE TABLE OFERTA (id BIGINT PRIMARY KEY, precio DOUBLE, fecha_inicio DATETIME, fecha_final DATETIME, flyer STRING, id_categoria BIGINT);");
        System.out.println("Creo la tabla categoria");
        db.execSQL("CREATE TABLE CATEGORIA (id INT2 PRIMARY KEY, nombre TEXT );");
        System.out.println("Creo la tabla cliente");
        db.execSQL("CREATE TABLE CLIENTE (no_id BIGINT PRIMARY KEY, auth_token TEXT, logged BOOLEAN);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}
