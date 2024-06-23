package com.uade.hotel.testunitarios;

import com.uade.hotel.controllers.ClienteController;

public class TestCliente {

    public TestCliente() {
        // hola
    }

    public void crearCliente() {
        System.out.println("");
        System.out.println("001 ---- Creamos un cliente nuevo: ");
        ClienteController clienteController = new ClienteController();
        clienteController.cargarCliente("Juan", "Perez", 1234567, "Email", "pepe@gmail.com", "11-2345-6789");
        clienteController.mostrarClientes();
    }

    public void crearClienteDuplicado() {
        System.out.println("");
        System.out.println("002 ---- Intenamos crear un cliente con el dni de uno ya existente: ");
        ClienteController clienteController = new ClienteController();
        clienteController.cargarCliente("Juan", "Perez", 1234567, "Email", "pepe@gmail.com", "11-2345-6789");
        clienteController.mostrarClientes();
        System.out.println("Al intentar agregarlo:");
        clienteController.cargarCliente("Cristian", "Rodriguez", 1234567, "Email", "pepe@gmail.com", "11-2345-6789");
        System.out.println("vemos que no se agrega:");
        clienteController.mostrarClientes();
    }

    public void eliminarCliente() {
        System.out.println("");
        System.out.println("003 ---- Eliminamos un cliente existente: ");
        ClienteController clienteController = new ClienteController();
        clienteController.cargarCliente("Juan", "Perez", 1234567, "Email", "pepe@gmail.com", "11-2345-6789");
        clienteController.cargarCliente("Cristian", "Rodriguez", 2333123, "Email", "pepe@gmail.com", "11-2345-6789");
        clienteController.mostrarClientes();
        System.out.println("Eliminamos al cliente por su dni");
        clienteController.eliminarCliente(1234567);
        System.out.println("Mostramos los clientes:");
        clienteController.mostrarClientes();
    }

    public void eliminarClienteNoExistente() {
        System.out.println("");
        System.out.println("004 ---- Eliminamos un cliente NO existente: ");
        // implementar test
    }

    public void modificarCliente() {
        System.out.println("");
        System.out.println("005 ---- Modificamos el nombre del cliente: ");
        // implementar test
    }

}
