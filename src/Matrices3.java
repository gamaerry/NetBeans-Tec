import java.util.Scanner;

public class Matrices3 {
    static Scanner escaner = new Scanner(System.in);
    static final int FILAS = 3, COLUMNAS = 4, EXIT_CODE = 10, ERROR_CODE = 0;
    static final String TEXTO_PARA_CUBICULO_VACIO = "(Vacío)";
    static String[][] cubiculos = new String[FILAS][COLUMNAS];
    public static void main(String[] args) {
        int opcion;
        do {
            opcion = getOpcion();
            switch (opcion) {
                case 1: reservaCubiculo();
                    break;
                case 2: liberaCubiculo();
                    break;
                case 3: mostrarCubiculos();
                    break;
                case 4: verificarReservacion();
                    break;
                case 5: consultaCubiculo();
                    break;
                case ERROR_CODE: System.out.println("¡Opción inválida!");
                    break;
                case EXIT_CODE: terminaPrograma();
                    break;
                default:
                    System.out.println("¡Opción fuera del rango!");
            }
        } while (opcion != EXIT_CODE);
    }

    static void terminaPrograma() {
        System.out.println("¡Hasta luego!");
        escaner.close();
    }

    static void verificarReservacion() {
        System.out.println("Verifica reservación:");
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = escaner.nextLine().toUpperCase();
        String filaEncontrada = null, columnaEncontrada = null;
        for (int i = 0; i < FILAS; i++)
            for (int j = 0; j < COLUMNAS; j++)
                if (!estaVacio(i, j) && cubiculos[i][j].equals(nombre)){
                    filaEncontrada = i + "";
                    columnaEncontrada = j + "";
                }
        System.out.println(filaEncontrada == null ? nombre + " no ha reservado ningun cubiculo" : "el cubiculo de " + nombre + " tiene coordanadas " + filaEncontrada + " y " + columnaEncontrada);
    }

    static void consultaCubiculo() {
        System.out.println("Consulta cubículo:");
        int[] coordenadas = getCoordenadasValidas();
        if (coordenadas != null) {
            if (!estaVacio(coordenadas[0], coordenadas[1]))
                System.out.println("¡Cubículo ocupado por: " + cubiculos[coordenadas[0]][coordenadas[1]] + "!");
            else System.out.println("¡Cubículo vacío!");
        } else System.out.println("¡Coordenadas inválidas!");
    }

    static void liberaCubiculo() {
        System.out.println("Libera cubículo:");
        int[] coordenadas = getCoordenadasValidas();
        if (coordenadas != null) {
            if (!estaVacio(coordenadas[0], coordenadas[1])) {
                cubiculos[coordenadas[0]][coordenadas[1]] = null;
                System.out.println("¡Cubículo liberado correctamente!");
            } else System.out.println("¡Cubículo vacío!");
        } else System.out.println("¡Coordenadas inválidas!");
    }

    static void mostrarCubiculos() {
        int masLargo = longitudDelNombreMasLargo();
        System.out.println("\nCubículos:");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++)
                System.out.print(getCubiculoTabulado(i, j, masLargo));
            System.out.println();
        }
    }
    
    static int longitudDelNombreMasLargo() {
        int masLargo = TEXTO_PARA_CUBICULO_VACIO.length();
        for (int i = 0; i < FILAS; i++)
            for (int j = 0; j < COLUMNAS; j++)
                if (!estaVacio(i, j) && cubiculos[i][j].length() > masLargo)
                    masLargo = cubiculos[i][j].length();
        return masLargo;
    }
    
    static String getCubiculoTabulado(int fila, int columna, int masLargo) {
        String cubiculo = estaVacio(fila, columna) ? TEXTO_PARA_CUBICULO_VACIO : cubiculos[fila][columna];
        int tabsNecesarios = 1;
        if (cubiculo.length() < masLargo)
            tabsNecesarios = ((masLargo - cubiculo.length()) / 4) + 1;
        for (int i = 0; i < tabsNecesarios; i++) 
            cubiculo += "\t";
        return cubiculo;
    }
    
    static String getNombreTabulado(String nombre) {
        return nombre.length() > "(Vacío)".length() ? nombre + "\t" : nombre + "\t\t";
    }

    static void reservaCubiculo() {
        System.out.println("Reserva cubículo:");
        int[] coordenadas = getCoordenadasValidas();
        if (coordenadas != null) {
            if (estaVacio(coordenadas[0], coordenadas[1])) {
                System.out.print("Ingrese el nombre del estudiante: ");
                String nombre = escaner.nextLine().toUpperCase();
                cubiculos[coordenadas[0]][coordenadas[1]] = nombre;
                System.out.println("¡Cubículo reservado correctamente!");
            } else System.out.println("¡Cubículo ocupado!");
        } else System.out.println("¡Coordenadas inválidas!");
    }

    static int getOpcion() {
        try {
            System.out.print("\nMenu\n1. Reserva cubiculo\n2. Libera cubiculo\n3. Mostrar cubiculo\n4. Consulta cubiculo\n" + EXIT_CODE + ". Salir\n>> ");
            return escaner.nextInt();
        } catch(Exception e) {
            return 0;
        } finally {
            escaner.nextLine(); // Limpiar el buffer
        }
    }

    static int[] getCoordenadasValidas() {
        System.out.print("Ingrese las coordenadas (en formato FILA,COLUMNA): ");
        String coordenadasDelCubiculo = escaner.nextLine().trim();
        if (coordenadasDelCubiculo.matches("[0-"+(FILAS-1)+"],[0-"+(COLUMNAS-1)+"]")) {
            String[] coordenadas = coordenadasDelCubiculo.split(",");
            return new int[]{Integer.parseInt(coordenadas[0]), Integer.parseInt(coordenadas[1])};
        } else return null;
    }

    static boolean estaVacio(int fila, int columna) {
        return cubiculos[fila][columna] == null;
    }
}