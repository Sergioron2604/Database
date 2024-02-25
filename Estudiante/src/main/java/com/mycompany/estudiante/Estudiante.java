package com.mycompany.estudiante;

public class Estudiante{
    private int IdEstudiante;
    private String Nombre;
    private int Edad;
    private String Email;
    private String Telefono;
    private String Universidad;
    
    
    public Estudiante(){
     
    }

    public Estudiante (int IdEstudiante ,String Nombre, int Edad ,String Email, String Telefono, String Universidad){
        this.IdEstudiante = IdEstudiante;
        this.Nombre= Nombre;
        this.Edad = Edad;
        this.Email= Email;
        this.Telefono= Telefono;
        this.Universidad =Universidad;
            
    }
    
    public int getIdEstudiante(){
        return IdEstudiante;
    }
    
    public void setIdEstudiante(int IdEstudiante){
        this.IdEstudiante = IdEstudiante;
    }
    
    public String getNombre(){
        return Nombre;
    }
    
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }
    
    public int getEdad(){
        return Edad;
    }
    
    public void setEdad(int Edad){
        this.Edad = Edad;
    }
    
    
    public String getEmail(){
        return Email;
    }
    
    public void setEmail(String Email){
        this.Email = Email;
    }
    
    public String getTelefono(){
        return Telefono;
    }
    
    public void setTelefono(String Telefono){
        this.Telefono = Telefono;
    }
    
    
    public String getUniversidad(){
        return Universidad;
    }
    
    public void setUniversidad(String Universidad){
        this.Universidad = Universidad;
    }
    
    
}