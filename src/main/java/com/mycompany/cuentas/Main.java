package com.company.cuentas;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CuentasDAO cuentasDAO = CuentasDAO.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Desea guardar en un archivo de texto? (S/N): ");
        String opcion = scanner.nextLine();

        Cuentas nuevoUsuario = new Cuentas(1, 1, "Debito", 14000);

        if (opcion.equalsIgnoreCase("S")) {
            guardarEnArchivoTexto(nuevoUsuario);
            System.out.println("Guardado en archivo de texto.");
        } else {
            cuentasDAO.save(nuevoUsuario);
            System.out.println("Guardado en la base de datos.");
        }

       List<Cuentas> Cuenta = cuentasDAO.getAll();
        for (Cuentas Cuentas : Cuenta) {
            System.out.println(Cuentas.getCuenta_ID()+ ", " + Cuentas.getUsuario_ID()+ ", " + Cuentas.getTipo()+ ", " + Cuentas.getSaldo());
        }
    }

    private static void guardarEnArchivoTexto(Cuentas Cuentas) {
        // Lógica para guardar en archivo de texto
    }
    
}
