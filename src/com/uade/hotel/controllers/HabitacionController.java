package com.uade.hotel.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.uade.hotel.builders.room.ConstructorComun;
import com.uade.hotel.builders.room.ConstructorSuite;
import com.uade.hotel.builders.room.DirectorHabitacion;
import com.uade.hotel.builders.room.Habitacion;
import com.uade.hotel.builders.room.IConstructor;
import com.uade.hotel.iterator.EstadoIterator;
import com.uade.hotel.iterator.HabitacionIterator;
import com.uade.hotel.iterator.IHabitacionIterator;
import com.uade.hotel.iterator.TipoIterator;
import com.uade.hotel.states.estadohabitacion.HabitacionStateDisponible;
import com.uade.hotel.states.estadohabitacion.HabitacionStateOcupado;

public class HabitacionController {

    List<Habitacion> habitaciones;

    public HabitacionController() {
        habitaciones = new ArrayList<>();
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public int cargarHabitacion(String tipo, int cantPersonas) {
        int idHabitacion = habitaciones.size() + 1;
        DirectorHabitacion directorHabitacion = new DirectorHabitacion();

        if ("Comun".equals(tipo)) {
            IConstructor constructorComun = new ConstructorComun();
            directorHabitacion.construirComun(constructorComun, idHabitacion, cantPersonas);
            Habitacion habitacionComun = constructorComun.getResultado();
            habitacionComun.setIdHabitacion(idHabitacion);
            habitaciones.add(habitacionComun);
            return idHabitacion;
        }
        if ("Suite".equals(tipo)) {
            IConstructor construictorSuite = new ConstructorSuite();
            directorHabitacion.construirSuite(construictorSuite, idHabitacion, cantPersonas);
            Habitacion habitacionSuite = construictorSuite.getResultado();
            habitacionSuite.setIdHabitacion(idHabitacion);
            habitaciones.add(habitacionSuite);
            return idHabitacion;
        }
        return -1;
    }

    public Habitacion buscarHabitacion(Integer idHabitacion) {
        for (Habitacion habitacion : habitaciones) {
            if (Objects.equals(habitacion.getIdHabitacion(), idHabitacion)) {
                return habitacion;
            }
        }
        return null;
    }

    public void reservarHabitacion(Integer idHabitacion) {

        if (idHabitacion < 0 || idHabitacion > habitaciones.size()) {
            System.out.println("La habitacion no existe");
            return;
        }
        if (buscarHabitacion(idHabitacion).obtenerEstado().equals("Ocupado")) {
            System.out.println("La habitacion ya esta ocupada");
            return;
        }
        buscarHabitacion(idHabitacion).cambiarEstado(new HabitacionStateOcupado());
    }

    public void liberarHabitacion(Integer idHabitacion) {

        if (idHabitacion < 0 || idHabitacion > habitaciones.size()) {
            System.out.println("La habitacion no existe");
            return;
        }
        if (buscarHabitacion(idHabitacion).obtenerEstado().equals("Disponible")) {
            System.out.println("La habitacion ya estaba liberada pero no pasa nada, queda igual");
        }
        buscarHabitacion(idHabitacion).cambiarEstado(new HabitacionStateDisponible());
    }

    public void generarReporte() {
        for (Habitacion habitacion : habitaciones) {
            System.out.println(
                    "Habitacion " + habitacion.getIdHabitacion() + "  Estado " + habitacion.obtenerEstado());
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

    public void buscarHabitaciones(String tipo, Integer cantidadDePersonas, List<String> extras) {
        List<Habitacion> habitacionesFiltradas = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (tipo == habitacion.obtenerTipo()
                    && habitacion.obtenerPersonas() >= cantidadDePersonas
                    && habitacion.getExtras().containsAll(extras)
                    && "Disponible".equals(habitacion.obtenerEstado())) {

                habitacionesFiltradas.add(habitacion);
            }
        }
        mostrarHabitaciones(habitacionesFiltradas);
    }

    public void mostrarHabitaciones() {
        for (Habitacion habitacion : habitaciones) {
            System.out.println("id: " + habitacion.getIdHabitacion() + "  Estado: " + habitacion.obtenerEstado()
                    + " Tipo: " + habitacion.obtenerTipo() + " Extras: " + habitacion.getExtras());
        }
    }

    private void mostrarHabitaciones(List<Habitacion> habitaciones) {
        for (Habitacion habitacion : habitaciones) {
            System.out.println(
                    "id: " + habitacion.getIdHabitacion() + "  Estado: " + habitacion.obtenerEstado() + " Tipo: "
                            + habitacion.obtenerTipo() + " Extras: " + habitacion.getExtras());
        }
    }

    public int contarHabitaciones() {
        return this.habitaciones.size();
    }

    public String obtenerEstadoHabitacion(int idHabitacion) {
        return buscarHabitacion(idHabitacion).obtenerEstado();
    }

    public IHabitacionIterator createEstadoIterator(String estado) {
        return new EstadoIterator(habitaciones, estado);
    }

    public IHabitacionIterator createTipoIterator(String tipo) {
        return new TipoIterator(habitaciones, tipo);
    }

    public IHabitacionIterator createHabitacionIterator() {
        return new HabitacionIterator(habitaciones);
    }
}
