package com.uade.hotel;

import java.sql.ClientInfoStatus;

import com.uade.hotel.controllers.ClienteController;
import com.uade.hotel.controllers.HabitacionController;
import com.uade.hotel.factories.room.HabitacionComun;
import com.uade.hotel.models.Cliente;

public class App {
    public static void main(String[] args) {

        HabitacionController controladoHabitacion = new HabitacionController();

        HabitacionComun habitacionComun = new HabitacionComun.ConstructorComun(1, 2).setInternetEnabled(true)
                .construir();
        controladoHabitacion.cargarHabitacion(habitacionComun);
        controladoHabitacion.generarReporte();

        controladoHabitacion.reservarHabitacion(1);
        controladoHabitacion.generarReporte();

        ClienteController controladorCliente = new ClienteController();

        Cliente cliente = new Cliente(1, "Juan", "Messi", "1233322", "Whatsapp",
                "juancho@gmail.com", "11-2233-4455");

        controladorCliente.cargarCliente(cliente);
        controladorCliente.mostrarClientes();
    }
}
