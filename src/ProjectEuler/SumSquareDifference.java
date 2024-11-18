package ProjectEuler;

public class SumSquareDifference {
    public static void main(String[] args) {
        long cuadradoDeLaSuma = (long) Math.pow(100*101/2, 2);
        long sumaDeCuadrados = 0;
        for (int i = 1; i < 101; i++)
            sumaDeCuadrados += i*i;
        long diferencia = cuadradoDeLaSuma - sumaDeCuadrados;
        System.out.println(diferencia);
    }
}
