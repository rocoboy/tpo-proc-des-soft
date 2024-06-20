package com.uade.hotel.builders.room;

public class DirectorHabitacion {

    public void construirComun(IConstructor constructor) {

        constructor.setIdHabitacion(0);
        constructor.setCantidadPersonas(4);
        constructor.setMinibar(true);
        constructor.setInternet(false);
        constructor.setTv(false);
    }

    public void construirSuite(IConstructor constructor) {

        constructor.setIdHabitacion(0);
        constructor.setCantidadPersonas(2);
        constructor.setMinibar(true);
        constructor.setInternet(true);
        constructor.setTv(true);
    }
}
