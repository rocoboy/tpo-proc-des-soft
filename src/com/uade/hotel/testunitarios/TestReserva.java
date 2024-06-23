package com.uade.hotel.testunitarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.uade.hotel.controllers.ReservaController;
import com.uade.hotel.models.DetalleCliente;

public class TestReserva {

    public void crearReserva() {

        System.out.println("");
        System.out.println(
                "001 ---- Creamos una reserva del usuario cuyo id es 1, y agregamos a juan y pagamos en efectivo, ademas se reserva por 5 dias: ");
        ReservaController reservaController = new ReservaController();
        DetalleCliente detalleCliente = new DetalleCliente("Juan", "Perez", 123456);
        List<DetalleCliente> listaClientes = new ArrayList<>();
        listaClientes.add(detalleCliente);

        @SuppressWarnings("deprecation")
        Date checkIn = new Date(124, 2, 22);
        @SuppressWarnings("deprecation")
        Date checkOut = new Date(124, 2, 22);

        Float montoReserva = 22.49f;
        reservaController.reservarHabitacion(1, 1, checkIn, checkOut, listaClientes, "Efectivo", montoReserva);
        reservaController.mostrarReservas();

    }

    public void cancelarReserva() {
        System.out.println("");
        System.out.println(
                "002 ---- Creamos una reserva del usuario cuyo id es 1, y agregamos a juan y pagamos en efectivo, ademas se reserva por 5 dias y luego la cancelamos");
        ReservaController reservaController = new ReservaController();
        DetalleCliente detalleCliente = new DetalleCliente("Juan", "Perez", 123456);
        List<DetalleCliente> listaClientes = new ArrayList<>();
        listaClientes.add(detalleCliente);

        @SuppressWarnings("deprecation")
        Date checkIn = new Date(124, 2, 22);
        @SuppressWarnings("deprecation")
        Date checkOut = new Date(124, 2, 22);

        Float montoReserva = 22.49f;
        reservaController.reservarHabitacion(1, 1, checkIn, checkOut, listaClientes, "Efectivo", montoReserva);
        reservaController.mostrarReservas();

        System.out.println("Cancelamos la reserva con id 1");
        reservaController.cancelarReserva(1);
        reservaController.mostrarReservas();
    }

    public void pagarReserva() {
        System.out.println("");
        System.out.println(
                "003 ---- Creamos una reserva del usuario cuyo id es 1, y agregamos a juan y pagamos en efectivo, ademas se reserva por 5 dias y luego la pagamos");
        ReservaController reservaController = new ReservaController();
        DetalleCliente detalleCliente = new DetalleCliente("Juan", "Perez", 123456);
        List<DetalleCliente> listaClientes = new ArrayList<>();
        listaClientes.add(detalleCliente);

        @SuppressWarnings("deprecation")
        Date checkIn = new Date(124, 2, 22);
        @SuppressWarnings("deprecation")
        Date checkOut = new Date(124, 2, 22);

        Float montoReserva = 22.49f;
        reservaController.reservarHabitacion(1, 1, checkIn, checkOut, listaClientes, "Efectivo", montoReserva);
        reservaController.mostrarReservas();

        System.out.println("Cancelamos la reserva con id 1");
        reservaController.pagarReserva(1);
        reservaController.mostrarReservas();
    }

    public void cancelarPorFaltaDePago() {
        // crear test
    }
}
