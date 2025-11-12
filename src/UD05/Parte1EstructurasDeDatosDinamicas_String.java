package UD05;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;


public class Parte1EstructurasDeDatosDinamicas_String {

    /*
    Una aplicación de acceso necesita validar nombres de usuario según normas específicas. Además, quiere ayudar a los usuarios a corregir errores comunes.

    a) Guarda 5 nombres de usuario. Muéstralos.
    b) Muestra cuáles son válidos: empiezan con letra, tienen entre 5 y 12 caracteres, no contienen espacios.
    c) Para aquellos que no sean válidos, sugiere una versión corregida (elimina espacios, cambia el carácter inicial si es un dígito, recorta o completa longitudes).
    d) Añade una nueva condición: todos los caracteres tienen que ser alfanuméricos. Modifica también el código para añadir sugerencia en caso de no superar esta nueva comprobación.
     */
    public static void EjercicioS5() {
        Scanner scanner = new Scanner(System.in);
//        String[] usuarios = new String[5];
        String[] usuarios = {"pet", "-Catarate", "paralel-pipedo", "1terratremol", "pa tata"};
        String[] usuariosValidados = new String[5];
        String[] usuariosValidadosConAlfanumericos = new String[5];

        System.out.println("\nValidación de usuarios:");
        System.out.println("Son 5 usuarios.");
//    do {
//        if(contadorUsuarios < 4) {
//            System.out.println("Este es el " + ((contadorUsuarios) + 1) + " usuario.");
//        } else {
//            System.out.println("Este es el último usuario a ingresar.");
//        }
//        System.out.println("Ingrese el nombre del usuario:");
//
//        usuarios[contadorUsuarios] = scanner.nextLine();
//        contadorUsuarios++;
//    } while (contadorUsuarios < 5);
        System.out.println("Los usuarios son: " + formatear(usuarios));
        for (int i = 0; i < usuarios.length; i++) {
            String usuario = usuarios[i];
            boolean empiezaConLetra = usuario.matches("[A-Za-z].*");
            boolean cantidadDeCaracteres = (usuario.length() >= 5 && usuario.length() <= 12);
            boolean noContieneEspacios = !usuario.contains(" ");




            if (empiezaConLetra && cantidadDeCaracteres && noContieneEspacios) {
                System.out.println("El usuario '" + usuario + "' cumple con los criterios de validación");
                usuariosValidados[i] = usuario;
            }
            if (!noContieneEspacios) {
                usuariosValidados[i] = usuario.replace(" ", "");
            }
            if (!empiezaConLetra) {
                usuariosValidados[i] = usuario.substring(1);
            }
            if (!cantidadDeCaracteres) {
                if (usuario.length() > 12) {
                    usuario = usuario.substring(0, 12);
                } else {
                    int iteraciones = 5 - usuario.length();
                    for (int j = 0; j < iteraciones; j++) {
                        usuario = usuario.concat("x");
                    }
                }
                usuariosValidados[i] = usuario;
            }
        }
        System.out.println();
        for (int i = 0; i < usuarios.length; i++) {
            System.out.println("El usuario original es: " + usuarios[i] + "\nRecomendamos: " + usuariosValidados[i] + ".\n");
        }
        System.out.println();
        System.out.println("Usuarios validos: " + formatear(usuariosValidados));
        for (int i = 0; i < usuariosValidados.length; i++) {
            int maximo = 65; // acaban caracteres alfanuméricos
            int minimo = 33; // empiezan caracteres alfanuméricos
            Random aleatorio = new Random();
            char caracter = (char) (aleatorio.nextInt(maximo - minimo + 1) + minimo);
            if (usuariosValidados[i].matches(".*[!-@0-9].*")) {
                usuariosValidadosConAlfanumericos[i] = usuariosValidados[i];
            } else {
                if (usuariosValidados[i].length() >= 11) {
                    usuariosValidadosConAlfanumericos[i] = (usuariosValidados[i].substring(0, usuariosValidados[i].length() - 1)).concat(String.valueOf(caracter));
                } else {
                    usuariosValidadosConAlfanumericos[i] = usuariosValidados[i] + caracter;
                }

            }

        }


        System.out.println("En caso que tenga un carácter alfanumérico no se harán cambios, pero sugerimos que los tenga para más seguridad.");
        System.out.println("Quedaría así la lista de usuarios recomendada: " + formatear(usuariosValidadosConAlfanumericos));
    }


