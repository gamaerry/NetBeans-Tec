package NetBeansTec;

import java.util.Scanner;

public class Arreglos5 {
    public static void main(String[] args) {
        Scanner escaner=new Scanner(System.in);
        String arreglo[]={"Benito", "Carlos", "Dana", "Daniel", "Jorge", "Miriam", "Osiel", "Pedro"};
        boolean coincidencia=false;
        int inicio=0,fin=arreglo.length-1,actual=0;
        System.out.print("Ingresar valor a buscar: ");
        String elementoBuscado = escaner.next();
        System.out.println("Considerar mayusculas y minusculas?");
        boolean ignoreCase = respuestaAfirmativa(escaner.next().toLowerCase());
        
        while(inicio<=fin && !coincidencia){
            actual=(inicio+fin)/2;
            if(!ignoreCase)
                 coincidencia = arreglo[actual].equalsIgnoreCase(elementoBuscado);
            else
                 coincidencia = arreglo[actual].equals(elementoBuscado);
            if (arreglo[actual].compareTo(elementoBuscado)>0)
                 fin=actual-1;
            else if (arreglo[actual].compareTo(elementoBuscado)<0)
                 inicio=actual+1;
        }
        
        if(coincidencia)
           System.out.println("El elemento "+elementoBuscado+" si se encontro en la celda "+actual);
        else
           System.out.println("El elemento "+ elementoBuscado+ " no se encontro");
  
    }
    static boolean respuestaAfirmativa(String r) {
        return r.equals("s") || r.equals("si") || r.equals("sí") || r.equals("y") || r.equals("yes"); 
    }
}
