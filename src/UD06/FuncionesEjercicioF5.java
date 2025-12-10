package UD06;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FuncionesEjercicioF5 {
    /*
    Diseña un sistema que permita añadir un estudiante, marcar su asistencia y mostrar el estado de asistencia de todos los estudiantes.
    Cuando el usuario quiera añadir un estudiante, el programa pedirá el nombre y
    lo incorporará a la lista de personas matriculadas solo si no está ya, asignándole automáticamente el estado de “no asistido”;
    si el nombre ya existe, no hará ningún cambio.
    Cuando el usuario elija marcar asistencia, el sistema pedirá el nombre del estudiante y,
    si lo encuentra en la lista, cambiará su estado a “asistido”, y si no existe, informará de que no se puede marcar la asistencia de un estudiante desconocido.
    Cuando el usuario pida ver los asistentes, el programa mostrará todos los nombres y si han asistido o no,
    y finalmente el usuario podrá finalizar la ejecución del programa cuando quiera.
     */
    public static void sistemaDeAsistencia() {
        HashMap<String, String> asistencia = new HashMap<>();
        String opcion;
        Scanner entrada = new Scanner(System.in);
        do {
            eMenu();
            System.out.print("Opción?: ");
            opcion = entrada.nextLine();
            switch (opcion) {
                case "1":
                    ingresoAlumno(entrada, asistencia);
                    break;
                case "2":
                    registrarAsistencia(entrada, asistencia);
                    break;
                case "3":
                    listarAsistencia(asistencia);
                    break;
                case "4":
                    opcion = salir(opcion);
                    break;
            }
        } while (!opcion.equals("4"));
        System.out.println("Gracias!");
    }

    private static String salir(String opcion) {
        opcion="4";
        System.out.println("Saliendo del programa!");
        return opcion;
    }

    private static void listarAsistencia(HashMap<String, String> asistencia) {
        System.out.println("Lista de alumnos y asistencia");
        for (Map.Entry<String, String> alumno : asistencia.entrySet()) {
            System.out.printf("%s: %s\n", alumno.getKey(), alumno.getValue());
        }
        System.out.println();
    }

    private static void registrarAsistencia(Scanner entrada, HashMap<String, String> asistencia) {
        String nombre;
        System.out.println("Marcar asistencia");
        System.out.print("Ingrese alumno: ");
        nombre = entrada.nextLine();
        if (asistencia.containsKey(nombre)) {
            asistencia.replace(nombre, "no asistido", "asistido");
            System.out.println("Asistencia registrada correctamente\n");
        } else {
            System.out.printf("\nNo está en la base de datos el alumno: %s\n", nombre);
        }
    }

    private static void ingresoAlumno(Scanner entrada, HashMap<String, String> asistencia){
        String nombre;
        System.out.print("Ingrese el nombre del alumno: ");
        nombre = entrada.nextLine();
        if (asistencia.containsKey(nombre)) {
            System.out.println("El alumno ya está en la lista\n");

        } else {
            asistencia.put(nombre, "no asistido");
            System.out.println("Alumno agregado con éxito!\n");
        }
    }

    private static void eMenu() {
        System.out.println("--- Sistema de asistencia ---");
        System.out.println("Opciones:");
        System.out.println("1.- Añadir un estudiante");
        System.out.println("2.- Marcar asistencia");
        System.out.println("3.- Ver asistentes");
        System.out.println("4.- Salir");
    }


}
