/*
//#Marat Rafael Azizov Azizova – examen 1º DAM 10/03/2021
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

        iniciarInmobiliaria(listaInmobiliarias);

        //Inmobiliaria.mostrarTodasInmobiliarias(listaInmobiliarias);
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
            System.out.println(hr);
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
            System.out.println("Acceso permitido");

            llamarMenuInmobiliaria(listaInmobiliarias.get(posicionInmobiliaria).getListaEnmuebles());
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
        for (int j = 0; j < listaInmobiliarias.size(); j++) {
            if(listaInmobiliarias.get(i).getCifInmobiliaria().equals(cifInmobiliariaBuscado)){
                posicion=i;               
            }           
        }      
        return posicion;
    }

    /**
     * metodo para llamar menu principal
     */
    public static void llamarMenuInmobiliaria(ArrayList<Inmueble> listaInmuebles) {
        

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
                        Terreno terreno = new Terreno();
                        terreno.solicitarDatos();
                        listaInmuebles.add(terreno);
                        break;
                    case 2:
                        Vivienda vivienda = new Vivienda();
                        vivienda.solicitarDatos();
                        listaInmuebles.add(vivienda);
                        break;
                    case 3:
                        Inmueble.buscarTerreno(listaInmuebles);
                        break;
                    case 4:
                        Inmueble.buscarVivienda(listaInmuebles);
                        break;
                    case 0:

                        salirMenu = true;
                        break;
                    default:
                        System.out.println("Opciones disponibles de 1 a 4 , 0 - para salir");
                        break;
                }
            } while (!salirMenu);


    }//fin metodo llamar menu

    public static void iniciarInmobiliaria(ArrayList<Inmobiliaria> listaInmobiliaria) {
        
        
        Inmobiliaria inmoTemp;
        Terreno terrenoTemp;
        Vivienda viviendaTemp;
        for (int i = 0; i < 3; i++) {
            inmoTemp = new Inmobiliaria();
            inmoTemp.setCifInmobiliaria("Inmo0" + i);
            inmoTemp.setNombreInmobiliaria("nombreInmo" + 1);
            for (int j = 0; j < 3; j++) {
                terrenoTemp = new Terreno();
                terrenoTemp.setIdInmueble(i + j);
                terrenoTemp.setMetrosCuadrados(j * 80);
                terrenoTemp.setPoblacion("poblac" + j);
                terrenoTemp.setPrecio(30000 * (j + 1));
                terrenoTemp.setTipoCalificacion(tipoTerreno.RUSTICO);
                inmoTemp.getListaEnmuebles().add(terrenoTemp);
                viviendaTemp = new Vivienda();
                viviendaTemp.setIdInmueble(i + j);
                viviendaTemp.setMetrosCuadrados(j * 80);
                viviendaTemp.setPoblacion("poblac" + j);
                viviendaTemp.setPrecio(30000 * (j + 1));
                viviendaTemp.setDescripcion("descripcion vivienda " + i);
                viviendaTemp.setNumHabitaciones(i + j + 1);
                inmoTemp.getListaEnmuebles().add(viviendaTemp);
            }
            listaInmobiliaria.add(inmoTemp);
        }
        
    }

}//fin class
