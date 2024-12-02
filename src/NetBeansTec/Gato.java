package NetBeansTec;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Gato {
    static char[][] gato;
    public static void main(String[] args) throws IOException {
        final Scanner ESCANER = new Scanner(System.in);
        final char CASILLA_VACIA = ' ';
        int actual = 0;
        boolean hayGanador = false;
        int dimension = nextDimension();
        char[] jugadores = nextJugadores();
        inicializarGato(dimension, CASILLA_VACIA);
        printGato(gato);
        while (!hayGanador) {
            nextJugada(jugadores[actual % 2], ESCANER, CASILLA_VACIA);
            hayGanador = revisarGanador(jugadores[actual++ % 2]);
        }
        System.out.println("¡Ha ganado el Jugador " + (--actual%2 + 1) + " ("+ jugadores[actual % 2] +")!");
        ESCANER.close();
    }

    static boolean revisarGanador(char jugador) {
        boolean hayGanador = false;
        // revisar filas
        for (int i = 0; i < gato.length && !hayGanador; i++) {
            for (int j = 0; j < gato[0].length; j++) {
                if (gato[i][j] != jugador) break;
                if (j == gato[0].length - 1) {
                    hayGanador = true;
                    break;
                }
            }
        }
        // revisar columnas
        for (int j = 0; j < gato[0].length && !hayGanador; j++) {
            for (int i = 0; i < gato.length; i++) {
                if (gato[i][j] != jugador) break;
                if (i == gato[0].length - 1) {
                    hayGanador = true;
                    break;
                }
            }
        }
        // revisar diagonales
        for (int i = 0; i < gato.length; i++) {
            if (gato[i][i] != jugador) break;
            if (i == gato.length - 1) {
                hayGanador = true;
                break;
            }
        }
        return hayGanador;
    }

    static void nextJugada(char jugador, Scanner escaner, char casillaVacia) throws IOException {
        System.out.print("Jugador " + jugador + " ingrese la coordenada: ");
        int[] coordenada = nextCasillaValida(escaner); // el formato debe ser "f,c"
        while (gato[coordenada[0] - 1][coordenada[1] - 1] != casillaVacia) {
            System.out.print("Casilla ya ocupada por " + gato[coordenada[0] - 1][coordenada[1] - 1] + ", ingrese de nuevo: ");
            coordenada = nextCasillaValida(escaner);
        }
        gato[coordenada[0] - 1][coordenada[1] - 1] = jugador;
        printGato(gato);
    }

    static int[] nextCasillaValida(Scanner escaner) {
        String casilla = escaner.next(); // el formato debe ser "f,c"
        while (!casilla.matches("[0-9],[0-9]")) {
            System.out.print("Casilla invalida, ingrese de nuevo: ");
            casilla = escaner.next();
        }
        int f = casilla.charAt(0) - '0';
        int c = casilla.charAt(2) - '0';
        while (fueraDeRango(f) || fueraDeRango(c)) {
            System.out.print("Casilla fuera de rango, ingrese de nuevo: ");
            casilla = escaner.next();
            f = casilla.charAt(0) - '0';
            c = casilla.charAt(2) - '0';
        }
        return new int[]{f, c};
    }

    static boolean fueraDeRango(int n) {
        return n < 1 || n > gato.length;
    }

    static void printGato(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(" ");
            for (int j = 0; j < matriz[0].length ; j++) {
                System.out.print(matriz[i][j] + (j+1 == matriz[0].length ? "" : " | "));
            }
            System.out.println();
            if (i + 1 != matriz.length) {
                for (int j = 0; j < matriz.length; j++) {
                    System.out.print("–-–"+ (j+1 != matriz[0].length ? "|" : ""));
                }
                System.out.println();
            }
                
        }
    }

    static void inicializarGato(int dimension, char casillaVacia) {
        gato = new char[dimension][dimension];
        for (char[] linea : gato) 
            Arrays.fill(linea, casillaVacia);
    }

    static char[] nextJugadores() throws IOException {
        System.out.print("Caracter del jugador 1: ");
        char jugador1 = nextChar();
        System.out.print("Caracter del jugador 2: ");
        char jugador2 = nextChar();
        while (jugador2 == jugador1) {
            System.out.print("Caracter ya elegido por otro jugador, elija de nuevo: ");
            jugador2 = nextChar();
        }
        return new char[]{jugador1, jugador2};
    }

    static int nextDimension() throws IOException {
        System.out.print("Ingrese las dimensiones del gato: ");
        int dimension =nextChar() - '0';
        while (dimension != 3 && dimension != 5 && dimension != 7) {
            System.out.print("Dimensión invalida, ingrese de nuevo: ");
            dimension = nextChar() - '0';
        }
        return dimension;
    }

    static char nextChar() throws IOException {
        char c = (char) System.in.read();
        System.in.read();
        return c;
    }
}
