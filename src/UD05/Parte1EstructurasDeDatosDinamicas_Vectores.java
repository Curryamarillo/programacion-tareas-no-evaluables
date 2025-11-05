package UD05;

import java.util.Arrays;
import java.util.Scanner;

public class Parte1EstructurasDeDatosDinamicas_Vectores {


    /*
    Algoritmos. Vectores
    */
    /*
    Un sistema tiene que controlar un conjunto de usuarios que se autentican con nombre y contraseña. Solo hay que almacenar y comprobar estos datos, sin cifrar.

    a) Declara e inicializa dos vectores paralelos con 5 nombres de usuario y sus contraseñas. Genera las contraseñas como un conjunto aleatorio de enteros con 4 cifras entre 1000 y 9999.
    b) Permite iniciar sesión: pide nombre y contraseña, y valida si coinciden. Muestra un mensaje informando del resultado.
    c) Mientras la sesión no se inicie correctamente, el programa pedirá usuario y contraseña constantemente, hasta que se introduzca "fin" como nombre.
    d) Si has iniciado correctamente la sesión, muestra un menú con dos opciones: una para cerrar sesión y otra que permite cambiar la contraseña actual.
     */
    public static void ejercicio5() {
        String[] nombresUsuarios = {"Juan", "Pepe", "Paco", "Ximo", "Tico"};
        int[] contrasenias = {1234, 2345, 3456, 4567, 5678};
        Scanner scanner = new Scanner(System.in);
        String nombre = "";
        int contrasenia = 0;
        int posicion = 0;
        boolean usuarioLogueado = false;

        do {
            System.out.println("Ingrese su nombre: ");
            nombre = scanner.nextLine();
            System.out.println("Ingrese su contraseña: ");
            contrasenia = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < nombresUsuarios.length; i++) {
                if (nombre.equals(nombresUsuarios[i])) {
                    posicion = i;
                    if (contrasenia == contrasenias[i]) {
                        usuarioLogueado = true;
                    }
                }
            }

        } while (!usuarioLogueado || nombre.equalsIgnoreCase("fin"));
        if (usuarioLogueado) {
            boolean cerrarSesion = false;
            System.out.println("Usuario logueado!!");
            System.out.println("Sesión activa.");
            System.out.println("--------------------------------");
            do {
                System.out.println("Si desea cerrar la sesión ingrese 1.");
                System.out.println("Si desea cambiar la contraseña ingrese 2.");
                int respuestaMenu = scanner.nextInt();
                if (respuestaMenu == 2) {
                    System.out.println("Ingrese la nueva contraseña(4 números enteros): ");
                    int nuevaContrasenia = scanner.nextInt();
                    contrasenias[posicion] = nuevaContrasenia;
                    System.out.println("La nueva contraseña es: " + contrasenias[posicion]);
                } else if (respuestaMenu == 1) {
                    cerrarSesion = true;
                }

            } while (!cerrarSesion);
        }
        System.out.println("Fin de la aplicación");
        scanner.close();
    }

    /*
    Se está analizando un cuestionario con 10 preguntas, cada una con 4 posibles soluciones (1, 2, 3 ó 4), realizado por varios estudiantes.

    a) Declara un vector donde se almacenan las respuestas correctas del test. Usa números enteros aleatorios entre 1 y 4.
    b) Almacena las respuestas de un estudiante en otro vector. Respuesta 0 se considerará como no contestada.
    c) Muestra cuántas preguntas ha contestado correctamente, cuántas ha contestado incorrectamente y cuántas no ha contestado.
    d) Calcula y muestra la nota obtenida. Si la nota sale negativa, será 0. Usa la siguiente ecuación:

    nota = (n_correctas - 0.33 * n_incorrectas) / n_total
     */
    public static void ejercicio4() {
        int[] respuestasCorrectas = {1, 2, 4, 2, 4, 3, 2, 1, 3, 2};
        int[] respuestasEstudianteUno = {0, -3, -2, 1, -4, -3, 1, -4, 0, -1};
        int sumaCorrectas = 0;
        int sumaIncorrectas = 0;
        int sumaNoContestadas = 0;

        for (int i = 0; i < respuestasCorrectas.length; i++) {
            if (respuestasCorrectas[i] == respuestasEstudianteUno[i]) {
                sumaCorrectas += 1;
            }
            if ((respuestasCorrectas[i] != respuestasEstudianteUno[i]) && (respuestasEstudianteUno[i] != 0)) {
                sumaIncorrectas += 1;
            }
            if (respuestasEstudianteUno[i] == 0) {
                sumaNoContestadas += 1;
            }
        }
        double nota = sumaCorrectas - (0.33 * sumaIncorrectas) / 10;
        System.out.println("La suma de ejercicios correctos es: " + sumaCorrectas);
        System.out.println("La suma de ejercicios incorrectos es: " + sumaIncorrectas);
        System.out.println("La suma de ejercicios no contestados es: " + sumaNoContestadas);
        if (nota <= 0) {
            System.out.println("La nota es CERO PATATERO");
        } else {
            System.out.println("La nota es: " + nota);
        }
    }

    /*
    a) Introduce en un vector 10 palabras dadas por el usuario. Muéstralas.
    b) Indica si hay palabras repetidas. Muéstralas.
     */
    public static void ejercicio3() {
        Scanner scanner = new Scanner(System.in);
        String[] vectorPalabras = new String[10];
        String palabraAComparar = "";
        for (int i = 0; i < vectorPalabras.length; i++) {
            System.out.println("Ingrese una palabra hasta completar el vector, esta es la " + (i + 1) + " palabra: ");
            vectorPalabras[i] = scanner.nextLine();
        }
        for (int i = 0; i < vectorPalabras.length; i++) {
            palabraAComparar = vectorPalabras[i];
            for (int j = i + 1; j < vectorPalabras.length; j++) {
                if (palabraAComparar.equalsIgnoreCase(vectorPalabras[j])) {
                    System.out.println("Palabra repetida: " + palabraAComparar);
                }
            }
        }
        System.out.println("El vector tiene las siguientes palabras: " + Arrays.toString(vectorPalabras).replace("[", "").replace("]", ""));
    }

    /*
    a) Declara y llena un vector con N palabras, donde N es un número introducido por teclado y las palabras son cadenas también introducidas por teclado.
    b) Muestra aquellas palabras que empiezan por vocal.
    c) Muestra cuál es la palabra más larga, e indica el tamaño.
     */
    public static void ejercicio2() {

        Scanner scanner = new Scanner(System.in);
        int tamanoVector = 0;
        System.out.println("Ingrese el tamaño del vector: ");
        tamanoVector = scanner.nextInt();
        scanner.nextLine();
        String[] vectorPalabras = new String[tamanoVector];
        int[] vectorContador = new int[tamanoVector];
        int posicionPalabraMasLarga = 0;

        for (int i = 0; i < vectorPalabras.length; i++) {
            System.out.println("Ingrese una palabra para guardar en el vector: ");
            vectorPalabras[i] = scanner.nextLine();
            vectorContador[i] = vectorPalabras[i].length();
            char primeraLetra = vectorPalabras[i].toLowerCase().charAt(0);
            switch (primeraLetra) {
                case 'a':
                    System.out.println("Empieza con vocal, la 'a'");
                    break;
                case 'e':
                    System.out.println("Empieza con vocal, la 'e'");
                    break;
                case 'i':
                    System.out.println("Empieza con vocal, la 'i'");
                    break;
                case 'o':
                    System.out.println("Empieza con vocal, la 'o'");
                    break;
                case 'u':
                    System.out.println("Empieza con vocal, la 'u'");
                    break;
            }
        }
        for (int i = 0; i < vectorPalabras.length; i++) {
            vectorContador[i] = vectorPalabras[i].length();
            if (vectorContador[i] > posicionPalabraMasLarga) {
                posicionPalabraMasLarga = i;
            }
        }

        System.out.println("El vector contiene las siguientes palabras: " + Arrays.toString(vectorPalabras).replace("[", "").replace("]", ""));
        System.out.println("La palabra más larga está en la posición: " + posicionPalabraMasLarga + " y es: " + vectorPalabras[posicionPalabraMasLarga]);
        System.out.println(posicionPalabraMasLarga);
        scanner.close();

    }


    /*
    Ejercicio V1
    a) Declara e inicializa un vector de 8 enteros. Muestra el contenido del vector por pantalla.
    b) Muestra cuántos valores son positivos y cuántos negativos.
    c) Muestra la suma y la media de los valores del vector.
    d) Indica cuál es el valor máximo y en qué posición se encuentra.
    */
    public static void ejercicio1() {
        int[] vector = {5, -10, 15, -20, 25, -30, 35, -40};
        System.out.println(Arrays.toString(vector));

        int i;
        int valoresPositivos = 0;
        int valoresNegativos = 0;
        int valorAux = 0;

        for (i = 0; i < vector.length; i++) {
            if (vector[i] > 0) {
                valoresPositivos++;
            }
            if (vector[i] < 0) {
                valoresNegativos++;
            }
        }
        System.out.println("Los valores positivos son: " + valoresPositivos);
        System.out.println("Los valores negativos son: " + valoresNegativos);

        for (int valor : vector) {
            if (valor > valorAux) {
                valorAux = valor;
            }
        }
        for (int k = 0; k < vector.length; k++) {
            if (vector[k] == valorAux) {
                System.out.println("El valor más alto está en la posición: " + k);
            }
        }

        System.out.println("Valor máximo: " + valorAux);
    }
}
