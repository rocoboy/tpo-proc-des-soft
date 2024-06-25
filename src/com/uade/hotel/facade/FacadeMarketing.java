package com.uade.hotel.facade;

import com.uade.hotel.models.Reserva;
import com.uade.hotel.observers.INotificado;

public class FacadeMarketing implements INotificado {

    @Override
    public void notificar(Reserva reserva, String mensaje) {
        System.out.println("Se notifico a marketing");
        System.out.println("Mensaje Especial" + mensaje);
        System.out.println("Reserva: " + reserva.idReserva);
        reserva.imprimirReserva();
    }

}