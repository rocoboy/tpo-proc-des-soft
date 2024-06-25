package com.uade.hotel.adapter;

import com.uade.hotel.strategies.pago.IPago;
import com.uade.hotel.strategies.pago.MercadoPagoStrategy;

class MercadoPagoAdapter implements IPago {

    MercadoPagoStrategy Adaptee;

    public void realizarPago() {

        MercadoPagoStrategy.efectuarPago();

    }

}
