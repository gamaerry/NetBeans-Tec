package ProjectEuler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class P23NonAbundantSums {
    public static void main(String[] args) {
        final int LIMITE = 28123;
        List<Integer> abundantes = getAbundantes(LIMITE);
        boolean[] numerosNoCompuestos = new boolean[LIMITE + 1];
        // Notese que numeros compuestos son los que son suma de dos abundantes
        Arrays.fill(numerosNoCompuestos, true);
        abundantes.parallelStream().forEach(i -> abundantes.forEach(j -> {
            if (i + j <= LIMITE) 
                numerosNoCompuestos[i + j] = false;
        }));
        System.out.println(IntStream.rangeClosed(1, LIMITE).filter(i -> numerosNoCompuestos[i]).sum());
    }

    static boolean esAbuntante(int n) {
        return P21AmicableNumbers.getDivisores(n).sum() > (n << 1); // n << 1 == 2*n
    }

    static List<Integer> getAbundantes(int limite) {
        return IntStream.rangeClosed(11, limite) // el 1er num abundante es el 12
            .parallel()
            .filter(n -> esAbuntante(n))
            .boxed() // Convertimos a Stream<Integer>
            .sorted() // Ordenamos directamente
            .collect(Collectors.toList());
    }

    static <T> List<T> streamToList(Stream<T> stream) {
        return stream.collect(Collectors.toList());
    }

    static <T> List<T> arrayToList(T[] array) {
        return streamToList(Arrays.stream(array));
    }
    static List<Boolean> arrayToList(boolean[] array) {
        return streamToList(IntStream.range(0, array.length).mapToObj(i -> array[i]));
    }
    static List<Integer> arrayToList(int[] array) {
        return streamToList(Arrays.stream(array).boxed());
    }
}
