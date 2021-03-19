/*
Clase Inmueble. (0,5 puntos) Un inmueble se caracteriza por tener 
    unos metros cuadrados, 
    precio, 
    población,
    identificador. 

Para controlar el identificador,
utilizaremos otro atributo para controlar el último ID asignado en un inmueble.
Esta clase implementa el 
    constructor vacío, 
    constructor con todos los atributos,
    constructor copia, 
    getters/setters y 
    método toString. 
El precio nunca puede ser menor o igual a cero en toda nuestra aplicación
 */
package eu.cifpfbmoll.java_examen;

import java.util.*;

/**
 *
 * @author Marat Rafael
 */
public abstract class Inmueble {

    static Scanner scNum = new Scanner(System.in);
    static Scanner scString = new Scanner(System.in);
    //atributos
    private static int ID;
    private int metrosCuadrados;
    private double precio;
    private String poblacion;
    private int idInmueble;

    //constructor
    //constructor vacio
    public Inmueble() {
        ID++;
        idInmueble = ID;
    }

    //constructor con todos atributos
    public Inmueble(int metrosCuadrados, double precio, String poblacion) {
        ID++;
        idInmueble = ID;
        this.setMetrosCuadrados(metrosCuadrados);
        this.setPrecio(precio);
        this.setPoblacion(poblacion);

    }

    //constructor copia
    public Inmueble(Inmueble inmueble) {
        ID++;
        idInmueble = ID;
        this.setMetrosCuadrados(inmueble.getMetrosCuadrados());
        this.setPrecio(inmueble.getPrecio());
        this.setPoblacion(inmueble.getPoblacion());
    }

    // getter/setter
    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Inmueble.ID = ID;
    }

    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(int metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public double getPrecio() {
        return precio;
    }

    //El precio nunca puede ser menor o igual a cero 
    public void setPrecio(double precio) {
        Scanner scNum = new Scanner(System.in);
        while (precio <= 0) {
            System.out.println("El precio nunca puede ser menor o igual a cero ");
            this.precio = scNum.nextDouble();
        }
        this.precio = precio;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }
    //toString

    @Override
    public String toString() {
        return "Inmueble{" + "metrosCuadrados=" + metrosCuadrados + ", precio=" + precio + ", poblacion=" + poblacion + ", idInmueble=" + idInmueble + '}';
    }

    public void solicitarDatos() {
        System.out.println("Metros cuadrados: ");
        this.setMetrosCuadrados(scNum.nextInt());
        System.out.println("Poblacion: ");
        this.setPoblacion(scString.nextLine());
        System.out.println("Precio: ");
        this.setPrecio(scNum.nextDouble());
    }

    /*
    Buscar Vivienda. (1,5 puntos) Recibirá como parámetro una lista de
    Inmuebles y solicitará al usuario un número de habitaciones. El método
    mostrará toda la información de todas aquellas Viviendas que
    cumplan con el criterio: número de habitaciones. Este método
    pertenece a la clase Inmueble.
     */
    public static void buscarVivienda(ArrayList<Inmueble> listaInmuebles) {
        System.out.println("Numero de habitaciones: ");
        int numHab = scNum.nextInt();
        
        // tenemos que buscar todos , asi que usamos for

        for (int i = 0; i < listaInmuebles.size(); i++) {
            if (listaInmuebles.get(i) instanceof Vivienda) {
                if (((Vivienda) listaInmuebles.get(i)).getNumHabitaciones() == numHab) {                 
                    System.out.println( listaInmuebles.get(i).toString());
                }
            }
        }
    } //fin metodo buscarVivienda

    /*
    Buscar Terreno.(1,5 puntos) Recibirá como parámetro una lista de
    Inmuebles y solicitará al usuario un tipo de calificación (rústico, urbano y
    urbanizable). El método mostrará toda la información del primer
    terreno que cumpla con la calificación buscada (rústico, urbano y
    urbanizable). Este método pertenece a la clase Inmueble.
     */
    public static void buscarTerreno(ArrayList<Inmueble> listaInmuebles) {
        // buscamos solo  primero, asi qu usamos while
        System.out.println("tipo de calificacion buscado: \n1-rustico, \n2-urbano  \n3-urbanizable ");
        byte opcionTipoTerreno = scNum.nextByte();
        int j = 0;
        boolean encontrado = false;
        switch (opcionTipoTerreno) {
            case 1:

                while (!encontrado && j < listaInmuebles.size()) {
                    if (listaInmuebles.get(j) instanceof Terreno) {
                        if (((Terreno) listaInmuebles.get(j)).getTipoCalificacion().equals(tipoTerreno.RUSTICO)) {
                            System.out.println(listaInmuebles.get(j).toString());
                            encontrado = true;
                        }
                    }
                    j++;
                }
                break;
            case 2:
                while (!encontrado && j < listaInmuebles.size()) {

                    if (listaInmuebles.get(j) instanceof Terreno) {
                        if (((Terreno) listaInmuebles.get(j)).getTipoCalificacion().equals(tipoTerreno.URBANO)) {
                            System.out.println(listaInmuebles.get(j).toString());
                            encontrado = true;
                        }
                    }
                    j++;
                }
                break;
            case 3:

                while (!encontrado && j < listaInmuebles.size()) {
                    if (listaInmuebles.get(j) instanceof Terreno) {
                        if (((Terreno) listaInmuebles.get(j)).getTipoCalificacion().equals(tipoTerreno.URBANIZABLE)) {
                            System.out.println(listaInmuebles.get(j).toString());
                            encontrado = true;
                        }
                    }
                    j++;
                }
                break;
            default:
                System.out.println("Opciones disponibles: ");
                System.out.println("tipos de calificacion 1-rustico, 2-urbano, 3-urbanizable ");
        }
        if (encontrado == false) {
            System.out.println("No encontramos terreno ");
        }

    }//fin buscarTerreno

    /*
    Calcular PrecioCompraventa. (1 punto). Este método será de obligada
implementación por las clases herederas, ya que el precio de compraventa es
su precio+impuestos y los impuestos varían según el tipo de Inmueble. Este
método se llamará desde el método toString de las diferentes clases
implicadas, así mostrará el precio de compraventa según sea Vivienda o
Terreno.
○ En el caso de la clase Vivienda los impuestos vendrán dados por el
cálculo: precio * IVA que es de un 10%, después del cálculo imprimirá
los datos de la vivienda y a continuación el importe de compraventa.
○ Para el caso de los terrenos, su precio de compraventa será de
precio*IVA, pero su IVA varía según la calificación (rústico 4%, urbano
6% y urbanizable 8%). Después del cálculo imprimirá los datos de la
vivienda y a continuación el importe de compraventa.
     */
    public abstract String calcularPrecioCompraVenta();
}
