package com.mycompany.habitacion;

public class Habitacion{
    private int IdHabitacion;
    private String NombreHabitación;
    private String Descripción;
    private String Dirección;
    private String Ciudad;
    private double Precio;
    private boolean Disponibilidad;
    private int IdPropietario;
    
    
    public Habitacion(){
    }
    
    public Habitacion (int IdHabitacion,String NombreHabitación,String Descripción,String Dirección,String Ciudad ,double Precio,boolean Disponibilidad, int IdPropietario){
      this.IdHabitacion = IdHabitacion;
      this.NombreHabitación = NombreHabitación;
      this.Descripción = Descripción;
      this.Dirección = Dirección;
      this.Ciudad = Ciudad;
      this.Precio = Precio;
      this.Disponibilidad = Disponibilidad;
      this.IdPropietario = IdPropietario;
    }

    
    
    public int getIdHabitacion() {
        return IdHabitacion;
    }

    public void setIdHabitacion(int IdHabitacion) {
        this.IdHabitacion = IdHabitacion;
    }

    public String getNombreHabitación() {
        return NombreHabitación;
    }

    public void setNombreHabitación(String NombreHabitación) {
        this.NombreHabitación = NombreHabitación;
    }

    public String getDescripción() {
        return Descripción;
    }

    public void setDescripción(String Descripción) {
        this.Descripción = Descripción;
    }

    public String getDirección() {
        return Dirección;
    }

    public void setDirección(String Dirección) {
        this.Dirección = Dirección;
    }
    
    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }
    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public boolean getDisponibilidad() {
        return Disponibilidad;
    }

    public void setDisponibilidad(boolean Disponibilidad) {
        this.Disponibilidad = Disponibilidad;
    }

    public int getIdPropietario() {
        return IdPropietario;
    }

    public void setIdPropietario(int IdPropietario) {
        this.IdPropietario = IdPropietario;
    }
    
}