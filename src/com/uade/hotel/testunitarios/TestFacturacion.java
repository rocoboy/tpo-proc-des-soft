package com.uade.hotel.testunitarios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.uade.hotel.controllers.ClienteController;
import com.uade.hotel.controllers.FacturacionController;
import com.uade.hotel.controllers.ReservaController;
import com.uade.hotel.facade.FacadeContabilidad;
import com.uade.hotel.facade.FacadeMarketing;
import com.uade.hotel.models.Cliente;
import com.uade.hotel.models.DetalleCliente;
import com.uade.hotel.models.ReglaPrecio;
import com.uade.hotel.states.estadoReserva.ReservaStatePagada;

public class TestFacturacion {

    public void realizarPago() {
        System.out.println("");
        System.out.println("001 ---- Creamos una factura: ");

        // creamos la reserva
        ReservaController reservaController = new ReservaController();
        ClienteController clienteController = new ClienteController();
        FacturacionController facturacionController = new FacturacionController();
        clienteController.cargarCliente("Juan", "Perez", 1234567, "Email", "juanperez@gmail.com", "11-2345-6789");
        DetalleCliente detalleMaria = new DetalleCliente("Maria", "Gomez", 9876543, "Email", "mariagomez",
                "11-2345-6789");
        DetalleCliente detallePedro = new DetalleCliente("Pedro", "Gonzalez", 5555555, "Email", "pedrogonzalez",
                "11-2345-6789");

        List<DetalleCliente> clientes = new ArrayList<>();
        Cliente juan = clienteController.encontrarCliente(1234567);

        clientes.add(juan.detalleCliente);
        clientes.add(detalleMaria);
        clientes.add(detallePedro);

        @SuppressWarnings("deprecation")
        Date checkIn = new Date(124, 2, 22);
        @SuppressWarnings("deprecation")
        Date checkOut = new Date(124, 2, 22);

        Float montoReserva = 22.49f;
        reservaController.reservarHabitacion(1, 1, checkIn, checkOut, clientes, "Efectivo", montoReserva);
        reservaController.getObservadorReserva().subscribir(new FacadeContabilidad());
        reservaController.getObservadorReserva().subscribir(new FacadeMarketing());

        // le registramos un observador nuevo al cliente de la reserva y lo registramos
        // al sujeto de la reserva
        reservaController.getObservadorReserva().subscribir(clienteController.encontrarCliente(1234567));
        clienteController.cargarCliente("Juan", "Perez", 1234567, "Email", "pepe@gmail.com", "11-2345-6789");

        clienteController.mostrarClientes();

        // ya tenemos cliente y reserva creamos la factura
        ReglaPrecio reglaPrecio = new ReglaPrecio(1, 2, 3, 0.7f);
        if (facturacionController.generarFactura(1, 1, "MercadoPago", reglaPrecio)) {
            reservaController.obtenerReserva(1).cambiarEstadoReserva(new ReservaStatePagada(),
                    reservaController.getObservadorReserva());
        }
    }

    public void cambiarValorPromo() {

        System.out.println("");
        System.out.println("002 ---- Cambiamos un parametro de facturacion: ");
        FacturacionController facturacionController = new FacturacionController();
        facturacionController.agregarParametroFacturacion(12, 15, 1.2f);
        facturacionController.agregarParametroFacturacion(0, 11, 0.7f);
        facturacionController.mostrarValoresReservas();
        System.out.println("");
        System.out.println("hacemos cambios en el primer parametro");
        facturacionController.cambiarParametrosFacturacion(1, 13, 18, 1.2f);
        facturacionController.mostrarValoresReservas();

    }
}
