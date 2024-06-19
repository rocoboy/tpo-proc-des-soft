package com.uade.hotel.observers;

public class Observador implements IObservador {
    String nombreObservador;
    ISujeto sujetoSubscripto;

    public Observador(String nombreObservador) {
        this.nombreObservador = nombreObservador;
    }

    @Override
    public void update() {
        String nuevoMensaje = (String) sujetoSubscripto.getUpdate();
        if (nuevoMensaje == null) {
            System.out.println(nombreObservador + " no hay nuevos mensajes");
        } else {
            System.out.println(nombreObservador + " nuevo mensaje: " + nuevoMensaje);
        }
    }

    @Override
    public void update(String nuevoMensaje) {
        if (nuevoMensaje == null) {
            System.out.println(nombreObservador + " No hay nuevos mensajes");
        } else {
            System.out.println(nombreObservador + " Nuevo mensaje: " + nuevoMensaje);
        }
    }

    @Override
    public void setSubject(ISujeto sujeto) {
        sujetoSubscripto = sujeto;
    }

}