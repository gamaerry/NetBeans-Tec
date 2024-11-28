package NetBeansTec;
public class Arreglos7 {
    public static void main(String[] args) {
        String arreglo[]={"Benito", "Carlos", "Dana", "Daniel", "Jorge", "Miriam", "Osiel", "Pedro", "Sulma"};
        for (String a : arreglo)
            System.out.println(a.charAt(0) + " - " + a.charAt(a.length() - 1));
    }
}
