package com.mycompany.estudiante;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Crear instancia de EstudianteDAO
        EstudianteDAO estudianteDAO = new EstudianteDAO();

        // Insertar un nuevo estudiante
        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setNombre("Sergio Roncacio");
        nuevoEstudiante.setEdad(20);
        nuevoEstudiante.setEmail("sfroncancio71@ucatolica.edu.co");
        nuevoEstudiante.setTelefono("123456789");
        nuevoEstudiante.setUniversidad("Universidad Catolica");
        estudianteDAO.insert(nuevoEstudiante);

        // Obtener todos los estudiantes y mostrarlos
        List<Estudiante> estudiantes = estudianteDAO.findAll();
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }
}
