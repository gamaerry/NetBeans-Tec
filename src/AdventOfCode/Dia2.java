package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Dia2 {
    public static void main(String[] args) {
        List<int[]> reportes = getMatrizFromTxt("src/AdventOfCode/input_dia2.txt", 1_000, " ");
        //primerProblema(reportes);
        segundoProblema(reportes);
    }

    static void segundoProblema(List<int[]> reportes) {
        long reportesConfiables = reportes.stream().filter(r -> {
            if (esConfiable(r)) 
                return true;
            for (int i = 0; i < r.length; i++) {
                int[] rTmp = r.clone();
                rTmp[i] = -1;
                rTmp = Arrays.stream(rTmp).filter(n -> n != -1).toArray();
                if (esConfiable(rTmp)) 
                    return true;
            }
            return false;
        }).count();
        System.out.println(reportesConfiables);
    }

    static void primerProblema(List<int[]> reportes) {
        System.out.println(reportes.stream().filter(r -> esConfiable(r)).count());
    }

    static boolean esConfiable(int[] reporte) {
        int creciente; // 1 verdadero, 0 falso, -1 ninguno
        creciente = reporte[0] < reporte [1] ? 1 : reporte[0] > reporte [1] ? 0 : -1;
        if (creciente == -1) 
            return false;
        for (int i = 0; i + 1 < reporte.length; i++) 
            if (seMantieneCreciente(reporte, i, i+1) != creciente || 
                !difierenCorrectamente(reporte[i], reporte[i + 1]))
                return false;
        return true;
    }

    static int seMantieneCreciente(int[] reporte, int i1, int i2) {
        return reporte[i1] < reporte [i2] ? 1 : reporte[i1] > reporte [i2] ? 0 : -1;
    }

    static boolean difierenCorrectamente(int a, int b) {
        int diferencia = Math.abs(a - b);
        return diferencia == 1 || diferencia == 2 || diferencia == 3;
    }

    static List<int[]> getMatrizFromTxt(String rutaRelativa, int filas, String separadorColumnas) {
        try (Scanner txtEscaneado = new Scanner(new File(rutaRelativa))) {
            List<int[]> matriz = new ArrayList<>();
            for (int i = 0; i < filas; i++) {
                String[] lineaActual = txtEscaneado.nextLine().split(separadorColumnas);
                int[] enterosLineaActual = new int[lineaActual.length];
                for (int j = 0; j < lineaActual.length; j++) 
                    enterosLineaActual[j] = Integer.parseInt( lineaActual[j] );
                matriz.add(enterosLineaActual);
            }
            return matriz;
        } catch (FileNotFoundException e) { return null; }
    }
}
