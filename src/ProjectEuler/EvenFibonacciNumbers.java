package ProjectEuler;

public class EvenFibonacciNumbers {
    public static void main(String[] args) {
        int suma = 0;
        boolean excede = false;
        for (int i = 1, actual = 0; !excede; i++) {
            actual = fib(i);
            excede = actual > 4_000_000;
            if(!excede &&  actual % 2 == 0){
                suma += actual;
                System.out.println(actual);
            }
                
        }
        System.out.println(suma);
    }
    static int fib(int n) {
        return n<=1 ? 1 : n == 2 ? 2 : fib(n-2) + fib(n-1);
    }
}