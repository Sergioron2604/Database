
package com.mycompany.usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements CrudDAO<Usuario> {
    private static UsuarioDAO instance;
    private Connection connection;

    private UsuarioDAO() {
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

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }

    @Override
    public void save(Usuario usuario) {
        String sql = "INSERT INTO Usuarios (Usuario_ID, Nombre, Email) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, usuario.getUSUARIO_ID());
            statement.setString(2, usuario.getNombre());
            statement.setString(3, usuario.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar usuario en la base de datos", e);
        }
    }

    @Override
    public void update(Usuario usuario) {
        String sql = "UPDATE Usuarios SET Nombre=?, Email=? WHERE Usuario_ID=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getEmail());
            statement.setInt(3, usuario.getUSUARIO_ID());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar usuario en la base de datos", e);
        }
    }

    @Override
    public void delete(String primaryKey) {
        String sql = "DELETE FROM Usuarios WHERE Usuario_ID=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, primaryKey);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar usuario de la base de datos", e);
        }
    }

    @Override
    public List<Usuario> getAll() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Usuario usuario = new Usuario(
                        resultSet.getInt("Usuario_ID"),
                        resultSet.getString("Nombre"),
                        resultSet.getString("Email")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener usuarios de la base de datos", e);
        }
        return usuarios;
    }
}


