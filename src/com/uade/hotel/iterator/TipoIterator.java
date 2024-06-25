package com.uade.hotel.iterator;

import java.util.List;

import com.uade.hotel.builders.room.Habitacion;

public class TipoIterator implements IHabitacionIterator {
    private List<Habitacion> habitaciones;
    private String tipo;
    private int position;

    public TipoIterator(List<Habitacion> habitaciones, String tipo) {
        this.habitaciones = habitaciones;
        this.tipo = tipo;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        while (position < habitaciones.size()) {
            if (habitaciones.get(position).obtenerTipo().equals(tipo)) {
                return true;
            } else {
                position++;
            }
        }
        return false;
    }

    @Override
    public Habitacion next() {
        Habitacion habitacion = habitaciones.get(position);
        position++;
        return habitacion;
    }

    @Override
    public Habitacion first() {
        if (habitaciones.size() == 0) {
            System.out.println("No existen habitaciones.");
            return null;
        }
        return habitaciones.get(0);
    }

    @Override
    public Habitacion last() {
        if (habitaciones.size() == 0) {
            System.out.println("No existen habitaciones.");
            return null;
        }
        return habitaciones.get(habitaciones.size() - 1);
    }
}