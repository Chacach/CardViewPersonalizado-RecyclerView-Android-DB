package com.chacachx.cardviewpersonalizadorecyclerview.dto;

public class listaItems {
    private String id_item, titulo, descripcion, imagen;

    public listaItems(String id_item, String titulo, String descripcion, String imagen) {
        this.id_item = id_item;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getId_item() {
        return id_item;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagen() {
        return imagen;
    }
}
