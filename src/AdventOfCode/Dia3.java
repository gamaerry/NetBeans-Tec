package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dia3 {
    public static void main(String[] args) {
        List<String> lista = getListaFromTxt("src/AdventOfCode/input_dia3.txt");
        primerProblema(lista);
        segundoProblema(lista);
    }

    static void primerProblema(List<String> lista) {
        System.out.println(lista.stream().mapToInt(linea -> {
            int suma = 0;
            while (linea.matches(".*?mul\\((\\d{1,3}),(\\d{1,3})\\).*")) {
                String funcionEncontrada = linea.replaceAll(".*?(mul\\((\\d{1,3}),(\\d{1,3})\\)).*", "$2,$3");
                suma += mul(funcionEncontrada);
                linea = linea.replaceFirst("mul\\((\\d{1,3}),(\\d{1,3})\\)", "");
            }
            return suma;
        }).sum());
    }

    static String lineaActual = "";
    static boolean activado = true;
    static void segundoProblema(List<String> lista) {
        System.out.println(lista.stream().mapToInt(linea -> {
            int suma = 0;
            lineaActual = linea;
            while (lineaActual.matches(".*?mul\\((\\d{1,3}),(\\d{1,3})\\).*")) {
                lineaActual = lineaActual.replace("º", "");
                String funcionEncontrada = lineaActual.replaceAll(".*?(mul\\((\\d{1,3}),(\\d{1,3})\\)).*", "$2,$3");
                suma += mul(funcionEncontrada) * (activado ? 1 : 0);
                lineaActual = lineaActual.replaceFirst("mul\\((\\d{1,3}),(\\d{1,3})\\)", "º");
                int huboCambio = hayCambio();
                activado = huboCambio == -1 ? activado : huboCambio == 1;
            }
            return suma;
        }).sum());
    }

    static int hayCambio() { // -1 no hay cambio, 0 don't() y 1 do()
        boolean cambio = lineaActual.matches(".*º((?!mul\\(\\d{1,3},\\d{1,3}\\)).)*(do\\(\\)|don't\\(\\)).*");
        if (cambio) {
            String tipo = lineaActual.replaceAll(".*º((?!mul\\(\\d{1,3},\\d{1,3}\\)).)*(do\\(\\)|don't\\(\\)).*", "$2");
            return tipo.equals("don't()") ? 0 : 1;
        } else return -1;
    }

    static int mul(String coincidencia) {
        String[] parametros = coincidencia.split(",");
        return Integer.parseInt(parametros[0]) * Integer.parseInt(parametros[1]);
    }

    static List<String> getListaFromTxt(String rutaRelativa) {
        try (Scanner txtEscaneado = new Scanner(new File(rutaRelativa))) {
            List<String> lista = new ArrayList<>();
            while (txtEscaneado.hasNextLine()) {
                String lineaActual = txtEscaneado.nextLine();
                lista.add(lineaActual);
            }
            return lista;
        } catch (FileNotFoundException e) { return null; }
    }
}