    /*
    Una aplicación ha recibido una lista de correos electrónicos que hay que validar y analizar.

    a) Guarda 5 correos en un vector de String. Muéstralos.
    b) Muestra cuáles contienen el símbolo "@" y acaban en ".com" o ".es".
    c) Muestra el dominio de cada correo (usa substring, indexOf).
     */

    public static void EjercicioS4() {
        Scanner scanner = new Scanner(System.in);
        int contadorCorreosElectronicos = 5;
        String[] correosElectronicos = new String[5];

        String[] correosConArroba = new String[5];
        String[] correosConPuntoComPuntoEs = new String[5];
        String[] correosPuntoCom = new String[5];
        int index = 0;
        do {
            System.out.println("Ingrese un correo electrónico a validar: ");
            System.out.println("En total son 5, quedan: " + contadorCorreosElectronicos);
            correosElectronicos[index] = scanner.nextLine();
            index++;
            contadorCorreosElectronicos -= 1;
        } while (contadorCorreosElectronicos > 0);
        scanner.close();
        System.out.println("Los correos electrónicos ingresados son: " + Arrays.toString(correosElectronicos).replace("[", "").replace("]", "").toLowerCase());

        for (int i = 0; i < correosElectronicos.length; i++) {
            if (correosElectronicos[i].contains("@")) {
                correosConArroba[i] = correosElectronicos[i];
            }
            if (correosElectronicos[i].contains(".com")) {
                correosPuntoCom[i] = correosElectronicos[i];
            }
            if (correosElectronicos[i].contains(".es")) {
                correosConPuntoComPuntoEs[i] = correosElectronicos[i];
            }
        }

        System.out.println("Los correos que tienen arroba son: " + formatear(correosConArroba));
        System.out.println("Los correos que tienen .com son: " + formatear(correosPuntoCom));
        System.out.println("Los correos que tienen .es son: " + formatear(correosConPuntoComPuntoEs));
        for (String correo : correosElectronicos) {
            if (correo.contains(".")) {
                String dominio = correo.substring(correo.indexOf("."));
                System.out.println("El dominio de: " + correo + " es: " + dominio);
            } else {
                System.out.println("El correo siguiente no tiene dominio: " + correo);
            }

        }

    }

    private static String formatear(String[] texto) {
        return Arrays.toString(texto).replace("[", "").replace("]", "").replace(" null,", "").replace(", null", "").replace("null,", "");
    }

    /*
        Se quieren hacer una serie de comprobaciones en una frase. Realízalas y muestra el resultado.

        a) Introduce una frase y guárdala. Indica si empieza por mayúscula y acaba por punto. Si no es el caso, modifica la cadena.
        b) Muestra la longitud de la frase y cuántas palabras contiene (asumiendo que están separadas por espacios en blanco).
        c) Sustituye todas las apariciones de la palabra "Java" por "Python".
        d) Muestra la frase final resultante, la longitud y el número de palabras.
         */
    public static void EjercicioS3() {
        Scanner scanner = new Scanner(System.in);
        String frase = "";
        int contadorPalabras = 1;
        System.out.print("Ingrese una frase: ");
        frase = scanner.nextLine();
        char[] cadenaFrase = frase.toCharArray();


        if (Character.isUpperCase(cadenaFrase[0])) {
            System.out.print("La cadena empieza por mayúscula.");
        } else if (!Character.isUpperCase(cadenaFrase[0])) {
            cadenaFrase[0] = Character.toUpperCase(cadenaFrase[0]);
            System.out.println("Como la cadena no empieza con mayúscula, la hemos corregido.");
            frase = String.copyValueOf(cadenaFrase);
        }
        if (!frase.endsWith(".")) {
            System.out.println("Como hemos visto que no acaba con punto se lo hemos agregado.");
            frase = frase + ".";
        }
        for (char caracter : cadenaFrase) {
            if (Character.valueOf(caracter).equals(' ')) {
                contadorPalabras++;
            }
        }
        System.out.println("Como queremos más Java te lo cambiamos por python");
        frase = frase.replace("Java", "Python");
        System.out.println("La frase tiene estas palabras: " + contadorPalabras);
        System.out.println(frase);
    }



