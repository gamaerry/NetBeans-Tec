import java.util.Random;
import java.util.Scanner;

public class Arreglos3 {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        Random random = new Random();
        int NUMERO_DE_CADENAS = random.nextInt(9-4+1) + 4;
        int[] longitudes = new int[NUMERO_DE_CADENAS];
        System.out.println("Cadenas a ingresar: " + NUMERO_DE_CADENAS);
        for (int i = 0; i < NUMERO_DE_CADENAS; i++) {
            String cadenaActual = escaner.nextLine();
            longitudes[i] = cadenaActual.length();
        }
        System.out.println("Las longitudes quedaron: ");
        for (int j = 0; j < longitudes.length; j++) {
            if(j + 1 == longitudes.length)
                System.out.println(longitudes[j]);
            else 
                System.out.print(longitudes[j]+", ");
        }
    }
}
