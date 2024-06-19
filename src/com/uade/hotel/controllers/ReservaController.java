package com.uade.hotel.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.uade.hotel.models.DetalleCliente;
import com.uade.hotel.models.Reserva;
import com.uade.hotel.models.ValoresReserva;

public class ReservaController {

    List<Reserva> reservas;
    List<ValoresReserva> valoresReservas;

    public ReservaController() {
        this.reservas = new ArrayList<>();
        this.valoresReservas = new ArrayList<>();

        valoresReservas.add(new ValoresReserva(0, 15, 0.85));
        valoresReservas.add(new ValoresReserva(30, null, 1.2));
    }

    public void reservarHabitacion(Integer idHabitacion, Integer idCliente, Date checkOut, Date checkIn,
            List<DetalleCliente> clientes, String medioDePago) {

        Reserva nuevaReserva = new Reserva(idHabitacion, idCliente, checkIn, checkOut, clientes, medioDePago);
        reservas.add(nuevaReserva);

        // tengo que agregar los observers
    }

    public void cambiarValorReserva(Integer idValorReserva, Integer diasMinimos, Integer diasMaximos,
            double porcentajeFinal) {

        valoresReservas.set(idValorReserva, new ValoresReserva(diasMinimos, diasMaximos, porcentajeFinal));
    }

    public void agregarValorReserva(Integer diasMinimos, Integer diasMaximos,
            double porcentajeFinal) {
        valoresReservas.add(new ValoresReserva(diasMinimos, diasMaximos, porcentajeFinal));
    }

}
