package com.uade.hotel.observers;

public interface IObservador {
    // M�todo para que un observador solicite actualizaciones
    void update();

    // M�todo usado por un sujeto para actualizar el observador por un cambio de
    // estado
    void update(String message);

    // M�todo para subscribir el observador a un sujeto
    void setSubject(SujetoReserva subject);

}
