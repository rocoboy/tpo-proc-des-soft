package com.uade.hotel.controllers;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.uade.hotel.models.DetalleCliente;
import com.uade.hotel.models.Reserva;
import com.uade.hotel.states.estadoReserva.ReservaStateCancelada;
import com.uade.hotel.states.estadoReserva.ReservaStatePagada;
import com.uade.hotel.states.estadoReserva.ReservaStatePendiente;

public class ReservaController {

    List<Reserva> reservas;

    public ReservaController() {
        this.reservas = new ArrayList<>();
    }

    public void reservarHabitacion(int idHabitacion, int idCliente, java.util.Date checkIn, java.util.Date checkOut,
            List<DetalleCliente> clientesReserva, String medioDePago, Float montoReserva) {

        int idReserva = reservas.size() + 1;

        Reserva nuevaReserva = new Reserva(idReserva, idCliente, idHabitacion, checkIn, checkOut, clientesReserva,
                medioDePago, montoReserva);
        if (obtenerIdReserva(idHabitacion) == -1) {
            reservas.add(nuevaReserva);
        } else {
            System.out.println("no es posible reservar, ya esta reservada la habitación");
        }

        // tengo que agregar los observers
    }

    public void pagarReserva(int idReserva) {
        obtenerReserva(idReserva).cambiarEstadoReserva(new ReservaStatePagada());
    }

    public void cancelarReserva(int idReserva) {
        obtenerReserva(idReserva).cambiarEstadoReserva(new ReservaStateCancelada());
    }

    public int obtenerIdReserva(int idHabitacion) {
        for (Reserva reserva : reservas) {
            if (reserva.idHabitacion == idHabitacion) {
                return reserva.idReserva;
            }
        }
        return -1;
    }

    public Reserva obtenerReserva(int idReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.idReserva == idReserva) {
                return reserva;
            }
        }
        return null;
    }

    public void mostrarReservas() {
        for (Reserva reserva : reservas) {
            System.out.println("CheckIn: " + reserva.checkIn + " CheckOut: " + reserva.checkOut + " idCliente: "
                    + reserva.idCliente + " Huespedes:  " + reserva.obtenerHuespedes() + " MedioPago: "
                    + reserva.medioDePago + reserva.obtenerEstado());
        }
    }

    public void analizarReservasPendientes() {
        ReservaStatePendiente reservaPendiente = new ReservaStatePendiente();
        LocalDateTime fechaHoy = LocalDateTime.now();
        for (Reserva reserva : reservas) {
            int diasDesdeReservacion = (int) ChronoUnit.HOURS.between(reserva.obtenerFechaReservacion(), fechaHoy);
            if (diasDesdeReservacion > 24
                    && Objects.equals(reserva.obtenerEstado(), reservaPendiente.consultarEstado())) {
                reserva.cambiarEstadoReserva(new ReservaStateCancelada());
            }
        }
    }

}
