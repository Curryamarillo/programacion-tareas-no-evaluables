package UD05;

public class pruebas {

    public static void EjercicioM1() {
        // Definición de constantes para el tamaño
        final int FILAS = 3;
        final int COLUMNAS = 4;

        // a) Inicializa la matriz directamente
        int[][] matrizNumeros = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        // Declaración de variables necesarias
        int[][] matrizNumerosMultiplicados = new int[FILAS][COLUMNAS];
        int sumatoria = 0;
        int numeroMayor = matrizNumeros[0][0]; // Inicializar ANTES de los bucles
        int numeroMenor = matrizNumeros[0][0]; // Inicializar ANTES de los bucles

        int[] sumasFila = new int[FILAS];
        double[] mediasFila = new double[FILAS];
        int[] sumasColumna = new int[COLUMNAS];
        double[] mediasColumna = new double[COLUMNAS];


        System.out.println("--- a) Matriz Original (3x4) ---");
        // Recorrido principal para puntos a, b, c, d (sumaFila) y f
        for (int i = 0; i < FILAS; i++) {
            sumasFila[i] = 0; // Inicializar la suma de la fila actual
            for (int j = 0; j < COLUMNAS; j++) {
                int valorActual = matrizNumeros[i][j];

                // a) Mostrar
                System.out.print(valorActual + "\t");

                // b) Suma total
                sumatoria += valorActual;

                // c) Mayor y menor
                if (valorActual > numeroMayor) {
                    numeroMayor = valorActual;
                }
                if (valorActual < numeroMenor) {
                    numeroMenor = valorActual;
                }

                // d) Suma de cada fila
                sumasFila[i] += valorActual;

                // f) Multiplicar por 2
                matrizNumerosMultiplicados[i][j] = valorActual * 2;
            }
            System.out.println(); // Salto de línea después de cada fila
        }

        // --- Resultados de los puntos b y c ---
        System.out.println("\n--- b) y c) Resultados Globales ---");
        System.out.println("La suma de todos los números es: **" + sumatoria + "**");
        System.out.println("El mayor número es: **" + numeroMayor + "**");
        System.out.println("El menor número es: **" + numeroMenor + "**");

        // --- d) Suma y Media de cada fila ---
        System.out.println("\n--- d) Suma y Media de cada Fila ---");
        for (int i = 0; i < FILAS; i++) {
            mediasFila[i] = (double) sumasFila[i] / COLUMNAS; // Calcular la media
            System.out.println("Fila " + i + ": Suma = " + sumasFila[i] + ", Media = " + String.format("%.2f", mediasFila[i]));
        }

        // --- e) Suma y Media de cada columna ---
        System.out.println("\n--- e) Suma y Media de cada Columna ---");
        for (int j = 0; j < COLUMNAS; j++) { // Recorre las columnas
            sumasColumna[j] = 0; // Inicializar la suma de la columna actual
            for (int i = 0; i < FILAS; i++) { // Recorre las filas
                sumasColumna[j] += matrizNumeros[i][j];
            }
            mediasColumna[j] = (double) sumasColumna[j] / FILAS; // Calcular la media
            System.out.println("Columna " + j + ": Suma = " + sumasColumna[j] + ", Media = " + String.format("%.2f", mediasColumna[j]));
        }

        // --- f) Multiplica por 2 y muestra la nueva matriz ---
        System.out.println("\n--- f) Matriz multiplicada por 2 ---");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(matrizNumerosMultiplicados[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

