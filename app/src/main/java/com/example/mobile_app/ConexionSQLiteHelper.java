package com.example.mobile_app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mobile_app.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    //constructor de SQLite
    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //metodos create y upgrade de SQLite
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
        db.execSQL(Utilidades.CREAR_TABLA_EMPLEADO);
        db.execSQL(Utilidades.CREAR_TABLA_CLIENTE);
        db.execSQL(Utilidades.CREAR_TABLA_VEHICULO);
        db.execSQL(Utilidades.CREAR_TABLA_CELDA);
        db.execSQL(Utilidades.CREAR_TABLA_REGISTRO);
        db.execSQL(Utilidades.CREAR_TABLA_SUSCRIPCION);
        db.execSQL(Utilidades.CREAR_TABLA_FACTURA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_REGISTRO);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_CELDA);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_CLIENTE);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_EMPLEADO);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_VEHICULO);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_SUSCRIPCION);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_FACTURA);
        onCreate(db);
    }
}
