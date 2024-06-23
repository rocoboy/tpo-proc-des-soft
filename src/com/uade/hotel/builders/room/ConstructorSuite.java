package com.uade.hotel.builders.room;

import com.uade.hotel.states.estadohabitacion.ContextoHabitacion;

public class ConstructorSuite implements IConstructor {

    Integer idHabitacion;
    String tipo;
    Integer cantidadPersonas;
    Boolean minibar;
    boolean tv;
    boolean internet;
    ContextoHabitacion estado;
    Float costoDiario;

    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public void setMinibar(boolean miniBar) {
        this.minibar = miniBar;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public void setTipo() {
        this.tipo = "Suite";
    }

    public Habitacion getResultado() {
        return new Habitacion(this.idHabitacion, this.cantidadPersonas, this.minibar, this.tv, this.internet,
                this.tipo);
    }

    public void setCostoDiario(Float costoDiario) {
        this.costoDiario = costoDiario;
    }

}
