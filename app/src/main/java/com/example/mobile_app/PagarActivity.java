package com.example.mobile_app;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobile_app.utilidades.Utilidades;

import java.io.Serializable;
import java.util.Calendar;

public class PagarActivity extends AppCompatActivity implements View.OnClickListener{

    EditText campoValor, campoMeses;
    Integer meses;
    Button btnRegresar, btnPagar;
    ConexionSQLiteHelper conn;
    String campoIdCliente, campoPlaca, campoCelda;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar);

        //Traer dato del activity Gestion pagos
        campoIdCliente = getIntent().getStringExtra("dato");


        //Enlazar la vista con el botón
        btnPagar= findViewById(R.id.btnPagar);
        btnRegresar= findViewById(R.id.btnRegresar);
        campoValor= findViewById(R.id.campoValor);
        campoMeses= findViewById(R.id.campoMeses);

        //Detección de la presión del botón
        btnPagar.setOnClickListener(this);
        btnRegresar.setOnClickListener(this);

        conn= new ConexionSQLiteHelper(getApplicationContext(), "parqueadero_db", null, 1);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnPagar:
                pagar();
                break;
            case R.id.btnRegresar:
                Intent i = new Intent(PagarActivity.this,GestionPagosActivity.class);
                startActivity(i);
                finish();
        }

    }
    public void pagar(){

        SQLiteDatabase db=conn.getWritableDatabase();

        //Confirmar placa de vehiculo
        String[] parametro2= new String[]{campoIdCliente};
        String[] campos2=new String[]{Utilidades.CAMPO_ID_PLACA};
        try{
            Cursor cursor= db.query(Utilidades.TABLA_VEHICULO, campos2,Utilidades.CAMPO_IDC+"=?", parametro2,null,null,null);
            cursor.moveToFirst();
            campoPlaca=cursor.getString(0);
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "El id no existe", Toast.LENGTH_SHORT).show();

        }

        //Confirmar número de celda
        String[] parametro3= new String[]{campoPlaca};
        String[] campos3=new String[]{Utilidades.CAMPO_CELDA};
        try{
            Cursor cursor= db.query(Utilidades.TABLA_CELDA, campos3,Utilidades.CAMPO_PLACAC+"=?", parametro3,null,null,null);
            cursor.moveToFirst();
            campoCelda=cursor.getString(0);
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "La celda no existe", Toast.LENGTH_SHORT).show();

        }

        //Habilitar la suscripción,
        String[] parametros ={campoIdCliente};
        ContentValues values = new ContentValues();
        Calendar today= Calendar.getInstance();
        values.put(Utilidades.CAMPO_FECHA_INICIO, today.getTime().toString());
        meses= Integer.parseInt(campoMeses.getText().toString());
        today.add(Calendar.MONTH,meses );
        values.put(Utilidades.CAMPO_FECHA_FINAL, today.getTime().toString());
        values.put(Utilidades.CAMPO_ESTADO_SUSCRIPCION, "1");
        values.put(Utilidades.CAMPO_CELDA_ID, campoCelda);
        db.update(Utilidades.TABLA_SUSCRIPCION, values, Utilidades.CAMPO_SUSCRIPCION+"=?", parametros );

        //creación de la factura
        ContentValues values1 =new ContentValues();
        Calendar now= Calendar.getInstance();
        values1.put(Utilidades.CAMPO_FECHA_FACTURA, now.getTime().toString());
        values1.put(Utilidades.CAMPO_VALOR, campoValor.getText().toString());
        values1.put(Utilidades.CAMPO_MESES, campoMeses.getText().toString());
        values1.put(Utilidades.CAMPO_SUSCRIPCION_IDF, campoIdCliente);
        Long idResultante=db.insert(Utilidades.TABLA_FACTURA, Utilidades.CAMPO_FACTURA, values1);
        Toast.makeText(getApplicationContext(), "Se ha guardado el pago ",Toast.LENGTH_LONG).show();

        limpiar();

    }

    //Método para limpiar los datos de las vistas
    public void limpiar(){
        campoValor.setText("");
        campoMeses.setText("");
    }

}
