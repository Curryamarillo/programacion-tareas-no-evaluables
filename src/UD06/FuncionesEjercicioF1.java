package UD06;

public class FuncionesEjercicioF1 {

        /*
        a) Escribe una función que devuelva la suma de los valores de un vector de enteros.
        b) Escribe una función que devuelva la media de los valores de un vector de enteros.
        c) Escribe una función que devuelva el valor máximo de un vector de enteros.
        d) Escribe un programa que cree un vector con N valores enteros (generados de forma aleatoria)
        y muestre la suma, la media y el máximo.
         */
    public static void creaSumaMediaMaxVector() {
        int[] vector = creaVector();
        int suma = suma(vector);
        double media = media(vector);
        int valorMax = valorMax(vector);

        System.out.printf("La suma del vector es: %s\n", suma);
        System.out.printf("La media del vector es: %.2f\n", media);
        System.out.printf("El valor máximo del vector es: %s\n", valorMax);
    }
    private static int suma(int[] a) {
        int resultado = 0;
        for (int i : a) {
            resultado += i;
        }
        return resultado;
    }
    private static double media(int[] a) {
        int resultado = 0;
        int tamanyo = a.length;
        for (int i : a) {
            resultado += i;
        }
        return (double) resultado / tamanyo;
    }
    private static int valorMax(int[] a) {
        int valorMax = 0;
        for (int j : a) {
            if (j > valorMax) valorMax = j;
        }
        return valorMax;
    }
    private static int[] creaVector() {
        int tamanyoVector = (int) (Math.random() * 100);
        int[] vector = new int[tamanyoVector];
        for (int i = 0; i < tamanyoVector; i++) {
            int numeroRandom = (int) (Math.random() * 101);
            vector[i] = numeroRandom;
        }
        return vector;
    }

}
