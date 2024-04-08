package gal.usc.etse.soap.calculator;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService
public interface Calculator {
    @WebMethod(operationName = "suma")
    @WebResult(name = "resultado")
    int sum(@WebParam(name = "sumando1") int a, @WebParam(name = "sumando2") int b);
    int sum(int[] nums);

    @WebMethod(operationName = "resta")
    @WebResult(name = "resultado")
    int minus(@WebParam(name = "operando1") int a, @WebParam(name = "operando2") int b);
    int minus(int[] nums);

    @WebMethod(operationName = "multiplicacion")
    @WebResult(name = "resultado")
    float multiplicacion(@WebParam(name = "multiplicando1") float a, @WebParam(name = "multiplicando2") float b);

    @WebMethod(operationName = "division")
    @WebResult(name = "resultado")
    float division(@WebParam(name = "dividendo") float a, @WebParam(name = "divisor") float b);


    @WebMethod(operationName = "elevacion")
    @WebResult(name = "resultado")
    double power(@WebParam(name = "base") float a, @WebParam(name = "exponente") float b);

    @WebMethod(operationName = "raiz")
    @WebResult(name = "resultado")
    double raiz(@WebParam(name = "num") float a);

    @WebMethod(operationName = "logaritmo")
    @WebResult(name = "resultado")
    double log(@WebParam(name = "num") int a);

    @WebMethod(operationName = "maximo")
    @WebResult(name = "resultado")
    double max(@WebParam(name = "num") double[] a);

    @WebMethod(operationName = "minimo")
    @WebResult(name = "resultado")
    double min(@WebParam(name = "num") double[] a);

    @WebMethod(operationName = "mediana")
    @WebResult(name = "resultado")
    double mediana(@WebParam(name = "num") double[] a);

    @WebMethod(operationName = "media")
    @WebResult(name = "resultado")
    double media(@WebParam(name = "num") double[] a);

    @WebMethod(operationName = "moda")
    @WebResult(name = "resultado")
    ArrayList<Double> moda(@WebParam(name = "nums") double[] a);

    @WebMethod(operationName = "DesviacionTipica")
    @WebResult(name = "resultado")
    double desvTip(@WebParam(name = "nums") double[] a);


}
