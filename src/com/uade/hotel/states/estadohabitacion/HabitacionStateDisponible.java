package com.uade.hotel.states.estadohabitacion;

public class HabitacionStateDisponible implements IHabitacionState {

    String estado = "Disponible";

    public String consultarEstado() {
        return this.estado;
    }
}