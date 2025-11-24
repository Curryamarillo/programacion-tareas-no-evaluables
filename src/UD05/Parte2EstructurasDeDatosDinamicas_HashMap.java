package UD05;

import java.util.HashMap;
import java.util.Scanner;


public class Parte2EstructurasDeDatosDinamicas_HashMap {

    /*
    En una plataforma de valoración se ha preparado un test de 10 preguntas. Cada pregunta puede recibir una puntuación de 1 a 5 estrellas por parte de los usuarios.
    Queremos un programa que acumule los resultados en una estructura clave-valor anidada, y que nos permita calcular estadísticas para cada pregunta y en conjunto.
    La estructura será:
    Clave exterior: número de pregunta [1..10]
    Valor exterior: otra estructura clave-valor donde
    Clave interior: puntuación [1..5]
    Valor interior: recuento de usuarios que han dado esa puntuación
    a) Declara e inicializa la estructura con valores enteros aleatorios.
    b) Permite al usuario pedir un número de pregunta y mostrar un histograma de las puntuaciones para esa pregunta. Por ejemplo:
    c) Haz que, además del histograma, calcule la puntuación media de la pregunta. Por ejemplo, para la pregunta anterior:
    */
    public static void EjercicioH6() {
        final int CANT_PREGUNTAS = 10;
        final int MAX_PUNTUACION = 5;
        final int MIN_PUNTUACION = 1;
        HashMap<Integer, HashMap<Integer, Integer>> valoraciones = new HashMap<>(CANT_PREGUNTAS);
        int opciones = 0;
        boolean finalizar = false;
        // Random aleatorio = new Random();
        int numeroPregunta, cantUsuarios, index, indexInt, suma = 0;
        double media;
        Scanner entrada = new Scanner(System.in);


        for (index = 0; index < CANT_PREGUNTAS; index++) {
            numeroPregunta = index + 1;
            HashMap<Integer, Integer> respUsuario = new HashMap<>();
            for (indexInt = 0; indexInt < MAX_PUNTUACION; indexInt++) {
                // cantUsuarios = aleatorio.nextInt(1,21);
                cantUsuarios = 1 + (int) (Math.random() * 20);
                respUsuario.put(indexInt + MIN_PUNTUACION, cantUsuarios);
            }
            valoraciones.put(numeroPregunta, respUsuario);
        }
//  Bucle for para ver carga correcta de resultados
//    for (index = 0; index < CANT_PREGUNTAS; index++) {
//        HashMap<Integer, Integer> respuesta = new HashMap<>(1);
//        respuesta = valoraciones.get(index + 1);
//        String fIndex = String.valueOf(index + 1);
//        String fRespuestas = String.valueOf(respuesta.keySet()).replace("[", "").replace("]", "");
//        String fUsuarios = String.valueOf(respuesta.values()).replace("[", "").replace("]","");
//        System.out.printf("Pregunta: %s, puntuación: %s, usuarios: %s\n", fIndex, fRespuestas, fUsuarios);
//    }
        System.out.println("=== Encuesta ===");
        do {
            System.out.println("--- Opciones ---");
            System.out.println("1. Consultar");
            System.out.println("0. Salir");
            opciones = entrada.nextInt();
            entrada.nextLine();
            switch (opciones) {
                case 1:
                    System.out.print("\nIngrese el número de pregunta: ");
                    numeroPregunta = entrada.nextInt();
                    System.out.printf("Pregunta: %s\n", numeroPregunta);
                    for (index = 0; index < MAX_PUNTUACION; index++) {
                        System.out.printf("%s: ", index + 1);
                        for (indexInt = 0; indexInt < valoraciones.get(numeroPregunta).get(index + 1); indexInt++) {
                            System.out.print("*");
                            suma++;
                        }
                        System.out.print("\n");
                    }
                    media = (double) suma / MAX_PUNTUACION;
                    System.out.printf("Media: %.2f%n", media);
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    finalizar = true;
            }
        } while (!finalizar);

    }

