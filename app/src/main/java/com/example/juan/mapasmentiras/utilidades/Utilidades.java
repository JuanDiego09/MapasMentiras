package com.example.juan.mapasmentiras.utilidades;

public class Utilidades {

    public static final String TABLA_SITIOS = "sitios";
    public static final String SITIOS_IMAGEN = "imagen";
    public static final String SITIOS_NOMBRE = "nombre";
    public static final String SITIOS_DESCRIPCION = "descripcion";
    public static final String SITIOS_UBIBACION = "ubicacion";
    public static final String SITIOS_LONGITUD = "longitud";
    public static final String SITIOS_LACTITUD = "lactitud";
    public static final String CREAR_TABLA_SITIOS = "CREATE TABLE "
            + TABLA_SITIOS
            + (SITIOS_IMAGEN + " VARCHAR, "
            + SITIOS_NOMBRE + "VARCHAR, "
            + SITIOS_DESCRIPCION + " VARCHAR, "
            + SITIOS_UBIBACION + " VARCHAR, "
            + SITIOS_LONGITUD + " VARCHAR, "
            + SITIOS_LACTITUD + " VARCHAR)");


    public static final String TABLA_HOTELES = "hoteles";
    public static final String HOTELES_IMAGEN = "imagen";
    public static final String HOTELES_NOMBRE = "nombre";
    public static final String HOTELES_DESCRIPCION = "descripcion";
    public static final String HOTELES_UBIBACION = "ubicacion";
    public static final String HOTELES_LONGITUD = "longitud";
    public static final String HOTELES_LACTITUD = "lactitud";
    public static final String CREAR_TABLA_HOTELES = "CREATE TABLE "
            + TABLA_HOTELES
            + (HOTELES_IMAGEN + " VARCHAR, "
            + HOTELES_NOMBRE + "VARCHAR, "
            + HOTELES_DESCRIPCION + " VARCHAR, "
            + HOTELES_UBIBACION + " VARCHAR, "
            + HOTELES_LONGITUD + " VARCHAR, "
            + HOTELES_LACTITUD + " VARCHAR)");



    public static final String TABLA_RESTAURANTES = "restaurantes";
    public static final String RESTAURANTES_IMAGEN = "imagen";
    public static final String RESTAURANTES_NOMBRE = "nombre";
    public static final String RESTAURANTES_DESCRIPCION = "descripcion";
    public static final String RESTAURANTES_UBIBACION = "ubicacion";
    public static final String RESTAURANTES_LONGITUD = "longitud";
    public static final String RESTAURANTES_LACTITUD = "lactitud";
    public static final String CREAR_TABLA_RESTAURANTES = "CREATE TABLE "
            + TABLA_RESTAURANTES
            + (RESTAURANTES_IMAGEN + " VARCHAR, "
            + RESTAURANTES_NOMBRE + "VARCHAR, "
            + RESTAURANTES_DESCRIPCION + " VARCHAR, "
            + RESTAURANTES_UBIBACION + " VARCHAR, "
            + RESTAURANTES_LONGITUD + " VARCHAR, "
            + RESTAURANTES_LACTITUD + " VARCHAR)");

}
