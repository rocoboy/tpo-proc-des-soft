package com.uade.hotel.builders.room;
import java.util.ArrayList;
import java.util.List;

import com.uade.hotel.states.estadohabitacion.ContextoHabitacion;

public class ConstructorComun implements IConstructor {

    Integer idHabitacion;
    String tipo;
    Integer cantidadPersonas;
    Boolean minibar;
    boolean tv;
    boolean internet;
    ContextoHabitacion estado;
    Float costoDiario;
    List<String> extras;

    public ConstructorComun(){
        this.extras = new ArrayList<>();
    }

    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public void setMinibar(boolean miniBar) {
        if(miniBar){
            this.extras.add("minibar");
        }
    }

    public void setTv(boolean tv) {
        if(tv){
            this.extras.add("tv");
        }
    }

    public void setInternet(boolean internet) {
        if(internet){
            this.extras.add("internet");
        }
    }


    public void setTipo() {
        this.tipo = "Comun";
    }

    public Habitacion getResultado() {
        return new Habitacion(this.idHabitacion, this.cantidadPersonas, this.minibar, this.tv, this.internet,
                this.tipo, this.extras);
    }

    public void setCostoDiario(Float costoDiario) {
        this.costoDiario = costoDiario;
    }

}
