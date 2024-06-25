package com.uade.hotel.observers;

public class ObservadorReserva {
    int idReserva;
    String nombreCliente;
    SujetoReserva sujetoSubscripto;

    public ObservadorReserva(int idReserva, String nombreCliente) {
        this.idReserva = idReserva;
        this.nombreCliente = nombreCliente;
    }

    public void update() {
        String nuevoMensaje = (String) sujetoSubscripto.getUpdate();
        if (nuevoMensaje == null) {
            System.out.println(idReserva + " no hay nuevos mensajes");
        } else {
            System.out.println("Hola! " + nombreCliente + ", tu reserva con id: " + idReserva
                    + " ha cambiado su estado a: " + nuevoMensaje);
        }
    }

    public void update(String nuevoMensaje) {
        if (nuevoMensaje == null) {
            System.out.println(idReserva + " No hay nuevos mensajes");
        } else {
            System.out.println("Hola! " + nombreCliente + ", tu reserva con id: " + idReserva
                    + " ha cambiado su estado a: " + nuevoMensaje);
        }
    }

    public void setSubject(SujetoReserva sujeto) {
        sujetoSubscripto = sujeto;
    }

    public int obtenerIdReserva() {
        return this.idReserva;
    }

}