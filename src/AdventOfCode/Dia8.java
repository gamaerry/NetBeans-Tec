package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dia8 {
    static List<String> renglones;
    static int largo, ancho;  
    public static void main(String[] args) {
        renglones = getListaFromTxt("src/AdventOfCode/input_dia8.txt");
        problema1();
    }

    static void problema1() {
        int contador = 0;
        for (int i = 0; i < largo; i++) {
            for (int j = 0; j < ancho; j++) {
                if (renglones.get(i).charAt(j) != '.' && renglones.get(i).charAt(j) != '#') {
                    contador += getAntinodos(i,j);
                }
            }
        }
        for (int i = 0; i < largo; i++) 
            System.out.println(renglones.get(i));
        System.out.println(contador);
    }

    static int getAntinodos(int i, int j) {
        int c = 0;
        char actual = renglones.get(i).charAt(j);
        for (int i2 = i + 1; i2 < largo; i2++) {
            for (int j2 = 0; j2 < ancho; j2++) {
                if (renglones.get(i2).charAt(j2) == actual)
                    c += antinodosParticulares(i, j, i2, j2);
            }
        }
        return c;
    }

    static String reemplazarChar(String original, int index, char nuevoChar) {
        if (original.charAt(index) == '.'){
            char[] chars = original.toCharArray();
            chars[index] = nuevoChar;
            return new String(chars);
        } else return original;
    }

    static int antinodosParticulares(int i, int j, int i2, int j2) {
        int c = 0, deltaI = i2 - i, deltaJ = j2 - j;
        if (dentroDelRango(i - deltaI, j - deltaJ)) {
            if (renglones.get(i - deltaI).charAt(j - deltaJ) != '#'){
                c++;
                renglones.set(i - deltaI, reemplazarChar(renglones.get(i - deltaI), j - deltaJ, '#'));
            }
        }
        if (dentroDelRango(i2 + deltaI, j2 + deltaJ)) { 
            if (renglones.get(i2 + deltaI).charAt(j2 + deltaJ) != '#'){
                c++;
                renglones.set(i2 + deltaI, reemplazarChar(renglones.get(i2 + deltaI), j2 + deltaJ, '#'));
            }
        }
        return c;
    }

    static boolean dentroDelRango(int i, int j) {
        return i >= 0 && i < largo && j >= 0 && j < ancho;
    }

    static List<String> getListaFromTxt(String rutaRelativa) {
        try (Scanner txtEscaneado = new Scanner(new File(rutaRelativa))) {
            List<String> renglones = new ArrayList<>();
            while (txtEscaneado.hasNextLine()) 
                renglones.add(txtEscaneado.nextLine());
            largo = renglones.size();
            ancho = renglones.getFirst().length();
            return renglones;
        } catch (FileNotFoundException e) { return null; }
    }
}
