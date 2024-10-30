import java.util.Scanner;

public class Matrices3 {
    static Scanner escaner = new Scanner(System.in);
    static final int FILAS = 3, COLUMNAS = 4;
    static String[][] cubiculos = new String[FILAS][COLUMNAS];
    public static void main(String[] args) {
        int opcion = getOpcion();
        while (opcion != 4) {
            switch (opcion) {
                case 1: reservaCubiculo();
                    break;
                case 2: liberaCubiculo();
                    break;
                case 3: consultaCubiculo();
                    break;
                case 4: terminaPrograma();
                    break;
                default:
                    System.out.println("¡Opción inválida!");
            }
            opcion = getOpcion();
        }
    }

    static void terminaPrograma() {
        System.out.println("¡Hasta luego!");
        escaner.close();
    }

    static void consultaCubiculo() {
        System.out.println("Consulta cubículo:");
        int[] coordenadas = getCoordenadasValidas();
        if (coordenadas != null) {
            if (cubiculos[coordenadas[0]][coordenadas[1]] != null) {
                System.out.println("¡Cubículo ocupado por: " + cubiculos[coordenadas[0]][coordenadas[1]] + "!");
            } else System.out.println("¡Cubículo vacío!");
        } else System.out.println("¡Coordenadas inválidas!");
    }

    static void liberaCubiculo() {
        System.out.println("Libera cubículo:");
        int[] coordenadas = getCoordenadasValidas();
        if (coordenadas != null) {
            if (cubiculos[coordenadas[0]][coordenadas[1]] != null) {
                cubiculos[coordenadas[0]][coordenadas[1]] = null;
                System.out.println("¡Cubículo liberado correctamente!");
            } else System.out.println("¡Cubículo vacío!");
        } else System.out.println("¡Coordenadas inválidas!");
    }

    static void imprimeCubiculos() {
        System.out.println("\nCubículos:");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(cubiculos[i][j] == null ? "(Vacío)\t\t" : cubiculos[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static void reservaCubiculo() {
        System.out.println("Reserva cubículo:");
        int[] coordenadas = getCoordenadasValidas();
        if (coordenadas != null) {
            if (cubiculos[coordenadas[0]][coordenadas[1]] == null) {
                System.out.println("Ingrese el nombre del estudiante");
                String nombre = escaner.nextLine();
                cubiculos[coordenadas[0]][coordenadas[1]] = nombre;
                System.out.println("¡Cubículo reservado correctamente!");
            } else System.out.println("¡Cubículo ocupado!");
        } else System.out.println("¡Coordenadas inválidas!");
    }

    static int getOpcion() {
        imprimeCubiculos();
        System.out.print("Menu\n1. Reserva cubiculo\n2. Libera cubiculo\n3. Consulta cubiculo\n4. Salir\n>> ");
        int opcion = escaner.nextInt();
        escaner.nextLine(); // Limpiar el buffer
        return opcion;
    }

    static int[] getCoordenadasValidas() {
        System.out.print("Ingrese las coordenadas (en formato FILA,COLUMNA): ");
        String coordenadasDelCubiculo = escaner.nextLine().trim();
        if (coordenadasDelCubiculo.matches("[0-"+(FILAS-1)+"],[0-"+(COLUMNAS-1)+"]")) {
            String[] coordenadas = coordenadasDelCubiculo.split(",");
            return new int[]{Integer.parseInt(coordenadas[0]), Integer.parseInt(coordenadas[1])};
        } else return null;
    }
}