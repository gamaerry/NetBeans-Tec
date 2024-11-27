package ProjectEuler;

import java.util.ArrayList;

public class P10SumationOfPrimes {
    public static void main(String[] args) {
        optimizada();
    }
    static void optimizada() {
        ArrayList<Integer> listaDePrimos = new ArrayList<>();
        boolean actualEsPrimo = true;
        int actual = 9;
        listaDePrimos.add(3);
        listaDePrimos.add(5);
        listaDePrimos.add(7); // el 2 puede omitirse ya que ninguno de los números impares es divisible por 2
        int p = listaDePrimos.get(0);
        long suma = 17;
        for (int i = 0; actual < 2_000_000; actualEsPrimo = true, i = 0) {
            p = listaDePrimos.get(i);
            actual += 2; // inicia corroborando si 11 (el 5to) es primo
            while (p * p <= actual)
                if (actual % p == 0){
                    actualEsPrimo = false;
                    break;
                } else p = listaDePrimos.get(++i);
            if (actualEsPrimo){
                listaDePrimos.add(actual);
                suma += actual;
            }
        }
        System.out.println(suma);
    }
}
