package com.uade.hotel.models;

import com.uade.hotel.builders.room.Habitacion;
import com.uade.hotel.controllers.FacturacionController;
import com.uade.hotel.controllers.HabitacionController;
import com.uade.hotel.controllers.ReservaController;

public class Gerente extends Cliente {

    private FacturacionController facturacionController;

    public Gerente(int idCliente, String nombre, String apellido, int dni, String preferenciacontacto, String email,
            String telefono) {
        super(idCliente, nombre, apellido, dni, preferenciacontacto, email, telefono);
        this.facturacionController = new FacturacionController();
    }

    public void actualizarFactura(int idValor, int diasMinimos, int diasMaximos, float porcentajeFinal) {
        facturacionController.cambiarParametrosFacturacion(idValor, diasMinimos, diasMaximos, porcentajeFinal);
    }

    public int crearHabitacion(HabitacionController habitacionController, String tipo, int cantPersonas) {
        return habitacionController.cargarHabitacion(tipo, cantPersonas);
    }

    public Habitacion buscarHabitacion(HabitacionController habitacionController, Integer idHabitacion) {
        return habitacionController.buscarHabitacion(idHabitacion);
    }

    public void listarHabitaciones(HabitacionController habitacionController) {
        for (Habitacion habitacion : habitacionController.getHabitaciones()) {
            System.out.println(habitacion.toString());
        }
    }

    public void imprimirReservas(ReservaController rc) {
        rc.imprimirReservas();
    }

}
