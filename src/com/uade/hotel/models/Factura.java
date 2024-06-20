package com.uade.hotel.models;

public class Factura {

    int idFactura;
    int idReserva;
    int idCliente;
    String medioDePago;
    float monto;
    ReglaPrecio reglaPrecio;

    public Factura(int idFactura, int idReserva, int idCliente, String medioDePago, float monto,
            ReglaPrecio reglaPrecio) {

        this.idFactura = idFactura;
        this.idReserva = idReserva;
        this.idCliente = idCliente;
        this.medioDePago = medioDePago;
        this.monto = monto;
        this.reglaPrecio = reglaPrecio;
    }

    public float getMonto() {
        return (this.monto * this.reglaPrecio.porcentajeFinal);
    }

    public int getIdFactura() {
        return this.idFactura;
    }

    public int getIdReserva() {
        return this.idReserva;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

}
