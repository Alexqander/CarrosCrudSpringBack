package com.mx.sda.carroscrudspring.model;


public class CocheDto {

    private long id;
    private String marca;
    private String modelo;
    private Boolean activo;
    private Integer precio;
    private String color;
    private Integer anio;

    public CocheDto() {
    }

    public CocheDto(long id, String marca, String modelo, Boolean activo, Integer precio, String color, Integer anio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.activo = activo;
        this.precio = precio;
        this.color = color;
        this.anio = anio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }
}
