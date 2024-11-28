package NetBeansTec;
import java.util.Random;
public class Arreglos {
    public static void main(String[] args) {
        int[] base2 = new int[12];
        Random random = new Random();
        int base10 = 0;
        boolean unoEncontrado = false;
        for (int i = base2.length-1; i >= 0; i--) {
            base2[i] = random.nextInt(2);
            base10 += base2[i] * Math.pow(2, i);
            unoEncontrado |= base2[i] == 1;
            if (unoEncontrado)
                System.out.print(base2[i]);
        }
        System.out.println(" equivale a: " + base10);
    } 
}
