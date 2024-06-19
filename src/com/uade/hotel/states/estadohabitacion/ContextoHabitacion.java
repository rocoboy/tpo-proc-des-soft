package com.uade.hotel.states.estadohabitacion;

public class ContextoHabitacion implements IHabitacionState {

    private IHabitacionState estado;

    public void cambiarEstado(IHabitacionState estado) {
        this.estado = estado;
    }

    @Override
    public String consultarEstado() {
        return this.estado.consultarEstado();
    }

}