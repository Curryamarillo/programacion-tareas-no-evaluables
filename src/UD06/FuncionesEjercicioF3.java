package UD06;

import java.util.Scanner;

public class FuncionesEjercicioF3 {
	
	/*
	    a) Escribe una función que recibirá una cadena y devolverá la contraria (invertida).
		b) Escribe una función que recibirá dos cadenas y devolverá true o false en función de si son iguales o no.
		c) Escribe un programa que pida por teclado una palabra y muestre si es palíndroma (capicúa) usando las funciones anteriores.
	 */

	
	
	public static void ejercicioF3() {
		
		Scanner entrada = new Scanner(System.in);
		String cadena1, cadena2;
		boolean esPalindromo = false;
		System.out.print("Ingrese la primera cadena: ");
		cadena1 = entrada.nextLine();
		System.out.print("Ingrese la segunda cadena: ");
		cadena2 = entrada.nextLine();
		System.out.printf("La cadena uno a la inversa es: %s", invertidorCadena(cadena1));
		System.out.printf("\nLa cadena dos a la inversa es: %s", invertidorCadena(cadena2));
		esPalindromo = comparadorCadenas(cadena1, cadena2);
		if (esPalindromo) System.out.printf("\nEs palíndromo: %s", cadena1);
		else System.out.println("\nNo es palíndromo");
	}
	
	public static String invertidorCadena(String cadena) {
		StringBuilder cadenaSB = new StringBuilder(cadena);
		return cadenaSB.reverse().toString();
	}
	public static boolean comparadorCadenas(String cadenaUno, String cadenaDos) {
		StringBuilder cadenaDosInvertida = new StringBuilder(cadenaDos);
		return cadenaUno.contentEquals(cadenaDosInvertida.toString());
		
	}
	
	
}
