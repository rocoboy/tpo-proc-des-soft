package com.uade.hotel.iterator;

import java.util.List;

import com.uade.hotel.builders.room.Habitacion;

public class EstadoIterator implements IHabitacionIterator {
    private List<Habitacion> habitaciones;
    private String estado;
    private int position;

    public EstadoIterator(List<Habitacion> habitaciones, String estado) {
        this.habitaciones = habitaciones;
        this.estado = estado;
        this.position = 0;

        while (!this.habitaciones.get(position).obtenerEstado().equals(estado) && position < habitaciones.size()) {
            position++;
        }
    }

    @Override
    public boolean hasNext() {
        while (position < habitaciones.size()) {
            if (habitaciones.get(position).obtenerEstado().equals(estado)) {
                return true;
            }
            position++;
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
