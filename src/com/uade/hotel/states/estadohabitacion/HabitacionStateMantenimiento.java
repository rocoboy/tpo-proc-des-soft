package com.uade.hotel.states.estadohabitacion;

public class HabitacionStateMantenimiento implements IHabitacionState {

    String estado = "Mantenimiento";

    public String consultarEstado() {
        return this.estado;
    }
}