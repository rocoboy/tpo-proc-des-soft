package com.uade.hotel.testunitarios;

import java.util.ArrayList;
import java.util.List;

import com.uade.hotel.controllers.HabitacionController;

public class TestHabitacion {

    public void crearHabitacionComun() {
        System.out.println("");
        System.out.println("001 ---- Creamos una habitación comun");
        HabitacionController habitacionController = new HabitacionController();
        habitacionController.cargarHabitacion("Comun");
        habitacionController.mostrarHabitaciones();
    }

    public void crearHabitacionSuite() {
        System.out.println("");
        System.out.println("002 ---- Creamos una habitación de suite");
        HabitacionController habitacionController = new HabitacionController();
        habitacionController.cargarHabitacion("Suite");
        habitacionController.mostrarHabitaciones();
    }

    public void ocuparHabitacion() {
        System.out.println("");
        System.out.println("003 ---- Ocupamos la habitación con id 1, en este caso la Suite que esta liberada:");
        HabitacionController habitacionController = new HabitacionController();
        habitacionController.cargarHabitacion("Suite");
        habitacionController.cargarHabitacion("Comun");
        habitacionController.mostrarHabitaciones();
        System.out.println("reservamos la habitación:");
        habitacionController.reservarHabitacion(1);
        habitacionController.mostrarHabitaciones();
    }

    public void liberarHabitacion() {
        System.out.println("");
        System.out.println("004 ---- La habitación 1 que es suite que estaba ocupada la liberamos ");
        HabitacionController habitacionController = new HabitacionController();
        habitacionController.cargarHabitacion("Suite");
        habitacionController.cargarHabitacion("Comun");
        habitacionController.reservarHabitacion(1);
        habitacionController.mostrarHabitaciones();
        System.out.println("liberamos la habitación 1:");
        habitacionController.liberarHabitacion(1);
        habitacionController.mostrarHabitaciones();
    }

    public void crearReporteHabitaciones() {
        System.out.println("");
        System.out.println("005 ---- Simplemente mostramos el estado de las habitaciones: ");
        HabitacionController habitacionController = new HabitacionController();
        habitacionController.cargarHabitacion("Suite");
        habitacionController.cargarHabitacion("Comun");
        System.out.println("Reporte:");
        habitacionController.generarReporte();
    }

    public void filtrarHabitacionesPorTipo() {
        System.out.println("");
        System.out.println("006 ---- Queremos ver las habitaciones suite disponibles, primero vemos todas: ");
        HabitacionController habitacionController = new HabitacionController();
        habitacionController.cargarHabitacion("Suite");
        habitacionController.reservarHabitacion(1);
        habitacionController.cargarHabitacion("Comun");
        habitacionController.cargarHabitacion("Suite");
        habitacionController.cargarHabitacion("Comun");
        habitacionController.mostrarHabitaciones();

        System.out.println("Ahora vemos las habitaciones filtradas por disponible y Suite con Wifi");
        List<String> extras = new ArrayList<>();
        extras.add("internet");
        habitacionController.buscarHabitaciones("Suite", 1, extras);

        System.out.println("Ahora vemos las habitaciones filtradas por disponible y Comun, con minibar y tv");
        extras.clear();
        extras.add("tv");
        extras.add("minibar");
        habitacionController.buscarHabitaciones("Comun", 1, extras);
    }
}
