package ProjectEuler;

import java.util.ArrayList;

public class NesimePrime {
    static final int N = 50_000_000;
    public static void main(String[] args) {
        optimizada();
    }

    static void simple() {
        boolean actualEsPrimo = true;
        int actual = 9; 
        for (int n = 4, i = 3; n < N; i = 3, actualEsPrimo = true) {
            actual += 2; // inicia corroborando si 11 (el 5to) es primo
            while (i * i <= actual)
                if (actual % i == 0){
                    actualEsPrimo = false;
                    break;
                } else i += 2;
            if (actualEsPrimo) n++;
        }
        System.out.println(actual);
    }

    static void optimizada() {
        ArrayList<Integer> listaDePrimos = new ArrayList<>();
        boolean actualEsPrimo = true;
        int actual = 9;
        listaDePrimos.add(3);
        listaDePrimos.add(5);
        listaDePrimos.add(7); // el 2 puede omitirse ya que ninguno de los números impares es divisible por 2
        int p = listaDePrimos.get(0);
        for (int n = 4, i = 0; n < N; actualEsPrimo = true, i = 0) {
            p = listaDePrimos.get(i);
            actual += 2; // inicia corroborando si 11 (el 5to) es primo
            while (p * p <= actual)
                if (actual % p == 0){
                    actualEsPrimo = false;
                    break;
                } else p = listaDePrimos.get(++i);
            if (actualEsPrimo){
                listaDePrimos.add(actual);
                n++;
            }
        }
        System.out.println(actual);
    }
}
