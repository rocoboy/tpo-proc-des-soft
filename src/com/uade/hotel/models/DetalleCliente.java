package com.uade.hotel.models;

public class DetalleCliente {
    public String nombre;
    public String apellido;
    public Integer dni;
    public String preferenciaContacto;
    public String email;
    public String telefono;

    public DetalleCliente(String nombre, String apellido, Integer dni, String preferenciaContacto, String email,
            String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.preferenciaContacto = preferenciaContacto;
        this.email = email;
        this.telefono = telefono;
    }

    public void imprimirDetalleCliente() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("DNI: " + dni);
    }
}
