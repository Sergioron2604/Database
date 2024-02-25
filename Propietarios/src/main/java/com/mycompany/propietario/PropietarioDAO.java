package com.mycompany.propietario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropietarioDAO implements DAO<Propietario, Integer> {

    private static final String SELECT_BY_ID = "SELECT * FROM Propietarios WHERE id_propietario = ?";
    private static final String SELECT_ALL = "SELECT * FROM Propietarios";
    private static final String INSERT = "INSERT INTO Propietarios (nombre, email, telefono) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE Propietarios SET nombre = ?, email = ?, telefono = ? WHERE id_propietario = ?";
    private static final String DELETE = "DELETE FROM Propietarios WHERE id_propietario = ?";

    @Override
    public Propietario findById(Integer id) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToPropietario(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Propietario> findAll() {
        List<Propietario> propietarios = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL)) {
            while (resultSet.next()) {
                propietarios.add(mapResultSetToPropietario(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return propietarios;
    }

    @Override
    public void insert(Propietario propietario) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, propietario.getNombre());
            statement.setString(2, propietario.getEmail());
            statement.setString(3, propietario.getTelefono());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                propietario.setIdPropietario(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Propietario propietario) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(UPDATE)) {
            statement.setString(1, propietario.getNombre());
            statement.setString(2, propietario.getEmail());
            statement.setString(3, propietario.getTelefono());
            statement.setInt(4, propietario.getIdPropietario());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Propietario propietario) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(DELETE)) {
            statement.setInt(1, propietario.getIdPropietario());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Propietario mapResultSetToPropietario(ResultSet resultSet) throws SQLException {
        Propietario propietario = new Propietario();
        propietario.setIdPropietario(resultSet.getInt("id_propietario"));
        propietario.setNombre(resultSet.getString("nombre"));
        propietario.setEmail(resultSet.getString("email"));
        propietario.setTelefono(resultSet.getString("telefono"));
        return propietario;
    }
}
