package ProjectEuler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaximumPathSum2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner txtEscaneado = new Scanner(new File("src/ProjectEuler/0067_triangle.txt"));
        int[][] piramide = new int[100][100];
        for (int i = 0; i < piramide.length; i++) {
            String[] lineaActual = txtEscaneado.nextLine().split(" ");
            for (int j = 0; j < lineaActual.length; j++) 
                piramide[i][j] = Integer.parseInt( lineaActual[j] );
        }
        for (int i = piramide.length - 1; i > 0; i--) 
            for (int j = 0; j < i; j++) // index i coincide con el # elementos de anterior
                piramide[i - 1][j] += Math.max(piramide[i][j], piramide[i][j + 1]);
        System.out.println(piramide[0][0]);
        txtEscaneado.close();
    }
}
