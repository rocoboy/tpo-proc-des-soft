package com.uade.hotel.models;

public class ReglaPrecio {

    int idRegla;
    int diasMinimos;
    int diasMaximos;
    float porcentajeFinal;

    public ReglaPrecio(int idRegla, int diasMinimos, int diasMaximos, float porcentajeFinal) {
        this.idRegla = idRegla;
        this.diasMinimos = diasMinimos;
        this.diasMaximos = diasMaximos;
        this.porcentajeFinal = porcentajeFinal;
    }

    public int getId() {
        return this.idRegla;
    }

    public int obtenerDiasMinimos() {
        return this.diasMinimos;
    }

    public void setDiasMinimos(int diasMinimos) {
        this.diasMinimos = diasMinimos;
    }

    public int obtenerDiasMaximos() {
        return this.diasMaximos;
    }

    public void setDiasMaximos(int diasMaximos) {
        this.diasMaximos = diasMaximos;
    }

    public float obtenerPorcentajeFinal() {
        return this.porcentajeFinal;
    }

    public void setPorcentajeFinal(float porcentajeFinal) {
        this.porcentajeFinal = porcentajeFinal;
    }

}
