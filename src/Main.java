import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    /// ejercicio1();
    /// ejercicio2();
    /// ejercicio3();
        ejercicio4();
    }

    /*
    Un grupo de amigos ha hecho un torneo y quiere registrar las puntuaciones.
    a) El programa pide el nombre y puntuación de 4 jugadores y muestra quién ha conseguido la puntuación más alta.
    b) Muestra la media de las puntuaciones.
    c) Si hay alguna puntuación inferior a 5, muestra "Hay que mejorar" para esos jugadores.
     */
    private static void ejercicio4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del jugador 1: ");
        String nombreJugador1 = scanner.nextLine();
        System.out.println("Ingrese su puntuación " + nombreJugador1 + ": ");
        int puntuacionJugador1 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la puntuación del jugador 2: ");
        int puntuacionJugador2 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la puntuación del jugador 3: ");
        int puntuacionJugador3 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la puntuación del jugador 4: ");
        int puntuacionJugador4 = scanner.nextInt();
        scanner.nextLine();
        String elMejorJugador = "";
        if (puntuacionJugador1 > puntuacionJugador2 && puntuacionJugador1 > puntuacionJugador3 && puntuacionJugador1 > puntuacionJugador4) {
            elMejorJugador = "jugador 1";
        } else if (puntuacionJugador2 > puntuacionJugador1 && puntuacionJugador2 > puntuacionJugador3 && puntuacionJugador2 > puntuacionJugador4) {
            elMejorJugador = "jugador 2";
        } else if (puntuacionJugador3 > puntuacionJugador1 && puntuacionJugador3 > puntuacionJugador2 && puntuacionJugador3 > puntuacionJugador4) {
            elMejorJugador = "jugador 3";
        } else {
            elMejorJugador = "jugador 4";
        }
        double mediaPuntos = (double) (puntuacionJugador1 + puntuacionJugador2 + puntuacionJugador3 + puntuacionJugador4) / 4;
        System.out.println("El mejor es el: " + elMejorJugador);
        System.out.println("La media de puntos es: " + mediaPuntos);
        if (puntuacionJugador1 < 5) {
            System.out.println("Jugador 1, hay que mejorar esta puntuación miserable de: " + puntuacionJugador1);
        } else if (puntuacionJugador2 < 5) {
            System.out.println("Jugador 2, hay que mejorar esta puntuación miserable de: " + puntuacionJugador1);
        } else if (puntuacionJugador3 < 5) {
            System.out.println("Jugador 3, hay que mejorar esta puntuación miserable de: " + puntuacionJugador1);
        } else if (puntuacionJugador4 < 5) {
            System.out.println("Jugador 4, hay que mejorar esta puntuación miserable de: " + puntuacionJugador1);
        }

    }

    /*
    a) Escribe un programa que calcule y muestre el factorial de un número N, introducido por teclado.
    b) Permite que se vuelva a pedir el valor de N hasta que sea un número positivo.
    c) Añade una funcionalidad que muestre la secuencia de multiplicaciones realizadas.
     */
    private static void ejercicio3() {
        System.out.println("Ingrese un número, para enseñar el factorial:");
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();
        int sumatoria = 1;
        while (numero <= 0){
            System.out.println("Ingrese un valor entero positivo: ");
            scanner.nextLine();
            numero = scanner.nextInt();
        }
        System.out.print("Los números a multiplicar son: ");
        for (int i = 1; i <= numero; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= numero; i++ ) {
            sumatoria = sumatoria * i;
            System.out.println("Multiplicación parcial: " + sumatoria);
        }
        System.out.println("Sumatoria total:" + sumatoria);
    }

    /*
    a) Crea un programa que vaya pidiendo números hasta que se lea un 0.
    b) Añade una variable que contabilice cuántos números se han leído.
    c) Muestra cuántos de ellos han sido positivos.
    d) Muestra la media de todos los números leídos (sin contar el 0 final).
     */
    private static void ejercicio2() {
        System.out.println("Ingrese un número, se leerá hasta que sea igual a 0 (cero):");
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();
        int contador = 1;
        int sumatoria = 0;

        if (numero == 0) {
            System.out.println("El primer número que ha ingresado es el 0");
            System.out.println("Ha ingresado: " + contador + " números.");
        } else {
            do {
                System.out.println("Su número es: " + numero);
                scanner.nextLine();
                contador += 1;
                sumatoria += numero;
                System.out.println("Ingrese otro número:");
                numero = scanner.nextInt();
            } while (numero != 0); {
                System.out.println("Su numero es 0. Fin.");
                System.out.println("Ha ingresado: " + contador + " números.");
                double media = (double) sumatoria / (contador - 1);
                System.out.println("La media es: " + media );
            }
        }
    }

    /*
    a) Escribe un programa que, dado un número N introducido por teclado, muestre por pantalla todos los números del 1 hasta N.
    b) Modifícalo para que solo muestre los números pares.
    c) Modifícalo para que no muestre ni el 16 ni los múltiplos de 3.
     */
    private static void ejercicio1() {

        System.out.println("Ingrese un número por teclado:");
        Scanner scanner = new Scanner(System.in);

        int numero = scanner.nextInt();
        scanner.close();
        for (int i = 1; i <= numero; i++) {
            if (i % 2 == 0) {
                if (i != 16)
                    if (i % 3 != 0) System.out.println(i);
            }

        }

    }
}