    /*
    Un pequeño almacén quiere informatizar el sistema de ventas y el inventario. Cada producto se representa con un nombre, un precio unitario y una cantidad en stock. Además, se quiere llevar un registro de cuántas unidades se han vendido de cada producto.
    a) Crea una estructura clave-valor donde cada clave sea el nombre de un producto y el valor sea un vector con el precio unitario y stock. Rellena la estructura con 5 productos diferentes, introduciendo por teclado todos los valores.
    b) Permite añadir un producto más, introduciendo por teclado el nombre y el precio unitario, y con stock inicial de 100.
    c) Permite realizar ventas: pide nombre y cantidad, comprueba si hay en stock y actualiza los valores.
    d) Crea un menú que permita al usuario elegir entre añadir un producto, realizar una venta o acabar el programa.
    e) Añade una nueva opción al menú para mostrar el estado actual del stock.
     */
    public static void EjercicioH5() {
        Scanner entrada = new Scanner(System.in);
        HashMap<String, double[][]> inventario = new HashMap<>();
        double[][] precioStock = new double[1][2];
        double[][] nPrecioStock = new double[1][2];
        String nombre = "";
        String rOtroProductoMas = "";
        double precio;
        double stock;
        double venta;
        boolean salir = false;
        int opciones = 0;
        boolean cargarMas = false;
        System.out.println("=== Sistema de gestión de inventario ===");

        do {
            System.out.println("Opciones:");
            System.out.println("1. Añadir un producto");
            System.out.println("2. Ventas");
            System.out.println("3. Listar inventario");
            System.out.println("4. Salir ");
            System.out.print("Opción: ");
            opciones = entrada.nextInt();
            entrada.nextLine();
            switch (opciones) {
                case 1:
                    do {
                        System.out.println("\n--- Añadir ---");
                        System.out.print("Nombre: ");
                        nombre = entrada.nextLine();
                        if (!nombre.isEmpty()) {
                            System.out.print("Ingrese el precio(0,00): ");
                            precio = entrada.nextDouble();
                            entrada.nextLine();
                            if (precio < 0) {
                                System.out.println("El precio no puede ser negativo, debe ser un número con dos decimales");
                            } else if (precio >= 0) {
                                System.out.print("Ingrese el stock: ");
                                stock = entrada.nextDouble();
                                entrada.nextLine();
                                precioStock[0][0] = precio;
                                precioStock[0][1] = stock;
                                inventario.put(nombre, precioStock);
                                System.out.println("Producto, precio y stock ingresados OK!\n");
                                System.out.println("¿Agregamos otro producto?(S/N)?");
                                rOtroProductoMas = entrada.nextLine();
                                if (rOtroProductoMas.matches("[nN]")) {
                                    cargarMas = true;
                                }
                            }
                        }
                    } while (!cargarMas);
                    break;
                case 2:
                    System.out.println("¿Qué producto vendemos?");
                    nombre = entrada.nextLine();
                    precioStock = inventario.get(nombre);
                    if (precioStock[0][0] != 0) {
                        System.out.printf("Stock: %s\n", precioStock[0][0]);
                        System.out.printf("Precio: %s €\n", precioStock[0][1]);
                        System.out.print("¿Cuánto vendemos?: ");
                        venta = entrada.nextDouble();
                        if (venta < 0 && venta < precioStock[0][0]) {
                            System.out.println("Que no puede ser negativo ni mayor que el stock!");
                        } else {
                            nPrecioStock[0][1] = precioStock[0][1];
                            nPrecioStock[0][0] = precioStock[0][0] - venta;
                            inventario.put(nombre, nPrecioStock);
                        }
                    } else {
                        System.out.println("No stock");
                    }
                    break;
                case 3:
                    System.out.println("---- Inventario general ---");
                    System.out.println("Producto   Precio   Stock");
                    for (String producto : inventario.keySet()) {
                        double[][] preStock = inventario.get(producto);
                        String pre = String.valueOf(preStock[0][0]);
                        String sto = String.valueOf(preStock[0][1]);
                        System.out.printf("%s :  %s€   %s \n", producto, pre, sto);
                    }
                    break;
                case 4:
                    salir = true;
                    break;
            }
        } while (!salir);
        System.out.println("Fuera!");
    }


