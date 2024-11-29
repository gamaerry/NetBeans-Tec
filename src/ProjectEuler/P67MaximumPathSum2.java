package ProjectEuler;

public class P67MaximumPathSum2 {
    public static void main(String[] args) {
        int[][] piramide = P11LargestProductInAGrid.getMatrizFromTxt("src/ProjectEuler/0067_triangle.txt", 100, 100);
        for (int i = piramide.length - 1; i > 0; i--) 
            for (int j = 0; j < i; j++) // index i coincide con el # elementos de anterior
                piramide[i - 1][j] += Math.max(piramide[i][j], piramide[i][j + 1]);
        // a esto se le conoce como Dynamic programming, en particular esta solucion empieza
        // de la base y resuelve el problema para todos los elementos (100) sobre la mejor
        // suma hacia arriba, sin embargo puesto que el problema pide específicamente resolver 
        // esto desde el elemento [0][0] podria decirse que mi solucion no es valida, pero 
        // resolver es resolver, si me dan ganas en el futuro lo haré como se pide :)
        System.out.println(piramide[0][0]);
    }
}
