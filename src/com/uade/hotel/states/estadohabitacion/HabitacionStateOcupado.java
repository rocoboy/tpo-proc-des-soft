package com.uade.hotel.states.estadohabitacion;

public class HabitacionStateOcupado implements IHabitacionState {

    String estado = "Ocupado";

    public String consultarEstado() {
        return this.estado;
    }
}