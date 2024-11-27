package ProjectEuler;
public class P17NumberLetterCounts {
    public static void main(String[] args) {
        int[] unidades = {0, 3, 3, 5, 4, 4, 3, 5, 5, 4};
        int[] decenas =  {0, 4, 6, 6, 5, 5, 5, 7, 6, 6};
        int centenas = 7, and = 3, suma = -49; // restar 6*10 al total ya que:
        // es ten en vez de teen
        // es eleven en vez de oneteen
        // es twelve en vez de twoteen
        // es thirteen en vez de threeteen
        // es fifteen en vez de fiveteen
        // es eighteen en vez de eightteen
        // y sumar 11 (one thousand)
        for (int i = 1; i < 1_000; i++)
            suma += (i/10 < 1) ? unidades[i] : (i/100 < 1) ? decenas[i/10] + unidades[i%10] : 
                    unidades[i/100] + centenas + (i%100 == 0 ? 0 : and + decenas[(i%100)/10] + unidades[(i%100)%10]);
        System.out.println(suma);
    }
}
