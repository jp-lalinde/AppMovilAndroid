package com.example.peter.appandroid_n1.Persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by peter on 26/02/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context){
        super(context,"myDb",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE OFERTA (id BIGINT primary key , precio DOUBLE , fecha_inicio DATETIME , fecha_final DATETIME , flyer BLOB ); " +
                        "CREATE TABLE CATEGORIA (id INT2 primary key , nombre TEXT ); " +
                        "CREATE TABLE CLIENTE ( no_id BIGINT primary key , auth_token TEXT , logged BOOLEAN ); "
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }



}
