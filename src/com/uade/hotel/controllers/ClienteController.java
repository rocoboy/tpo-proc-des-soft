package com.uade.hotel.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.uade.hotel.models.Cliente;

public class ClienteController {

    List<Cliente> clientes;

    public ClienteController() {
        this.clientes = new ArrayList<>();
    }

    public void cargarCliente(String nombre, String apellido, int dni, String preferencias, String email,
            String telefono) {

        if (encontrarCliente(dni) == null) {
            int idCliente = clientes.size() + 1;
            Cliente cliente = new Cliente(idCliente, nombre, apellido, dni, preferencias, email, telefono);
            this.clientes.add(cliente);
        } else {
            System.out.println("el cliente ya existe");
        }
    }

    public void modificarCliente(Integer idCliente, Cliente nuevoCliente) {
        clientes.set(encontrarIndexCliente(idCliente), nuevoCliente);
    }

    public Integer encontrarIndexCliente(Integer idCliente) {
        for (Cliente cliente : clientes) {
            if (Objects.equals(cliente.idCliente, idCliente)) {
                return clientes.indexOf(cliente);
            }
        }
        return -1;
    }

    public Cliente encontrarCliente(int dni) {
        for (Cliente cliente : clientes) {
            if (Objects.equals(cliente.dni, dni)) {
                return cliente;
            }
        }
        return null;
    }

    public void cambiarPreferencia(int idCliente, String nuevaPreferencia) {
        clientes.get(encontrarIndexCliente(idCliente)).preferenciaContacto = nuevaPreferencia;
    }

    public String obtenerPreferencia(int dni) {
        return encontrarCliente(dni).preferenciaContacto;
    }

    public void mostrarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println("Cliente Nro: " + cliente.idCliente + "   Nombre: " + cliente.nombre + "   Apellido: "
                    + cliente.apellido);
        }
    }
}
