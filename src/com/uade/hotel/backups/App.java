package com.uade.hotel.backups;

import java.util.Date;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.uade.hotel.builders.room.ConstructorComun;
import com.uade.hotel.builders.room.DirectorHabitacion;
import com.uade.hotel.builders.room.Habitacion;
import com.uade.hotel.builders.room.IConstructor;
import com.uade.hotel.controllers.ClienteController;
import com.uade.hotel.controllers.FacturacionController;
import com.uade.hotel.controllers.HabitacionController;
import com.uade.hotel.controllers.ReservaController;
import com.uade.hotel.models.Cliente;
import com.uade.hotel.models.DetalleCliente;
import com.uade.hotel.states.estadohabitacion.HabitacionStateOcupado;

public class App {
    public static void main(String[] args) throws ParseException {

        // defino los controllers
        ClienteController clienteController = new ClienteController();
        HabitacionController habitacionController = new HabitacionController();
        ReservaController reservaController = new ReservaController();
        FacturacionController facturacionController = new FacturacionController();

        // defino las variables para usar con la consola
        Scanner scanner = new Scanner(System.in);
        int rol = 1;

        while (rol != 0) {
            menuPrincipal();
            rol = scanner.nextInt();
            clearConsole();

            switch (rol) {
                case 1:
                    crearCliente(clienteController);
                    break;
                case 2:
                    crearHabitacion(habitacionController);
                    break;
                case 3:
                    buscarHabitaciones(habitacionController);
                    break;
                case 4:
                    buscarHabitaciones(habitacionController);
                    break;
                case 5:
                    reservarHabitacion(habitacionController, reservaController);
                    break;
                case 6:
                    cancelarReserva(habitacionController, reservaController);
                    break;
                case 7:
                    cambiarParametrosFacturacion(facturacionController);
                    break;
                case 8:
                    habitacionController.mostrarHabitaciones();
                    break;
                default:
                    break;
            }

            // esperamos a que presione una tecla el cliente
            System.out.println("\npresione una tecla para continuar");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clearConsole();
        }
        scanner.close();
    }

    public static void menuPrincipal() {
        System.out.println("Bienvenido, indique que desea hacer");
        System.out.println("1. Carga de clientes");
        System.out.println("2. Cargar habitacion");
        System.out.println("3. Buscar habitacion");
        System.out.println("4. Reservar habitación");
        System.out.println("5. Cancelar Reserva");
        System.out.println("6. Pagar reserva");
        System.out.println("7. Cambiar parametros de facturación");
        System.out.println("8. Generar reporte de habitaciones");
        System.out.println("0. Salir");
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void crearCliente(ClienteController clienteController) {
        clienteController.cargarCliente("Juan", "Perez", 1234567, "Email", "pepe@gmail.com", "11-2345-6789");
        clienteController.mostrarClientes();

        // ahora vamos a intentar crear un cliente con el dni ya existente
    }

    public static void crearHabitacion(HabitacionController habitacionController) {
        // puedo almacenar si quiero el id de habitación que devuelve para usarlo luego
        habitacionController.cargarHabitacion("Comun");
        habitacionController.mostrarHabitaciones();
    }

    public static void buscarHabitaciones(HabitacionController habitacionController) {
        habitacionController.buscarHabitaciones("Comun", 2);
    }

    public static void reservarHabitacion(HabitacionController habitacionController,
            ReservaController reservaController) throws ParseException {

        int idHabitacion = 1;
        int idCliente = 1;
        String medioDePago = "Efectivo";
        DetalleCliente detalleCliente = new DetalleCliente("Juan", "Petri", 1232345);
        List<DetalleCliente> clientesReserva = new ArrayList<>();
        clientesReserva.add(detalleCliente);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false); // Esto asegura que el parseo sea estricto
        Date checkIn = sdf.parse("2021-01-09");
        Date checkOut = sdf.parse("2021-01-13");

        // calculamos cuanto sale la reserva
        Float montoReserva = habitacionController.buscarHabitacion(idHabitacion).getCostoDiario();

        if ("Disponible".equals(habitacionController.buscarHabitacion(idHabitacion).obtenerEstado())) {
            habitacionController.buscarHabitacion(idHabitacion).cambiarEstado(new HabitacionStateOcupado());
            reservaController.reservarHabitacion(idHabitacion, idCliente, checkIn, checkOut, clientesReserva,
                    medioDePago, montoReserva);
            reservaController.mostrarReservas();
        }
    }

    public static void cancelarReserva(HabitacionController habitacionController, ReservaController reservaController) {
        int idReserva = 1;
        int idHabitacion = reservaController.obtenerReserva(idReserva).obtenerIdHabitacion();
        reservaController.cancelarReserva(1);
        habitacionController.liberarHabitacion(idHabitacion);
        reservaController.mostrarReservas();
    }

    public static void cambiarParametrosFacturacion(FacturacionController facturacionController) {
        facturacionController.mostrarValoresReservas();
        float nuevoPorcentaje = 0.3f;
        facturacionController.cambiarParametrosFacturacion(1, 12, 11, nuevoPorcentaje);
    }

}
