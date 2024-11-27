package ProjectEuler;

import java.util.ArrayList;

public class P3LargestPrimeFactor {
    public static void main(String[] args) {
        System.out.println(getFactoresPrimos(600851475143L));
    }

    static ArrayList<Long> getFactoresPrimos(long n) {
        ArrayList<Long> factores = new ArrayList<>();
        long i = 3;
        while (n % 2 == 0) {
            factores.add(2L);
            n /= 2;
        }
        while (i * i <= n) {
            while (n % i == 0) {
                factores.add(i);
                n /= i;
            }
            i += 2;
        }
        if (n > 1) // Por si queda un número primo mayor que sqrt(n) (no puede quedar mas de uno)
            factores.add(n);
        return factores;
    }
}
