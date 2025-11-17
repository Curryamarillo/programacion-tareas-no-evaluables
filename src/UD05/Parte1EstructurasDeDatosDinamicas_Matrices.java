package UD05;

import java.util.Arrays;

public class Parte1EstructurasDeDatosDinamicas_Matrices {

    /*
    Tienes una matriz String de 6x4 donde cada fila representa una variable y cada columna representa una versión del programa. El contenido indica el estado de la variable ("OK", "NULL" o "ERROR").

    a) Declara, inicializa y muestra la matriz. Cada posición contendrá, de forma aleatoria, alguna de las tres cadenas posibles.
    b) Muestra qué variables han tenido, al menos, un "ERROR".
    c) Muestra en qué versión se producen más "NULL".
    d) Muestra un resumen de cuántas veces aparece cada estado globalmente.
     */

    public static void EjercicioM5() {
        final int VARIABLES = 6;
        final int VERSIONES = 4;
        int[] contadorNullVersiones = new int[VERSIONES];

        int contadorErrorVersiones = 0;
        int contadorNullVersionesGlobal = 0;
        int contadorOkVersiones = 0;

        String[][] matriz = new String[VARIABLES][VERSIONES];

        for (int i = 0; i < VARIABLES; i++) {
            System.out.print("La variable " + i + " contiene: ");
            boolean valorError = false;
            for (int j = 0; j < VERSIONES; j++) {
                int estadoAlAzar = (int) (Math.random() * 3);
                String estado = switch (estadoAlAzar) {
                    case 0 -> "NULL";
                    case 1 -> "OK";
                    case 2 -> "ERROR";
                    default -> "";
                };
                matriz[i][j] = estado;
                if (estado.equals("ERROR")) {
                    valorError = true;
                    contadorErrorVersiones++;
                }
                if (estado.equals("NULL")) {
                    contadorNullVersiones[j]++;
                    contadorNullVersionesGlobal++;
                }

                if (estado.equals("OK")) contadorOkVersiones++;

                System.out.print(matriz[i][j] + " ");

            }
            if (valorError) {
                System.out.print("<--- CONTIENE UN VALOR ERROR");
            }
            System.out.println();
        }
        int maxNull = contadorNullVersiones[0];
        int posicion = 0;
        for (int i = 1; i < VERSIONES; i++) {
           if (contadorNullVersiones[i] > maxNull) {
               maxNull = contadorNullVersiones[i];
               posicion = i;
           }

        }
        System.out.println("\nLa version que tiene más NULL es: " + posicion + " con: " + contadorNullVersiones[posicion]);
        System.out.println("\nLa cantidad de NULL es: " + contadorNullVersionesGlobal);
        System.out.println("La cantidad de ERROR es: " + contadorErrorVersiones);
        System.out.println("La cantidad de OK es: " + contadorOkVersiones);
    }

    /*
    Tienes una matriz de 5 alumnos y 4 asignaturas. Cada valor es la nota (entero de 0 a 10) de un alumno en una asignatura.

    a) Introduce las notas con números aleatorios y muestra la matriz.
    b) Muestra la media de cada alumno.

    Para simplificar, puedes usar un identificador para cada alumno: "El alumno [1] ha sacado una media de 7.3"
    c) Muestra la media de cada asignatura.

    Para simplificar, puedes usar un identificador para cada asignatura: "La asignatura [3] tiene una media de 6.1"
    d) Muestra los alumnos que han aprobado todas las asignaturas.
     */

