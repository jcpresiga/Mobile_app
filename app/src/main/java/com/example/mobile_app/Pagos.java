package com.example.mobile_app;

import java.io.Serializable;

//Instancia para las vistas de las listas de celdas

public class Pagos implements Serializable {

    private Integer id_suscripcion;
    private String fecha_final;

    //Se define el constructor
    public Pagos() {}
    public Pagos(Integer id_suscripcion, String fecha_final) {
        this.id_suscripcion = id_suscripcion;
        this.fecha_final = fecha_final;
    }

    //Getter y Setter
    public Integer getId_suscripcion() {
        return id_suscripcion;
    }
    public void setId_suscripcion(Integer id_suscripcion) {
        this.id_suscripcion = id_suscripcion;
    }
    public String getFecha_final() {
        return fecha_final;
    }
    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }


}
