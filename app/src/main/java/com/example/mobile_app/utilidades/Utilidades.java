package com.example.mobile_app.utilidades;

public class Utilidades {

    //Constantes campos tabla usuario
    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_IDU="id_usuario";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_APELLIDO="apellido";
    public static final String CAMPO_TELEFONO="telefono";

    //constantes de tabla empleado
    public static final String TABLA_EMPLEADO="empleado";
    public static final String CAMPO_ID_EMPLEADO="id_empleado";
    public static final String CAMPO_USR="usr";
    public static final String CAMPO_PASSWORD="password";
    public static final String CAMPO_IDUE="usuario_id";

    //Constantes de la tabla suscripcion
    public static final String TABLA_SUSCRIPCION="suscripcion";
    public static final String CAMPO_SUSCRIPCION="id_suscripcion";
    public static final String CAMPO_FECHA_INICIO="fecha_inicio";
    public static final String CAMPO_FECHA_FINAL="fecha_final";
    public static final String CAMPO_ESTADO_SUSCRIPCION="estado_suscripcion";
    public static final String CAMPO_CELDA_ID="celda_id";

    //constantes de tabla cliente
    public static final String TABLA_CLIENTE="cliente";
    public static final String CAMPO_ID_CLIENTE="id_cliente";
    public static final String CAMPO_CORREO="correo";
    public static final String CAMPO_IDUC="usuario_id";
    public static final String CAMPO_SUSCRIPCION_IDC="suscripcion_id";

    //Constantes campos tabla vehiculo
    public static final String TABLA_VEHICULO="vehiculo";
    public static final String CAMPO_ID_PLACA="id_placa";
    public static final String CAMPO_MODELO="modelo";
    public static final String CAMPO_MARCA="marca";
    public static final String CAMPO_COLOR="color";
    public static final String CAMPO_IDC="cliente_id";

    //constantes de tabla celda
    public static final String TABLA_CELDA="celda";
    public static final String CAMPO_CELDA="id_celda";
    public static final String CAMPO_UBICACION="ubicacion";
    public static final String CAMPO_ESTADO="estado";
    public static final String CAMPO_PLACAC="placa_id";

    //Constantes de la tabla factura
    public static final String TABLA_FACTURA="factura";
    public static final String CAMPO_FACTURA="id_factura";
    public static final String CAMPO_FECHA_FACTURA="fecha_factura";
    public static final String CAMPO_VALOR="valor";
    public static final String CAMPO_MESES="meses";
    public static final String CAMPO_SUSCRIPCION_IDF="suscripcion_id";

    //constantes de tabla registro
    public static final String TABLA_REGISTRO="registro";
    public static final String CAMPO_ID_REGISTRO="id_registro";
    public static final String CAMPO_FECHA_HORA="fecha_hora";
    public static final String CAMPO_MOVIMIENTO="movimiento";
    public static final String CAMPO_NOVEDAD="novedad";
    public static final String CAMPO_PLACAR="placa_id";

