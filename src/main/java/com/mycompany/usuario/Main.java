package com.mycompany.usuario;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Desea guardar en un archivo de texto? (S/N): ");
        String opcion = scanner.nextLine();

        Usuario nuevoUsuario = new Usuario(1, "John", "john123@gmail.com");

        if (opcion.equalsIgnoreCase("S")) {
            guardarEnArchivoTexto(nuevoUsuario);
            System.out.println("Guardado en archivo de texto.");
        } else {
            usuarioDAO.save(nuevoUsuario);
            System.out.println("Guardado en la base de datos.");
        }

        List<Usuario> usuarios = usuarioDAO.getAll();
        for (Usuario Usuario : usuarios) {
            System.out.println(Usuario.getUSUARIO_ID() + ", " + Usuario.getNombre() + ", " + Usuario.getEmail());
        }
    }

    private static void guardarEnArchivoTexto(Usuario usuario) {
        // Lógica para guardar en archivo de texto
    }
    
}