package com.par2024.apirest.modelos;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Factura implements Serializable{
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String numero;
    private long cliente;
    private long total;

    //Constructor vacío
    public Factura(){

    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id= id;
    }

    public String getNumero(){
        return numero;
    }

    public void setNumero(String numero){
        this.numero= numero;
    }

    public long getCliente(){
        return cliente;
    }

    public void setCliente(long cliente){
        this.cliente= cliente;
    }

    public long getTotal(){
        return total;
    }

    public void setTotal(long total){
        this.total= total;
    }

    public static long getSerialversionuid(){
        return serialVersionUID;
    }

}
