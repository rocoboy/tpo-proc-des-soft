package com.uade.hotel.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.uade.hotel.observers.IObservador;
import com.uade.hotel.observers.ISujeto;
import com.uade.hotel.observers.Sujeto;
import com.uade.hotel.states.estadoReserva.ContextoReserva;
import com.uade.hotel.states.estadoReserva.IReservaState;
import com.uade.hotel.states.estadoReserva.ReservaStatePendiente;

public class Reserva {

    public int idReserva;
    public int idCliente;
    public int idHabitacion;
    public java.util.Date checkIn;
    public java.util.Date checkOut;
    public List<DetalleCliente> huespedes;
    public String medioDePago;
    public Float montoReserva;

    // estado
    public ContextoReserva estadoReserva;

    // observers
    private ISujeto sujeto;
    private List<IObservador> observadores = new ArrayList<>();

    public Reserva(int idReserva, int idCliente, int idHabitacion, java.util.Date checkIn, java.util.Date checkOut,
            List<DetalleCliente> huespedes,
            String medioDePago) {

        this.idReserva = idReserva;
        this.idCliente = idCliente;
        this.idHabitacion = idHabitacion;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.huespedes = huespedes;
        this.medioDePago = medioDePago;

        this.sujeto = new Sujeto();

        this.estadoReserva = new ContextoReserva();
        estadoReserva.cambiarEstado(new ReservaStatePendiente());

        // se agrega un contador a la reserva para que esta pase a cancelada 24hs
        // pasadas
        // sin recibir un pago

        // se configuran los boservers y el sujeto
    }

    public void setObserver(IObservador observador) {
        observador.setSubject(this.sujeto);
        observadores.add(observador);
    }

    public void cambiarEstadoReserva(IReservaState nuevoEstado) {
        this.estadoReserva.cambiarEstado(nuevoEstado);
        // avisamos el cambio del estado
        sujeto.postMessage(this.estadoReserva.consultarEstado());
    }

    public void establecerMonto(Float montoReserva) {
        this.montoReserva = montoReserva;
    }

    public int obtenerIdHabitacion() {
        return this.idHabitacion;
    }

}
