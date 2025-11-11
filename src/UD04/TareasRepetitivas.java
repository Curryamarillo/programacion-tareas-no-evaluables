package U04;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class TareasRepetitivas {

    /*
    Una empresa de servicios quiere automatizar la facturación mensual en función del uso y aplicar tramos de tarifas y un IVA específico. El coste por unidad varía según consumos:

    Hasta 100 unidades: 0,10 €
    De 101 a 500: 0,08 €
    Más de 500: 0,05 €
    Además, se aplica un IVA del 21 %.

    a) Pide el consumo mensual (unidades) y calcula el coste base sin IVA.
    b) Aplica el IVA y muestra el total con IVA incluido.
    c) Añade un descuento del 5 % si el consumo supera las 1000 unidades (sobre el total con IVA).
    d) Permite facturar para varios clientes hasta que el usuario introduzca "fin", y acumula el total facturado.
    e) Muestra un resumen: número de facturas, ingresos brutos, total de IVA y total de descuentos aplicados.
     */
    public static void ejercicio9() {
        double precioHasta100unidades = 0.10d;
        double precioDe101a500 = 0.08d;
        double precioMasDe500 = 0.05d;

        int unidades;
        double costeBase;
        double totalFacturado = 0;
        boolean ingresarConsumos = true;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Ingrese el consumo mensual: ");
            unidades = scanner.nextInt();
            if (unidades > 500) {
                costeBase = unidades * precioMasDe500;
            } else if (unidades > 100) {
                costeBase = unidades * precioDe101a500;
            } else {
                costeBase = unidades * precioHasta100unidades;
            }
            scanner.nextLine();

            if(unidades > 100) {
                double precioConIVAMasDeMil = ((costeBase * 1.21) * 0.95);
                System.out.println("El precio con IVA es de: " + precioConIVAMasDeMil + " incluye un descuento de un 5%");
                totalFacturado += precioConIVAMasDeMil;
            } else {
                double precioConIVAMenosDeMil = costeBase * 1.21;
                System.out.println("El precio con IVA es: " + precioConIVAMenosDeMil);
                totalFacturado += precioConIVAMenosDeMil;
            }
            System.out.println("¿Quiere ingresar más consumos? Si no ingrese 'fin' y enter ");
            String finalizar = scanner.nextLine();

            if (finalizar.equals("fin")) ingresarConsumos = false;

        } while (ingresarConsumos);
        System.out.println("El total facturado es: " + totalFacturado);

    }

    /*
    Un departamento académico quiere un programa que calcule la nota final de un alumno teniendo en cuenta exámenes, prácticas y trabajos. Cada tipo tiene un peso diferente: exámenes 50 %, prácticas 30 % y trabajos 20 %. Además, si alguno de los tres componentes está por debajo de 4, el alumno suspenderá automáticamente.

    a) Pide las tres notas (0–10) y calcula la nota ponderada simple.
    b) Añade la comprobación: si alguna nota < 4, muestra "Suspenso automático".
    c) Si no hay suspenso automático, muestra "Aprobado" o "Sobresaliente" si la nota final ≥ 9.
    d) Permite repetir el cálculo para varios alumnos hasta que el usuario introduzca "fin".
    e) Al final, muestra cuántos alumnos han aprobado, han suspendido por nota baja y cuántos han obtenido Sobresaliente.
     */
    public static void ejercicio8() {

        double notaExamenes;
        double notaPracticas;
        double notaTrabajos;

        double notaPonderadaSimple;
        int alumnosAprobados = 0;
        int alumnosSuspendidosPorBajaNota = 0;
        int alumnosSuspendidosPorMedia = 0;
        int alumnosSobresalientes = 0;

        boolean ingresarMasAlumnos = true;
        Scanner scanner = new Scanner(System.in);

        do {
            boolean suspensoAutomatico = false;

            System.out.println("Ingrese la nota de exámenes del alumno: ");
            notaExamenes = scanner.nextDouble();
            System.out.println("Ingrese la nota de prácticas del alumno: ");
            notaPracticas = scanner.nextDouble();
            System.out.println("Ingrese la nota de trabajos del alumno: ");
            notaTrabajos = scanner.nextDouble();
            scanner.nextLine();
            notaPonderadaSimple = (notaExamenes * 0.50) + (notaPracticas * 0.30) + (notaTrabajos * 0.20);
            System.out.println("La nota ponderada simple es: " + notaPonderadaSimple);
            if (notaExamenes < 4 || notaPracticas < 4 || notaTrabajos < 4) {
                System.out.println("Suspenso automático! Una de las notas es menor a 4!");
                suspensoAutomatico = true;
                alumnosSuspendidosPorBajaNota++;
            }
            if (!suspensoAutomatico) {
                if(notaPonderadaSimple >=9) {
                    alumnosAprobados++;
                    alumnosSobresalientes++;
                    System.out.println("Sobresaliente!!! Has aprobado un una nota genial!!!");
                } else if (notaPonderadaSimple >=5) {
                    alumnosAprobados++;
                    System.out.println("Aprobado!!!");
                } else {
                    System.out.println("Suspendido!!!");
                    alumnosSuspendidosPorMedia++;
                }
            }
            System.out.println("Si quiere cargar más alumnos pulse enter, si no escriba 'fin' y enter");
            String respuesta = scanner.nextLine();



            if (respuesta.equals("fin")) {
                ingresarMasAlumnos = false;
            }
        } while (ingresarMasAlumnos);

        System.out.println("Los alumnos que han aprobado son: " + alumnosAprobados);
        System.out.println("Los alumnos que han suspendido por la media son: " + alumnosSuspendidosPorMedia);
        System.out.println("Los alumnos suspendidos por baja nota son: " + alumnosSuspendidosPorBajaNota);
        System.out.println("Los alumnos con nota sobresaliente son: " + alumnosSobresalientes);
        scanner.close();
    }

    /*
    En una biblioteca universitaria quieren digitalizar el sistema de control de préstamos. Cada libro tiene un código, un título y una fecha de devolución prevista. El programa debe gestionar la lista de préstamos abiertos y calcular posibles recargos por retraso.

    a) Pide al usuario el código y el título de un libro, y la fecha de devolución prevista (día, mes, año). Muéstralo todo por pantalla.
    b) Añade la fecha de hoy y calcula si el libro está retrasado (fecha hoy > fecha devolución). Muestra por pantalla tanto si está retrasado como si no.

    Considera que un mes tiene 30 días, y un año tiene 365 días.
    Comprueba en orden: año, mes, día.
    c) Si hay retraso, calcula el número de días de retraso y muestra un recargo de 0,50 € por día.
    d) Permite introducir varios préstamos hasta que el usuario escriba "fin", y acumula el total de recargos.
    e) Al final, muestra un resumen: número de libros prestados, libros retrasados y recargos totales.
     */
    public static void ejercicio7() {
        Scanner scanner = new Scanner(System.in);
        int codigoLibro;
        String nombreLibro;
        LocalDate fechaDevolucion;
        double recargoPorDia = 0.50d;
        double sumaRecargo = 0.00d;
        int sumaLibrosRetrasados = 0;
        int sumaLibrosPrestados = 0;
        boolean continuar = true;

        do {
            System.out.println("Ingrese el código del libro: ");
            codigoLibro = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el título del libro:");
            nombreLibro = scanner.nextLine();
            System.out.println("Ingrese la fecha (yyyy-mm-dd): ");
            /// System.out.println(LocalDate.now());
            sumaLibrosPrestados++;
            fechaDevolucion = LocalDate.parse(scanner.nextLine());
            long diasPrestamo = ChronoUnit.DAYS.between(fechaDevolucion, LocalDateTime.now());
            System.out.println("El código del libro es: " + codigoLibro);
            System.out.println("El nombre del libro es: " + nombreLibro);
            System.out.println("La fecha de devolución es: " + fechaDevolucion);
            System.out.println("los días de retraso son: " + diasPrestamo);
            if (diasPrestamo > 0) {
                sumaRecargo = diasPrestamo * recargoPorDia;
                sumaLibrosRetrasados++;
            }
            System.out.println("Introduzca 'fin' para acabar de ingresar libros, si quiere seguir pulse 'enter'" );
            String ingresoFin = scanner.nextLine();
            if (ingresoFin.equals("fin")) {
                continuar = false;
            }

        } while (continuar);
        System.out.println("La suma de libros prestados es: " + sumaLibrosPrestados);
        System.out.println("La suma de libros con recargo es: " + sumaLibrosRetrasados + " €");
        System.out.println("La suma del recargo en total es: " + sumaRecargo);

    }

    /*
    Queremos controlar los gastos mensuales de una casa.

a) El programa debe pedir tres gastos (luz, agua y comida) y mostrar el total mensual.
b) Se amplía el programa para pedir también un cuarto gasto opcional (otros), y mostrarlo solo si es mayor que 0.
c) Se amplía el programa para mostrar un resumen con porcentajes de cada gasto sobre el total.
     */
    public static void ejercicio6() {

        Scanner scanner = new Scanner(System.in);
        float importeLuz = 0, importeAgua = 0, importeComida = 0, importeOtros = 0;

        System.out.println("Ingrese el importe de la factura de la luz:");
        importeLuz = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Ingrese el importe de la factura de la agua:");
        importeAgua = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Ingrese el importe de la factura de la comida:");
        importeComida = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Ingrese el importe de otros gastos:");
        importeOtros = scanner.nextFloat();
        scanner.nextLine();
        scanner.close();

        float totalMensual = importeLuz + importeAgua + importeComida + importeOtros;
        System.out.println("El total mensual es: " + totalMensual + " €.");
        double porcentajeLuz = (importeLuz * 100) / totalMensual;
        System.out.println("El porcentaje del gasto de la luz es: " + porcentajeLuz);
        double porcentajeAgua = (importeAgua * 100) / totalMensual;
        System.out.println("El porcentaje del gasto del agua es: " + porcentajeAgua);
        double porcentajeComida = (importeComida * 100) / totalMensual;
        System.out.println("El porcentaje del gasto de la comida es: " + porcentajeComida);
        if (importeOtros > 0) {
            double porcentajeOtros = (importeOtros * 100) / totalMensual;
            System.out.println("El porcentaje del gasto de otros es: " + porcentajeOtros);
        }

    }

    /*
    En un centro de atención telefónica quieren saber cuántos clientes han valorado negativamente el servicio.

    a) Escribe un programa que lea por teclado 10 valoraciones numéricas (−5 a +5) e indique si ha habido algún negativo.
    b) Modifícalo para que también cuente y muestre cuántos son positivos, cuántos negativos y cuántos neutros (valoración de 0).
    c) Añade un mensaje en caso de que todos sean positivos: "¡Excelente!"
    d) Si alguno es −5, añadir "Revisión urgente necesaria".
     */
    public static void ejercicio5() {
        int cuentaRegresiva = 10;
        int numerosPositivos = 0;
        int numerosNegativos = 0;
        int numerosNeutros = 0;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Ingrese un número (-5 a 5), en total son 10, quedan: " + cuentaRegresiva);
            int numeroIngresado = scanner.nextInt();
            if (numeroIngresado == 0) {
                numerosNeutros += 1;
            } else if (numeroIngresado < 0) {
                numerosNegativos += 1;
            } else {
                numerosPositivos += 1;
            }
            cuentaRegresiva--;
        } while (cuentaRegresiva >= 1);
        scanner.close();
        System.out.println("Los números neutros son: " + numerosNeutros);
        System.out.println("Los números positivos son: " + numerosPositivos);
        System.out.println("Los números negativos son: " + numerosNegativos);

        if (numerosPositivos == 10) {
            System.out.println("¡¡¡Excelente!!!");
        }
        if (numerosNegativos == -5) {
            System.out.println("Revisión urgente necesaria");
        }

    }

    /*
    Un grupo de amigos ha hecho un torneo y quiere registrar las puntuaciones.
    a) El programa pide el nombre y puntuación de 4 jugadores y muestra quién ha conseguido la puntuación más alta.
    b) Muestra la media de las puntuaciones.
    c) Si hay alguna puntuación inferior a 5, muestra "Hay que mejorar" para esos jugadores.
     */
    public static void ejercicio4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del jugador 1: ");
        String nombreJugador1 = scanner.nextLine();
        System.out.println("Ingrese su puntuación, " + nombreJugador1 + ": ");
        int puntuacionJugador1 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el nombre del jugador 2: ");
        String nombreJugador2 = scanner.nextLine();
        System.out.println("Ingrese su puntuación, " + nombreJugador2 + ": ");
        int puntuacionJugador2 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el nombre del jugador 3: ");
        String nombreJugador3 = scanner.nextLine();
        System.out.println("Ingrese su puntuación, " + nombreJugador3 + ": ");
        int puntuacionJugador3 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el nombre del jugador 4: ");
        String nombreJugador4 = scanner.nextLine();
        System.out.println("Ingrese su puntuación, " + nombreJugador4 + ": ");
        int puntuacionJugador4 = scanner.nextInt();
        scanner.nextLine();

        scanner.close();

        String elMejorJugador = "";
        if (puntuacionJugador1 > puntuacionJugador2 && puntuacionJugador1 > puntuacionJugador3 && puntuacionJugador1 > puntuacionJugador4) {
            elMejorJugador = nombreJugador1;
        } else if (puntuacionJugador2 > puntuacionJugador1 && puntuacionJugador2 > puntuacionJugador3 && puntuacionJugador2 > puntuacionJugador4) {
            elMejorJugador = nombreJugador2;
        } else if (puntuacionJugador3 > puntuacionJugador1 && puntuacionJugador3 > puntuacionJugador2 && puntuacionJugador3 > puntuacionJugador4) {
            elMejorJugador = nombreJugador3;
        } else {
            elMejorJugador = nombreJugador4;
        }

        double mediaPuntos = (double) (puntuacionJugador1 + puntuacionJugador2 + puntuacionJugador3 + puntuacionJugador4) / 4;
        System.out.println("El mejor es: " + elMejorJugador);
        System.out.println("La media de puntos es: " + mediaPuntos);

        if (puntuacionJugador1 < 5) {
            System.out.println( nombreJugador1 + " hay que mejorar esta puntuación miserable de: " + puntuacionJugador1);
        }
        if (puntuacionJugador2 < 5) {
            System.out.println(nombreJugador2 + " hay que mejorar esta puntuación miserable de: " + puntuacionJugador2);
        }
        if (puntuacionJugador3 < 5) {
            System.out.println(nombreJugador3 + " hay que mejorar esta puntuación miserable de: " + puntuacionJugador3);
        }
        if (puntuacionJugador4 < 5) {
            System.out.println(nombreJugador4 + " hay que mejorar esta puntuación miserable de: " + puntuacionJugador4);
        }

    }

    /*
    a) Escribe un programa que calcule y muestre el factorial de un número N, introducido por teclado.
    b) Permite que se vuelva a pedir el valor de N hasta que sea un número positivo.
    c) Añade una funcionalidad que muestre la secuencia de multiplicaciones realizadas.
     */
    public static void ejercicio3() {
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
    public static void ejercicio2() {
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
    public static void ejercicio1() {

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
