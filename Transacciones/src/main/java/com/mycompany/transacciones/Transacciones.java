package com.mycompany.transacciones;

public class Transacciones {
    private int Transaccion_ID;
    private int Usuario_ID;
    private int Cuenta_ID;
    private String Fecha;
    private double Monto;
    private String Tipo;

    public Transacciones(int Transaccion_ID,int USUARIO_ID,int Cuenta_ID , String Fecha, double Monto, String Tipo) {
        this.Transaccion_ID= Transaccion_ID;
        this.Usuario_ID = USUARIO_ID;
        this.Cuenta_ID = Cuenta_ID;
        this.Fecha = Fecha;
         this.Monto= Monto;
         this.Tipo= Tipo;
    }
    
    // Getters y setters
    
     public int getTransaccion_ID() {
        return Transaccion_ID;
    }

    public void setTransaccion_ID(int Transaccion_ID) {
        this.Transaccion_ID = Transaccion_ID;
    }
    
    public int getUSUARIO_ID() {
        return Usuario_ID;
    }

    public void setId(int USUARIO_ID) {
        this.Usuario_ID = USUARIO_ID;
    }
    
    
     public int getCuenta_ID() {
        return Cuenta_ID;
    }

    public void setCuenta_ID(int Cuenta_ID) {
        this.Cuenta_ID = Cuenta_ID;
    }


    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }
    
     public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
}