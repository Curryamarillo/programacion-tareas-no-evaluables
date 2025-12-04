package UD06;

import java.util.Locale;
import java.util.Scanner;

public class FuncionesEjercicioF2 {
    /*
    a) Escribe una función que devuelva cuántas vocales contiene una cadena de texto.
    b) Escribe una función que devuelva cuántos espacios contiene una cadena de texto.
    c) Escribe una función que devuelva cuántas consonantes contiene una cadena de texto.
    d) Escribe un programa que lea una frase por teclado y muestre el número de vocales,
    el número de espacios y el número de consonantes.
     */

    public static void lectorDeFrases() {
        Scanner entrada = new Scanner(System.in);
        String frase;
        int numVocales, numEspacios, numConsonantes;
        System.out.print("Ingrese una frase: ");
        frase = entrada.nextLine();
        numVocales = contadorVocales(frase);
        numEspacios = contadorEspacios(frase);
        numConsonantes = frase.length() - numVocales - numEspacios;
        System.out.println("Cantidad de:");
        System.out.printf("Vocales: %s\n", numVocales );
        System.out.printf("Espacios: %s\n", numEspacios );
        System.out.printf("Consonantes: %s\n", numConsonantes );
    }
    private static int contadorVocales(String cadenaTexto) {
        if (cadenaTexto.isEmpty()) {
            return 0;
        }
        String cadenaMinuscula = cadenaTexto.toLowerCase();
        String temp = cadenaMinuscula.replaceAll("[^aeiouàèìòù0-9.]", "");
        return temp.length();
    }
    private static int contadorEspacios(String cadenaTexto) {
        int longitudInicial = cadenaTexto.length();
        String cadenaSinEspacios = cadenaTexto.replaceAll("^\\S", "");
        return  longitudInicial - cadenaSinEspacios.length();
    }

}
