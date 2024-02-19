package com.mycompany.transacciones;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaccionesDAO implements CrudDAO<Transacciones> {
    private static TransaccionesDAO instance;
    private Connection connection;

    private TransaccionesDAO() {
        try {
            // Establecer la conexión a la base de datos SQL Server
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Construccion";
            String user = "Sergio"; 
            String password = "12345";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error al establecer conexión con la base de datos", e);
        }
    }

    public static TransaccionesDAO getInstance() {
        if (instance == null) {
            instance = new TransaccionesDAO();
        }
        return instance;
    }

    @Override
    public void save(Transacciones transaccion) {
        String sql = "INSERT INTO Transacciones (Transaccion_ID, Usuario_ID, Cuenta_ID, Monto, Fecha, Tipo) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, transaccion.getTransaccion_ID());
            statement.setInt(2, transaccion.getUSUARIO_ID());
            statement.setInt(3, transaccion.getCuenta_ID());
            statement.setDouble(4, transaccion.getMonto());
            statement.setString(5, transaccion.getFecha());
            statement.setString(6, transaccion.getTipo());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar transacción en la base de datos", e);
        }
    }

    @Override
    public void update(Transacciones transaccion) {
        String sql = "UPDATE Transacciones SET Monto=?, Fecha=?, Tipo=? WHERE Transaccion_ID=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, transaccion.getMonto());
            statement.setString(2, transaccion.getFecha());
            statement.setString(3, transaccion.getTipo());
            statement.setInt(4, transaccion.getTransaccion_ID());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar transacción en la base de datos", e);
        }
    }

    @Override
    public void delete(String primaryKey) {
        String sql = "DELETE FROM Transacciones WHERE Transaccion_ID=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, primaryKey);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar transacción de la base de datos", e);
        }
    }

    @Override
    public List<Transacciones> getAll() {
        List<Transacciones> transacciones = new ArrayList<>();
        String sql = "SELECT * FROM Transacciones";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Transacciones transaccion = new Transacciones(
                        resultSet.getInt("Transaccion_ID"),
                        resultSet.getInt("Usuario_ID"),
                        resultSet.getInt("Cuenta_ID"),
                        resultSet.getString("Fecha"),
                        resultSet.getDouble("Monto"),
                        resultSet.getString("Tipo")
                );
                transacciones.add(transaccion);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener transacciones de la base de datos", e);
        }
        return transacciones;
    }
}