    /*
    Crea un programa que permita gestionar el inventario de una tienda.

    a) Almacena una lista de productos en una estructura clave-valor donde la clave es el nombre de un producto
    y el valor es su cantidad disponible en almacén. Añade, al menos, 5 elementos clave-valor por teclado.
    Elimina los espacios en blanco iniciales y finales del nombre del producto. Muestra todos los productos del inventario.
    b) Permite añadir un nuevo producto al inventario durante la ejecución del programa.
    c) Permite al usuario introducir un producto y que el programa muestre su stock actual. Si no está en el inventario, lo indica.
    d) Permite, dado un producto, actualizar su cantidad en stock.
    e) Modifica el programa para mostrar un menú que permitirá al usuario elegir entre añadir un nuevo producto, buscar un producto en el inventario, actualizar la cantidad de un producto, mostrar todos los productos o acabar el programa.
     */
    public static void EjercicioH4() {
        Scanner entrada = new Scanner(System.in);
        HashMap<String, Integer> inventario = new HashMap<>();
        System.out.print("=== Inventario de productos ===\n");
        String producto = "";
        int cantidad = 0;
        int nuevaCantidad = 0;
        String opcion = "";
        boolean salir = false;

        do {
            System.out.println("Opciones del programa: ");
            System.out.println("1. Añadir un producto");
            System.out.println("2. Ver el stock de un producto");
            System.out.println("3. Actualizar stock");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = entrada.nextLine();
            switch (opcion) {
                case "1":
                    System.out.print("\n=== Añadir ===\n");
                    System.out.print("Nombre del producto: ");
                    producto = entrada.nextLine().trim().toLowerCase();
                    System.out.print("Stock: ");
                    cantidad = entrada.nextInt();
                    entrada.nextLine();
                    inventario.put(producto, cantidad);
                    System.out.println("Producto añadido exitosamente!\n");
                    break;
                case "2":
                    System.out.print("\n=== Consulta stock ===\n");
                    System.out.print("Nombre del producto: ");
                    producto = entrada.nextLine();
                    if (inventario.containsKey(producto)) {
                        System.out.printf("Stock: %s\n\n", inventario.get(producto));
                    } else {
                        System.out.println("No está en el inventario!");
                    }
                    break;
                case "3":
                    System.out.print("=== Actualizar stock ===\n");
                    System.out.print("\nNombre del producto: ");
                    producto = entrada.nextLine();
                    if (inventario.containsKey(producto)) {
                        System.out.printf("Stock: %d \n", inventario.get(producto));
                        System.out.print("Actualizar stock: ");
                        nuevaCantidad = entrada.nextInt();
                        entrada.nextLine();
                        inventario.put(producto, nuevaCantidad);
                        System.out.println("Producto actualizado correctamente!\n");
                    }
                    break;
                case "4":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción ingresada incorrecta\n");

            }

        } while (!salir);

    }


    /*
    Implementa un programa para gestionar contactos telefónicos de personas.

    a) Permite añadir parejas "nombre - número de teléfono" en una estructura clave-valor. Debes quitar los espacios en blanco iniciales y/o finales del nombre. Se podrán añadir hasta que el usuario introduzca la cadena "fin" como nombre.
    b) Permite consultar el número de teléfono de un nombre dado.
    c) Permite borrar un contacto dado su nombre.
    d) Modifica el programa de forma que se muestre un menú que permita elegir entre: añadir un nuevo contacto, borrar dado el nombre y consultar el teléfono dado el nombre.
     */
    public static void EjercicioH3() {
        Scanner entrada = new Scanner(System.in);
        HashMap<String, String> agenda = new HashMap<>();
        System.out.println("=== Contactos telefónicos ===");
        String nombre = "";
        String telefono = "";
        String consulta = "";
        String respuesta = "";
        boolean finalizar = false;
        do {
            System.out.print("Ingrese: \n");
            System.out.print("'consultar' para buscar contactos\n");
            System.out.print("'borrar' para eliminar contactos\n");
            System.out.print("'fin' para salir del programa\n");
            System.out.print("O un nombre para ingresar: ");
            nombre = entrada.nextLine().trim();
            switch (nombre) {
                case "fin":
                    System.out.println("Hasta pronto!");
                    finalizar = true;
                    break;
                case "consultar":
                    System.out.print("Ingrese el nombre a consultar: ");
                    consulta = entrada.nextLine().trim();
                    if (agenda.containsKey(consulta)) {
                        respuesta = agenda.get(consulta);
                    } else {
                        System.out.print("No encontrado en la agenda\n");
                    }
                    System.out.printf("El usuario: %s.\n", consulta);
                    System.out.printf("Tiene el teléfono %s. \n", respuesta);
                    break;
                case "borrar":
                    System.out.print("Ingrese el nombre para borrar: ");
                    consulta = entrada.nextLine();
                    if (agenda.containsKey(consulta)) {
                        agenda.remove(consulta);
                        System.out.print("Contacto removido con éxito!\n\n");
                    } else {
                        System.out.print("No existe tal contacto");
                    }
                    break;
                default:
                    System.out.print("Ingrese el teléfono: ");
                    telefono = entrada.nextLine();
                    if (!nombre.isEmpty() && !telefono.isEmpty()) {
                        agenda.put(nombre, telefono);
                        System.out.printf("\n%s con teléfono %s ha sido ingresada correctamente! \n\n", nombre, telefono);
                    } else {
                        System.out.print("Nombre o teléfono incorrectos");
                    }


            }
            agenda.put(nombre, telefono);
        }

        while (!finalizar);
        System.out.println(agenda);
    }


