package com.uade.hotel.states.estadoReserva;

public class ReservaStatePendiente implements IReservaState {

    String estado = "Pendiente de pago";

    public String consultarEstado() {
        return this.estado;
    }
}