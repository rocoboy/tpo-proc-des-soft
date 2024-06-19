package com.uade.hotel.observers;

import java.util.ArrayList;
import java.util.List;

// Esta clase notifica a sus observadores de cada cambio de su estado
public class Sujeto implements ISujeto {

    private List<IObservador> observadores = null;
    private String mensaje;

    public Sujeto() {
        observadores = new ArrayList<>();
    }

    @Override
    public void register(IObservador observador) {
        observadores.add(observador);
    }

    @Override
    public void unregister(IObservador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notifyObservers() {
        if (observadores != null && !observadores.isEmpty()) {
            for (IObservador observer : observadores) {
                observer.update(mensaje);
            }
        } else {
            System.out.println("No hay observadores para notificar");
        }
    }

    @Override
    public Object getUpdate() {
        return mensaje;
    }

    @Override
    public void postMessage(String mensaje) {
        System.out.println("Tema : " + mensaje);
        this.mensaje = mensaje;
        notifyObservers();
    }

}
