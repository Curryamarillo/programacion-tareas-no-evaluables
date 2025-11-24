package UD05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Parte2EstructurasDeDatosDinamicas_ArrayList {

    

    /*
    Gestionar una lista con nombres de alumnos.

    a) Crea una lista con nombres de alumnos. El usuario va añadiendo nombres hasta que escribe "fin". Después, muestra el número de alumnos y sus nombres en el orden original.
    b) Muestra los nombres ordenados alfabéticamente.
    c) Permite buscar un nombre e indicar si está en la lista.
    d) Modifica el programa para mostrar un menú con las siguientes opciones:

    Mostrar los alumnos ordenados alfabéticamente.
    Buscar un alumno y, si existe, indicar la posición.
    Añadir un alumno (si no se encuentra ya en el listado).
    Eliminar un alumno (si existe).
     */
    public static void EjercicioL2() {
    ArrayList<String> listaAlumnos = new ArrayList<>();
    boolean salir = false;
    boolean salirDentro = false;
    Scanner entrada = new Scanner(System.in);
    String alumno  = "";
    String opcionNA = "";
    int cantAlumnos = 0;
    int posicion = 0;
    int opciones = 0;
    System.out.println("=== Lista de alumnos ===");
    System.out.println("Ingrese 'fin' para terminar!");
        System.out.print("Ingrese el nombre del alumno: ");
    do {
        if (cantAlumnos != 0) {
            System.out.print("Otro más: ");
        }
        alumno = entrada.nextLine();
        if (alumno.equals("fin")) {
            salir = true;
        } else {
            listaAlumnos.add(alumno);
            cantAlumnos++;
        }

    } while (!salir);
    System.out.printf("\nNúmero de alumnos: %s\n", cantAlumnos);
    System.out.print("Nombres: ");
    for (String alum : listaAlumnos) {
        System.out.print(alum + " ");
    }

    do {
        System.out.print("\n\nOpciones: ");
        System.out.print("\n1. Ordenar alfabéticamente");
        System.out.print("\n2. Buscar en la lista un alumno");
        System.out.print("\n3. Eliminar un alumno");
        System.out.print("\n4. Salir\n");
        System.out.print(":");
        opciones = entrada.nextInt();
        entrada.nextLine();
        switch (opciones) {
            case 1:
                System.out.print("\n--- Ordenar ---");
                listaAlumnos.sort(String.CASE_INSENSITIVE_ORDER);
                System.out.print("\nNombres en orden: ");
                for (String alum : listaAlumnos) {
                    System.out.print(alum + " ");
                }
                break;
            case 2:
                System.out.print("\n--- Buscar --- ");
                System.out.print("\nIngrese un alumno: ");
                alumno = entrada.nextLine();
                if (listaAlumnos.contains(alumno)) {
                    posicion = listaAlumnos.indexOf(alumno);
                    System.out.printf("%s está en la lista en la posición %s", alumno, posicion);
                } else {
                    System.out.printf("\n%s no está en la lista!", alumno);
                    System.out.print("\nDesea agregarla/o??(s/N): ");
                    opcionNA = entrada.nextLine();
                    if (opcionNA.equals("s") || opcionNA.equals("S")) {
                        listaAlumnos.add(alumno);
                        System.out.printf("\n%s agregada/o con éxito", alumno);
                    }
                }
                break;
            case 3:
                System.out.print("\n--- Eliminar ---");
                System.out.print("\nNombre: ");
                alumno = entrada.nextLine();
                if (listaAlumnos.contains(alumno)) {
                    listaAlumnos.remove(alumno);
                    System.out.print("Alumno eliminado exitosamente!");
                } else {
                    System.out.printf("\n%s está en la lista: ", alumno);
                }
                break;
            case 4:
                salirDentro = true;
                break;
            default:
                System.out.println("Opción incorrecta!");
        }


    } while (!salirDentro);

    }

    /*
    Gestión de una lista de valores enteros positivos.

    a) Pide valores enteros al usuario hasta que escriba un valor negativo. Guárdalos en una lista. Muestra la lista completa.
    b) Muestra cuántos valores hay y la suma total.
    c) Muestra solo los valores pares. A continuación, muestra solo los valores impares.
    d) Permite al usuario pedir una posición (se pedirá hasta que elija una correcta) y elimina el valor del listado en esa posición.
     */
    public static void EjercicioL1() {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        ArrayList<Integer> listaPares = new ArrayList<>();
        ArrayList<Integer> listaImpares = new ArrayList<>();
        boolean finalizar = false;
        boolean posicionOk = false;
        System.out.println("=== Lista de números ===");
        System.out.println("Ingresar un valor negativo es salir del programa.");
        int valor = 0;
        int contador = 0;
        int suma = 0;
        int posicion = 0;
        System.out.print("Ingrese valores: \n");
        do {
            valor = entrada.nextInt();
            if (valor >= 0) {
                listaNumeros.add(valor);
                contador++;
                suma += valor;
                if (valor % 2 == 0) {
                    listaPares.add(valor);
                } else {
                    listaImpares.add(valor);
                }
            } else {
                System.out.print("Guardados: ");
                for (int numero : listaNumeros) {
                    System.out.print(numero + " ");
                }
                System.out.printf("\nCantidad de valores: %s", contador);
                System.out.printf("\nSuma de valores: %s\n", suma);
                Iterator<Integer> itValor = listaPares.iterator();
                Iterator<Integer> itValorIm = listaImpares.iterator();
                System.out.print("Los pares son: ");
                while (itValor.hasNext()) {
                    valor = itValor.next();
                    ;
                    System.out.print(valor + " ");
                }
                System.out.print("\nLos impares son: ");
                while (itValorIm.hasNext()) {
                    valor = itValorIm.next();
                    ;
                    System.out.print(valor + " ");
                }

                do {
                    System.out.print("\nIngrese una posición para borrar: ");
                    posicion = entrada.nextInt();
                    if (posicion >= 0 && posicion < listaNumeros.size()) {
                        listaNumeros.remove(posicion);
                        System.out.print("\nLista modificada: ");
                        for (Integer listaNumero : listaNumeros) {
                            System.out.print(listaNumero + " ");
                        }
                        posicionOk = true;
                    } else {
                        System.out.print("Incorrecta");
                    }
                } while (!posicionOk);
                finalizar = true;
            }
            entrada.close();
        } while (!finalizar);
    }
}
