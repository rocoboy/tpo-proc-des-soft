package com.uade.hotel.models;

public class ValoresReserva {

    Integer diasMinimos;
    Integer diasMaximos;
    double porcentajeFinal;

    public ValoresReserva(Integer diasMinimos, Integer diasMaximos, double porcentajeFinal) {
        this.diasMinimos = diasMinimos;
        this.diasMaximos = diasMaximos;
        this.porcentajeFinal = porcentajeFinal;
    }

}
