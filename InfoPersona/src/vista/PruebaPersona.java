
package vista;
import modelo.*;

public class PruebaPersona {
    public static void main(String[] args) {
        
        Persona persona1 = new Persona("Luis");
        persona1.nacimiento.crearFecha(25, 10, 2003);
        persona1.hogar.setUbicacion(44, 7, 23);
        persona1.trabajo.setUbicacion(12, 5, 80);
        
        Persona persona2 = new Persona();
        persona2.setNombre("Alan");
        persona2.nacimiento.crearFecha(10, 02, 2000);
        persona2.hogar.setUbicacion(23, 4, 61);
        persona2.trabajo.setUbicacion(12, 16, 07);
        
        System.out.println("Datos persona\n");
        mostrarDatos(persona1);
        mostrarDatos(persona2);
    }
    public static void mostrarDatos(Persona persona){
        String nombre,fecha;
        nombre = persona.getNombre();
        fecha = persona.nacimiento.mostrarFecha();
        
        System.out.printf("%s nació el %s\n",nombre,fecha);
        System.out.printf("La direccion de su casa es %s",persona.hogar.getUbicacion());
        System.out.printf("\nLa direccion de su trabajo es %s\n\n",persona.trabajo.getUbicacion());
    }
}