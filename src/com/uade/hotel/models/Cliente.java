package com.uade.hotel.models;

import java.util.Date;
import java.util.List;

import com.uade.hotel.builders.room.Habitacion;
import com.uade.hotel.controllers.HabitacionController;
import com.uade.hotel.controllers.ReservaController;
import com.uade.hotel.iterator.IHabitacionIterator;
import com.uade.hotel.observers.INotificado;

import com.uade.hotel.states.estadohabitacion.HabitacionStateDisponible;
import com.uade.hotel.states.estadohabitacion.HabitacionStateOcupado;

public class Cliente implements INotificado {

    public int idCliente;
    public DetalleCliente detalleCliente;

    public Cliente(int idCliente, String nombre, String apellido, int dni, String preferenciacontacto,
            String email, String telefono) {

        this.idCliente = idCliente;
        this.detalleCliente = new DetalleCliente(nombre, apellido, dni, preferenciacontacto, email, telefono);

    }

    public void imprimirCliente() {
        System.out.println("Cliente: " + this.idCliente);
        detalleCliente.imprimirDetalleCliente();
    }

    @Override
    public void notificar(Reserva reserva, String mensaje) {
        System.out.println("Se notifico al cliente " + this.detalleCliente.nombre + " " + this.detalleCliente.apellido);
        System.out.println("Mensaje Especial " + mensaje);
        System.out.println("Reserva: " + reserva.idReserva);
        System.out.println("Mediante: " + this.detalleCliente.preferenciaContacto);
        reserva.imprimirReserva();
    }

    public void cambiarPreferencia(String nuevaPreferencia) {
        this.detalleCliente.preferenciaContacto = nuevaPreferencia;
    }

    public String obtenerPreferencia() {
        return this.detalleCliente.preferenciaContacto;
    }

    public int getDni() {
        return this.detalleCliente.dni;
    }

    protected void cambiarDni(int dni) {
        this.detalleCliente.dni = dni;
    }

    public void reservarHabitacion(Habitacion h, ReservaController rc, int idHabitacion, int idCliente, Date checkIn,
            Date checkOut, List<DetalleCliente> clientesReserva, String medioDePago, Float montoReserva) {
        if (h.obtenerEstado() == "Disponible") {
            rc.reservarHabitacion(detalleCliente.dni, idCliente, checkIn, checkOut, clientesReserva, medioDePago,
                    montoReserva);
            h.cambiarEstado(new HabitacionStateOcupado());
        } else {
            System.out.println("No es posible reservar, ya esta reservada la habitación");
        }
    }

    public void cancelarReserva(Habitacion h, ReservaController rc, int idReserva) {
        rc.cancelarReserva(idReserva);
        h.cambiarEstado(new HabitacionStateDisponible());
    }

    public List<Habitacion> mostrarHabitacionesDisponibles(HabitacionController hc) {
        List<Habitacion> habitacionesDisponibles = hc.getHabitaciones();
        for (Habitacion habitacion : hc.getHabitaciones()) {
            if (habitacion.obtenerEstado() == "Disponible") {
                System.out.println(
                        "Habitacion Nro: " + habitacion.getIdHabitacion() + "   Tipo: " + habitacion.obtenerEstado()
                                + "   Precio: " + habitacion.getCostoDiario());
                habitacionesDisponibles.add(habitacion);
            }
        }
        return habitacionesDisponibles;
    }

    public IHabitacionIterator iterarHabitacionesDisponibles(HabitacionController hc) {
        return hc.createEstadoIterator("Disponible");
    }

    public IHabitacionIterator iterarHabitacionesOcupadas(HabitacionController hc) {
        return hc.createEstadoIterator("Ocupado");
    }

    public IHabitacionIterator iteratorHabitacion(HabitacionController hc) {
        return hc.createHabitacionIterator();
    }

}
