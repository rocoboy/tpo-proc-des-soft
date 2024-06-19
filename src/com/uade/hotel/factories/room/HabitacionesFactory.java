package com.uade.hotel.factories.room;

public class HabitacionesFactory {

    public static Habitacion crearHabitacion(String tipo) {
        if ("BasicRoom".equalsIgnoreCase(tipo)) {
            return new HabitacionComun(null);
        }
        return null;
    }
}
