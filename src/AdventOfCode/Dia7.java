package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Dia7 {
    static long[][] matriz;
    static List<Long> resultados = new ArrayList<>();
    static Set<Long> combinaciones = new HashSet<>();
    public static void main(String[] args) {
        matriz = getListaFromTxt("src/AdventOfCode/input_dia7.txt");
        problema1();
        problema2();
    }

    static void problema2() {
        BigInteger suma = BigInteger.ZERO;
        for (int i = 0; i < matriz.length; i++) {
            updateCombinaciones2(matriz[i]);
            if(combinaciones.contains(resultados.get(i)))
                suma = suma.add(BigInteger.valueOf(resultados.get(i)));
            combinaciones.clear();
        }
        System.out.println(suma);
    }

    static void updateCombinaciones2(long[] lista){
        combinaciones.addAll(IntStream
            .rangeClosed(0, (int) Math.pow(3, lista.length - 1))
            .mapToLong(posibilidad -> getResultado2(getCamino(posibilidad), lista))
            .boxed().toList()
        );
    }

    static long getCamino(int n) {
        int parteEntera = n;
        String base3 = "";
        while (parteEntera != 0) {
            base3 = (parteEntera % 3) + base3;
            parteEntera /= 3;
        }
        return Long.parseLong(base3.isBlank() ? "0" : base3);
    }

    static long getResultado2(long camino, long[] lista) {
        long resultado = lista[0];
        String caminoStr = String.format("%0"+(lista.length-1)+"d", camino);
        for (int i = 1; i < lista.length; i++) {
            resultado = caminoStr.charAt(i-1) == '0' ? resultado * lista[i] : 
                caminoStr.charAt(i-1) == '1' ? resultado + lista[i] : 
                Long.parseLong(resultado + "" + lista[i]);
        }
        return resultado;
    }

    static void problema1(){
        BigInteger suma = BigInteger.ZERO;
        for (int i = 0; i < matriz.length; i++) {
            updateCombinaciones(matriz[i]);
            if(combinaciones.contains(resultados.get(i)))
                suma = suma.add(BigInteger.valueOf(resultados.get(i)));
            combinaciones.clear();
        }
        System.out.println(suma);
    }

    static void updateCombinaciones(long[] lista){
        combinaciones.addAll(IntStream.rangeClosed(0, 1 << (lista.length - 1)).mapToLong(binario -> getResultado(binario, lista)).boxed().toList());
    }

    static long getResultado(int binario, long[] lista) {
        long resultado = lista[0];
        for (int i = 1; i < lista.length; i++) {
            resultado = (binario & (1 << (i-1))) == 0 ? resultado * lista[i] : resultado + lista[i];
        }
        return resultado;
    }

    static long[][] getListaFromTxt(String rutaRelativa) {
        try (Scanner txtEscaneado = new Scanner(new File(rutaRelativa))) {
            List<long[]> input = new ArrayList<>();
            while (txtEscaneado.hasNextLine()) {
                String[] lineaActual = txtEscaneado.nextLine().split(": ");
                resultados.add(Long.parseLong(lineaActual[0]));
                input.add(Arrays.stream(lineaActual[1].split(" ")).mapToLong(Long::parseLong).toArray());
            }
            return input.toArray(long[][]::new);
        } catch (FileNotFoundException e) { return null; }
    }
}
