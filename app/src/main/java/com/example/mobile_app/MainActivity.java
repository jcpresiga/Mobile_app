package com.example.mobile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnentrada, btnsalida, btnceldas, btnpagos, btnusuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnentrada = (Button) findViewById(R.id.btnentrada);
        btnsalida = (Button) findViewById(R.id.btnsalida);
        btnceldas = (Button) findViewById(R.id.btnceldas);
        btnpagos = (Button) findViewById(R.id.btnpagos);
        btnusuarios = (Button) findViewById(R.id.btnusuarios);

        btnentrada.setOnClickListener(this);
        btnsalida.setOnClickListener(this);
        btnceldas.setOnClickListener(this);
        btnpagos.setOnClickListener(this);
        btnusuarios.setOnClickListener(this);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_parqueadero",null,1);
    }


    public void onClick(View view) {
        Intent miIntent=null;
        switch (view.getId()){
            case R.id.btnentrada:
                miIntent=new Intent(MainActivity.this,RegistroEntradaActivity.class);
                break;
            case R.id.btnsalida:
                miIntent=new Intent(MainActivity.this,RegistroSalidaActivity.class);
                break;
            case R.id.btnceldas:
                miIntent=new Intent(MainActivity.this,RegistroCeldasActivity.class);
                break;
            case R.id.btnpagos:
                miIntent=new Intent(MainActivity.this,RegistroPagosActivity.class);
                break;
            case R.id.btnusuarios:
                miIntent=new Intent(MainActivity.this,RegistroUsuariosActivity.class);
                break;
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }

    }
}