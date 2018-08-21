package com.example.juan.mapasmentiras.utilidades;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexion extends SQLiteOpenHelper {
    public Conexion(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_SITIOS);
        db.execSQL(Utilidades.CREAR_TABLA_HOTELES);
        db.execSQL(Utilidades.CREAR_TABLA_RESTAURANTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.TABLA_SITIOS );
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.TABLA_HOTELES );
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.TABLA_RESTAURANTES );
    }
}
