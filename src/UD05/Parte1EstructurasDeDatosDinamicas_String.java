package UD05;

import java.util.Scanner;

public class Parte1EstructurasDeDatosDinamicas_String {

    /*
    Una aplicación web quiere validar contraseñas según ciertas normas antes de registrarlas. Un valor numérico indicará la fiabilidad de la contraseña:

    Un valor de 0 indica contraseña muy segura.
    Por cada comprobación que no supere, aumentará en 1.
    La seguridad de los distintos niveles es:
    Nivel 0: Muy segura.
    Nivel 1: Segura.
    Nivel 2 ó 3: Muy insegura.
    a) Pide al usuario una contraseña. Indica si la longitud es superior o inferior a 8 caracteres.
    b) Indica si contiene, al menos, una mayúscula.
    c) Indica si contiene, al menos, un dígito.
    d) Indica el nivel de seguridad, mostrando el mensaje correspondiente según las comprobaciones superadas.
 */
    public static void EjercicioS1() {

        String contrasenia = "";
        int nivel = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Esta aplicación valora las contraseñas siendo: ");
        System.out.println("Nivel 0: Muy segura");
        System.out.println("Nivel 1: Segura");
        System.out.println("Nivel 2 o 3: Muy insegura");
        System.out.println("Ingrese la contraseña a validar:");
        contrasenia = scanner.nextLine();
        boolean contieneMayuscula = false;
        boolean contieneDigito = false;

        char[] cadenaContrasenia = contrasenia.toCharArray();

        if (contrasenia.length() < 8) {
            System.out.println("La contraseña tiene menos de 8 caracteres...");
            nivel += 1;
        }
        for (int i = 0; i < cadenaContrasenia.length; i++) {
            if (Character.isUpperCase(contrasenia.charAt(i))) {
                contieneMayuscula = true;
            }
            if (Character.isDigit(contrasenia.charAt(i))) {
                contieneDigito = true;
            }
        }
        if (!contieneMayuscula) {
            System.out.println("No contiene mayúsculas, mal vamos...");
            nivel++;
        }
        if (!contieneDigito) {
            System.out.println("No contiene dígito, que desastre de contraseña!");
            nivel++;
        }
    System.out.println("El nivel de seguridad es: " + nivel);
        switch (nivel) {
            case 0:
                System.out.println("Excelente contraseña!");
                break;
            case 1:
                System.out.println("Contraseña segura pero mejorable.");
                break;
            default:
                System.out.println("Contraseña más insegura que las Ramblas de Barcelona!");
        }
    }


}
