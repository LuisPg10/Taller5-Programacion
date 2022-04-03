
package modelo;

public class Direccion {
    
    private int calle,carrera,numCasa;
    
    public Direccion(int calle,int carrera,int numCasa){
        this.calle = calle;
        this.carrera = carrera;
        this.numCasa = numCasa;
    }
    public Direccion(){
        this(0,0,0);
    }
    
    public void setUbicacion(int calle,int carrera,int numCasa){
        this.calle = calle;
        this.carrera = carrera;
        this.numCasa = numCasa;
    }
    public String getUbicacion(){
        return "Calle "+this.calle+" # "+this.carrera+"-"+numCasa;
    }
}