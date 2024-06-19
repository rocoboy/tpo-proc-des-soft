package com.uade.hotel.states.estadoReserva;

public class ReservaStatePagada implements IReservaState {

    String estado = "Pagada";

    public String consultarEstado() {
        return this.estado;
    }
}