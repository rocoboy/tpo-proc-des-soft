package com.uade.hotel.builders.room;

public interface IConstructor {

    public void setIdHabitacion(Integer idHabitacion);

    public void setCantidadPersonas(Integer cantidadPersonas);

    public void setMinibar(boolean miniBar);

    public void setTv(boolean tv);

    public void setInternet(boolean internet);

    public Habitacion getResultado();
}
