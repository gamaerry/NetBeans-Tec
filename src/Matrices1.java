import java.util.Random;

public class Matrices1 {
    static final Random random = new Random();
    public static void main(String[] args) {
        int[][] matriz = new int[digitoRandom(2,6)][digitoRandom(2,6)];
        int numeroActual = 0;
        for (int[] renglones: matriz) {
            for (int i = 0; i < renglones.length; i++) {
                renglones[i] = numeroActual;
                System.out.print(renglones[i]);
            }
            numeroActual++;
            System.out.println();
        }
        
    }
    static int digitoRandom(int limInferior, int limSuperior) { 
        return random.nextInt(limSuperior-limInferior+1)+limInferior; 
    }
}
