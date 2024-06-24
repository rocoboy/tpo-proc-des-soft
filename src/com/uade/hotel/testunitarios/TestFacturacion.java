package com.uade.hotel.testunitarios;

import com.uade.hotel.controllers.FacturacionController;
import com.uade.hotel.models.ReglaPrecio;

public class TestFacturacion {

    public void realizarPago() {
        System.out.println("");
        System.out.println("001 ---- Creamos una factura: ");
        FacturacionController facturacionController = new FacturacionController();
        ReglaPrecio reglaPrecio = new ReglaPrecio(1, 2, 3, 0.7f);
        facturacionController.generarFactura(1, 1, "MercadoPago", reglaPrecio);
        facturacionController.mostrarFacturas();
    }

    public void cambiarValorPromo() {

    }
}
