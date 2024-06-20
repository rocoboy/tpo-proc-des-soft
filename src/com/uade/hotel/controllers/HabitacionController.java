package com.uade.hotel.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.uade.hotel.builders.room.Habitacion;
import com.uade.hotel.states.estadohabitacion.HabitacionStateDisponible;
import com.uade.hotel.states.estadohabitacion.HabitacionStateOcupado;

public class HabitacionController {

    List<Habitacion> habitaciones;

    public HabitacionController() {
        habitaciones = new ArrayList<>();
    }

    public boolean cargarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
        return false;
    }

    public Habitacion buscarHabitaciones(Integer idHabitacion) {
        for (Habitacion habitacion : habitaciones) {
            if (Objects.equals(habitacion.obtenerIdHabitacion(), idHabitacion)) {
                return habitacion;
            }
        }
        return null;
    }

    public void reservarHabitacion(Integer idHabitacion) {
        buscarHabitaciones(idHabitacion).cambiarEstado(new HabitacionStateOcupado());
    }

    public void liberarHabitacion(Integer idHabitacion) {
        buscarHabitaciones(idHabitacion).cambiarEstado(new HabitacionStateDisponible());
    }

    public void generarReporte() {
        for (Habitacion habitacion : habitaciones) {
            System.out.println(
                    "Habitacion " + habitacion.obtenerIdHabitacion() + "  Estado " + habitacion.obtenerEstado());
        }
    }

    public List<Habitacion> filtrarHabitaciones(String estado) {
        List<Habitacion> habitacionesFiltradas = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (Objects.equals(habitacion.obtenerEstado(), estado)) {
                habitacionesFiltradas.add(habitacion);
            }
        }
        return habitacionesFiltradas;
    }
}
