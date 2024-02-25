package com.mycompany.propietario;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Crear instancia de propietarioDAO
        PropietarioDAO propietarioDAO = new PropietarioDAO();

        // Insertar una nueva habitación
        Propietario propietario = new Propietario();
        propietario.setNombre("Andres Rodriguez");
        propietario.setEmail("AndreRodrigez12@gmail.com");
        propietario.setTelefono("3145896535");
        propietario.setIdPropietario(1); // Id del propietario
        propietarioDAO.insert(propietario);

        // Listar los propietarios
        List<Propietario> propietarios = propietarioDAO.findAll();
        for (Propietario Propietario : propietarios) {
            System.out.println(propietario);
        }
    }
}

