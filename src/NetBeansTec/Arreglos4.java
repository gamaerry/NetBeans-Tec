package NetBeansTec;
import java.io.IOException;

public class Arreglos4 {
    public static void main(String[] args) throws IOException{
        char[] ciudad = {'M','O','R','E','L','I','A'}, ciudadModificada = new char[ciudad.length];
        System.out.print("Sentido: ");
        char sentido = (char) System.in.read();
        System.in.read();
        int aux = 0;
        while(sentido == 'D' || sentido == 'd' || sentido == 'I' || sentido == 'i') {
            if(sentido == 'D' || sentido == 'd')
                aux++;
            else aux--;
            for (int i = 0; i < ciudad.length; i++) {
                ciudadModificada[i] = ciudad[(aux < 0 ? i - aux : i + aux) % ciudad.length];
            }
            System.out.println(ciudadModificada);
            sentido = (char) System.in.read();
            System.in.read();
        }
    }
}
