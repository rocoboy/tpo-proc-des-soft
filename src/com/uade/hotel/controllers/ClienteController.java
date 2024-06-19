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

    public void cargarCliente(Cliente cliente) {
        this.clientes.add(cliente);
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

    public Cliente encontrarCliente(Integer idCliente) {
        for (Cliente cliente : clientes) {
            if (Objects.equals(cliente.idCliente, idCliente)) {
                return cliente;
            }
        }
        return null;
    }

    public void cambiarPreferencia(Integer idCliente, String nuevaPreferencia) {
        clientes.get(encontrarIndexCliente(idCliente)).preferenciaContacto = nuevaPreferencia;
    }

    public String obtenerPreferencia(Integer idCliente) {
        return encontrarCliente(idCliente).preferenciaContacto;
    }

    public void mostrarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println("Cliente Nro: " + cliente.idCliente + "   Nombre: " + cliente.nombre + "   Apellido: "
                    + cliente.apellido);
        }
    }
}
