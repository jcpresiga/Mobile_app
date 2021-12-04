package com.example.mobile_app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_app.Adapter.AdaptadorPagos;
import com.example.mobile_app.utilidades.Utilidades;

import java.util.ArrayList;

public class ListarPagosActivity extends AppCompatActivity {

    ArrayList<Pagos> List_Datos_Pagos;
    RecyclerView recyclerViewPagos;
    String campoIdCliente;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_pagos);

        //Traer dato del activity Gestion pagos
        campoIdCliente = getIntent().getStringExtra("dato");

        conn= new ConexionSQLiteHelper(getApplicationContext(), "parqueadero_db", null,1);
        List_Datos_Pagos=new ArrayList<>();
        recyclerViewPagos=findViewById(R.id.reciclerId);
        recyclerViewPagos.setLayoutManager(new LinearLayoutManager(this));
        consultarListaCeldas();
        AdaptadorPagos adapter=new AdaptadorPagos(List_Datos_Pagos);
        recyclerViewPagos.setAdapter(adapter);
    }
    private void consultarListaCeldas(){
        SQLiteDatabase db=conn.getReadableDatabase();
        Pagos pagos= null;

        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_SUSCRIPCION +" WHERE "+Utilidades.CAMPO_SUSCRIPCION +" = "+campoIdCliente , null);
        
        while (cursor.moveToNext()){
            pagos=new Pagos();
            pagos.setId_suscripcion(cursor.getInt(0));
            pagos.setFecha_final(cursor.getString(2));
            List_Datos_Pagos.add(pagos);
        }
        if (pagos==null){
            Toast.makeText(getApplicationContext(), "No hay pagos disponibles en el momento ", Toast.LENGTH_SHORT).show();
        }
    }

}
