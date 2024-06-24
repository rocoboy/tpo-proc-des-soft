package com.uade.hotel.testunitarios;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Defino las variables para usar con la consola
        Scanner scanner = new Scanner(System.in);
        int rol = 1;

        while (rol != 0) {
            menuPrincipal();
            rol = scanner.nextInt();

            switch (rol) {
                case 1:
                    testearClientes();
                    break;
                case 2:
                    testearHabitacion();
                    break;
                case 3:
                    testearReserva();
                    break;
                default:
                    break;
            }
            // Esperamos a que el cliente presione una tecla para continuar
            System.out.println("\nPresione una tecla para continuar");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clearConsole(); // Mueve esta línea aquí
        }
        scanner.close();
    }

    public static void menuPrincipal() {
        System.out.println("Bienvenido, indique que desea hacer");
        System.out.println("1. Ejecutar tests de clientes");
        System.out.println("2. Ejecutar tests de habitación");
        System.out.println("3. Ejecutar tests de reserva");
        System.out.println("0. Salir");
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void testearClientes() {
        TestCliente testCliente = new TestCliente();
        testCliente.crearCliente();
        testCliente.crearClienteDuplicado();
        testCliente.eliminarCliente();
    }

    public static void testearHabitacion() {
        TestHabitacion testHabitacion = new TestHabitacion();
        testHabitacion.crearHabitacionComun();
        testHabitacion.crearHabitacionSuite();
        testHabitacion.ocuparHabitacion();
        testHabitacion.liberarHabitacion();
        testHabitacion.filtrarHabitacionesPorTipo();
    }

    public static void testearReserva() {
        TestReserva testReserva = new TestReserva();
        testReserva.crearReserva();
        testReserva.cancelarReserva();
        testReserva.pagarReserva();
        testReserva.testearCancelacionAutomatica();
        testReserva.testearObserverReserva();
    }
}