    //Creación de la tabla usuario
    public static  final String CREAR_TABLA_USUARIO="CREATE TABLE "+TABLA_USUARIO+" ("+CAMPO_IDU+" INTEGER PRIMARY KEY, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_APELLIDO+" TEXT, "+CAMPO_TELEFONO+" TEXT)";

    // Creación de la tabla empleado
    public static final String CREAR_TABLA_EMPLEADO=
            "CREATE TABLE "+TABLA_EMPLEADO+" ("+CAMPO_ID_EMPLEADO+" INTEGER PRIMARY KEY , "+CAMPO_USR+" TEXT, "+CAMPO_PASSWORD+" TEXT, "+CAMPO_IDUE+" INTEGER, FOREIGN KEY("+CAMPO_IDUE+" ) REFERENCES  "+TABLA_USUARIO+" ("+CAMPO_IDU+"))";

    //Creación de la tabla suscripcion
    public static final String CREAR_TABLA_SUSCRIPCION=
            "CREATE TABLE "+TABLA_SUSCRIPCION+" ("+CAMPO_SUSCRIPCION+" INTEGER PRIMARY KEY, "+CAMPO_FECHA_INICIO+" TEXT, "+CAMPO_FECHA_FINAL+" TEXT, "+CAMPO_ESTADO_SUSCRIPCION+" INTEGER, "+CAMPO_CELDA_ID+" INTEGER, "+" FOREIGN KEY ("+CAMPO_CELDA_ID+") REFERENCES "+TABLA_CELDA+" ( "+CAMPO_CELDA+"))";

    //Creación de la tabla cliente
    public static final String CREAR_TABLA_CLIENTE=
            "CREATE TABLE "+TABLA_CLIENTE+" ("+CAMPO_ID_CLIENTE+" INTEGER PRIMARY KEY UNIQUE, "+CAMPO_CORREO+" TEXT, "+CAMPO_IDUC+" INTEGER, "+CAMPO_SUSCRIPCION_IDC+" INTEGER, "+" FOREIGN KEY ( "+CAMPO_IDUC+" ) REFERENCES "+TABLA_USUARIO+" ("+CAMPO_IDU+"), "+" FOREIGN KEY ("+CAMPO_SUSCRIPCION_IDC+" ) REFERENCES "+TABLA_SUSCRIPCION+" ("+CAMPO_SUSCRIPCION+"))";

    //Creación de la tabla vehiculo
    public static  final String CREAR_TABLA_VEHICULO=
            "CREATE TABLE "+TABLA_VEHICULO+" ("+CAMPO_ID_PLACA+" TEXT PRIMARY KEY UNIQUE, "+CAMPO_MODELO+" TEXT, "+CAMPO_MARCA+" TEXT, "+
                    CAMPO_COLOR+" TEXT, "+CAMPO_IDC+" INTEGER, FOREIGN KEY ( "+CAMPO_IDC+") REFERENCES "+TABLA_CLIENTE+" ("+CAMPO_ID_CLIENTE+"))";

    //Creación de la tabla celda
    public static final String CREAR_TABLA_CELDA=
            "CREATE TABLE "+TABLA_CELDA+" ("+CAMPO_CELDA+" INTEGER PRIMARY KEY, "+CAMPO_UBICACION+" TEXT, "+CAMPO_ESTADO+" INTEGER, "+CAMPO_PLACAC+" TEXT, FOREIGN KEY ("+CAMPO_PLACAC+" ) REFERENCES "+TABLA_VEHICULO+" ("+CAMPO_ID_PLACA+"))";

    //Creación de la tabla factura
    public static final String CREAR_TABLA_FACTURA=
            "CREATE TABLE "+TABLA_FACTURA+" ("+CAMPO_FACTURA+" INTEGER PRIMARY KEY, "+CAMPO_FECHA_FACTURA+" TEXT, "+CAMPO_VALOR+" INTEGER, "+CAMPO_MESES+" INTEGER, "+CAMPO_SUSCRIPCION_IDF+" INTEGER,  "+" FOREIGN KEY ("+CAMPO_SUSCRIPCION_IDF+") REFERENCES "+TABLA_SUSCRIPCION+" ( "+CAMPO_SUSCRIPCION+"))";

    //Creación de la tabla registro
    public static final String CREAR_TABLA_REGISTRO =
            "CREATE TABLE "+TABLA_REGISTRO+" ("+CAMPO_ID_REGISTRO+" INTEGER PRIMARY KEY, "+CAMPO_FECHA_HORA+" TEXT, "+CAMPO_MOVIMIENTO+" TEXT, "+CAMPO_NOVEDAD+" TEXT, "+CAMPO_PLACAR+" TEXT, FOREIGN KEY ("+CAMPO_PLACAR+" ) REFERENCES  "+TABLA_VEHICULO+" ("+CAMPO_ID_PLACA+"))";


}
