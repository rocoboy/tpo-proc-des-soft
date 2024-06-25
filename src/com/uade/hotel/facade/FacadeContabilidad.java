package com.uade.hotel.facade;

import com.uade.hotel.models.Reserva;
import com.uade.hotel.observers.INotificado;

public class FacadeContabilidad implements INotificado {

    public void notificar(Reserva reserva, String mensaje) {
        System.out.println("Se notifico a contabilidad");
        System.out.println("Mensaje Especial: " + mensaje);
        System.out.println("Reserva: " + reserva.idReserva);
        reserva.imprimirReserva();
    }
}