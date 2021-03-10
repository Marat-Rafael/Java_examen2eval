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
        this.metrosCuadrados = metrosCuadrados;
        this.precio = precio;
        this.poblacion = poblacion;

    }

    //constructor copia
    public Inmueble(Inmueble inmueble) {
        ID++;
        idInmueble = ID;
        this.metrosCuadrados = inmueble.metrosCuadrados;
        this.precio = inmueble.precio;
        this.poblacion = inmueble.poblacion;
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

}
