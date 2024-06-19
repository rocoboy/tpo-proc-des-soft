package com.uade.hotel.models;

public class DetalleCliente {
    public String nombre;
    public String apellido;
    public Integer dni;

    public DetalleCliente(String nombre, String apellido, Integer dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
}
