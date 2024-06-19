package com.uade.hotel;

import com.uade.hotel.controllers.HabitacionController;
import com.uade.hotel.factories.room.HabitacionComun;

public class App {
    public static void main(String[] args) {

        HabitacionController controladoHabitacion = new HabitacionController();

        HabitacionComun habitacionComun = new HabitacionComun.ConstructorComun(1, 2).setInternetEnabled(true)
                .construir();
        controladoHabitacion.cargarHabitacion(habitacionComun);
        controladoHabitacion.generarReporte();

        controladoHabitacion.reservarHabitacion(1);
        controladoHabitacion.generarReporte();
    }
}
