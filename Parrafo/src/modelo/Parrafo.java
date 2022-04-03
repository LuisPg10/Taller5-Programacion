package modelo;
import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parrafo {
    
    private String texto;
    private Pattern expresion;private Matcher buscador;
    
    public Parrafo(){this.texto = "";}
    public Parrafo(String texto){this.texto = texto;}
    
    public void setText(String text){this.texto = text;}
    public String getText(){return this.texto;}
    
    public int nVocales(){return conteo("[(aeiou)]");}
    public int nConsonantes(){return conteo("[^(aeiou)&&(a-z)]");}
    public int nSimbolos(){return conteo("[(\\W)&&(\\S)]");}
    
    public int buscar(String palabra ){
        
        String palabraBase = Normalizer.normalize(palabra, Normalizer.Form.NFD)
                .replaceAll("[\\u0300-\\u036f]", "").toLowerCase();
        
        return conteo(palabraBase);
    }
    public String vocalModa(){
        
        String textoBasico = Normalizer.normalize(this.texto, Normalizer.Form.NFD)
        .replaceAll("[\\u0300-\\u036f]", "").toLowerCase();
        
        expresion = Pattern.compile("[(aeiou)]");
        buscador = expresion.matcher(textoBasico);
        
        int num_vocales[] = new int[5];
        String vocales[] = {"a","e","i","o","u"};
        int size = textoBasico.length();
        
        while(size>0){
            
            if(buscador.find()){
                switch(buscador.group()){
                    case "a": num_vocales[0]++;break;
                    case "e": num_vocales[1]++;break;
                    case "i": num_vocales[2]++;break;
                    case "o": num_vocales[3]++;break;
                    case "u": num_vocales[4]++;break;
                }
            }
            size--;
        }
       
        int num_MaxVocal = num_vocales[0];
        String MaxVocal = vocales[0];
        
        for(int i=0;i<5;i++){
            if(num_vocales[i]>num_MaxVocal){
                num_MaxVocal = num_vocales[i];
                MaxVocal = vocales[i];
            }
        }
        return MaxVocal;
    }
    
    public int nPalabras(){
        
        String textoBase = Normalizer.normalize(this.texto, Normalizer.Form.NFD)
                .replaceAll("[^(a-zA-Z)&&\\S]", "").toLowerCase();
        String cPalabras[] = textoBase.split(" ");
        
        return cPalabras.length;
    }
    public String palabraMayor(){
        
        String textoBase = this.texto.replaceAll("[^(a-zA-ZñÑ)&&\\S]", "").toLowerCase();
        
        String cPalabras[] = textoBase.split(" ");
        int cantidad[] = new int[cPalabras.length];
        
        for(int i=0;i<cPalabras.length;i++){
            cantidad[i] = cPalabras[i].length();
        }
        
        String PalabraMayor = cPalabras[0];
        int MaxPalabra = cantidad[0];
        
        for(int i=0;i<cPalabras.length;i++){
            if(cantidad[i]>MaxPalabra){
                MaxPalabra = cantidad[i];
                PalabraMayor = cPalabras[i];
            }
        }
        
        return "La palabra más larga es "+PalabraMayor+" con un largo de "+MaxPalabra;
    }
    
    public int conteo(String regex){
        
        int contador = 0;
        String textoBasico = Normalizer.normalize(this.texto, Normalizer.Form.NFD)
                .replaceAll("[\\u0300-\\u036f]", "").toLowerCase();
        
        expresion = Pattern.compile(regex);
        buscador = expresion.matcher(textoBasico);

        for(int i=0;i<textoBasico.length();i++){
            if(buscador.find())
                contador++;
        }
        
        return contador;
    }
}