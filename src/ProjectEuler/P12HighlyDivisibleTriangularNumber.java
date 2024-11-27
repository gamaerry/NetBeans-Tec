package ProjectEuler;

public class P12HighlyDivisibleTriangularNumber {
    public static void main(String[] args) {
        int divisores = 1;
        int nActual = 1, iActual=1, n, i, ocurrencias;
        while (divisores < 500) {
            divisores = 1;
            ocurrencias = 1;
            nActual += ++iActual; 
            n = nActual;
            while (n % 2 == 0) {
                ocurrencias++;
                n /= 2;
            }
            i = 3;
            divisores *= ocurrencias;
            ocurrencias = 1;
            while (i * i <= n) {
                while (n % i == 0) {
                    ocurrencias++;
                    n /= i;
                }
                divisores *= ocurrencias;
                ocurrencias = 1;
                i += 2;
            }
            if (n > 1)  // Si queda un número primo mayor que sqrt(n) (no hay no puede haber mas de dos)
                ocurrencias++;
            divisores *= ocurrencias;
            ocurrencias = 1;
        }
        System.out.println(nActual);
    }
}
