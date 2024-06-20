package com.uade.hotel.builders.room;

import com.uade.hotel.states.estadohabitacion.ContextoHabitacion;
import com.uade.hotel.states.estadohabitacion.IHabitacionState;

public class Habitacion {
    Integer idHabitacion;
    Integer cantidadPersonas;
    Boolean minibar;
    boolean tv;
    boolean internet;
    ContextoHabitacion estado;

    public Habitacion(Integer idHabitacion, Integer cantidadPersonas, Boolean minibar, boolean tv, boolean internet) {
        this.idHabitacion = idHabitacion;
        this.cantidadPersonas = cantidadPersonas;
        this.minibar = minibar;
        this.tv = tv;
        this.internet = internet;
        this.estado = new ContextoHabitacion();
    }

    public void cambiarEstado(IHabitacionState estado) {
        this.estado.cambiarEstado(estado);
    }

    public void getDetalles() {
        System.out.println("Detalles de la habitación");
        System.out.printf("Cantidad de Personas: %s %n", cantidadPersonas);
        System.out.printf("Minibar: %s %n", minibar);
        System.out.printf("Tv: %s %n", tv);
        System.out.printf("Internet: %s %n", internet);
        System.out.printf("Estado de la habitacion: %s %n", estado.consultarEstado());
    }

    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Integer obtenerIdHabitacion() {
        return this.idHabitacion;
    }

    public String obtenerEstado() {
        return this.estado.consultarEstado();
    }
}
