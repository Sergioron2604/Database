package com.mycompany.usuario;

public class Usuario {
    private int USUARIO_ID;
    private String Nombre;
    private String Email;

    public Usuario(int USUARIO_ID, String Nombre, String Email) {
        this.USUARIO_ID = USUARIO_ID;
        this.Nombre = Nombre;
        this.Email = Email;
    }

    // Getters y setters
    public int getUSUARIO_ID() {
        return USUARIO_ID;
    }

    public void setId(int USUARIO_ID) {
        this.USUARIO_ID = USUARIO_ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}