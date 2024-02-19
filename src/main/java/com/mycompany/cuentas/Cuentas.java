package com.company.cuentas;

public class Cuentas {
    private int Cuenta_ID;
    private int Usuario_ID;
    private String Tipo;
    private double Saldo;

    public Cuentas(int Cuenta_ID, int Usuario_ID, String Tipo, double Saldo) {
        this.Cuenta_ID = Usuario_ID;
        this.Usuario_ID = Cuenta_ID;
        this.Tipo = Tipo;
        this.Saldo = Saldo;
    }

    
      public int getCuenta_ID() {
        return Cuenta_ID;
    }

    public void setCuenta_ID(int Cuenta_ID ) {
        this.Cuenta_ID = Cuenta_ID;
    }
    
    
    public int getUsuario_ID() {
        return Usuario_ID;
    }

    public void setUsuario_ID(int Usuario_ID ) {
        this.Usuario_ID = Usuario_ID;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }
}
