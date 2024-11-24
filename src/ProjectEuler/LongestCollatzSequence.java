package ProjectEuler;

import java.util.HashSet;

public class LongestCollatzSequence {
    public static void main(String[] args) {
        long mayor = 2;
        long puntajeMayor = 1;
        HashSet<Long> numerosEnLaSerie = new HashSet<Long>();
        long  tmp, tmpPuntaje = 1;
        for (long i = 1_000_000; i != 0; i--, tmpPuntaje = 0) {
            if (!numerosEnLaSerie.contains(i)) {
                tmp = i;
                while (tmp != 1) {
                    tmp = tmp % 2 == 0 ? tmp / 2 : 3 * tmp + 1;
                    numerosEnLaSerie.add(tmp);
                    tmpPuntaje++;
                }
                if (puntajeMayor < tmpPuntaje){
                    puntajeMayor = tmpPuntaje;
                    mayor = i;
                }
            }
        }
        System.out.println(mayor);
    }
}
