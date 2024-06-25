package com.uade.hotel.observers;

import java.util.ArrayList;
import java.util.List;

import com.uade.hotel.models.Reserva;

public class ObservadorReserva {

    public List<INotificado> notificados;

    public ObservadorReserva() {
        this.notificados = new ArrayList<>();
    }

    public void subscribir(INotificado notificado) {
        notificados.add(notificado);
    }

    public void desubscribir(INotificado notificado) {
        notificados.remove(notificado);
    }

    public void notificar(Reserva reserva, String mensaje) {
        for (INotificado notificado : notificados) {
            if (notificado != null) {
                notificado.notificar(reserva, mensaje);
            }

        }
    }

}