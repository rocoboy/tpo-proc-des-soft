package com.uade.hotel;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.uade.hotel.builders.room.ConstructorComun;
import com.uade.hotel.builders.room.DirectorHabitacion;
import com.uade.hotel.builders.room.Habitacion;
import com.uade.hotel.builders.room.IConstructor;
import com.uade.hotel.controllers.ClienteController;
import com.uade.hotel.controllers.HabitacionController;
import com.uade.hotel.controllers.ReservaController;
import com.uade.hotel.models.Cliente;
import com.uade.hotel.models.DetalleCliente;

public class App {
    public static void main(String[] args) throws ParseException {

        // creamos las primeras habitaciones
        // -------------------------------------------------------------
        HabitacionController controladorHabitacion = new HabitacionController();
        cargarHabitaciones(controladorHabitacion);

        // creamos el primer cliente
        // -------------------------------------------------------------
        ClienteController clienteController = new ClienteController();
        crearClientes(clienteController);

        // hacemos un reporte de las habitaciones
        // -------------------------------------------------------------
        controladorHabitacion.generarReporte();

        // realizando la reserva con un cliente y otro huesped
        // -------------------------------------------------------------
        ReservaController reservaController = new ReservaController();
        DetalleCliente detalleCliente = new DetalleCliente("Juan", "Petri", 1232345);
        List<DetalleCliente> clientesReserva = new ArrayList<>();
        clientesReserva.add(detalleCliente);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false); // Esto asegura que el parseo sea estricto
        Date checkIn = sdf.parse("2021-01-09");
        Date checkOut = sdf.parse("2021-01-13");

        reservaController.reservarHabitacion(1, 1, checkOut, checkIn, clientesReserva, "mercadoPago");

        // cancelando la reserva realizada en la habitacion 1
        reservaController.cancelarReserva(reservaController.obtenerIdReserva(1));

    }

    public static Habitacion crearHabitacion(Integer idHabitacion, String tipo) {

        IConstructor constructorComun = new ConstructorComun();
        DirectorHabitacion directorHabitacion = new DirectorHabitacion();

        if ("Comun".equals(tipo)) {
            directorHabitacion.construirComun(constructorComun);
            Habitacion habitacionComun = constructorComun.getResultado();
            habitacionComun.setIdHabitacion(idHabitacion);
            return habitacionComun;
        }
        return null;
    }

    public static void cargarHabitaciones(HabitacionController controladorHabitacion) {

        controladorHabitacion.cargarHabitacion(crearHabitacion(1, "Comun"));
        controladorHabitacion.cargarHabitacion(crearHabitacion(2, "Comun"));
        controladorHabitacion.cargarHabitacion(crearHabitacion(3, "Comun"));
    }

    public static void crearClientes(ClienteController clienteController) {

        Cliente cliente = new Cliente(1, "Juan", "Messi", "1233322", "Whatsapp",
                "juancho@gmail.com", "11-2233-4455");
        Cliente cliente2 = new Cliente(2, "Pepe", "Zapata", "1233232", "Whatsapp",
                "pepin@gmail.com", "11-234-4215");

        clienteController.cargarCliente(cliente);
        clienteController.cargarCliente(cliente2);
    }

    public static void buscarHabitaciones() {

    }

    public static void reservar() {

    }

    public static void cambiarParametrosFacturacion() {

    }

}
