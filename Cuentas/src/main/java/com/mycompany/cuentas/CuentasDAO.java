package com.mycompany.cuentas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuentasDAO implements CrudDAO<Cuentas> {
    private static CuentasDAO instance;
    private Connection connection;

    private CuentasDAO() {
        try {
            // Establecer la conexión a la base de datos SQL Server
            String url;
            url = "jdbc:sqlserver://localhost:1433;databaseName=Construccion";
            String user = "Sergio"; 
            String password = "12345";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error al establecer conexión con la base de datos", e);
        }
    }

    public static CuentasDAO getInstance() {
        if (instance == null) {
            instance = new CuentasDAO();
        }
        return instance;
    }

    @Override
    public void save(Cuentas cuenta) {
        String sql = "INSERT INTO Cuentas (Cuenta_ID, Usuario_ID, Tipo, Saldo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, cuenta.getCuenta_ID());
            statement.setInt(2, cuenta.getUsuario_ID());
            statement.setString(3, cuenta.getTipo());
            statement.setDouble(4, cuenta.getSaldo());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar cuenta en la base de datos", e);
        }
    }

    @Override
    public void update(Cuentas cuenta) {
        String sql = "UPDATE Cuentas SET Tipo=?, Saldo=? WHERE Cuenta_ID=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cuenta.getTipo());
            statement.setDouble(2, cuenta.getSaldo());
            statement.setInt(3, cuenta.getCuenta_ID());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar cuenta en la base de datos", e);
        }
    }

    @Override
    public void delete(String primaryKey) {
        String sql = "DELETE FROM Cuentas WHERE Cuenta_ID=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, primaryKey);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar cuenta de la base de datos", e);
        }
    }

    @Override
    public List<Cuentas> getAll() {
        List<Cuentas> cuentas = new ArrayList<>();
        String sql = "SELECT * FROM Cuentas";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Cuentas cuenta = new Cuentas(
                        resultSet.getInt("Cuenta_ID"),
                        resultSet.getInt("Usuario_ID"),
                        resultSet.getString("Tipo"),
                        resultSet.getDouble("Saldo")
                );
                cuentas.add(cuenta);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener cuentas de la base de datos", e);
        }
        return cuentas;
    }
}
