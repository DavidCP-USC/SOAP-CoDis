package gal.usc.etse.soap.textanalyzer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.ArrayList;


@WebService
public interface textAnalyzer {
    @WebMethod(operationName = "ContarPalabras")
    @WebResult(name = "NumeroPalabras")
    int contarPalabras(@WebParam(name = "Texto") String texto);

    @WebMethod(operationName = "ContarCaracteres")
    @WebResult(name = "NumeroCaracteres")
    int contarCaracteres(@WebParam(name = "Texto") String texto);

    @WebMethod(operationName = "ContarFrases")
    @WebResult(name = "NumeroFrases")
    int contarFrases(@WebParam(name = "Texto") String texto);

    @WebMethod(operationName = "ContarPalabra")
    @WebResult(name = "NumeroPalabra")
    int contarPalabra(@WebParam(name = "Texto") String texto, @WebParam(name = "palabra") String palabra);


    @WebMethod(operationName = "PalabraMasUsada")
    @WebResult(name = "PalabraConMasUsos")
    ArrayList<String> palabrasMasUsadas(@WebParam(name = "Texto") String texto);
    @WebMethod(operationName = "PalabraMenosUsada")
    @WebResult(name = "PalabraConMenosUsos")
    ArrayList<String> palabrasMenosUsadas(@WebParam(name = "Texto") String texto);

    @WebMethod(operationName = "ReemplazarPalabra")
    @WebResult(name = "ReemplazarPalabra")
    String reemplazarPalabra(@WebParam(name = "Texto") String texto, @WebParam(name = "PalabraAReemplazar") String palabraOriginal, @WebParam(name = "PalabraDeReemplazo") String palabraReemplazo);

}