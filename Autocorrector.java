import java.util.ArrayList;
import java.util.Scanner;

public class Autocorrector
{
    public static void main(String[] args)
    {
        ArrayList<String> diccionario = new ArrayList<String>();
       
        diccionario.add("Hola");
        diccionario.add("ordenador");
        diccionario.add("corrígeme");
        diccionario.add("la");
        diccionario.add("frase");
        diccionario.add("porfavor");
        diccionario.add("que");
        diccionario.add("tal");
        diccionario.add("estas");
        diccionario.add("muchas");
        diccionario.add("gracias");
        diccionario.add("adiós");
        diccionario.add("buenos");
        diccionario.add("dias");
        diccionario.add("tardes");
   
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escribe la frase :");
        String frase = entrada.nextLine();
        
        //quitar espacios al principio y final que no tienen que estar
        frase = frase.trim();
       
        String resultado = "";
       
        boolean mayuscula = false;
       
        int corregidas = 0;

        //recorro letras frase
        for (int i = 0; i < frase.length(); i++)
        {
            char caracter = frase.charAt(i);
           
            //primera letra mayuscula
            if(i == 0 && Character.isLowerCase(caracter)) 
            {
                caracter = Character.toUpperCase(caracter);
                corregidas++;
            }

           
            //mayuscula despues de espacio    
            if (mayuscula && caracter != ' ')
            {
                caracter = Character.toUpperCase(caracter);
                corregidas++;
                //reiniciamos proceso hasta nuevo punto
                mayuscula = false;
            }
               
            resultado = resultado + caracter;    
           
            //si es...
            if (caracter == '.' || caracter == ',' || caracter == ';' || caracter == ':')
            {
                //si no es un espacio
                if (frase.charAt(i + 1) != ' ')
                {
                    //imprimo espacio
                    resultado = resultado + " ";
                    corregidas++;
                }
            }
           
            //si hay punto iniciamos proceso de mayuscula detras de punto
            if (caracter == '.')
                mayuscula = true;
           
        }
        //punto al final
        if (!frase.endsWith(".")) {
            resultado = resultado + ".";
            corregidas++;
        }

       
        //contador palabras que no estan
        String[] palabras = resultado.split(" ");
        int contadorNoestan = 0;
       
        for (int i = 0; i < palabras.length; i++)
        {
            palabras[i] = palabras[i].replace(".", "").replace(",", "");
           
            //si no esta en el diccionario
            if (!diccionario.contains(palabras[i]))
            {
                contadorNoestan++;
               
            }
        }
       
        System.out.println(resultado);
        System.out.println("Se han corregido " + corregidas + " errores");
        System.out.println("Hay " + contadorNoestan + " palabras incorrectas ");
        entrada.close();
    }
}
