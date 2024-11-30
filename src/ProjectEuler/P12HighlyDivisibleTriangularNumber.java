package ProjectEuler;

public class P12HighlyDivisibleTriangularNumber {
    public static void main(String[] args) {
        int n = 1, i = 1, divisores = 1;
        while (divisores < 500) {
            n += ++i;
            divisores = getNumeroDeDivisores(n);
        }
        System.out.println(n);
    }
    
    static int getNumeroDeDivisores(int x) {
        int ocurrencias = 1, i = 3, divisores = 1;
        while (x % 2 == 0) {
            ocurrencias++;
            x /= 2;
        }
        divisores *= ocurrencias;
        ocurrencias = 1;
        while (i * i <= x) {
            while (x % i == 0) {
                ocurrencias++;
                x /= i;
            }
            divisores *= ocurrencias;
            ocurrencias = 1;
            i += 2;
        }
        if (x > 1)  // Si queda un número primo mayor que sqrt(n) (no hay no puede haber mas de dos)
            ocurrencias++;
        divisores *= ocurrencias;
        // la funcion se basa en la formula (n1 + 1)(n2 + 1)...(nm + 1)
        // donde cada nm es el numero de veces que un primo pm divide a x 
        return divisores;
    }
}
