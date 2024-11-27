package ProjectEuler;

public class P1Multiples3or5 {
    public static void main(String[] args) {
        int suma = 0;
        for (int i = 0; i < 1000; i++) {
            suma += (i % 3 == 0 || i % 5 == 0) ? i : 0;
        }
        System.out.println(suma);
    }
}
