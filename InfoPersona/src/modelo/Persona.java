package modelo;

public class Persona {
    
    private String nombre;
    public Fecha nacimiento = new Fecha();
    public Direccion hogar = new Direccion();
    public Direccion trabajo = new Direccion();
    
    public Persona(){this.nombre = "";}
    public Persona(String nombre){this.nombre = nombre;}
    
    public void setNombre(String nombre){this.nombre = nombre;}
    public String getNombre(){return this.nombre;}
}