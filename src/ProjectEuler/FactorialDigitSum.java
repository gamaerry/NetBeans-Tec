package ProjectEuler;
import java.math.BigInteger;

public class FactorialDigitSum {
    public static void main(String[] args) {
        String digitos = LatticePaths.factorial(BigInteger.valueOf(100)).toString();
        int suma = 0;
        for (char c : digitos.toCharArray())
            suma += Integer.parseInt(c + "");
        System.out.println(suma);
    }
}
