package UD05;

import java.util.*;

public class Parte2EstructurasDeDatosDinamicas_ArrayList {

    /*

     */

    /*
    Se está celebrando un torneo de ajedrez y se registran los resultados de las partidas entre participantes.
    Cada resultado indica el nombre del ganador y del perdedor.
    a) Introduce en un listado los resultados de las partidas. Cada posición del listado indica una partida,
    y tiene que haber dos valores (ganador, perdedor).
    Usa un vector para almacenar los dos valores en cada posición del listado.
    b) Muestra la lista de jugadores únicos que han participado (sin repetir).
    c) Muestra el número total de victorias para cada jugador.
     */
    public static void EjercicioL5() {
        final int PARTIDA = 1;
        final int JUGADORES = 2;
        ArrayList<String[][]> resultados = new ArrayList<>();
        ArrayList<String> ganadores = new ArrayList<>();
        HashMap<String, Integer> jugadorGanados = new HashMap<>();
        ArrayList<String> sinRepe = new ArrayList<>();

        String ganador = "", perdedor = "";
        System.out.print("\n=== Torneo Ajedrez ===");
        boolean salir = false;
        String opcion;
        int i;
        Scanner entrada = new Scanner(System.in);
        do {
            String[][] resultado = new String[PARTIDA][JUGADORES];
            System.out.print("\nRegistrar partida");
            System.out.print("\nIngrese el ganador: ");
            ganador = entrada.nextLine();
            ;
            System.out.print("Ingrese el perdedor: ");
            perdedor = entrada.nextLine();
            resultado[0][0] = ganador;
            resultado[0][1] = perdedor;
            ganadores.add(ganador);
            resultados.add(resultado);
            System.out.println("Para salir pulse S");
            opcion = entrada.nextLine();
            if (opcion.equals("s") || opcion.equals("S")) {
                salir = true;
            }
        } while (!salir);

        for (i = 0; i < resultados.size(); i++) {
            String[][] resultado;
            resultado = resultados.get(i);
            System.out.printf("Ganador: %s, ", resultado[0][0]);
            System.out.printf("Perdedor: %s\n", resultado[0][1]);
            if (!sinRepe.contains(resultado[0][1])) {
                sinRepe.add(resultado[0][1]);
            }
            if (!sinRepe.contains(resultado[0][0])) {
                sinRepe.add(resultado[0][0]);
            }
        }
        System.out.print("\nHan participado: ");
//        for (String jugador : sinRepe) {
//            System.out.print(jugador + " ");
//        }
        for (i = 0; i < sinRepe.size(); i++) {
            System.out.print(sinRepe.get(i));
            if (i < sinRepe.size() -1) {
                System.out.print(", ");
            }
        }
        System.out.print(".\n");
        for (String gan : ganadores) {
            jugadorGanados.put(gan, jugadorGanados.getOrDefault(gan, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : jugadorGanados.entrySet()) {
            System.out.printf("\nJugador: %s --> %s triunfos.", entry.getKey(), entry.getValue());
        }


    }

    /*
    Se ha recogido el tiempo (en segundos) que cada usuario ha tardado al responder una encuesta. Se quiere detectar patrones y casos sospechosos.
    a) Genera un listado de tiempo para cada usuario con números aleatorios entre 1 y 100. Muestra los tiempos y la media.
    b) Muestra qué usuarios (indicando las posiciones) han respondido en menos de 10 segundos (posibles bots). Por ejemplo:
    c) Muestra el porcentaje de usuarios que han tardado entre 20 y 60 segundos.
     */
    public static void EjercicioL4() {
        final int NUM_USUARIOS = 20;
        final int SEG_UMBRAL = 10;
        final int MIN_PORC = 20;
        final int MAX_PORC = 60;
        ArrayList<Integer> tiempos = new ArrayList<>(NUM_USUARIOS);
        int i;
        int sumatoriaTiempos = 0;
        int sumatoriaMinMax = 0;
        double porcentaje = 0.0d;
        for (i = 0; i < NUM_USUARIOS; i++) {
            int tPregunta = (int) (1 + (Math.random() * 100));
            tiempos.add(tPregunta);
            sumatoriaTiempos += tPregunta;
        }
        System.out.print("\nTiempos de los usuarios: ");
        for (i = 0; i < NUM_USUARIOS; i++) {
            System.out.print(tiempos.get(i));
            if (i < NUM_USUARIOS - 1) {
                System.out.print(", ");
            }
        }
        double media = (double) sumatoriaTiempos / NUM_USUARIOS;
        System.out.printf("\nMedia: %s\n\n", media);
        System.out.print("Usuarios sospechosos: ");
        for (i = 0; i < NUM_USUARIOS; i++) {
            if (tiempos.get(i) < SEG_UMBRAL) {
                System.out.printf("\nUsuario %s con marca %s!!!!", i, tiempos.get(i));
            }
            if (tiempos.get(i) > MIN_PORC && tiempos.get(i) < MAX_PORC) {
                sumatoriaMinMax++;
            }
        }
        porcentaje = (double) (sumatoriaMinMax * 100) / NUM_USUARIOS;
        System.out.printf("\nEl porcentaje de usuarios entre %s y %s segundos es de: %s%%", MIN_PORC, MAX_PORC, porcentaje);

    }

    /*
    Se han recogido las temperaturas máximas de cada día durante un mes y se quieren analizar.
    a) Almacena 30 valores en una lista (números aleatorios entre 15 y 35, por ejemplo). Muestra el listado de los días junto con su temperatura.
    b) Muestra la media mensual y también los días con temperatura superior a la media.
    c) Muestra la longitud de la secuencia más larga de días seguidos con temperaturas superiores a 30 °C.
     */
    public static void EjercicioL3() {
        final int NUM_DIAS = 30;
        final int UMBRAL_RITMO_CALOR = 30;
        ArrayList<Integer> temperaturas = new ArrayList<>(NUM_DIAS);
        ArrayList<Integer> temperaturasMayMedia = new ArrayList<>();
        System.out.print("=== Clima ===");

        int sumaTemp = 0;
        double mediaTemp;
        int i;
        int rachaMax = 0;
        int rachaAct = 0;

        for (i = 0; i <= NUM_DIAS; i++) {
            int tempDia = (int) (15 + (Math.random() * 21));
            temperaturas.add(tempDia);
        }
        System.out.println("\nLos días y sus temperaturas son: ");
        for (i = 0; i <= NUM_DIAS; i++) {
            System.out.printf("Día %s: %s\n", i + 1, temperaturas.get(i));
            sumaTemp += temperaturas.get(i);
        }
        mediaTemp = (double) sumaTemp / NUM_DIAS + 1;
        System.out.printf("\nLa media de temperaturas es: %.2f ºC\n", mediaTemp);
        System.out.println("\nLos días que superaron la media fueron: ");
        for (i = 0; i <= NUM_DIAS; i++) {
            if (temperaturas.get(i) > mediaTemp) {
                System.out.printf("Día %s: %s\n", i + 1, temperaturas.get(i));
                temperaturasMayMedia.add(i);
            }
        }
        System.out.print("\nDias mas calor que la media: ");
        for (int ind : temperaturasMayMedia) {
            System.out.print((ind + 1) + " ");
        }
        for (int temp : temperaturas) {
            if (temp > UMBRAL_RITMO_CALOR) {
                rachaAct++;
            } else {
                if (rachaAct > rachaMax) {
                    rachaMax = rachaAct;
                }
                rachaAct = 0;
            }


        }
        if (rachaAct > rachaMax) {
            rachaMax = rachaAct;
        }
        System.out.printf("\nLa racha de dias de más de %sºC es de %s días. ", UMBRAL_RITMO_CALOR, rachaMax);

    }

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
        String alumno = "";
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
