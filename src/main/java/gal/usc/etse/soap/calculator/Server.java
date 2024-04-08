package gal.usc.etse.soap.calculator;

import gal.usc.etse.soap.textanalyzer.textAnalyzer;
import gal.usc.etse.soap.textanalyzer.textAnalyzerImpl;

import javax.xml.ws.Endpoint;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la IP para el servidor del Calculator: ");
        String ipCalculator = scanner.nextLine();
        System.out.println("Introduce el puerto del Calculator: ");
        String puertoCalculator = scanner.nextLine();
        System.out.println("Introduce la IP para el servidor del Analizador de Texto: ");
        String ipTextAnalyzer = scanner.nextLine();
        System.out.println("Introduce el puerto del Analizador de Texto: ");
        String puertoTextAnalyzer = scanner.nextLine();
        scanner.close();
        Calculator c = new CalculatorImpl();
        String address = "http://" + ipCalculator +":" + puertoCalculator +"/calculator";
        textAnalyzer t = new textAnalyzerImpl();
        String address2 = "http://" + ipTextAnalyzer +":" + puertoTextAnalyzer +"/textAnalyzer";

        Endpoint.publish(address, c);
        Endpoint.publish(address2, t);
    }
}
