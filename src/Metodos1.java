public class Metodos1 {
    public static void main(String[] args) {
        System.out.println(serieULAM(5,10));
    }
    private static char getTipo(int n) {
        int suma = 0;
        for (int i = 1; i < n; i++) 
            suma += n%i==0 ? i : 0;
        return suma == n ? 'P' : suma > n ? 'A' : 'D';
    }
    private static boolean esBinario(long n){
        return (n + "").matches("[01]*");
    }
    private static int getDecimal(String cadena) {
        int decimal = 0;
        if (!esBinario(Integer.parseInt(cadena)))
            return -1;
        else for (int i = cadena.length() - 1; i >= 0 ; i--) 
            decimal += cadena.charAt(cadena.length() - (i + 1)) == '1' ? Math.pow(2, i) : 0;
        return decimal;
    }
    private static String getBinario(int n) {
        return Integer.toBinaryString(n);
    }
    private static int coincidencias (String cadena, char caracter) {
        int coincidencias = 0;
        while (cadena.contains(caracter + "")){
            coincidencias ++;
            cadena = cadena.replaceFirst(caracter + "", "");
        }
        return coincidencias;
    }
    private static String serieULAM (int inicial, int n) {
        String cadena = "";
        for (int i = 0; i < n && inicial != 1 ; i++) {
            inicial = inicial%2 == 0 ? inicial/2 : inicial*3 + 1;
            cadena += ", " + inicial;
        }
        return cadena.replaceFirst(", ", "");
    }
}
