package com.uade.hotel.models;

import java.util.ArrayList;
import java.util.List;

import com.uade.hotel.observers.ObservadorReserva;

public class Cliente {

    public int idCliente;
    public String nombre;
    public String apellido;
    public int dni;
    public String preferenciaContacto;
    public String email;
    public String telefono;

    private List<ObservadorReserva> observadoresReservas;

    public Cliente(int idCliente, String nombre, String apellido, int dni, String preferenciacontacto,
            String email, String telefono) {

        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.preferenciaContacto = preferenciacontacto;
        this.email = email;
        this.telefono = telefono;

        this.observadoresReservas = new ArrayList<>();
    }

    public ObservadorReserva agregarObservador(int idReserva) {
        if (obtenerObservador(idReserva) == null) {
            this.observadoresReservas.add(new ObservadorReserva(idReserva, nombre));
            return obtenerObservador(idReserva);
        } else {
            System.out.println("ya existe el observador para la reserva");
        }
        return null;
    }

    public ObservadorReserva obtenerObservador(int idReserva) {
        for (ObservadorReserva observadorReserva : observadoresReservas) {
            if (observadorReserva.obtenerIdReserva() == idReserva) {
                return observadorReserva;
            }
        }
        return null;
    }

}
