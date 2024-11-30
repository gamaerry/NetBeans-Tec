package ProjectEuler;

import java.util.ArrayList;
import java.util.List;

public class P3LargestPrimeFactor {
    public static void main(String[] args) {
        System.out.println(getFactoresPrimos(600851475143L).getLast());
    }

    static List<Long> getFactoresPrimos(long x) {
        List<Long> primos = new ArrayList<>();
        long i = 3;
        while (x % 2 == 0) {
            primos.add(2L);
            x /= 2;
        }
        while (i * i <= x) {
            while (x % i == 0) {
                primos.add(i);
                x /= i;
            }
            i += 2;
        }
        if (x > 1)  // Si queda un número primo mayor que sqrt(n) (no hay no puede haber mas de dos)
            primos.add(x);
        return primos;
    }
}
