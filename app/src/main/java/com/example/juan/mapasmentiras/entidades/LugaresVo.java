package com.example.juan.mapasmentiras.entidades;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class LugaresVo implements Serializable {

    private String nombre;
    private String descripcionCorta;
    private String descripcionLarga;
    private String Ubicacion;
    private int imagen;

    public LugaresVo(String nombre, String descripcionCorta, String descripcionLarga, String ubicacion, int imagen) {
        this.nombre = nombre;
        this.descripcionCorta = descripcionCorta;
        this.descripcionLarga = descripcionLarga;
        Ubicacion = ubicacion;
        this.imagen = imagen;
    }

    public LugaresVo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    public String getDescripcionLarga() {
        return descripcionLarga;
    }

    public void setDescripcionLarga(String descripcionLarga) {
        this.descripcionLarga = descripcionLarga;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
