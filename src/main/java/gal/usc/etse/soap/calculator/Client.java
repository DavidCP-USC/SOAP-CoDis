package gal.usc.etse.soap.calculator;
import gal.usc.etse.soap.textanalyzer.textAnalyzer;


import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    static Scanner scanner = new Scanner(System.in);
    public static double[] obtenerLista(){
        int n;
        System.out.print("Introduce numero de elementos a añadir:");
        n = scanner.nextInt();
        if (n == 0){
            System.out.println("No se añadieron números");
        }
        double a[] = new double[n];
        for(int i = 0; i < n; i++){
            System.out.println("Introduce el elemento " + (i+1));
            a[i] = scanner.nextDouble();
        }
        return a;
    }

    public static void main(String[] args) throws MalformedURLException {

        // Pedimos la IP y el puerto del servidor de la Calculadora
        System.out.println("Introduce la IP del servidor Calculadora: ");
        String ipCalc = scanner.nextLine();
        System.out.println("Introduce el puerto del servidor Calculadora: ");
        String puertoCalc = scanner.nextLine();

        // Pedimos la IP y el puerto del servidor del Analizador de Textos
        System.out.println("Introduce la IP del servidor Analizador de Textos: ");
        String ipTextAnalyzer = scanner.nextLine();
        System.out.println("Introduce el puerto del servidor Analizador de Textos: ");
        String puertoTextAnalyzer = scanner.nextLine();
        
        // Creamos el servicio de la calculadora
        URL wsdlURL = new URL("http://" + ipCalc  + ":" + puertoCalc + "/calculator?wsdl");
        QName Calculator = new QName("http://calculator.soap.etse.usc.gal/", "Calculator");
        Service service = Service.create(wsdlURL, Calculator);
        Calculator client = service.getPort(Calculator.class);

        // Creamos el servicio del analizador de textos
        URL wsdlURLTextAnalyzer = new URL("http://" + ipTextAnalyzer  + ":" + puertoTextAnalyzer + "/textAnalyzer?wsdl");
        QName textAnalyzerA = new QName("http://textanalyzer.soap.etse.usc.gal/", "textAnalyzer");
        Service serviceTextAnalyzer = Service.create(wsdlURLTextAnalyzer, textAnalyzerA);
        textAnalyzer analizadorTexto = serviceTextAnalyzer.getPort(textAnalyzer.class);

        boolean exit = false;
        boolean exitPrincipal = false;
        double[] lista = null;
        // Menu principal
        while (!exitPrincipal){
            System.out.println("-------- Servicios --------");
            System.out.println("a) Calculadora");
            System.out.println("b) Analizador de textos");
            System.out.println("c) Salir");
            System.out.println("Opción:");

            String opcion = scanner.nextLine();
            if(opcion.equals("a")) {
                while (!exit) {
                    System.out.println("-------- MENU --------");
                    System.out.println("1) Suma");
                    System.out.println("2) Resta");
                    System.out.println("3) Multiplicacion");
                    System.out.println("4) Division");
                    System.out.println("5) Potencia");
                    System.out.println("6) Raiz Cuadrada");
                    System.out.println("7) Logaritmo");
                    System.out.println("8) Maximo");
                    System.out.println("9) Minimo");
                    System.out.println("10) Media");
                    System.out.println("11) Mediana");
                    System.out.println("12) Moda");
                    System.out.println("13) Desviación típica");
                    System.out.println("0) Volver al menú principal");
                    System.out.print("Opción: ");
                    try {
                        int command = scanner.nextInt();
                        switch (command){
                            case 1: // Suma
                                System.out.println("Sumando1:");
                                int sumando1 = scanner.nextInt();
                                System.out.println("Sumando2:");
                                int sumando2 = scanner.nextInt();
                                System.out.println("Resultado: " + client.sum(sumando1, sumando2));
                                break;
                            case 2: // Resta
                                System.out.println("Minuendo:");
                                int minuendo = scanner.nextInt();
                                System.out.println("Sustraendo:");
                                int sustraendo = scanner.nextInt();
                                System.out.println("Resultado: " + client.minus(minuendo, sustraendo));
                                break;
                            case 3: // Multiplicacion
                                System.out.println("Multiplicando1:");
                                int multiplicando1 = scanner.nextInt();
                                System.out.println("Multiplicando2:");
                                int multiplicando2 = scanner.nextInt();
                                System.out.println("Resultado: " + client.multiplicacion(multiplicando1, multiplicando2));
                                break;
                            case 4: // Division
                                System.out.println("Dividendo:");
                                int dividendo = scanner.nextInt();
                                System.out.println("Divisor:");
                                int divisor = scanner.nextInt();
                                System.out.println("Resultado: " + client.division(dividendo, divisor));
                                break;
                            case 5: // Potencia
                                System.out.println("Base:");
                                int base = scanner.nextInt();
                                System.out.println("Exponente:");
                                int exponente = scanner.nextInt();
                                System.out.println("Resultado: " + client.power(base, exponente));
                                break;
                            case 6: // Raiz Cuadrada
                                System.out.println("Raiz:");
                                int num = scanner.nextInt();
                                System.out.println("Resultado: " + client.raiz(num));
                                break;
                            case 7: // Logaritmo
                                System.out.println("Logaritmo:");
                                int n = scanner.nextInt();
                                System.out.println("Resultado: " + client.log(n));
                                break;
                            case 8: // Maximo
                                System.out.println("Maximo:");
                                lista = obtenerLista();
                                System.out.println("Resultado: " + client.max(lista));
                                break;
                            case 9: // Minimo
                                System.out.println("Minimo:");
                                lista = obtenerLista();
                                System.out.println("Resultado: " + client.min(lista));
                                break;
                            case 10: // Media
                                System.out.println("Media:");
                                lista = obtenerLista();
                                System.out.println("Resultado: " + client.media(lista));
                                break;
                            case 11: // Mediana
                                System.out.println("Mediana:");
                                lista = obtenerLista();
                                System.out.println("Resultado: " + client.mediana(lista));
                                break;
                            case 12: // Moda
                                System.out.println("Moda:");
                                lista = obtenerLista();
                                System.out.println("Resultado: " + client.moda(lista));
                                break;
                            case 13: // Desviacion Típica
                                System.out.println("Desviacion Típica:");
                                lista = obtenerLista();
                                System.out.println("Resultado: " + client.desvTip(lista));
                                break;
                            case 0: // Salir
                                exit = true;
                                scanner.nextLine();
                                break;
                            default: // Opcion no valida
                                System.out.println("Opción no válida");
                                break;
                        }
                    }catch (Exception ex){
                        System.out.println(ex);
                    }
                }
            } else if (opcion.equals("b")) {
                exit = false;
                System.out.println("Introduzca el texto sobre el que se realizarán las operaciones");
                String texto = scanner.nextLine();
                while (!exit) {
                    System.out.println("MENU:");
                    System.out.println("1) Contar Palabras");
                    System.out.println("2) Contar Caracteres");
                    System.out.println("3) Contar frases");
                    System.out.println("4) Contar frecuencia palabra");
                    System.out.println("5) Palabra mas frecuente");
                    System.out.println("6) Palabra menos frecuente");
                    System.out.println("7) Reemplazar palabra");
                    System.out.println("8) Cambiar texto de entrada");
                    System.out.println("0) Salir");
                    System.out.print("Opcion: ");
                    try {
                        int command = scanner.nextInt();
                        scanner.nextLine();
                        switch (command){
                            case 1: // Contar palabras
                                System.out.println(analizadorTexto.contarPalabras(texto));
                                break;
                            case 2: // Contar caracteres
                                System.out.println(analizadorTexto.contarCaracteres(texto));
                                break;
                            case 3: // Contar frases
                                System.out.println(analizadorTexto.contarFrases(texto));
                                break;
                            case 4: // Contar frecuencia palabra
                                System.out.println("Introduzca palabra a contar");
                                String word = scanner.nextLine();
                                word = word.toLowerCase();
                                System.out.println(analizadorTexto.contarPalabra(texto, word));
                                break;
                            case 5: // Palabra mas frecuente
                                for (String s: analizadorTexto.palabrasMasUsadas(texto)){
                                    System.out.println(s);
                                }
                                break;
                            case 6: // Palabra menos frecuente
                                ArrayList<String> palabrasMeU = analizadorTexto.palabrasMenosUsadas(texto);
                                for (String s: palabrasMeU){
                                    System.out.println(s);
                                }
                                break;
                            case 7: // Reemplazar palabra
                                System.out.println("Introduzca palabra a reemplazar:");
                                String palabraAReemplazar = scanner.nextLine();
                                System.out.println("Introduzca la nueva palabra");
                                String palabraDeReemplazo = scanner.nextLine();
                                texto = analizadorTexto.reemplazarPalabra(texto, palabraAReemplazar, palabraDeReemplazo);
                                System.out.println(texto);
                                break;
                            case 8:
                                System.out.println("Introduce el nuevo texto: ");
                                texto = scanner.nextLine();
                                break;
                            case 0: // Salir
                                exit = true;
                                break;
                            default: // Opcion no valida
                                System.out.println("Opcion no válida");
                                break;
                        }
                    } catch(Exception ex){
                        System.out.println();
                    }
                }
            }
            else if(opcion.equals("c")){
                exitPrincipal = true;
                System.out.println("Fin del programa\n");
            }
            else{
                System.out.println("Opción no válida\n");
            }
        }
        scanner.close();
    }
}
