package gal.usc.etse.soap.calculator;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebService(
        endpointInterface = "gal.usc.etse.soap.calculator.Calculator",
        serviceName = "Calculator"
)
public class CalculatorImpl implements Calculator {
    @Override
    public int sum(int a, int b) {
        return a+b;
    }

    @Override
    public int sum(int[] nums) {
        return Arrays.stream(nums).sum();
    }

    @Override
    public int minus(int a, int b) {
        return a-b;
    }

    @Override
    public int minus(int[] nums) {
        if (nums.length < 0){
            System.out.println("No hay números que restar");
            return 0;
        }
        int resultado = nums[0];
        for (int i = 1 ; i < nums.length; i++){
            resultado -= nums[i];
        }
        return resultado;
    }

    @Override
    public float multiplicacion(float a, float b) { return a*b; }

    @Override
    public float division(float a, float b) { return a/b; }

    @Override
    public double power(float a, float b) {
        return Math.pow(a,b);
    }

    @Override
    public double raiz(float a){
        return (Math.pow(a, 0.5));
    }

    @Override
    public double log(int a){
        return Math.log(a);
    }

    @Override
    public double max(double[] nums){
        return Arrays.stream(nums).max().getAsDouble();
    }

    @Override
    public double min(double[] nums){
        return Arrays.stream(nums).min().getAsDouble();
    }

    @Override
    public double mediana(double[] nums){
        // Ordenamos el array de nums
        Arrays.sort(nums);

        int n = nums.length;
        if (n % 2 == 0) {
            // Si la cantidad de elementos es par, la mediana es el promedio de los dos valores centrales.
            int medio1 = n / 2 - 1;
            int medio2 = n / 2;
            return (nums[medio1] + nums[medio2]) / 2.0;
        } else {
            // Si la cantidad de elementos es impar, la mediana es el valor central.
            int medio = n / 2;
            return nums[medio];
        }
    }

    @Override
    public double media(double[] nums){
        if (nums.length == 0) {
            return 0.0; // Si no hay numeros, la media es 0.
        }

        double suma = 0.0;
        for (double dato : nums) {
            suma += dato;
        }
        return suma / nums.length;
    }


    @Override
    public ArrayList<Double> moda(double[] array) {
        // Crear un mapa para almacenar la frecuencia de cada elemento en el array
        Map<Double, Integer> frecuencia = new HashMap<>();

        // Encontrar la frecuencia de cada elemento y realizar un seguimiento del máximo
        int maxFrecuencia = 0;
        for (double num : array) {
            frecuencia.put(num, frecuencia.getOrDefault(num, 0) + 1);
            maxFrecuencia = Math.max(maxFrecuencia, frecuencia.get(num));
        }

        // Encontrar los elementos que tienen la frecuencia máxima (moda)
        ArrayList<Double> moda = new ArrayList<>();
        for (Map.Entry<Double, Integer> entry : frecuencia.entrySet()) {
            if (entry.getValue() == maxFrecuencia) {
                moda.add(entry.getKey());
            }
        }

        return moda;
    }


    @Override
    public double desvTip(double[] nums){
        int n = nums.length;

        // Calculamos la media
        double media = this.media(nums);

        // Calcular la suma de los cuadrados de las diferencias
        double sumaDiferenciasCuadrado = 0;
        for (double num : nums) {
            double diferencia = num - media;
            sumaDiferenciasCuadrado += diferencia * diferencia;
        }

        // Dividimos por la cantidad de elementos
        double varianza = sumaDiferenciasCuadrado / n;

        // Calculamos la raíz cuadrada para obtener la desviación estándar
        // y la devolvemos
        return Math.sqrt(varianza);
    }
}

