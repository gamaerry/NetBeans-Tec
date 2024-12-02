package ProjectEuler;

import java.util.Arrays;
import java.util.stream.LongStream;

public class P22NamesScores {
    public static void main(String[] args) {
        String[] nombres = P11LargestProductInAGrid.getListFromOneLineTxt(
            "src/ProjectEuler/0022_names.txt", "\",\"");
        Arrays.sort(nombres);
        long suma = LongStream.rangeClosed(1, nombres.length).parallel().map(n -> nombres[(int) (n-1)].chars().map(c -> 
        getValorDeCaracter(c)).sum() * n ).sum();
        System.out.println(suma);
    }

    static int getValorDeCaracter(int c) {
        return c - 'A' + 1;
    }
}