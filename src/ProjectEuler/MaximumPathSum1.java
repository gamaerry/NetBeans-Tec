package ProjectEuler;

public class MaximumPathSum1 {
    static String s = """
75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
    """;
    public static void main(String[] args) {
        int[][] piramide = new int[15][15];
        for (int i = 0; i < piramide.length; i++) 
            for (int j = 0; j < s.split("\\n")[i].split(" ").length; j++) 
                piramide[i][j] = Integer.parseInt( s.split("\\n")[i].split(" ")[j] );
        int sumaMaxima = 0;
        for (int r = 0, suma = 75; r < 16_384; r++, suma = 75) {
            String camino = String.format("%14s", Integer.toBinaryString(r)).replace(" ", "0");
            for (int i = 1, columnaActual = 0; i < piramide.length; i++) {
                int delta = Integer.parseInt(camino.charAt(i-1) + "");
                columnaActual = columnaActual + delta;
                suma += piramide[i][columnaActual];
            }
            sumaMaxima = Math.max(sumaMaxima, suma);
        }
        System.out.println(sumaMaxima);
    }
}
