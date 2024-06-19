package com.uade.hotel.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.uade.hotel.models.DetalleCliente;
import com.uade.hotel.models.Reserva;

public class ReservaController {

    List<Reserva> reservas;

    public ReservaController() {
        this.reservas = new ArrayList<>();
    }

    public void reservarHabitacion(Integer idHabitacion, Integer idCliente, Date checkOut, Date checkIn,
            List<DetalleCliente> clientes, String medioDePago) {

        Reserva nuevaReserva = new Reserva(idHabitacion, idCliente, checkIn, checkOut, clientes, medioDePago);
        reservas.add(nuevaReserva);
    }

}
