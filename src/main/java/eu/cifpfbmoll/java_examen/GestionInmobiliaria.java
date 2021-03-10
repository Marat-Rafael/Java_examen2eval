/*
//#Marat Rafael Azizov Azizova – examen 1º DAM 10/03/2021
 */

 /*
El programa principal (1 punto) incluido en la Clase GestionInmobiliaria,
que se caracteriza por tener una lista de Inmobiliarias y el main con el que
se gestionará el resto del programa. El main tendrá un menú que se llamará
indefinidamente hasta que el usuario quiera salir de la aplicación. Hay que
tener en cuenta que el menú trabaja con una inmobiliaria concreta y ofreciendo
para ella todas las opciones que se detallan a continuación, por tanto es
imprescindible saber primero con qué inmobiliaria trabajaremos, por ello,
desarrolla la solución que consideres más conveniente.

○ Añadir Terreno. (1 punto) Llamará al método solicitar Datos (aparece
en el punto F) y devolverá un terreno que se añadirá a la lista de
inmuebles. Este método pertenece a la clase Terreno.

○ Añadir Vivienda.(1 punto) Llamará al método solicitar Datos y añadirá la
vivienda la lista de inmuebles. Este método pertenece a la clase
Vivienda.

○ Buscar Vivienda. (1,5 puntos) Recibirá como parámetro una lista de
Inmuebles y solicitará al usuario un número de habitaciones. El método
mostrará toda la información de todas aquellas Viviendas que
cumplan con el criterio: número de habitaciones. Este método
pertenece a la clase Inmueble.

○ Buscar Terreno.(1,5 puntos) Recibirá como parámetro una lista de
Inmuebles y solicitará al usuario un tipo de calificación (rústico, urbano y
urbanizable). El método mostrará toda la información del primer
terreno que cumpla con la calificación buscada (rústico, urbano y
urbanizable). Este método pertenece a la clase Inmueble.
 */
package eu.cifpfbmoll.java_examen;

import java.util.*;

/**
 *
 * @author Marat Rafael
 */
public class GestionInmobiliaria {

    static Scanner scNum = new Scanner(System.in);
    static Scanner scString = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Inmobiliaria> listaInmobiliarias = new ArrayList<>();
        loginInmobiliaria(listaInmobiliarias);

    }// fin main

    public static void loginInmobiliaria(ArrayList<Inmobiliaria> listaInmobiliarias) {
        System.out.println("Para acceder a la aplicacion debe introducir cif de la inmobiliaria ");

        boolean salirLogin = false;
        byte opcionLogin;
        String hr = "*******************************************************";

        do {
            System.out.println(hr);
            System.out.println("Acceso a la aplicacion de inmobiliaria");
            System.out.println("1 - login");
            System.out.println("0 - salir");
            opcionLogin = scNum.nextByte();
            switch (opcionLogin) {

                case 1:

                    acederMenuPrincipal(listaInmobiliarias);

                    break;
                case 0:
                    salirLogin = true;
                    break;
                default:
                    System.out.println("solo 1 - login , 0 para salir");
                    break;
            }

        } while (!salirLogin);

    }

    public static void acederMenuPrincipal(ArrayList<Inmobiliaria> listaInmobiliarias) {
        // buscamos si inmobiliaria en la lista
        System.out.println("CIF: ");
        String cifInmobiliariaBuscado = scString.nextLine();
        int posicionInmobiliaria = buscarCifInmobiliaria(listaInmobiliarias, cifInmobiliariaBuscado);
        if (posicionInmobiliaria == -1) {
            System.out.println("CIF indicado incorrecto");
        } else {
            llamarMenuInmobiliaria();
        }
    }

    /**
     * un metodo para buscar cif de inmobiliaria y comparar con cif que pasamos
     * como parametro
     *
     * @param listaInmobiliarias
     * @param cifInmobiliariaBuscado
     * @return posicion de inmobiliaria si existe, si no existe devuelve -1;
     */
    private static int buscarCifInmobiliaria(ArrayList<Inmobiliaria> listaInmobiliarias, String cifInmobiliariaBuscado) {
        int posicion = -1;
        int i = 0;
        boolean encontrado = false;

        while (encontrado && i < listaInmobiliarias.size()) {
            i++;
            if (listaInmobiliarias.get(i).getCifInmobiliaria().equals(cifInmobiliariaBuscado)) {
                posicion = i;
                encontrado = true;
            }
        }
        return posicion;
    }

    /**
     * metodo para llamar menu principal
     */
    public static void llamarMenuInmobiliaria() {
        try {

            boolean salirMenu = false;
            byte opcionMenu;
            String hr = "******************************************************";
            String menu = "*********************MENU*****************************";

            do {
                System.out.println(hr);
                System.out.println(menu);
                System.out.println("1-Añadir terreno");
                System.out.println("2-Añadir vivienda");
                System.out.println("3-Buscar terreno");
                System.out.println("4-Buscar vivienda");
                System.out.println("0-Salir");
                System.out.println(hr);
                System.out.println();
                opcionMenu = scNum.nextByte();
                switch (opcionMenu) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 0:

                        salirMenu = true;
                        break;
                    default:
                        System.out.println("Opciones disponibles de 1 a 4 , 0 - para salir");
                        break;
                }
            } while (!salirMenu);
        } catch (Exception e) {
            System.out.println("Acepta solo valores numericos");
        }

    }//fin metodo llamar menu

}//fin class
