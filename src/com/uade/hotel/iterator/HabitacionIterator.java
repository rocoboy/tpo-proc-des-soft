package com.uade.hotel.iterator;

import java.util.List;
import java.util.NoSuchElementException;

import com.uade.hotel.builders.room.Habitacion;

public class HabitacionIterator implements IHabitacionIterator {
    private List<Habitacion> habitaciones;
    private int index = 0;

    public HabitacionIterator(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    @Override
    public boolean hasNext() {
        return index < habitaciones.size();
    }

    @Override
    public Habitacion next() {
        if (hasNext()) {
            Habitacion habitacion = habitaciones.get(index);
            index++;
            return habitacion;
        }
        throw new NoSuchElementException("No more elements in the iterator.");
    }

    @Override
    public Habitacion first() {
        return habitaciones.get(0);
    }

    @Override
    public Habitacion last() {
        if (habitaciones.size() > 0) {
            return habitaciones.get(habitaciones.size() - 1);
        } else {
            System.out.println("No existen habitaciones.");
            return null;
        }
    }
}
