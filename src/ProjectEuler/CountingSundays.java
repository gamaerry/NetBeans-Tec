package ProjectEuler;

public class CountingSundays {
    public static void main(String[] args) {
        int diaActual = (1 + 365) % 7, domingosEnPrimero = 0, diasEnElMes;
        boolean[] mesesCon31 = new boolean[12];
        mesesCon31[0] = mesesCon31[2] = mesesCon31[4] = mesesCon31[6] = mesesCon31[7] = mesesCon31[9] = mesesCon31[11] = true;
        for (int year = 1, month = 0; year < 101; year++, month = 0)
            for (; month < mesesCon31.length; month++) {
                if (diaActual == 0) domingosEnPrimero++;
                diasEnElMes = mesesCon31[month] ? 31 : month != 1 ? 30 : year % 4 == 0 ? 29 : 28;
                diaActual =(diaActual + diasEnElMes) % 7;
            }
        System.out.println(domingosEnPrimero);
    }
}
