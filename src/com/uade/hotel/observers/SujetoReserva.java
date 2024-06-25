package com.uade.hotel.observers;

import java.util.ArrayList;
import java.util.List;

// Esta clase notifica a sus observadores de cada cambio de su estado
public class SujetoReserva {

    private List<ObservadorReserva> observadores = null;
    private String mensaje;

    public SujetoReserva() {
        observadores = new ArrayList<>();
    }

    public void register(ObservadorReserva observadorReserva) {
        observadores.add(observadorReserva);
    }

    public void unregister(ObservadorReserva observador) {
        observadores.remove(observador);
    }

    public void notifyObservers() {
        if (observadores != null && !observadores.isEmpty()) {
            for (ObservadorReserva observer : observadores) {
                observer.update(mensaje);
            }
        } else {
            System.out.println("No hay observadores para notificar");
        }
    }

    public Object getUpdate() {
        return mensaje;
    }

    public void postMessage(String mensaje) {
        System.out.println("Tema : " + mensaje);
        this.mensaje = mensaje;
        notifyObservers();
    }

}
