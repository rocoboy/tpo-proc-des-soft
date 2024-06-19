package com.uade.hotel.observers;

public interface ISujeto {
    // Registro de un observador
    void register(IObservador observador);

    // Cancelaci�n de registro de un observador
    void unregister(IObservador observador);

    // Notificar a todos los observadores de un cambio de estado
    void notifyObservers();

    // M�todo para que los observadores obtengan informaci�n
    Object getUpdate();

    // Env�o de mensaje a los observadores
    void postMessage(String message);
}