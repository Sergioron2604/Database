package com.mycompany.propietario;


public class Propietario{
   private int IdPropietario;
   private String Nombre;
   private String Email;
   private String Telefono;

 public Propietario(){
     
 }

   public Propietario(int IdPropietario, String Nombre, String Email, String Telefono) {
        this.IdPropietario = IdPropietario;
        this.Nombre = Nombre;
        this.Email = Email;
        this.Telefono = Telefono;
    }
   
 public int getIdPropietario() {
        return IdPropietario;
    }

    public void setIdPropietario(int IdPropietario) {
        this.IdPropietario = IdPropietario;
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

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
 
  
      
}