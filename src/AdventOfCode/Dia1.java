package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Dia1 {
    public static void main(String[] args) {
        int[][] listas = getMatrizFromTxt("src/AdventOfCode/input_dia1.txt", 1_000, 2, "   ");
        primerProblema(listas);
        segundoProblema(listas);
    }

    static void primerProblema(int[][] listas) {
        int suma = 0;
        for (int i = 0; i < listas[0].length; i++)
            suma += Math.abs(listas[0][i] - listas[1][i]);
        System.out.println(suma);
    }

    static void segundoProblema(int[][] listas) {
        int suma = 0;
        for (int i = 0; i < listas[0].length; i++){
            int j = 0, ocurrencias = 0;
            while (j <= listas[1].length - 1 && listas[0][i] >= listas[1][j]) {
                if (listas[0][i] == listas[1][j++])
                    ocurrencias++;
            }
            suma += listas[0][i] * ocurrencias;
        }
        System.out.println(suma);
    }

    static int[][] getMatrizFromTxt(String rutaRelativa, int filas, int columnas, String separadorColumnas) {
        try (Scanner txtEscaneado = new Scanner(new File(rutaRelativa))) {
            int[] lista1 = new int[filas];
            int[] lista2 = new int[filas];
            for (int i = 0; i < filas; i++) {
                String[] lineaActual = txtEscaneado.nextLine().split(separadorColumnas);
                    lista1[i] = Integer.parseInt(lineaActual[0]);
                    lista2[i] = Integer.parseInt(lineaActual[1]);
            }
            Arrays.sort(lista1);
            Arrays.sort(lista2);
            return new int[][] {lista1, lista2};
        } catch (FileNotFoundException e) { return null; }
    }
}
