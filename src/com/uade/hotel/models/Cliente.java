package com.uade.hotel.models;

import java.util.List;

import com.uade.hotel.observers.IObservador;

public class Cliente {

    public int idCliente;
    public String nombre;
    public String apellido;
    public int dni;
    public String preferenciaContacto;
    public String email;
    public String telefono;

    private List<IObservador> reservas;

    public Cliente(int idCliente, String nombre, String apellido, int dni, String preferenciacontacto,
            String email, String telefono) {

        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.preferenciaContacto = preferenciacontacto;
        this.email = email;
        this.telefono = telefono;
    }
}
