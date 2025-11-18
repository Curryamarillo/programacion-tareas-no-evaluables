package UD05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Parte2EstructurasDeDatosDinamicas {

    /*
    Crea un programa que pida 5 nombres de pruebas por teclado,
    genere tiempos de ejecución aleatorios (100–1000 ms) para cada prueba
    y los guarde en un hashmap para la prueba (string) y el tiempo de ejecución (integer).
    Muestra el contenido del hashmap. Después, muestra cuál fue la prueba más rápida y la más lenta.
     */
    public static void hashmapPractica() {
        Scanner scanner = new Scanner(System.in);
        final int max = 1000;
        final int min = 100;

        Integer numeroRandom = (int) ((Math.random())* 1001);
        System.out.println(numeroRandom);

    }


}
