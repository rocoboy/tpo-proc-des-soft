package com.uade.hotel.strategies.pago;

public class DebitoStrategy implements IPago {

    public void realizarPago() {
        System.out.println("Pagaste mediante Debito");
    }

}