package com.uade.hotel.controllers;

import java.util.ArrayList;
import java.util.List;

import com.uade.hotel.models.Factura;
import com.uade.hotel.models.ReglaPrecio;

public class FacturacionController {

    List<Factura> facturas;
    List<ReglaPrecio> valoresReservas;

    public FacturacionController() {
        this.facturas = new ArrayList<>();
        this.valoresReservas = new ArrayList<>();
    }

    public void generarFactura(int idCliente, int idReserva, String medioDePago, ReglaPrecio reglaPrecio) {
        if (obtenerFactura(idReserva) == null) {
            facturas.add(new Factura(idReserva, idReserva, idCliente, medioDePago, idReserva, reglaPrecio));
        } else {
            System.out.println("ya existe una factura para la reserva");
        }
    }

    public Factura obtenerFactura(int idReserva) {
        for (Factura factura : facturas) {
            if (factura.getIdReserva() == idReserva) {
                return factura;
            }
        }
        return null;
    }

    private ReglaPrecio obtenReglaPrecio(int idRegla) {
        for (ReglaPrecio reglaPrecio : valoresReservas) {
            if (reglaPrecio.getId() == idRegla) {
                return reglaPrecio;
            }
        }
        return null;
    }

    public void eliminarFactura(int idReserva) {
        facturas.remove(obtenerFactura(idReserva));
    }

    public void cambiarParametrosFacturacion(int idValor, int diasMinimos, int diasMaximos, float porcentajeFinal) {
        if (obtenReglaPrecio(idValor) != null) {
            obtenReglaPrecio(idValor).setDiasMaximos(diasMaximos);
            obtenReglaPrecio(idValor).setDiasMinimos(diasMinimos);
            obtenReglaPrecio(idValor).setPorcentajeFinal(porcentajeFinal);
        } else {
            System.out.println("no existe la regla");
        }

    }

    public void mostrarValoresReservas() {
        for (ReglaPrecio valorReserva : valoresReservas) {
            System.out.println("id: " + valorReserva.getId() + " | Dias minimos: " + valorReserva.obtenerDiasMinimos()
                    + " | Maximos: " + valorReserva.obtenerDiasMaximos() + " | porcentaje: "
                    + valorReserva.obtenerPorcentajeFinal());
        }
    }

    public void mostrarFacturas() {
        for (Factura factura : facturas) {
            System.out.println("Id: " + factura.getIdFactura() + "idCliente:  " + factura.getIdCliente()
                    + "idReserva:  " + factura.getIdReserva() + "Monto:  " + factura.getMonto());
        }
    }
}
