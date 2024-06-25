package com.uade.hotel.observers;

import com.uade.hotel.models.Reserva;

public interface INotificado {

    void notificar(Reserva reserva, String mensaje);
}
