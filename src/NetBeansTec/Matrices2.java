package NetBeansTec;
import java.util.Random;
import java.util.Scanner;

/*
 * Lopez Hernandez Luis Gerardo
 */
public class Matrices2 {
    static final Random random = new Random();
    static final Scanner escaner = new Scanner(System.in);
    public static void main(String[] args) {
        String opcionElegida;
        do {
            System.out.print("Programa a ejecutar? A Promedio por renglón, B Intercambio de renglones: ");
            opcionElegida = escaner.nextLine().toUpperCase();
            if (opcionElegida.equals("A"))
                ejercicio4();
            else if (opcionElegida.equals("B"))
                ejercicio5();
        } while (opcionElegida.equals("A") || opcionElegida.equals("B"));
        escaner.close();
    }

    static void ejercicio5() {
        int[][] matriz = {{4, 7, 8, 2, 3, 3, 2, 1},
            {34, 5, 5, 1, 1, 2, 2, 2},
            {2, 90, 2, 0, 12, 5, 8, 3}};
        System.out.println("Matriz original:");
        printMatriz(matriz);
        int primerRenglon, segundoRenglon;
        boolean renglonesValidos;
        do {
            System.out.print("Ingresar primer renglón del intercambio: ");
            primerRenglon = escaner.nextInt();
            System.out.print("Ingresar segundo renglón del intercambio: ");
            segundoRenglon = escaner.nextInt();
            renglonesValidos = primerRenglon >= 0 && primerRenglon < matriz.length && segundoRenglon >= 0 && segundoRenglon < matriz.length;
            if (!renglonesValidos)
                System.out.println("Error: los renglones ingresados no son válidos.");
        } while (!renglonesValidos);
        if (primerRenglon == segundoRenglon) {
            System.out.println("Los renglones ingresados son iguales, reimprimiendo matriz original:");
            printMatriz(matriz);
        } else {
            for (int i = 0, valorTemporal = 0; i < matriz.length; i++) {
                valorTemporal = matriz[primerRenglon][i];
                matriz[primerRenglon][i] = matriz[segundoRenglon][i];
                matriz[segundoRenglon][i] = valorTemporal;
            }
            printMatriz(matriz);
        }
        /* 
         * es necesario limpiar buffer, ya que nextInt() no consume el 
         * salto de linea que queda al ingresar el segundo renglon: 
         */ 
        escaner.nextLine(); 
    }

    static void printMatriz(int[][] matriz) {
        for (int[] renglon : matriz) {
            for (int celda : renglon)
                System.out.print(celda + "\t");
            System.out.println();
        }
    }

    static void ejercicio4() {
        final int PROMEDIO_MUJERES = 160;
        final int PROMEDIO_HOMBRES = 170;
        final int DESVIACION = 5;
        /* 
         * Puede modificar el valor de la constante N para
         * corroborar que efectivamente los promedios de estaturas
         * se acercan cada vez mas a los valores de PROMEDIO_MUJERES
         * y PROMEDIO_HOMBRES a medida que N crece:
         */
        final int N = 10;
        /* 
         * El arreglo estaturas1erSemISIC detalla las estaturas de los
         * chicos y chicas del 1er semestre de la carrera de sistemas,
         * con {N} chicos y {N} chicas para los grupos A, B y C
         * respectivamente y se considera la estatura promedio
         * de las mujeres en {PROMEDIO_MUJERES}cm y la de los 
         * hombres en {PROMEDIO_HOMBRES}cm con una variacion de
         * mas o menos {DESVIACION}cm cada uno:
         */
        int[][] estaturas1erSemISIC = new int[6][N];
        double[] promediosEstaturas = new double[estaturas1erSemISIC.length];
        // notese que los indices (de cada fila) pares son de hombres y los impares son de mujeres
        for (int renglon = 0; renglon < estaturas1erSemISIC.length; renglon++) {
            for (int i = 0; i < N; i++) {
                if (renglon % 2 == 0){
                    estaturas1erSemISIC[renglon][i] = digitoRandom(PROMEDIO_HOMBRES, DESVIACION);
                    System.out.print(estaturas1erSemISIC[renglon][i] + "\t");
                } else {
                    estaturas1erSemISIC[renglon][i] = digitoRandom(PROMEDIO_MUJERES, DESVIACION);
                    System.out.print(estaturas1erSemISIC[renglon][i] + "\t");
                } 
                promediosEstaturas[renglon] += estaturas1erSemISIC[renglon][i];
            }
            promediosEstaturas[renglon] /= N;
            System.out.println();
        }
        for (int i = 0, grupo = 65; i < promediosEstaturas.length; i++) {
            if (i % 2 == 0) 
                System.out.println("Promedio de estaturas de hombres del grupo " + (char) grupo + ": " + promediosEstaturas[i] + " cm");
            else
                System.out.println("Promedio de estaturas de mujeres del grupo " + (char) grupo++ + ": " + promediosEstaturas[i] + " cm");
        }
    }

    static int digitoRandom(int media, int desviacionEstandar) {
        /*
         * Notese que en lugar de usar nextInt() se usa nextGaussian() para
         * obtener un valor aleatorio con distribucion normal (gaussiana entre -1 y 1)
         * con media = {media} y desviacion estandar = {desviacionEstandar}
         * para simular la variacion realista de las estaturas de los alumnos.
         * Tambien se redondea el valor obtenido con Math.round() para obtener el entero 
         * correcto correspondiente (ie si (int) 1.9 devuelve 1, Math.round devuelve 2).
         */
        return (int) Math.round(media + random.nextGaussian() * desviacionEstandar);
    }
}
