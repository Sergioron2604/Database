package com.mycompany.estudiante;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO implements DAO<Estudiante, Integer> {

    private static final String SELECT_BY_ID = "SELECT * FROM Estudiantes WHERE id_estudiante = ?";
    private static final String SELECT_ALL = "SELECT * FROM Estudiantes";
    private static final String INSERT = "INSERT INTO Estudiantes (nombre, edad, email, telefono, universidad) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE Estudiantes SET nombre = ?, edad = ?, email = ?, telefono = ?, universidad = ? WHERE id_estudiante = ?";
    private static final String DELETE = "DELETE FROM Estudiantes WHERE id_estudiante = ?";

    @Override
    public Estudiante findById(Integer id) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToEstudiante(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Estudiante> findAll() {
        List<Estudiante> estudiantes = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL)) {
            while (resultSet.next()) {
                estudiantes.add(mapResultSetToEstudiante(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }

    @Override
    public void insert(Estudiante estudiante) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, estudiante.getNombre());
            statement.setInt(2, estudiante.getEdad());
            statement.setString(3, estudiante.getEmail());
            statement.setString(4, estudiante.getTelefono());
            statement.setString(5, estudiante.getUniversidad());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                estudiante.setIdEstudiante(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Estudiante estudiante) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(UPDATE)) {
            statement.setString(1, estudiante.getNombre());
            statement.setInt(2, estudiante.getEdad());
            statement.setString(3, estudiante.getEmail());
            statement.setString(4, estudiante.getTelefono());
            statement.setString(5, estudiante.getUniversidad());
            statement.setInt(6, estudiante.getIdEstudiante());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Estudiante estudiante) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(DELETE)) {
            statement.setInt(1, estudiante.getIdEstudiante());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Estudiante mapResultSetToEstudiante(ResultSet resultSet) throws SQLException {
        Estudiante estudiante = new Estudiante();
        estudiante.setIdEstudiante(resultSet.getInt("id_estudiante"));
        estudiante.setNombre(resultSet.getString("nombre"));
        estudiante.setEdad(resultSet.getInt("edad"));
        estudiante.setEmail(resultSet.getString("email"));
        estudiante.setTelefono(resultSet.getString("telefono"));
        estudiante.setUniversidad(resultSet.getString("universidad"));
        return estudiante;
    }
}
