package com.uade.hotel.iterator;

import com.uade.hotel.builders.room.Habitacion;

public interface IHabitacionIterator {
    boolean hasNext();

    Habitacion next();

    Habitacion first();

    Habitacion last();
}
