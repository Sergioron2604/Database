package com.mycompany.habitacion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabitacionDAO implements DAO<Habitacion, Integer> {

    private static final String SELECT_BY_ID = "SELECT * FROM Habitaciones WHERE id_habitacion = ?";
    private static final String SELECT_ALL = "SELECT * FROM Habitaciones";
    private static final String INSERT = "INSERT INTO Habitaciones (nombre_habitacion, descripcion, direccion, ciudad, precio, disponible, id_propietario) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE Habitaciones SET nombre_habitacion = ?, descripcion = ?, direccion = ?, ciudad = ?, precio = ?, disponible = ?, id_propietario = ? WHERE id_habitacion = ?";
    private static final String DELETE = "DELETE FROM Habitaciones WHERE id_habitacion = ?";

    @Override
    public Habitacion findById(Integer id) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToHabitacion(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Habitacion> findAll() {
        List<Habitacion> habitaciones = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL)) {
            while (resultSet.next()) {
                habitaciones.add(mapResultSetToHabitacion(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return habitaciones;
    }

    @Override
    public void insert(Habitacion habitacion) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, habitacion.getNombreHabitación());
            statement.setString(2, habitacion.getDescripción());
            statement.setString(3, habitacion.getDirección());
            statement.setString(4, habitacion.getCiudad());
            statement.setDouble(5, habitacion.getPrecio());
            statement.setBoolean(6, habitacion.getDisponibilidad());
            statement.setInt(7, habitacion.getIdPropietario());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                habitacion.setIdHabitacion(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Habitacion habitacion) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(UPDATE)) {
            statement.setString(1, habitacion.getNombreHabitación());
            statement.setString(2, habitacion.getDescripción());
            statement.setString(3, habitacion.getDirección());
            statement.setString(4, habitacion.getCiudad());
            statement.setDouble(5, habitacion.getPrecio());
            statement.setBoolean(6, habitacion.getDisponibilidad());
            statement.setInt(7, habitacion.getIdPropietario());
            statement.setInt(8, habitacion.getIdHabitacion());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Habitacion habitacion) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(DELETE)) {
            statement.setInt(1, habitacion.getIdHabitacion());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Habitacion mapResultSetToHabitacion(ResultSet resultSet) throws SQLException {
        Habitacion habitacion = new Habitacion();
        
        habitacion.setIdHabitacion(resultSet.getInt("id_habitacion"));
        habitacion.setNombreHabitación(resultSet.getString("nombre_habitacion"));
        habitacion.setDescripción(resultSet.getString("descripcion"));
        habitacion.setDirección(resultSet.getString("direccion"));
        habitacion.setCiudad(resultSet.getString("ciudad"));
        habitacion.setPrecio(resultSet.getDouble("precio"));
        habitacion.setDisponibilidad(resultSet.getBoolean("disponible"));
        habitacion.setIdPropietario(resultSet.getInt("id_propietario"));
        return habitacion;
    }
}
