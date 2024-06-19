package com.uade.hotel.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.uade.hotel.observers.IObservador;
import com.uade.hotel.observers.ISujeto;
import com.uade.hotel.observers.Sujeto;

public class Reserva {

    public Integer idReserva;
    public Integer idCliente;
    public Date checkIn;
    public Date checkOut;
    public List<DetalleCliente> huespedes;
    public String medioDePago;

    // falta agregar estado a la reserva
    private ISujeto sujeto;
    private List<IObservador> observadores = new ArrayList<>();

    public Reserva(Integer idReserva, Integer idCliente, Date checkIn, Date checkOut, List<DetalleCliente> huespedes,
            String medioDePago) {

        this.idReserva = idReserva;
        this.idCliente = idCliente;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.huespedes = huespedes;
        this.medioDePago = medioDePago;

        this.sujeto = new Sujeto();
    }

    public void setObserver(IObservador observador) {
        observador.setSubject(this.sujeto);
        observadores.add(observador);
    }

    // agregar funciones de estado
}
