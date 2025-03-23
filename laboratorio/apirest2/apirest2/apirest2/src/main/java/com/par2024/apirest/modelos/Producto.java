package com.par2024.apirest.modelos;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto implements Serializable{
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private long precio;
    private String descripcion;


    //Constructor vacío
    public Producto(){

    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id= id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre= nombre;
    }

    public long getPrecio(){
        return precio;
    }

    public void setPrecio(long precio){
        this.precio= precio;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion= descripcion;
    }

    public static long getSerialversionuid(){
        return serialVersionUID;
    }

}