    public static void ejercicioM4() {

        final int ALUMNOS = 5;
        final int ASIGNATURAS = 4;
        final int NOTA_APROBADO = 4;
        int[][] curso = new int[ALUMNOS][ASIGNATURAS];
        float[] sumatoriaNotas = new float[ALUMNOS];
        float[] sumatoriaAsignaturas = new float[ASIGNATURAS];
        boolean[] aprobadoTodo = new boolean[ALUMNOS];

        System.out.println("Las notas son: ");
        for (int i = 0; i < ALUMNOS; i++) {
            System.out.print("\nAlumno " + (i + 1) + " : ");
            for (int j = 0; j < ASIGNATURAS; j++) {
                curso[i][j] = (int) (Math.random() * 11);
                sumatoriaNotas[i] += curso[i][j];
                sumatoriaAsignaturas[j] += curso[i][j];
                aprobadoTodo[i] = true;
                System.out.print(curso[i][j] + " ");
            }
        }
        System.out.println("\n");
        for (int i = 0; i < ALUMNOS; i++) {
            float promedio = sumatoriaNotas[i] / ASIGNATURAS;
            System.out.println("El promedio del alumno [" + (i + 1) + "] es: " + promedio);
        }
        System.out.println("\n");
        for (int i = 0; i < ASIGNATURAS; i++) {
            float promedio = sumatoriaAsignaturas[i] / ALUMNOS;
            System.out.println("La media de la asignatura [" + (i + 1) + "] es: " + promedio);
        }
        for (int i = 0; i < ALUMNOS; i++) {
            for (int j = 0; j < ASIGNATURAS; j++) {
                if (curso[i][j] < NOTA_APROBADO) {
                    aprobadoTodo[i] = false;
                    break;
                }
            }
        }
        boolean ningunoAprobado = false;
        for (int i = 0; i < aprobadoTodo.length; i++) {
            if (aprobadoTodo[i]) {
                System.out.println("El alumno " + (i + 1) + " ha aprobado todo!");
                ningunoAprobado = true;
            }
        }
        if (!ningunoAprobado) {
            System.out.println("Ninguno ha aprobado, manga de burros!");
        }


    }


