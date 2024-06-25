package com.uade.hotel.builders.room;

public class DirectorHabitacion {

    // The ID and amount of people are passed on by parameters

    public void construirComun(IConstructor constructor, int IdHabitacion, int cantPersonas) {

        constructor.setIdHabitacion(IdHabitacion);
        constructor.setCantidadPersonas(cantPersonas);
        constructor.setMinibar(true);
        constructor.setInternet(false);
        constructor.setTv(false);
        constructor.setCostoDiario(22.0f);
        constructor.setTipo();
    }

    // The ID and amount of people are passed on by parameters

    public void construirSuite(IConstructor constructor, int IdHabitacion, int cantPersonas) {

        constructor.setIdHabitacion(IdHabitacion);
        constructor.setCantidadPersonas(cantPersonas);
        constructor.setMinibar(true);
        constructor.setInternet(true);
        constructor.setTv(true);
        constructor.setCostoDiario(24.0f);
        constructor.setTipo();
    }
}
