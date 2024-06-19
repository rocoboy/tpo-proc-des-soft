package com.uade.hotel.iterators.habitacion;

import com.uade.hotel.factories.room.Habitacion;

public interface HabitacionIterator {

    boolean existeSiguiente();

    Habitacion obtenerSiguiente();

    void reset();
}
