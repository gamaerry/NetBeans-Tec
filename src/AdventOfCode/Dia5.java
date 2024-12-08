package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dia5 {
    static List<List<Integer>> reglas = new ArrayList<>();
    static List<List<Integer>> impresiones;
    public static void main(String[] args) {
        impresiones = getMapaFromTxt("src/AdventOfCode/input_dia5.txt");
        //problema1();
        problema2();
    }

    static void problema2() {
        List<List<Integer>> impresionesErradas = impresiones.stream().filter(lista -> !cumpleTodas(lista)).collect(Collectors.toList());
        System.out.println(impresionesErradas.stream().map(lista -> arreglarImpresion(lista)).mapToInt(lista -> lista.get(lista.size()/2)).sum());
    }

    static List<Integer> arreglarImpresion(List<Integer> impresion) {
        List<Integer> nueva = new ArrayList<Integer>();
        nueva.add(impresion.get(0));
        int nuevaI = 0;
        boolean lugarEncontrado = false;
        for (int pag : impresion) {
            if (!nueva.contains(pag)){ 
                for (int i = 0; i < nueva.size(); i++) {
                    for (List<Integer> regla : reglas) {
                        if (regla.contains(pag) && regla.contains(nueva.get(i))) {
                            nuevaI = i + regla.indexOf(pag);
                            lugarEncontrado = regla.indexOf(pag) == 0;
                        }
                    }
                    if (lugarEncontrado) break;
                }
                nueva.add(nuevaI, pag);
                lugarEncontrado = false;
                nuevaI = 0;
            }
        }
        return nueva;
    }

    static void problema1() {
        int suma = 0;
        for (List<Integer> impresion : impresiones) {
            if (cumpleTodas(impresion)) {
                System.out.println(impresion.get(impresion.size() / 2));
                suma += impresion.get(impresion.size() / 2);
            }
        }
        System.out.println(suma);
    }

    static boolean cumpleTodas(List<Integer> impresion) {
        for (List<Integer> regla : reglas)
            if (!cumpleLaRegla(impresion, regla)) return false;
        return true;
    }

    static boolean cumpleLaRegla(List<Integer> impresion, List<Integer> regla) {
        int iRegla, jRegla; //posiciones de las paginas en las reglas
        boolean menorQueImpresion, menorQueRegla;
        for (int i = 0; i < impresion.size(); i++) {
            if (regla.contains(impresion.get(i))) 
                for (int j = 0; j < impresion.size(); j++) 
                    if (regla.contains(impresion.get(j)) && i!=j){
                        iRegla = regla.indexOf(impresion.get(i));
                        jRegla = regla.indexOf(impresion.get(j));
                        menorQueImpresion = i < j;
                        menorQueRegla = iRegla < jRegla;
                        if (menorQueImpresion != menorQueRegla) 
                            return false;
                    }
        }
        return true;
    }

    static List<List<Integer>> getMapaFromTxt(String rutaRelativa) {
        try (Scanner txtEscaneado = new Scanner(new File(rutaRelativa))) {
            List<List<Integer>> impresiones = new ArrayList<>();
            String linea;
            String[] regla;
            Stream<String> impresion;
            while (txtEscaneado.hasNextLine()) {
                linea = txtEscaneado.nextLine();
                if (linea.contains("|")) {
                    regla = linea.split("\\|");
                    reglas.add(new ArrayList<Integer>(List.of(Integer.parseInt(regla[0]), Integer.parseInt(regla[1]))));
                } else {
                    impresion = Arrays.stream(linea.split(","));
                    impresiones.add(impresion.mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
                }
            }
            return impresiones;
        } catch (FileNotFoundException e) { return null; }
    }
}
