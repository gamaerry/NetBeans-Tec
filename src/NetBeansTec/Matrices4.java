package NetBeansTec;

import java.util.Random;

public class Matrices4 {
    static final Random random = new Random();
    public static void main(String[] args) {
        final int N = digitoRandom(2,6), M = digitoRandom(2,6), longitudDeCadena =2*N*M;
        String cadena = "";
        int[][] matriz = new int[N][M];
        for (int i = 0; i < longitudDeCadena; i++) {
            cadena += digitoRandom(0, 9);
        }
        int contador = 0;
        for (int[] renglones: matriz) {
            for (int i = 0; i < renglones.length; i++) {
                renglones[i] = Integer.parseInt(cadena.charAt(contador++) + "" + cadena.charAt(contador++));
            }
        }
        System.out.println("N="+N+", M="+M+", 2*N*M="+longitudDeCadena);
        System.out.println(cadena);
        printMatriz(matriz);
    }
    static int digitoRandom(int limInferior, int limSuperior) { 
        return random.nextInt(limSuperior-limInferior+1)+limInferior; 
    }
    static void printMatriz(int[][] matriz) {
        for (int[] renglon : matriz) {
            for (int celda : renglon)
                System.out.print(celda + "\t");
            System.out.println();
        }
    }
}
