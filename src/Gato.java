
import java.util.Scanner;

public class Gato {
    static int[][] gato;
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        int dim;
        do {
            System.out.print("Ingrese las dimensiones del gato:");
            dim = escaner.nextInt();
        } while (dim != 3 || dim != 5 || dim != 7);
        System.out.print("Caracter del jugador 1:");
        char jugador1 = escaner.next().toUpperCase().charAt(0);
        System.out.print("Caracter del jugador 2:");
        char jugador2 = escaner.next().toUpperCase().charAt(0);
        int[][] gato = new int[dim][dim];
        printGato(gato);
    }
    static void printGato(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length ; j++) {
                System.out.print(matriz[i][j] + (j+1 == matriz[0].length ? "" : " | "));
            }
            System.out.println();
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(i+1 == matriz.length ? "" : " - ");
            }
            System.out.println();
        }
    }
}
