# Servicios SOAP

Práctica realizada para la asignatura Computación Distribuida del Grado en Ingeniería Informática de la USC.

Los servicios SOAP son una forma de implementar sistemas distribuidos empleando una arquitectura simple basada en la Web. Estos servicios se denominan contract-first, puesto que su desarrollo se basa en una especificación previa de las operaciones, los inputs y los outputs de estas.
Los servicios SOAP pueden ser implementados en cualquier lenguaje empleando las librerías adecuadas (PHP+Symfony2, C+gSOAP, Java+GlassFish…). En este caso, usaremos Apache CXF, un framework Java basado en la implementación de referencia (GlassFish) que facilita mucho el desarrollo, para crear 2 servicios distintos.

# Servicio 1: Calculadora
Servicio de calculadora que implementa las siguientes operaciones. Supondremos que todas las entradas serán número enteros.
1. Suma de dos números.
2. Resta de dos números
3. Multiplicación de dos números
4. División de dos números
5. Potencia de un número.
6. Raíz cuadrada de un número.
7. Logaritmo neperiano de un número.
8. Máximo de una lista de números.
9. Mínimo de una lista de números.
10. Media de una lista de números.
11. Mediana de una lista de números.
12. Moda de una lista de números.
13. Desviación típica de una lista de números

# Servicio 2: Analizador de textos
Servicio analizador de textos que implementa las siguientes operaciones:
1. Contar palabras.
2. Contar caracteres (incluyendo espacios, signos de puntuación, etc.)
3. Contar frases.
4. Número de veces que aparece una palabra.
5. Palabra más usada.
6. Palabra menos usada.
7. Reemplazar palabra.
