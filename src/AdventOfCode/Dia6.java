package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Dia6 {
    static boolean esInicio = true;
    static int[][] matriz;
    static int[] coordenadas;
    static List<Character> estadosDeJugador = List.of('^', '>', 'v', '<');
    static char jugador = estadosDeJugador.get(0);
    static Set<String> caminosAnteriores = new HashSet<>();
    static String caminoActual="";
    public static void main(String[] args) {
        matriz = getListaFromTxt("src/AdventOfCode/input_dia6.txt");
        //problema1();
        problema2();
    }
    
    static void printMatriz(int[][] matriz) {
        for (int[] renglon : matriz) {
            for (int elemento : renglon)
                System.out.print(elemento + "\t");
            System.out.println();
        }
    }

    static void problema2() {
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) 
            for (int j = 0; j < matriz[0].length; j++) {
                updateMatrizConObstaculo(i, j);
                if (hayLoop()) 
                    suma++;
                caminosAnteriores.clear();
            }
        System.out.println(suma);
    }

    static boolean hayLoop() {
        jugador = estadosDeJugador.getFirst();
        coordenadas = getCoordenadasJugador();
        while (!alFiloDelMapa()){
            mover2();
            if (estadosDeJugador.indexOf(jugador) == 0) {
                if (caminosAnteriores.contains(caminoActual)) {
                    return true;
                }
                caminosAnteriores.add(caminoActual);
                caminoActual = "";
            }
        }
        return false;
    }

    static void updateMatrizConObstaculo(int i, int j) {
        matriz = getListaFromTxt("src/AdventOfCode/input_dia6.txt");
        if (!esJugador(matriz[i][j])) {
            matriz[i][j] = 0;
        }
    }

    static void mover2() {
        int[] nuevasCoordenadas = nuevaDireccion();
        while (!fueraDelMapa(nuevasCoordenadas) && !esObstaculo(nuevasCoordenadas)) {
            marcarPaso();
            coordenadas = nuevasCoordenadas;
            nuevasCoordenadas = nuevaDireccion();
            caminoActual += coordenadas[0] + jugador +coordenadas[1];
        }
        jugador = estadosDeJugador.get((estadosDeJugador.indexOf(jugador) + 1) % 4);
    }

    static void problema1() {
        coordenadas = getCoordenadasJugador();
        while (!alFiloDelMapa())
            mover();
        marcarPaso();
        int suma = 0;
        for (int[] fila : matriz) 
            for (int n : fila)
                if (n == 1) suma++;
        System.out.println(suma);
    }

    static boolean alFiloDelMapa() {
        return coordenadas[0] == 0 || coordenadas[1] == 0 || (coordenadas[0] == matriz.length - 1) || (coordenadas[1] == matriz[0].length - 1); 
    }

    static void mover() {
        int[] nuevasCoordenadas = nuevaDireccion();
        while (!fueraDelMapa(nuevasCoordenadas) && !esObstaculo(nuevasCoordenadas)) {
            marcarPaso();
            coordenadas = nuevasCoordenadas;
            nuevasCoordenadas = nuevaDireccion();
        }
        jugador = estadosDeJugador.get((estadosDeJugador.indexOf(jugador) + 1) % 4);
    }

    static void marcarPaso() {
        matriz[coordenadas[0]][coordenadas[1]] = 1;
    }

    static int[] nuevaDireccion() {
        int[] c = coordenadas.clone();
        switch (jugador) {
            case '^': 
                c[0] = c[0] - 1;
            break;
            case 'v':
                c[0] = c[0] + 1;
            break;
            case '>': 
                c[1] = c[1] + 1;
            break;
            default: 
                c[1] = c[1] - 1;
            break;
        }
        return c;
    }

    static int[] getCoordenadasJugador() {
        for (int i = 0; i < matriz.length; i++) 
            for (int j = 0; j < matriz[0].length; j++) 
                if (esJugador(matriz[i][j])) 
                    return new int[]{i, j};
        return null;
    }

    static boolean esObstaculo(int[] c) {
        return matriz[c[0]][c[1]] == 0;
    }

    static boolean fueraDelMapa(int[] c) {
        return c[0] == -1 || c[1] == -1 || c[0] == matriz.length || c[1] == matriz[0].length;
    }

    static boolean esJugador(int elemento) {
        return elemento > 1;
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
        return caracter == '#' ? 0 : caracter == '.' ? -1 : '^';
    }
}
