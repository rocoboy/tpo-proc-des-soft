package com.uade.hotel.models;

import java.util.ArrayList;
import java.util.List;

import com.uade.hotel.observers.IObservador;

public class Cliente {

    public Integer idCliente;
    public String nombre;
    public String apellido;
    public String dni;
    public String preferenciaContacto;
    public String email;
    public String telefono;

    private List<IObservador> reservas;

    public Cliente(Integer idCliente, String nombre, String apellido, String dni, String preferenciacontacto,
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
