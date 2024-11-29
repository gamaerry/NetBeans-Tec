package ProjectEuler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class P18MaximumPathSum1 {
    static String s = """
75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
    """;
    public static void main(String[] args) {
        int[][] piramide = P11LargestProductInAGrid.getMatrizFromString(s, 15, 15);
        System.out.println(getMaximaSuma2(piramide));
    }

    static int getMaximaSuma2(int[][] piramide) {
        return LongStream.range(0, 1L << (piramide.length - 1))
        .parallel()
        .mapToInt(binario -> calcularSuma(binario, piramide)) 
        .max()
        .orElse(0);
        // notese que a pesar de que getMaximaSuma2() es mas eficiente que
        // getMaximaSuma() sigue sin ser suficiente para resolver el P68
    }

    private static int calcularSuma(long binarioActual, int[][] piramide) {
        int columnaActual = 0, suma = piramide[0][0];
        for (int i = 1; i < piramide.length; i++) {
            columnaActual += (binarioActual & (1L << (i - 1))) != 0 ? 1 : 0;
            // puesto que el camino binarioActual representa las rutas 
            // (a la izq o derec de la piramide) desde su ultimo bit 
            // al comparar con AND con ese unico ultimo bit se verifica 
            // si es 1 o 0, podria decirse que i-1 indica la posicion 
            // especifica del "paso actual" en el binarioActual
            suma += piramide[i][columnaActual];
        }
        return suma;
    }

    static int getMaximaSuma(int[][] piramide) {
        return getCaminoBinario(piramide.length - 1).parallelStream().mapToInt(posibilidad -> {
            int sumaPosibilidad = piramide[0][0];
            for (int i = 1, columnaActual = 0; i < piramide.length; i++) {
                columnaActual += Integer.parseInt(posibilidad.charAt(i-1) + "");
                sumaPosibilidad += piramide[i][columnaActual];
            }
            return sumaPosibilidad;
        }).max().orElse(0);
        // Toda el uso de la funcion mapToInt de stream fue porque en el método
        // forEach de List<String> no permitia modificar una variable externa
    }

    static List<String> getCaminoBinario(int bits) {
        int posibilidades = 1 << bits; // esto equivalente a elevar 2^n
        List<String> caminoBinario = new ArrayList<>(posibilidades);
        for (int i = 0; i < posibilidades; i++) 
            caminoBinario.add(String.format("%"+bits+"s", Integer.toBinaryString(i)).replace(" ", "0"));
        return caminoBinario;
    }
}
