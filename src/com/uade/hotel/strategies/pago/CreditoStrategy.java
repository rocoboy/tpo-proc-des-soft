package com.uade.hotel.strategies.pago;

public class CreditoStrategy implements IPago {

    public void realizarPago() {
        System.out.println("Pagaste mediante Credito");
    }

}