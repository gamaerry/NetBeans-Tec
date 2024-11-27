package ProjectEuler;

import java.math.BigInteger;

public class P15LatticePaths {
    public static void main(String[] args) {
        System.out.println(factorial(BigInteger.valueOf(40)).divide(factorial(BigInteger.valueOf(20)).pow(2)));
    }
    static BigInteger factorial (BigInteger n) {
        if (n.compareTo(BigInteger.TWO) < 0) 
            return BigInteger.ONE;
        return n.multiply(factorial(n.add(BigInteger.ONE.negate())));
    }
}
