package com.uade.hotel.testunitarios;

import java.util.Random;

import com.uade.hotel.builders.room.Habitacion;
import java.util.ArrayList;
import java.util.List;

import com.uade.hotel.controllers.HabitacionController;
import com.uade.hotel.iterator.IHabitacionIterator;

public class TestHabitacion {

    public void crearHabitacionComun() {
        System.out.println("");
        System.out.println("001 ---- Creamos una habitación comun");
        HabitacionController habitacionController = new HabitacionController();
        habitacionController.cargarHabitacion("Comun", 4); // Tipo de Habitación, Cant Personas
        habitacionController.mostrarHabitaciones();
    }

    public void crearHabitacionSuite() {
        System.out.println("");
        System.out.println("002 ---- Creamos una habitación de suite");
        HabitacionController habitacionController = new HabitacionController();
        habitacionController.cargarHabitacion("Suite", 2);
        habitacionController.mostrarHabitaciones();
    }

    public void ocuparHabitacion() {
        System.out.println("");
        System.out.println("003 ---- Ocupamos la habitación con id 1, en este caso la Suite que esta liberada:");
        HabitacionController habitacionController = new HabitacionController();
        habitacionController.cargarHabitacion("Suite", 2);
        habitacionController.cargarHabitacion("Comun", 4);
        habitacionController.mostrarHabitaciones();
        System.out.println("reservamos la habitación:");
        habitacionController.reservarHabitacion(1);
        habitacionController.mostrarHabitaciones();
    }

    public void liberarHabitacion() {
        System.out.println("");
        System.out.println("004 ---- La habitación 1 que es suite que estaba ocupada la liberamos ");
        HabitacionController habitacionController = new HabitacionController();
        habitacionController.cargarHabitacion("Suite", 2);
        habitacionController.cargarHabitacion("Comun", 4);
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
        habitacionController.cargarHabitacion("Suite", 2);
        habitacionController.cargarHabitacion("Comun", 4);
        System.out.println("Reporte:");
        habitacionController.generarReporte();
    }

    public void filtrarHabitacionesPorTipo() {
        System.out.println("");
        System.out.println("006 ---- Queremos ver las habitaciones suite disponibles, primero vemos todas: ");
        HabitacionController habitacionController = new HabitacionController();
        habitacionController.cargarHabitacion("Suite", 2);
        habitacionController.reservarHabitacion(1);
        habitacionController.cargarHabitacion("Comun", 4);
        habitacionController.cargarHabitacion("Suite", 4);
        habitacionController.cargarHabitacion("Comun", 2);
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

    // lets use the Iterator pattern to show the rooms
    public void iterarHabitaciones() {
        System.out.println("");
        System.out.println("007 ---- Mostramos las habitaciones con el patrón Iterator");
        HabitacionController habitacionController = new HabitacionController();

        System.out.println("Creamos 10 habitaciones random");
        Random random = new Random();
        for (int i = 0; i <= 10; i++) {
            int randomNum = random.nextInt(2);
            if (randomNum == 0) {
                habitacionController.cargarHabitacion("Suite", random.nextInt(5) + 1);
                System.out.println(i + ": Habitacion Suite creada");
            } else {
                habitacionController.cargarHabitacion("Comun", random.nextInt(5) + 1);
                System.out.println(i + ": Habitacion Comun creada");
            }
        }

        System.out.println("Reservamos algunas habitaciones de manera aleatoria");
        IHabitacionIterator iteratorEstado = habitacionController.createEstadoIterator("Disponible");
        while (iteratorEstado.hasNext()) {
            Habitacion habitacion = iteratorEstado.next();
            // Cambiamos el estado de alguna habitación de manera random
            if (random.nextInt(2) == 0) {
                habitacionController.reservarHabitacion(habitacion.obtenerIdHabitacion());
                System.out.println("Habitacion " + habitacion.obtenerIdHabitacion() + " reservada");
            }
        }

        System.out.println("Probamos el patrón Iterator");
        System.out.println("Iteramos por estado = " + "Disponible");

        IHabitacionIterator estadoIterator = habitacionController.createEstadoIterator("Disponible");
        System.out.println("Habitaciones:");
        Habitacion habitacion = estadoIterator.next();
        while (estadoIterator.hasNext()) {
            System.out.println(
                    "Habitacion: " + habitacion.obtenerIdHabitacion() + " Estado: " + habitacion.obtenerEstado());
            habitacion = estadoIterator.next();
        }

        System.out.println("Iteramos por tipo" + " Suite");

        IHabitacionIterator tipoIterator = habitacionController.createTipoIterator("Suite");
        System.out.println("Habitaciones:");
        habitacion = tipoIterator.next();
        while (tipoIterator.hasNext()) {
            System.out.println(
                    "Habitacion: " + habitacion.obtenerIdHabitacion() + " Tipo: " + habitacion.obtenerTipo());
            habitacion = tipoIterator.next();
        }

        IHabitacionIterator habitacionIterator = habitacionController.createHabitacionIterator();
        System.out.println("Iteramos por todas las habitaciones");
        System.out.println("Habitaciones:");
        habitacion = habitacionIterator.next();
        while (habitacionIterator.hasNext()) {
            System.out.println("Habitacion: " + habitacion.obtenerIdHabitacion() + " Tipo: " + habitacion.obtenerTipo()
                    + " Estado: " + habitacion.obtenerEstado());
            habitacion = habitacionIterator.next();
        }

    }
}
