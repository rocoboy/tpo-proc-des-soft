package com.uade.hotel.controllers;

import java.util.ArrayList;
import java.util.List;

import com.uade.hotel.models.DetalleCliente;
import com.uade.hotel.models.Reserva;
import com.uade.hotel.states.estadoReserva.ReservaStateCancelada;
import com.uade.hotel.states.estadoReserva.ReservaStatePagada;

public class ReservaController {

    List<Reserva> reservas;

    public ReservaController() {
        this.reservas = new ArrayList<>();
    }

    public void reservarHabitacion(int idHabitacion, int idCliente, java.util.Date checkIn, java.util.Date checkOut,
            List<DetalleCliente> clientesReserva, String medioDePago) {

        Reserva nuevaReserva = new Reserva(idHabitacion, idCliente, idHabitacion, checkIn, checkOut, clientesReserva,
                medioDePago);
        reservas.add(nuevaReserva);

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
}
