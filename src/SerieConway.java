import java.util.Scanner;

public class SerieConway {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        System.out.print("Cuantos renglones: ");
        int filas = escaner.nextInt();
        int[][] serie = new int[100][100];
        serie[0][0] = 1;
        for (int i = 0; i < (filas-1); i++) {
            for (int j = 0, k = 0, contador = 1; j > serie.length - 1 || k > serie.length - 1 || serie[i][k] != 0; j+=2, contador = 1) {
                while (serie[i][k] == serie[i][++k])
                    contador++;
                serie[i + 1][j] = contador;
                serie[i + 1][j + 1] = serie[i][k-1];
            }
        }
        printSerie(serie, filas);
        escaner.close();
    }
    
    static void printSerie(int[][] matriz, int filas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < 100 && matriz[i][j] != 0; j++)
                System.out.print(matriz[i][j] + "");
            System.out.println();
        }
    }
}
