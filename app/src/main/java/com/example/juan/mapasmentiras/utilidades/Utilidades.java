package com.example.juan.mapasmentiras.utilidades;

public class Utilidades {

    public static final String TABLA_SITIOS = "sitios";
    public static final String SITIOS_IMAGEN = "imagen";
    public static final String SITIOS_NOMBRE = "nombre";
    public static final String SITIOS_DESCRIPCION_CORTA = "descripcioncorta";
    public static final String SITIOS_DESCRIPCION_LARGA = "descripcionlarga";
    public static final String SITIOS_UBIBACION = "ubicacion";
    public static final String SITIOS_LONGITUD = "longitud";
    public static final String SITIOS_LACTITUD = "lactitud";
    public static final String CREAR_TABLA_SITIOS = "CREATE TABLE "
            + TABLA_SITIOS
            + "( " + SITIOS_NOMBRE + " VARCHAR, "
            + SITIOS_DESCRIPCION_CORTA + " VARCHAR, "
            + SITIOS_DESCRIPCION_LARGA + " VARCHAR, "
            + SITIOS_UBIBACION + " VARCHAR )";


    public static final String TABLA_HOTELES = "hoteles";
    public static final String HOTELES_IMAGEN = "imagen";
    public static final String HOTELES_NOMBRE = "nombre";
    public static final String HOTELES_DESCRIPCION_CORTA = "descripcion_corta";
    public static final String HOTELES_DESCRIPCION_LARGA = "descripcion_larga";
    public static final String HOTELES_UBIBACION = "ubicacion";
    public static final String HOTELES_LONGITUD = "longitud";
    public static final String HOTELES_LACTITUD = "lactitud";
    public static final String CREAR_TABLA_HOTELES = "CREATE TABLE "
            + TABLA_HOTELES
            + "( " + HOTELES_IMAGEN + " INTEGER, "
            + HOTELES_NOMBRE + "VARCHAR, "
            + HOTELES_DESCRIPCION_CORTA + " VARCHAR, "
            + HOTELES_DESCRIPCION_LARGA + " VARCHAR, "
            + HOTELES_UBIBACION + " VARCHAR, "
            + HOTELES_LONGITUD + " VARCHAR, "
            + HOTELES_LACTITUD + " VARCHAR)";


    public static final String TABLA_RESTAURANTES = "restaurantes";
    public static final String RESTAURANTES_IMAGEN = "imagen";
    public static final String RESTAURANTES_NOMBRE = "nombre";
    public static final String RESTAURANTES_DESCRIPCION_CORTA = "descripcion_corta";
    public static final String RESTAURANTES_DESCRIPCION_LARGA = "descripcion_larga";
    public static final String RESTAURANTES_UBIBACION = "ubicacion";
    public static final String RESTAURANTES_LONGITUD = "longitud";
    public static final String RESTAURANTES_LACTITUD = "lactitud";
    public static final String CREAR_TABLA_RESTAURANTES = "CREATE TABLE "
            + TABLA_RESTAURANTES
            + "( " + RESTAURANTES_IMAGEN + " INTEGER, "
            + RESTAURANTES_NOMBRE + "VARCHAR, "
            + RESTAURANTES_DESCRIPCION_CORTA + " VARCHAR, "
            + RESTAURANTES_DESCRIPCION_LARGA + " VARCHAR, "
            + RESTAURANTES_UBIBACION + " VARCHAR, "
            + RESTAURANTES_LONGITUD + " VARCHAR, "
            + RESTAURANTES_LACTITUD + " VARCHAR)";

}
