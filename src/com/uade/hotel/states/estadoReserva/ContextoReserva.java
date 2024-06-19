package com.uade.hotel.states.estadoReserva;

public class ContextoReserva implements IReservaState {

    private IReservaState estado;

    public void cambiarEstado(IReservaState estado) {
        this.estado = estado;
    }

    @Override
    public String consultarEstado() {
        return this.estado.consultarEstado();
    }

}