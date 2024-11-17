package ProjectEuler;

public class LargestPrimeFactor {
    public static void main(String[] args) {
        long n = 561;
        int i = 3;
        while (n % 2 == 0) {
            System.out.println(2);
            n /= 2;
        }
        while (i * i <= n) {
            while (n % i == 0) {
                System.out.println(i);
                n /= i;
            }
            i += 2;
        }
        if (n > 1) {  // Si queda un número primo mayor que sqrt(n) (no hay no puede haber mas de dos)
            System.out.println(n);
            System.out.println("n es un semiprimo fuerte!");
        }
        
    }
}
