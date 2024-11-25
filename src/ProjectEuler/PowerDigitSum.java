package ProjectEuler;

import java.math.BigInteger;

public class PowerDigitSum {
    public static void main(String[] args) {
        String n = BigInteger.TWO.pow(1_000).toString();
        int suma = 0;
        for (int i = 0; i < n.length(); i++) 
            suma += Integer.parseInt(n.charAt(i) + "");
        System.out.println(suma);
    }
}
