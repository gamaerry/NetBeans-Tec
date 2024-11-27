package ProjectEuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P10SumationOfPrimes {
    public static void main(String[] args) {
        System.out.println(getListaDePrimos(2_000_000).stream().mapToLong(Long::valueOf).sum());
    }

    static List<Integer> getListaDePrimos(int limiteExclusivo) {
        if (limiteExclusivo <= 2) 
            return List.of(); // No hay primos menores que 2
            
        boolean[] esPrimo = new boolean[limiteExclusivo];
        Arrays.fill(esPrimo, true); // Inicialmente, marcamos a todos como primos
        esPrimo[0] = esPrimo[1] = false; // 0 y 1 no son primos

        // Marcar múltiplos de cada número como no primos
        for (int i = 2; i * i < limiteExclusivo; i++)
            if (esPrimo[i]) // es decir si no ha sido desmarcado en anteriores iteraciones
                for (int j = i * i; j < limiteExclusivo; j += i) // desmarca multiplos de i
                    esPrimo[j] = false;

        List<Integer> primos = new ArrayList<>();
        for (int i = 2; i < limiteExclusivo; i++)
            if (esPrimo[i]) 
                primos.add(i);

        return primos;
    }
}