    /*
    Construye un traductor básico de palabras individuales (por ejemplo español-inglés).

    a) Almacena una lista de traducciones en una estructura clave-valor donde la clave es una palabra en una lengua y el valor es su traducción en otra lengua.
     Añade, al menos, 5 elementos clave-valor por teclado. Las palabras deben guardarse en minúsculas.
    b) Permite al usuario introducir una palabra y que el programa muestre la traducción. Si no está en el diccionario, lo indica.
    c) Permite añadir una nueva traducción al diccionario durante la ejecución del programa.
    d) Modifica el programa para mostrar un menú que permitirá al usuario elegir entre buscar una palabra en el diccionario, añadir una nueva palabra o acabar el programa.
    e) Añade una nueva opción para mostrar todas las palabras del diccionario.
     */
    public static void EjercicioH2() {
        Scanner entrada = new Scanner(System.in);
        HashMap<String, String> diccionario = new HashMap<>();
        String castellano = "";
        String valencia = "";
        int opcion = 0;
        System.out.println("--- Diccionario Valenciano - Castellano ---");
        do {
            System.out.println("Elija una opción:");
            System.out.println("1. Introducir una palabra nueva y su traducción.");
            System.out.println("2. Buscar una palabra.");
            System.out.println("3. Lista de palabras.");
            System.out.println("4. Salir");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la palabra en castellano: ");
                    castellano = entrada.nextLine().toLowerCase().trim();
                    if (castellano.isEmpty()) {
                        System.out.println("Palabra no ingresada!\n");
                        break;
                    }
                    System.out.print("Ingrese la paraula en valencià: ");
                    valencia = entrada.nextLine().toLowerCase().trim();
                    if (valencia.isEmpty()) {
                        System.out.println("Paraula no ingressada!\n");
                        break;
                    }
                    diccionario.put(castellano, valencia);
                    System.out.println("Palabra ingresada correctamente!\n");
                    break;
                case 2:
                    System.out.print("Ingrese la palabra a buscar: ");
                    castellano = entrada.nextLine();
                    if (!diccionario.containsKey(castellano)) {
                        System.out.println("No está en el diccionario la palabra " + castellano);
                    } else {
                        System.out.println("Palabra encontrada!");
                        System.out.println(castellano + ": " + diccionario.get(castellano) + "\n");
                    }
                    break;
                case 3:
                    System.out.println("--- Lista de palabras / Llista de paraules ----");
                    for (String palabra : diccionario.keySet()) {
                        System.out.println(palabra + ": " + diccionario.get(palabra));
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Hasta la próxima! / Fins prompte!");
                    break;
                default:
                    System.out.println("Opción inválida!!");
            }

        } while (opcion != 4);


    }
        /*
        Escribe un programa que pida una frase al usuario y use un HashMap para contar cuántas veces aparece cada palabra.
        a) Pide una frase por teclado, normaliza el texto (pasa a minúsculas y elimina signos de puntuación) y almacena cada palabra en un vector.
        b) Guarda cada palabra en una estructura asociativa, donde la clave sea la palabra y el valor sea el recuento.
        c) Muestra las palabras y el número de repeticiones.
        d) Muestra qué palabra es la que más se repite.
         */

    public static void EjercicioH1() {
        Scanner entrada = new Scanner(System.in);
        String frase = "";
        HashMap<String, Integer> vectorPalabras = new HashMap<>();
        String[] frasePalabras;
        String palabrasMax = "";
        int repeticiones = 0;
        System.out.println("=== Contador de palabras ===");
        System.out.println("Ingrese una frase para el conteo de palabras:");
        frase = entrada.nextLine();
        if (!frase.isEmpty()) {
            frase = frase.trim().toLowerCase().replaceAll("[^a-záéíóúñü\\s]", "");
            frasePalabras = frase.split("\\s");
            for (String palabras : frasePalabras) {
                vectorPalabras.put(palabras, vectorPalabras.getOrDefault(palabras, 0) + 1);
            }
            for (String palabra : vectorPalabras.keySet()) {
                System.out.println("'" + palabra + "'" + " se repite: " + vectorPalabras.get(palabra));
            }
            for (String palabra : vectorPalabras.keySet()) {
                if (vectorPalabras.get(palabra) > repeticiones) {
                    repeticiones = vectorPalabras.get(palabra);
                    palabrasMax = palabra;
                }
            }
            System.out.print("Se repite " + repeticiones + " veces" + " la palabra '" + palabrasMax + "'");


        } else {
            System.out.print("No ha ingresado una frase válida!");
        }
    }


}