    /*
    En una carpeta hay varios nombres de fichero. Hay que analizarlos para identificar sus tipos y validar nombres válidos.

    a) Guarda 8 nombres de fichero (con extensión) en un vector de String. Muéstralos.
    b) Muestra aquellos que no tienen extensión.
    c) Muestra aquellos nombres que acaban en ".txt".
    d) Muestra qué nombres contienen espacios.
    e) Cambia todos los nombres para que estén en minúsculas.
    f) Muestra solo los nombres de los ficheros sin la extensión.
     */

    public static void EjercicioS2() {

        int cantidadFicheros = 8;
        Scanner scanner = new Scanner(System.in);
        String[] carpetaFicheros = new String[8]; // {"Pete.txt", "tema.doc", "alfil.es", "pico.pdf", "informe", "Jacinto.pdf", "Robe rto.exe", "jaimnito.txt"};
        String[] carpetaFicherosLowerCase = new String[8];
        String[] carpetaFicherosSinExtension = new String[8];
        do {
            System.out.println("Ingrese el fichero a guardar, quedan " + cantidadFicheros);
            carpetaFicheros[cantidadFicheros - 1] = scanner.nextLine();
            cantidadFicheros--;
        } while (cantidadFicheros > 0);
        System.out.println("La carpeta contiene los siguientes ficheros: " + Arrays.toString(carpetaFicheros).replace("[", " ").replace("]", " "));

        for (int i = 0; i < carpetaFicheros.length; i++) {
            if (!carpetaFicheros[i].contains(".")) {
                System.out.println("El fichero no contiene extensión: " + carpetaFicheros[i]);
            } else if (carpetaFicheros[i].endsWith(".txt")) {
                System.out.println("Este fichero acaba en .txt: " + carpetaFicheros[i]);
            }
            if (carpetaFicheros[i].contains(" ")) {
                System.out.println("Este fichero tiene un espacio!: " + carpetaFicheros[i]);
            }
            carpetaFicherosLowerCase[i] = carpetaFicheros[i].toLowerCase(Locale.ROOT);
            if (carpetaFicheros[i].contains(".")) {
                int posicionPunto = carpetaFicheros[i].indexOf(".");
                carpetaFicherosSinExtension[i] = carpetaFicheros[i].substring(0, posicionPunto);
            } else {
                carpetaFicherosSinExtension[i] = carpetaFicheros[i];
            }


        }
        System.out.println("Estos ficheros están pasados a minúscula" + Arrays.toString(carpetaFicherosLowerCase).replace("[", " ").replace("]", " "));
        System.out.println("Estos ficheros no tienen extensión: " + Arrays.toString(carpetaFicherosSinExtension).replace("[", " ").replace("]", " "));

        scanner.close();
    }


    /*
    Una aplicación web quiere validar contraseñas según ciertas normas antes de registrarlas. Un valor numérico indicará la fiabilidad de la contraseña:

    Un valor de 0 indica contraseña muy segura.
    Por cada comprobación que no supere, aumentará en 1.
    La seguridad de los distintos niveles es:
    Nivel 0: Muy segura.
    Nivel 1: Segura.
    Nivel 2 o 3: Muy insegura.
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