    public static void EjercicioM3() {
        final int FILAS = 5;    // Funciones
        final int COLUMNAS = 4; // Ejecuciones
        int[][] tiemposEjecucion = new int[FILAS][COLUMNAS];
        float[] sumatoriaTiemposFilas = new float[FILAS];
        float[] sumatoriaTiemposColumnas = new float[COLUMNAS];

        // --- a) Declara y muestra una matriz e inicialízala con valores aleatorios ---
        System.out.println("--- a) Tiempos de Ejecución (ms) ---");
        for (int i = 0; i < FILAS; i++) {
            System.out.print("Función " + (i + 1) + ": ");
            for (int j = 0; j < COLUMNAS; j++) {
                tiemposEjecucion[i][j] = (int) (Math.random() * 1000); // Valores entre 0 y 999
                // Acumular sumas para cálculos posteriores
                sumatoriaTiemposFilas[i] += tiemposEjecucion[i][j];
                sumatoriaTiemposColumnas[j] += tiemposEjecucion[i][j];
                System.out.print(tiemposEjecucion[i][j] + " ");
            }
            System.out.println();
        }

        // --------------------------------------------------------------------------

        System.out.println("\n--- b) Tiempo Medio por Función (Fila) ---");
        // Se calcula y muestra el promedio de cada fila
        for (int i = 0; i < FILAS; i++) {
            // CORRECCIÓN: Se divide por COLUMNAS (4 ejecuciones) en lugar de FILAS (5 funciones)
            float promedio = sumatoriaTiemposFilas[i] / COLUMNAS;
            System.out.printf("El tiempo medio de la Función %d es: %.2f ms\n", (i + 1), promedio);
        }

        // --------------------------------------------------------------------------

        System.out.println("\n--- c) Ejecución (Columna) Globalmente Más Rápida ---");
        int columnaMasRapida = 0;
        float tiempoTotalMasRapido = sumatoriaTiemposColumnas[0]; // Inicializar con la suma de la primera columna

        // Encontrar la columna con la menor suma de tiempos (la más rápida)
        for (int j = 1; j < COLUMNAS; j++) {
            if (sumatoriaTiemposColumnas[j] < tiempoTotalMasRapido) {
                tiempoTotalMasRapido = sumatoriaTiemposColumnas[j]; // Actualizar comparador
                columnaMasRapida = j; // Guardar el índice de la columna
            }
        }

        float promedioColumnaMasRapida = tiempoTotalMasRapido / FILAS;

        System.out.println("La Ejecución globalmente más **rápida** es la número **" + (columnaMasRapida + 1) + "**.");
        System.out.printf("El tiempo medio de ejecución de esa columna fue: **%.2f ms**.\n", promedioColumnaMasRapida);

        // --------------------------------------------------------------------------

        // --- d) Funciones que han mejorado rendimiento respecto a la ejecución anterior ---
        System.out.println("\n--- d) Funciones con Mejora de Rendimiento (Ejecución < Anterior) ---");
        boolean mejoraEncontrada = false;

        // Se itera por cada función (fila)
        for (int i = 0; i < FILAS; i++) {
            // Se itera por las ejecuciones a partir de la segunda (j=1) para compararla con la anterior (j-1)
            for (int j = 1; j < COLUMNAS; j++) {
                // Un mejor rendimiento significa un tiempo de ejecución menor
                if (tiemposEjecucion[i][j] < tiemposEjecucion[i][j - 1]) {
                    System.out.printf("Función %d mejoró: Ejecución %d (%d ms) es más rápida que Ejecución %d (%d ms).\n",
                            (i + 1), (j + 1), tiemposEjecucion[i][j], j, tiemposEjecucion[i][j - 1]);
                    mejoraEncontrada = true;
                }
            }
        }

        if (!mejoraEncontrada) {
            System.out.println("Ninguna función mejoró su rendimiento en una ejecución respecto a la inmediatamente anterior.");
        }
    }

//    /*
//    Una matriz contiene los tiempos de ejecución (en milisegundos) de diferentes funciones de un programa, medidos durante varias ejecuciones.
//
//    a) Declara y muestra una matriz de enteros de 5 funciones por 4 ejecuciones. Inicialízala por código con valores aleatorios de hasta 3 cifras (entre 0 y 999).
//    b) Muestra el tiempo medio de cada función (fila).
//    c) Muestra qué ejecución (columna) ha sido globalmente más rápida (indica la columna y el tiempo medio de ejecución).
//    d) Muestra qué funciones han mejorado rendimiento respecto a la ejecución anterior.
//     */
//
//    public static void EjercicioM3() {
//        final int FILAS = 5;
//        final int COLUMNAS = 4;
//        int[][] tiemposEjecucion = new int[FILAS][COLUMNAS];
//        float[] sumatoriaTiemposFilas = new float[FILAS];
//        float[] sumatoriaTiemposColumnas = new float[COLUMNAS];
//        float sumaTotalTiempos = 0;
//
//        for (int i = 0; i < FILAS; i++) {
//            System.out.print("Los números de la fila " + (i + 1) + " son: ");
//            for (int j= 0; j < COLUMNAS; j++) {
//                tiemposEjecucion[i][j] = (int) (Math.random() * 1000);
//                sumatoriaTiemposFilas[i] += tiemposEjecucion[i][j];
//                sumatoriaTiemposColumnas[j] += tiemposEjecucion[i][j];
//                sumaTotalTiempos += tiemposEjecucion[i][j];
//                System.out.print(tiemposEjecucion[i][j] + " ");
//            }
//            System.out.println();
//
//        }
//        int columnaMasRapida = 0;
//        float columnaComparador = sumatoriaTiemposColumnas[0];
//        System.out.println();
//        float[] promedioTiemposFilas = new float[FILAS];
//        for (int i = 0; i < FILAS; i++) {
//            promedioTiemposFilas[i] = sumatoriaTiemposFilas[i] / FILAS;
//            System.out.println("El tiempo medio de cada función de la fila " + (i +1) + " es: " + (promedioTiemposFilas[i]));
//        }
//
//        System.out.println("\nSumatoria columnas: ");
//        for (float numero: sumatoriaTiemposColumnas) {
//            System.out.println(numero);
//        }
//        for (int i = 1; i < COLUMNAS; i++) {
//            if (sumatoriaTiemposColumnas[i] < columnaComparador) {
//                columnaMasRapida = i;
//            }
//        }
//        System.out.println("La columna más rápida es la: " + columnaMasRapida);
//        System.out.println("El tiempo medio de ejecución es: " + (sumaTotalTiempos / (COLUMNAS * FILAS)));
//
//    }

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
            for (int j = 0; j < COLUMNAS; j++) {
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


        System.out.println("Las palabras son: \n" + Arrays.deepToString(conjuntoPalabras).replace("[", "").replace("]", "") + "\n");
        System.out.println("Las palabras reemplazadas con asterisco son: \n" + Arrays.deepToString(conjuntoModificadoAsterisco).replace("[", "").replace("]", "") + "\n");
        System.out.println("Las palabras reemplazadas con guión son: \n" + Arrays.deepToString(conjuntoModificadoGuion).replace("[", "").replace("]", "") + "\n");
        System.out.print("Las palabras separadas por frase son: ");
        for (int i = 0; i < conjuntoPalabras.length; i++) {
            System.out.println();
            for (int j = 0; j < conjuntoPalabras[i].length; j++) {
                System.out.print(conjuntoPalabras[i][j]);
                if (j < conjuntoPalabras[i].length - 1) {
                    System.out.print(" ");
                }

            }
            System.out.print(".");
        }

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

                mediaColumnas[i] = (float) sumaColumnas[i] / COLUMNAS;

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
