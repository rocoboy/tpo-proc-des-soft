package com.uade.hotel.states.estadoReserva;

public class ReservaStateCancelada implements IReservaState {

    String estado = "Cancelada";

    public String consultarEstado() {
        return this.estado;
    }
}