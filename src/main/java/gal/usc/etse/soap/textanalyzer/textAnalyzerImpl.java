package gal.usc.etse.soap.textanalyzer;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


@WebService(
        endpointInterface = "gal.usc.etse.soap.textanalyzer.textAnalyzer",
        serviceName = "textAnalyzer"
)
public class textAnalyzerImpl implements textAnalyzer {
    @Override
    public int contarPalabras(String texto){
        if (texto == null || texto.isEmpty()) {
            return 0;
        }

        // Dividimos el texto en palabras utilizando el espacio en blanco como delimitador
        String[] palabras = texto.split("\\s+");

        return palabras.length;
    }

    @Override
    public int contarCaracteres(String texto){
        if (texto == null || texto.isEmpty()) {
            return 0;
        }

        return texto.length();
    }

    @Override
    public int contarFrases(String texto){
        if (texto == null || texto.isEmpty()) {
            return 0;
        }

        // Dividimos el texto según los delimitadores que indican que una frase ha termiando
        String[] frases = texto.split("[.!?]+");

        return frases.length;
    }

    @Override
    public int contarPalabra(String texto, String palabra) {
        if (texto == null || texto.isEmpty() || palabra == null || palabra.isEmpty()) {
            return 0;
        }
        // Pasamos la palabra a minúsculas
        palabra = palabra.toLowerCase();

        // Utilizar una expresión regular para dividir el texto en palabras sin incluir signos de puntuación
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        java.util.regex.Matcher matcher = pattern.matcher(texto.toLowerCase());

        int contador = 0;

        while (matcher.find()) {
            String palabraEnTexto = matcher.group().toLowerCase();
            if (palabraEnTexto.equals(palabra.toLowerCase())) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public ArrayList<String> palabrasMenosUsadas(String texto) {
        if (texto == null || texto.isEmpty()) {
            return null;
        }

        // Crear un mapa para almacenar la frecuencia de cada palabra
        Map<String, Integer> frecuenciaPalabras = new HashMap<>();

        // Utilizar una expresión regular para dividir el texto en palabras sin incluir signos de puntuación
        Pattern patron = Pattern.compile("\\b\\w+\\b");

        java.util.regex.Matcher matcher = patron.matcher(texto.toLowerCase());

        while (matcher.find()) {
            String palabra = matcher.group();
            int frecuencia = frecuenciaPalabras.getOrDefault(palabra, 0) + 1;
            frecuenciaPalabras.put(palabra, frecuencia);
        }

        // Encontrar la frecuencia mínima
        int minFrecuencia = Integer.MAX_VALUE;
        for (int frecuencia : frecuenciaPalabras.values()) {
            if (frecuencia < minFrecuencia) {
                minFrecuencia = frecuencia;
            }
        }

        // Encontrar las palabras con la frecuencia mínima
        ArrayList<String> palabrasMenosUsadas = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : frecuenciaPalabras.entrySet()) {
            if (entry.getValue() == minFrecuencia) {
                palabrasMenosUsadas.add(entry.getKey());
            }
        }

        return palabrasMenosUsadas;
    }


    @Override
    public ArrayList<String> palabrasMasUsadas(String texto) {
        if (texto == null || texto.isEmpty()) {
            return null;
        }

        // Crear un mapa para almacenar la frecuencia de cada palabra
        Map<String, Integer> frecuenciaPalabras = new HashMap<>();

        // Utilizar una expresión regular para dividir el texto en palabras sin incluir signos de puntuación
        Pattern patron = Pattern.compile("\\b\\w+\\b");

        java.util.regex.Matcher matcher = patron.matcher(texto.toLowerCase());

        while (matcher.find()) {
            String palabra = matcher.group();
            int frecuencia = frecuenciaPalabras.getOrDefault(palabra, 0) + 1;
            frecuenciaPalabras.put(palabra, frecuencia);
        }

        // Encontrar la frecuencia máxima
        int maxFrecuencia = 0;
        for (int frecuencia : frecuenciaPalabras.values()) {
            if (frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
            }
        }

        // Encontrar las palabras con la frecuencia máxima
        ArrayList<String> palabrasMasUsadas = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : frecuenciaPalabras.entrySet()) {
            if (entry.getValue() == maxFrecuencia) {
                palabrasMasUsadas.add(entry.getKey());
            }
        }

        return palabrasMasUsadas;
    }


    @Override
    public String reemplazarPalabra(String texto, String palabraOriginal, String palabraReemplazo) {
        if (texto == null || texto.isEmpty() || palabraOriginal == null || palabraOriginal.isEmpty()) {
            return texto;
        }

        String[] palabras = texto.split("\\s+");

        for (int i = 0; i < palabras.length; i++) {
            // Eliminar signos de puntuación alrededor de la palabra
            palabras[i] = palabras[i].replaceAll("^\\p{Punct}+", "");
            palabras[i] = palabras[i].replaceAll("\\p{Punct}+$", "");

            // Comparar la palabra actual (sin distinción de mayúsculas y minúsculas) con la palabra original
            if (palabras[i].equalsIgnoreCase(palabraOriginal)) {
                palabras[i] = palabraReemplazo;
            }
        }

        StringBuilder textoModificado = new StringBuilder();
        for (String palabra : palabras) {
            textoModificado.append(palabra).append(" ");
        }

        if (textoModificado.length() > 0) {
            textoModificado.setLength(textoModificado.length() - 1);
        }

        return textoModificado.toString();
    }

}
