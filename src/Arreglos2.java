import java.util.Scanner;
public class Arreglos2 {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        System.out.println("Ingresa cadena:");
        String cadena = escaner.nextLine();
        char[] caracteres = new char[cadena.length()];
        for (int i = 0; i < caracteres.length; i++) {
            caracteres[i] = cadena.charAt(i);
        }
        System.out.println("Impresion del arreglo caracteres: ");
        System.out.println(caracteres);
    }
}
