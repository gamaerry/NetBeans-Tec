package ProjectEuler;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P21AmicableNumbers {
    public static void main(String[] args) {
        int limite = 10_000;
        int[] sumasDeDivisoresPropios = IntStream.rangeClosed(1, limite/2)
            .parallel()
            .map(n -> getDivisores(n<<1).sum() - (n<<1)) //resta el mismo numero x por definicion de divisor impropio
            .toArray();
        System.out.println(getNumerosAmigables2(sumasDeDivisoresPropios).stream().reduce(0, Integer::sum));
    }

    static Set<Integer> getNumerosAmigables1(int[] sumasDeDivisoresPropios) {
        Set<Integer> numerosAmigables = new HashSet<>();
        for (int i = 0; i < sumasDeDivisoresPropios.length; i++)
            for (int j = 0; j < sumasDeDivisoresPropios.length; j++) {
                if (i != j && sumasDeDivisoresPropios[i] == ((j+1)*2) && sumasDeDivisoresPropios[j] == ((i+1)*2)) {
                    numerosAmigables.add((i+1)*2);
                    numerosAmigables.add((j+1)*2);
                }
            }
        return numerosAmigables;
    }

    static Set<Integer> getNumerosAmigables2(int[] sumasDeDivisoresPropios) {
        return IntStream.rangeClosed(1, sumasDeDivisoresPropios.length) // sumasDeDivisoresPropios.length == limite/2
            .parallel()
            .filter(i -> {
                int j = sumasDeDivisoresPropios[i-1] / 2; //se divide entre dos porque i y j son indices 
                return i != j && j > 0 && j <= sumasDeDivisoresPropios.length && sumasDeDivisoresPropios[j-1] == (i<<1);
            })
            .map(n -> n<<1).boxed().collect(Collectors.toSet());
    }

    private static IntStream getDivisores(int x) {
        return IntStream.rangeClosed(1, (int) Math.sqrt(x))
            .filter(i -> x % i == 0)
            .flatMap(i -> (i == x / i) ? IntStream.of(i) : IntStream.of(i, x / i));
    }
}
