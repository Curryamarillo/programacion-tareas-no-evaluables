package UD06;

import java.util.Scanner;

public class FuncionesEjercicioF4 {

	/*
	 *  a) Escribe una función que muestre un menú con las opciones: sumar, restar, multiplicar, dividir y terminar el programa.
		b) Escribe una función que devuelva la suma de dos números recibidos por parámetros.
		c) Escribe una función que devuelva la resta de dos números recibidos por parámetros.
		d) Escribe una función que devuelva la multiplicación de dos números recibidos por parámetros.
		e) Escribe una función que devuelva la división de dos números recibidos por parámetros (teniendo en cuenta la división por cero).
		f) Escribe un programa que pida dos números, muestre el menú y permita elegir una opción. 
		Lo hará hasta que el usuario seleccione la opción de salir del programa.
	 */
	public static void calculadora() {
		int opcion = 0;
		double numeroUno, numeroDos;
		boolean salir = false;
		
		Scanner entrada = new Scanner(System.in);
		do {
			eMenu();
			opcion = entrada.nextInt();
			entrada.nextLine();
			if (opcion >= 1 && opcion <= 4) {
				System.out.print("\nIngrese el primer número: ");
				numeroUno = entrada.nextDouble();
				System.out.print("Ingrese el segundo número: ");
				numeroDos = entrada.nextDouble();
				switch(opcion) {
				case 1:
					System.out.printf("Resultado de la suma: %.2f\n", suma(numeroUno, numeroDos));
					break;
				case 2:
					System.out.printf("Resultado de la resta: %.2f\n", resta(numeroUno, numeroDos));
					break;
				case 3:
					System.out.printf("Resultado de la multiplicación: %.2f\n", multiplicacion(numeroUno, numeroDos));
					break;
				case 4:
					if (numeroDos == 0) System.out.println("La división por cero no está permitida!");
					else System.out.printf("El resultado de la división es: %.2f", division(numeroUno, numeroDos));
					break;
				} 
	} else if (opcion == 5) {
		salir = true;
	} else {
		System.out.println("Opción incorrecta!");
	}
		} while (!salir);
		System.out.print("Fuera del programa, hasta la próxima!");
	}

	private static double suma(double primerTermino, double segundoTermino) {
		return primerTermino + segundoTermino;
	}
	private static double resta(double primerTermino, double segundoTermino) {
		return primerTermino - segundoTermino;
	}
	private static double multiplicacion(double primerTermino, double segundoTermino) {
		return primerTermino * segundoTermino;
	}
	private static double division(double primerTermino, double segundoTermino) {
		return primerTermino / segundoTermino;
	}

	private static void eMenu() {
		System.out.println("--- Calculadora CLI ---");
		System.out.println("Opciones:");
		System.out.println("1- Sumar");
		System.out.println("2- Restar");
		System.out.println("3- Multiplicar");
		System.out.println("4- Dividir");
		System.out.println("5- Terminar el programa");
		System.out.print("\nOpcion?: ");
	}
}

