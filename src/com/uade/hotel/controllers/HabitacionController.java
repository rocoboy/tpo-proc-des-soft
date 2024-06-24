package com.uade.hotel.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.uade.hotel.builders.room.ConstructorComun;
import com.uade.hotel.builders.room.ConstructorSuite;
import com.uade.hotel.builders.room.DirectorHabitacion;
import com.uade.hotel.builders.room.Habitacion;
import com.uade.hotel.builders.room.IConstructor;
import com.uade.hotel.states.estadohabitacion.HabitacionStateDisponible;
import com.uade.hotel.states.estadohabitacion.HabitacionStateOcupado;

public class HabitacionController {

    List<Habitacion> habitaciones;

    public HabitacionController() {
        habitaciones = new ArrayList<>();
    }

    public int cargarHabitacion(String tipo) {
        int idHabitacion = habitaciones.size() + 1;
        DirectorHabitacion directorHabitacion = new DirectorHabitacion();

        if ("Comun".equals(tipo)) {
            IConstructor constructorComun = new ConstructorComun();
            directorHabitacion.construirComun(constructorComun);
            Habitacion habitacionComun = constructorComun.getResultado();
            habitacionComun.setIdHabitacion(idHabitacion);
            habitaciones.add(habitacionComun);
            return idHabitacion;
        }
        if ("Suite".equals(tipo)) {
            IConstructor construictorSuite = new ConstructorSuite();
            directorHabitacion.construirSuite(construictorSuite);
            Habitacion habitacionSuite = construictorSuite.getResultado();
            habitacionSuite.setIdHabitacion(idHabitacion);
            habitaciones.add(habitacionSuite);
            return idHabitacion;
        }
        return -1;
    }

    public Habitacion buscarHabitacion(Integer idHabitacion) {
        for (Habitacion habitacion : habitaciones) {
            if (Objects.equals(habitacion.obtenerIdHabitacion(), idHabitacion)) {
                return habitacion;
            }
        }
        return null;
    }

    public void reservarHabitacion(Integer idHabitacion) {
        buscarHabitacion(idHabitacion).cambiarEstado(new HabitacionStateOcupado());
    }

    public void liberarHabitacion(Integer idHabitacion) {
        buscarHabitacion(idHabitacion).cambiarEstado(new HabitacionStateDisponible());
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

    public void buscarHabitaciones(String tipo, int cantidadDePersonas) {
        List<Habitacion> habitacionesFiltradas = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (Objects.equals(habitacion.obtenerTipo(), tipo)
                    && (habitacion.obtenerPersonas() >= cantidadDePersonas)
                    && "Disponible".equals(habitacion.obtenerEstado())) {
                habitacionesFiltradas.add(habitacion);
            }
        }
        mostrarHabitaciones(habitacionesFiltradas);
    }

    public void mostrarHabitaciones() {
        for (Habitacion habitacion : habitaciones) {
            System.out.println("id: " + habitacion.obtenerIdHabitacion() + "  Estado: " + habitacion.obtenerEstado()
                    + " Tipo: " + habitacion.obtenerTipo());
        }
    }

    private void mostrarHabitaciones(List<Habitacion> habitaciones) {
        for (Habitacion habitacion : habitaciones) {
            System.out.println(
                    "id: " + habitacion.obtenerIdHabitacion() + "  Estado: " + habitacion.obtenerEstado() + " Tipo: "
                            + habitacion.obtenerTipo());
        }
    }

    public int contarHabitaciones() {
        return this.habitaciones.size();
    }

    public String obtenerEstadoHabitacion(int idHabitacion) {
        return buscarHabitacion(idHabitacion).obtenerEstado();
    }
}
