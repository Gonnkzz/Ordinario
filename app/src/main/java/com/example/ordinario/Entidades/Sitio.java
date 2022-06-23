package com.example.ordinario.Entidades;

public class Sitio {
    private String nombre;
    private String descripcion;
    private int imagenId;

    public Sitio(String nombre, String descripcion, int imagenId) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenId = imagenId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
