package com.uade.hotel.testunitarios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.uade.hotel.controllers.ClienteController;
import com.uade.hotel.controllers.FacturacionController;
import com.uade.hotel.controllers.ReservaController;
import com.uade.hotel.models.DetalleCliente;
import com.uade.hotel.models.ReglaPrecio;
import com.uade.hotel.observers.ObservadorReserva;
import com.uade.hotel.states.estadoReserva.ReservaStatePagada;

public class TestFacturacion {

    public void realizarPago() {
        System.out.println("");
        System.out.println("001 ---- Creamos una factura: ");

        // creamos la reserva
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

        // le registramos un observador nuevo al cliente de la reserva y lo registramos
        // al sujeto de la reserva
        ClienteController clienteController = new ClienteController();
        clienteController.cargarCliente("Juan", "Perez", 1234567, "Email", "pepe@gmail.com", "11-2345-6789");
        clienteController.mostrarClientes();
        ObservadorReserva observadorReserva = clienteController.setearObserverCliente(1234567, 1);
        System.out.println("holis");

        reservaController.obtenerSujetoReserva(1).register(observadorReserva);

        // ya tenemos cliente y reserva creamos la factura
        FacturacionController facturacionController = new FacturacionController();
        ReglaPrecio reglaPrecio = new ReglaPrecio(1, 2, 3, 0.7f);
        if (facturacionController.generarFactura(1, 1, "MercadoPago", reglaPrecio)) {
            reservaController.obtenerReserva(1).cambiarEstadoReserva(new ReservaStatePagada());
        }
    }

    public void cambiarValorPromo() {
        //
    }
}
