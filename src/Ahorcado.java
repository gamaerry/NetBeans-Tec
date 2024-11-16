import java.util.Random;

public class Ahorcado {
    final static String PALABRA = getPalabraAleatoria();
    static final int OPORTUNIDADES = 7;
    static String palabraOculta = PALABRA.replaceAll(".", "_");
    static int oportunidadActual = 1;
    public static void main(String[] args) {
        System.out.println("Adivina la palabra:");
        while (oportunidadActual <= OPORTUNIDADES) {
            printPalabra();
            char letra = pedirLetra();
            if (PALABRA.contains(letra + "")) {
                for (int i = 0; i < PALABRA.length(); i++)
                    if (PALABRA.charAt(i) == letra) 
                        descubrirLetra(i, letra);
            } else fallar(oportunidadActual == OPORTUNIDADES);
            if (!palabraOculta.contains("_"))
                ganar();
        }
    }
    static void ganar() {
        System.out.println("Felicidades, lograste adivinar la palabra");
        printPalabra();
        oportunidadActual = OPORTUNIDADES + 1;
    }
    static void fallar(boolean esUltimaOportunidad) {
        System.out.println("No existe esa letra en la palabra");
        oportunidadActual++;
        if (esUltimaOportunidad) {
            System.out.println("Sin oportunidades, escriba la palabra:");
            if (System.console().readLine().toUpperCase().equals(PALABRA))
                ganar();
            else System.out.println("Lo siento has perdido, agotaste las oportunidades! La palabra era: " + PALABRA);
        }
    }
    static void descubrirLetra(int i, char letra) {
        char[] palabraOcultaArray = palabraOculta.toCharArray();
        palabraOcultaArray[i] = letra;
        palabraOculta = new String(palabraOcultaArray);
    }
    static char pedirLetra() {
        System.out.print("Oportunidad " + oportunidadActual + " que letra aparece?: ");
        return System.console().readLine().toUpperCase().charAt(0);
    }
    static String getPalabraAleatoria() {
        String[] palabras = {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "once", "doce", "trece", "catorce", "quince"};
        return palabras[new Random().nextInt(palabras.length)].toUpperCase();
    }
    static void printPalabra() {
        for (char c : palabraOculta.toCharArray())
            System.out.print(" " + c);
        System.out.println();
    }
}