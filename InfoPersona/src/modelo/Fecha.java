
package modelo;

public class Fecha {
    private int dia,mes,year;
   
    public Fecha(){
        dia = 0;
        mes = 0;
        year = 0;
    }

    public void setDia(int dia) {this.dia = dia;}
    public void setMes(int mes) {this.mes = mes;}
    public void setYear(int year) {this.year = year;}
    
    public int getDia() {return dia;}
    public int getMes() {return mes;}
    public int getYear() {return year;}
    
    public void crearFecha(int dia, int mes, int year){
        this.dia  = dia;
        this.mes = mes;
        this.year = year;
    }
    public String mostrarFecha(){return dia+"/"+mes+"/"+year;}
}