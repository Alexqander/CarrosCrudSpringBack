package com.mx.sda.carroscrudspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class CocheDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "La marca es obligatoria")

    private String marca;
    @NotBlank(message = "El modelo es obligatoria")
    private String modelo;
    @NotNull(message = "El estado es obligatorio")
    private Boolean activo;
    @NotNull(message = "El precio es obligatoria")
    private Integer precio;
    @NotBlank(message = "El color es obligatoria")
    private String color;
    @NotNull(message = "El año es obligatoria")
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
