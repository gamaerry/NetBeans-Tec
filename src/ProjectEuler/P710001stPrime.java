package ProjectEuler;

import java.util.ArrayList;

public class P710001stPrime {
    public static void main(String[] args) {
        System.out.println(getEnesimoPrimo(10_001));
    }

    static int getEnesimoPrimo(int N) {
        final ArrayList<Integer> listaDePrimos = new ArrayList<>();
        listaDePrimos.add(3);
        listaDePrimos.add(5);
        listaDePrimos.add(7); // el 2 puede omitirse ya que ninguno de los números impares es divisible por 2
        boolean actualEsPrimo = true;
        int actual = 9;
        int n = 4;
        while (n != N) {
            actualEsPrimo = true;
            actual += 2; // inicia corroborando si 11 (el 5to) es primo
            for (int p : listaDePrimos) {
                if (p * p > actual) break;
                if (actual % p == 0){
                    actualEsPrimo = false;
                    break;
                }
            }
            if (actualEsPrimo){
                listaDePrimos.add(actual);
                n++;
            }
        }
        return actual;
    }
}
