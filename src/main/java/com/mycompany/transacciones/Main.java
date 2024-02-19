package com.mycompany.transacciones;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TransaccionesDAO transaccionesDAO = TransaccionesDAO.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Desea guardar en un archivo de texto? (S/N): ");
        String opcion = scanner.nextLine();

        Transacciones nuevoUsuario = new Transacciones(1, 1, 1, "26/04/2023", 11551, "Nequi");

        if (opcion.equalsIgnoreCase("S")) {
            guardarEnArchivoTexto(nuevoUsuario);
            System.out.println("Guardado en archivo de texto.");
        } else {
            transaccionesDAO.save(nuevoUsuario);
            System.out.println("Guardado en la base de datos.");
        }

        List<Transacciones> Transaccion = transaccionesDAO.getAll();
        for (Transacciones Transacciones : Transaccion) {
            System.out.println(Transacciones.getTransaccion_ID()+ ", "+ Transacciones.getCuenta_ID()+ ", " + Transacciones.getUSUARIO_ID()+ ", " + Transacciones.getFecha()+ ", " + Transacciones.getMonto()+ ", " + Transacciones.getTipo());
        }
    }

    private static void guardarEnArchivoTexto(Transacciones Transacciones) {
        // Lógica para guardar en archivo de texto
    }
    
}