package com.uade.hotel.strategies.pago;

public class PagoContext {

    IPago pago;

    public void setStrategy(IPago pago) {
        this.pago = pago;
    }

    public void realizarPago() {
        this.pago.realizarPago();
    }
}
