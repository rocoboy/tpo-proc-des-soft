package com.uade.hotel.models;

import java.util.Date;
import java.time.LocalDateTime;
import java.util.List;

import com.uade.hotel.observers.ObservadorReserva;
import com.uade.hotel.states.estadoReserva.ContextoReserva;
import com.uade.hotel.states.estadoReserva.IReservaState;
import com.uade.hotel.states.estadoReserva.ReservaStatePendiente;

public class Reserva {

    public int idReserva;
    public int idCliente;
    public int idHabitacion;
    public Date checkIn;
    public Date checkOut;
    public LocalDateTime fechaReserva;
    public List<DetalleCliente> huespedes;
    public String medioDePago;
    public Float montoReserva;

    // estado
    public ContextoReserva estadoReserva;

    public Reserva(int idReserva, int idCliente, int idHabitacion, java.util.Date checkIn, java.util.Date checkOut,
            List<DetalleCliente> huespedes,
            String medioDePago, Float montoReserva) {

        this.idReserva = idReserva;
        this.idCliente = idCliente;
        this.idHabitacion = idHabitacion;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.huespedes = huespedes;
        this.medioDePago = medioDePago;
        this.montoReserva = montoReserva;
        this.fechaReserva = LocalDateTime.now();
        this.estadoReserva = new ContextoReserva();
        estadoReserva.cambiarEstado(new ReservaStatePendiente());

    }

    public void cambiarEstadoReserva(IReservaState nuevoEstado, ObservadorReserva observador) {
        this.estadoReserva.cambiarEstado(nuevoEstado);
        // cambiamos el estado y avisamos
        observador.notificar(this, "Se cambio el estado de la reserva");
    }

    public void establecerMonto(Float montoReserva) {
        this.montoReserva = montoReserva;
    }

    public int obtenerIdHabitacion() {
        return this.idHabitacion;
    }

    public String obtenerEstado() {
        return this.estadoReserva.consultarEstado();
    }

    public String obtenerHuespedes() {
        String listaHuespedes = "";
        for (DetalleCliente detalleCliente : huespedes) {
            listaHuespedes = listaHuespedes.concat(detalleCliente.nombre);
            if (huespedes.indexOf(detalleCliente) < huespedes.size() - 1) {
                listaHuespedes = listaHuespedes.concat(", ");
            }
        }
        return listaHuespedes;
    }

    public LocalDateTime obtenerFechaReservacion() {
        return this.fechaReserva;
    }

    public void cambiarDiasReserva(LocalDateTime fechaNueva) {
        this.fechaReserva = fechaNueva;
    }

    public void imprimirReserva() {
        System.out.println("CheckIn: " + this.checkIn + " CheckOut: " + this.checkOut + " idCliente: " + this.idCliente
                + " Huespedes:  " + this.obtenerHuespedes() + " MedioPago: " + this.medioDePago + " Estado: "
                + this.obtenerEstado());
    }
}
