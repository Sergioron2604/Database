package com.mycompany.habitacion;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Crear instancia de HabitacionDAO
        HabitacionDAO habitacionDAO = new HabitacionDAO();

        // Insertar una nueva habitación
        Habitacion nuevaHabitacion = new Habitacion();
        nuevaHabitacion.setNombreHabitación("Habitación 101");
        nuevaHabitacion.setDescripción("Habitación individual con baño privado");
        nuevaHabitacion.setDirección("123 Calle Principal");
        nuevaHabitacion.setCiudad("Ciudad Universitaria");
        nuevaHabitacion.setPrecio(1500000);
        nuevaHabitacion.setDisponibilidad(true);
        nuevaHabitacion.setIdPropietario(1); // Id del propietario asociado
        habitacionDAO.insert(nuevaHabitacion);

        // Obtener todas las habitaciones y mostrarlas
        List<Habitacion> habitaciones = habitacionDAO.findAll();
        for (Habitacion habitacion : habitaciones) {
            System.out.println(habitacion);
        }
    }
}

