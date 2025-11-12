package UD05;

import java.util.Arrays;

public class Parte1EstructurasDeDatosDinamicas_Matrices {

    /*
    a) Declara y muestra una matriz de 3x3 de String con palabras cortas inicializadas directamente en el código.
    b) Muestra qué palabras contienen más de 5 letras y sustitúyelas por un asterisco ("*").
    c) De la matriz modificada, muestra qué palabras empiezan por vocal y sustitúyelas por un guión ("-").
    d) Considera que cada fila forma una frase. Muestra las tres frases, teniendo en cuenta que:
        - Cada palabra tiene que estar separada por un espacio
        - Tiene que haber un punto final.
     */
    public static void EjercicioM2() {

        final int FILAS = 3;
        final int COLUMNAS = 3;
        final int COLUMNAS_FRASE = 1;
        final int FILAS_FRASE = 3;

        String[][] conjuntoPalabras = {
                {"perro", "gato", "dia"},
                {"jirafa", "ala", "eso"},
                {"ara", "rata", "petroleo"}
        };

        String[][] conjuntoModificadoAsterisco = new String[FILAS][COLUMNAS];
        String[][] conjuntoModificadoGuion = new String[FILAS][COLUMNAS];

        String[][] frases = new String[FILAS_FRASE][COLUMNAS_FRASE];

        for (int i = 0; i < FILAS; i++) {
            for (int j= 0; j < COLUMNAS; j++ ) {
                String palabraActual = conjuntoPalabras[i][j];
                if (palabraActual.length() > 5) {
                    conjuntoModificadoAsterisco[i][j] = "*";
                } else {
                    conjuntoModificadoAsterisco[i][j] = conjuntoPalabras[i][j];
                }
                if (palabraActual.matches("[aeiouAEIOU].*")) {
                    conjuntoModificadoGuion[i][j] = "-";
                } else {
                    conjuntoModificadoGuion[i][j] = conjuntoPalabras[i][j];
                }
            }
        }
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
               System.out.println(conjuntoPalabras[i][j] + " ");
               frases[i][0] += (conjuntoPalabras[i][j]);


//                for (int k = 0; k < FILAS_FRASE; k++) {
//                    for (int l = 0; l < COLUMNAS_FRASE; l++) {
//
//                    }
//                }
            }
        }

//        System.out.println(Arrays.deepToString(conjuntoPalabras));
//        System.out.println(Arrays.deepToString(conjuntoModificadoAsterisco));
//        System.out.println(Arrays.deepToString(conjuntoModificadoGuion));



        System.out.println(Arrays.deepToString(frases));
        // TODO Continuar con esta tarea, estoy el punto d)
    }

    /*
    a) Declara y muestra una matriz de 3x4 con valores enteros inicializados directamente en el código.
    b) Muestra la suma de todos los elementos de la matriz.
    c) Muestra el mayor y el menor elemento de la matriz.
    d) Muestra la suma y la media de cada fila.
    e) Muestra la suma y la media de cada columna.
    f) Multiplica todos los valores por 2 y muestra la nueva
     */
    public static void EjercicioM1() {
        final int FILAS = 3;
        final int COLUMNAS = 4;
        int[][] matrizNumeros = {
                {4, 2, 3, 5},
                {11, 20, 9, 21},
                {8, 2, 7, 12}
        };
        int[][] matrizNumerosMultiplicados = new int[FILAS][COLUMNAS];
        int sumatoria = 0;
        int numeroMayor = matrizNumeros[0][0];
        int numeroMenor = matrizNumeros[0][0];
        int[] sumaFilas = new int[COLUMNAS];
        int[] sumaColumnas = new int[FILAS];
        float[] mediaFilas = new float[COLUMNAS];
        float[] mediaColumnas = new float[FILAS];

        System.out.print("Los números cargados son: ");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(matrizNumeros[i][j] + " ");
                sumatoria += matrizNumeros[i][j];

                if (numeroMayor < matrizNumeros[i][j]) {
                    numeroMayor = matrizNumeros[i][j];
                }
                if (numeroMenor > matrizNumeros[i][j]) {
                    numeroMenor = matrizNumeros[i][j];
                }
                sumaColumnas[i] += matrizNumeros[i][j];

                sumaFilas[j] += matrizNumeros[i][j];

                mediaColumnas[i] =(float) sumaColumnas[i] / COLUMNAS;

                mediaFilas[j] = (float) sumaFilas[i] / FILAS;

                matrizNumerosMultiplicados[i][j] = matrizNumeros[i][j] * 2;
            }


        }
        System.out.println("\nLa sumatoria de todos los campos es: " + sumatoria);
        System.out.println("El número menor es: " + numeroMenor);
        System.out.println("El número mayor es: " + numeroMayor);

        System.out.println("La suma de filas es: " + Arrays.toString(sumaFilas).replace("[", "").replace("]", ""));
        System.out.println("La media de filas es: " + Arrays.toString(mediaFilas).replace("[", "").replace("]", ""));
        System.out.println("La suma de columnas es: " + Arrays.toString(sumaColumnas).replace("[", "").replace("]", ""));
        System.out.println("La media de columnas es: " + Arrays.toString(mediaColumnas).replace("[", "").replace("]", ""));

        System.out.print("La matriz con los campos multiplicados por dos es: ");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(matrizNumerosMultiplicados[i][j] + " ");
            }
        }
    }
}
