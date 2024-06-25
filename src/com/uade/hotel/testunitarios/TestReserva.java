package com.uade.hotel.testunitarios;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.uade.hotel.controllers.ClienteController;
import com.uade.hotel.controllers.ReservaController;
import com.uade.hotel.facade.FacadeMarketing;
import com.uade.hotel.models.Cliente;
import com.uade.hotel.models.DetalleCliente;

public class TestReserva {

        public void crearReserva() {

                System.out.println("");
                System.out.println(
                                "001 ---- Creamos una reserva del usuario cuyo id es 1, y agregamos a juan y pagamos en efectivo, ademas se reserva por 5 dias: ");
                ReservaController reservaController = new ReservaController();
                DetalleCliente detalleCliente = new DetalleCliente("Juan", "Perez", 123456, "Email",
                                "juanperez@gmail.com",
                                "11-2345-6789");
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
                ClienteController clienteController = new ClienteController();
                Cliente juan = clienteController.cargarCliente("Juan", "Perez", 123456, "Email", "juanperez@gmail.com",
                                "11-2345-6789");
                List<DetalleCliente> listaClientes = new ArrayList<>();
                listaClientes.add(juan.detalleCliente);

                reservaController.getObservadorReserva().subscribir(juan);

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
                                "003 ---- Creamos una reserva del usuario cuyo id es 1, y agregamos a juan y a ricardo y pagamos en efectivo, ademas se reserva por 5 dias y luego la pagamos");
                ReservaController reservaController = new ReservaController();
                DetalleCliente detalleCliente = new DetalleCliente("Juan", "Perez", 123456, "Email",
                                "juanperez@gmail.com",
                                "11-2345-6789");
                DetalleCliente detalleCliente2 = new DetalleCliente("Ricardo", "Gomez", 789012, "Email",
                                "ricardogomez@gmail.com",
                                "11-9876-5432");
                List<DetalleCliente> listaClientes = new ArrayList<>();
                listaClientes.add(detalleCliente);
                listaClientes.add(detalleCliente2);

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

        public void testearCancelacionAutomatica() {
                System.out.println("");
                System.out.println(
                                "004 ---- Creamos una reserva del usuario cuyo id es 1, y agregamos a juan y pagamos en efectivo, ademas se reserva por 5 dias: ");
                ReservaController reservaController = new ReservaController();
                DetalleCliente detalleCliente = new DetalleCliente("Juan", "Perez", 123456, "Email",
                                "juanperez@gmail.com",
                                "11-2345-6789");
                List<DetalleCliente> listaClientes = new ArrayList<>();
                listaClientes.add(detalleCliente);

                @SuppressWarnings("deprecation")
                Date checkIn = new Date(124, 2, 22);
                @SuppressWarnings("deprecation")
                Date checkOut = new Date(124, 2, 22);

                Float montoReserva = 22.49f;
                reservaController.reservarHabitacion(1, 1, checkIn, checkOut, listaClientes, "Efectivo", montoReserva);
                reservaController.mostrarReservas();

                System.out.println("Cambiamos la fecha a dos dias antes de hoy y actualizamos");
                reservaController.obtenerReserva(1).cambiarDiasReserva(LocalDateTime.now().minusDays(2));
                reservaController.analizarReservasPendientes();
                reservaController.mostrarReservas();
        }

        public void testearObserverReserva() {
                System.out.println("");
                System.out.println(
                                "005 ---- Creamos una reserva y le asignamos un observer al cliente, vemos al cliente: ");
                ClienteController clienteController = new ClienteController();
                Cliente juan = clienteController.cargarCliente("Juan", "Perez", 1234567, "Email", "pepe@gmail.com",
                                "11-2345-6789");

                clienteController.mostrarClientes();

                System.out.println("creamos la reserva: ");
                ReservaController reservaController = new ReservaController();
                reservaController.getObservadorReserva().subscribir(juan);
                reservaController.getObservadorReserva().subscribir(new FacadeMarketing());
                DetalleCliente detalleCliente = new DetalleCliente("Juan", "Perez", 123456, "Email",
                                "juanperez@gmail.com",
                                "11-2345-6789");
                DetalleCliente detalleCliente2 = new DetalleCliente("Ricardo", "Gomez", 789012, "Email",
                                "ricardogomez@gmail.com", "11-9876-5432");

                List<DetalleCliente> listaClientes = new ArrayList<>();
                listaClientes.add(detalleCliente);
                listaClientes.add(detalleCliente2);

                @SuppressWarnings("deprecation")
                Date checkIn = new Date(124, 2, 22);
                @SuppressWarnings("deprecation")
                Date checkOut = new Date(124, 2, 22);

                Float montoReserva = 22.49f;
                reservaController.reservarHabitacion(1, 1, checkIn, checkOut, listaClientes, "Efectivo", montoReserva);

                System.out.println("Ahora le asigno un cambio a esa reserva y vemos que pasa con el cliente");

                reservaController.cancelarReserva(1);
                reservaController.mostrarReservas();

        }
}
