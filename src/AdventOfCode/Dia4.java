package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dia4 {
    static int filas = 0;
    static int columnas = 0;
    static int[][] matriz;
    public static void main(String[] args) {
        matriz = getListaFromTxt("src/AdventOfCode/input_dia4.txt");
        filas = matriz.length; columnas = matriz[0].length;
        problema2();
    }

    static void problema2() {
        int coincidencias = 0;
        for (int i = 0; i < filas; i++) 
            for (int j = 0; j < columnas; j++)
                coincidencias += getCoincidencias2(i, j);
        System.out.println(coincidencias);
    }

    static void problema1() {
        int coincidencias = 0;
        for (int i = 0; i < filas; i++) 
            for (int j = 0; j < columnas; j++)
                coincidencias += getCoincidencias(i, j);
        System.out.println(coincidencias);
    }

    static int getCoincidencias(int i, int j) { //2horiz, 2vertic, 2diag, 2 2diagInv
        if (matriz[i][j] == 0) return
            secuenciaCorrecta(i, j+1, i, j+2, i, j+3) + secuenciaCorrecta(i, j-1, i, j-2, i, j-3) +
            secuenciaCorrecta(i+1, j, i+2, j, i+3, j) + secuenciaCorrecta(i-1, j, i-2, j, i-3, j) +
            secuenciaCorrecta(i+1, j+1, i+2, j+2, i+3, j+3) + secuenciaCorrecta(i-1, j-1, i-2, j-2, i-3, j-3) +
            secuenciaCorrecta(i-1, j+1, i-2, j+2, i-3, j+3) + secuenciaCorrecta(i+1, j-1, i+2, j-2, i+3, j-3);
        else return 0;
    }

    static int getCoincidencias2(int i, int j) { 
        if (matriz[i][j] == 2 && rangoPermitido(i+1, j+1) && rangoPermitido(i-1, j-1)) 
            return secuenciaCorrecta2(i, j);
        else return 0;
    }

    static int secuenciaCorrecta2(int i, int j) {
        if (extremosValidos(i, j))
            return ordenValido(i, j) ? 1 : 0;
        else return 0;
    }

    static boolean ordenValido(int i, int j) {
        if (matriz[i + 1][j + 1] + matriz[i - 1][j + 1] + matriz[i + 1][j - 1] + matriz[i - 1][j - 1] == 8)
            return matriz[i + 1][j + 1] != matriz[i - 1][j - 1];
        else return false;
    }

    static boolean extremosValidos(int i, int j) {
        return matriz[i + 1][j + 1] % 2 == 1 && matriz[i - 1][j + 1] % 2 == 1 && matriz[i + 1][j - 1] % 2 == 1 && matriz[i - 1][j - 1] % 2 == 1;
    }

    static int secuenciaCorrecta(int i1, int j1, int i2, int j2, int i3, int j3) {
        if (rangoPermitido(i1, j1) && rangoPermitido(i2, j2) && rangoPermitido(i3, j3))
            return (matriz[i1][j1] == 1 && matriz[i2][j2] == 2 && matriz[i3][j3] == 3) ? 1 : 0;
        else return 0;
    }

    static boolean rangoPermitido(int i, int j) {
        return i >= 0 && i < filas && j >= 0 && j < columnas;
    }

    static int[][] getListaFromTxt(String rutaRelativa) {
        try (Scanner txtEscaneado = new Scanner(new File(rutaRelativa))) {
            List<String> lista = new ArrayList<>();
            while (txtEscaneado.hasNextLine()) {
                String lineaActual = txtEscaneado.nextLine();
                lista.add(lineaActual);
            }
            return lista.stream().map(cadena -> cadena.chars().map(c -> convertirChar(c)).toArray()).toArray(int[][]::new);
        } catch (FileNotFoundException e) { return null; }
    }

    static int convertirChar(int caracter) {
        return caracter == 'X' ? 0 : caracter == 'M' ? 1 : caracter == 'A' ? 2 : 3;
    }
}