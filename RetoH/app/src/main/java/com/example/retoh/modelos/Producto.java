package com.example.retoh.modelos;

public class Producto {
    private int id;
    private byte[] image;
    private String titulo;
    private String description;

    public Producto(int id, String titulo, String description, byte[] image) {
        this.id = id;
        this.image = image;
        this.titulo = titulo;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
