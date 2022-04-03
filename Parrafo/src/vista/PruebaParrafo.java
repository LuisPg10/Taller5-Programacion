package vista;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import modelo.Parrafo;

public class PruebaParrafo {
    public static void main(String[] args) {
        
        Parrafo parrafo = new Parrafo();
        JTextArea texto = new JTextArea(30,50);
        texto.setLineWrap(true);
        
        JOptionPane.showMessageDialog(null,texto,"Parrafo a procesar",-1);
        parrafo.setText(texto.getText());
        
        String opciones[] = {
            "Número de vocales",
            "Número de consonantes",
            "Número de simbolos",
            "Número de palabras",
            "Repeticiones de una palabra",
            "Vocal que más aparece",
            "Palabra más Larga"};
        
        String desicion = (String) JOptionPane.showInputDialog(null,"¿Que desea conocer?","Opciones"
                    ,JOptionPane.DEFAULT_OPTION,null,opciones,opciones[0]);
        
        int opciones2[] = {parrafo.nVocales(),parrafo.nConsonantes()
                ,parrafo.nSimbolos(),parrafo.nPalabras()};
        
        for(int i=0;i<4;i++){
            
            if(desicion.equals(opciones[i])){
                JOptionPane.showMessageDialog(null,opciones[i]+": "+opciones2[i]);
                break;
            }
        }
        if(desicion.equals(opciones[4])){
            String palabra = JOptionPane.showInputDialog(null,
                    "Que palabra desea contar","Buscador",-1);
            
            JOptionPane.showMessageDialog(null,"La palabra "+palabra+" aparece "
                    +parrafo.buscar(palabra)+" veces");
            
        }else if(desicion.equals(opciones[5])){
            JOptionPane.showMessageDialog(null,"La vocal que más se repite es la "+parrafo.vocalModa());
            
        }else if(desicion.equals(opciones[6])){
            JOptionPane.showMessageDialog(null, parrafo.palabraMayor());
        }
    }
}