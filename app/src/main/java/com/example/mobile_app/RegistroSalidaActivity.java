package com.example.mobile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroSalidaActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnsaregresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_salida);

        btnsaregresar = findViewById(R.id.btnceregresar);

        btnsaregresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnsaregresar:
                Intent i = new Intent(RegistroSalidaActivity.this,MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}