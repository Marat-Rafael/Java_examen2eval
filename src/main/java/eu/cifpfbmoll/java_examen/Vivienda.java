/*
Clase Vivienda. (0,5 puntos) Una vivienda es una especialización de la clase
vivienda, y además de los atributos de la clase Inmueble, tiene los atributos
    número de habitaciones y 
    descripción. 
Esta clase implementa el constructor vacío, constructor copia getters/setters y método toString. 
Debemos controlar que cuando se soliciten los datos de una vivienda, 
esta debe tener al menos una habitación, 
de lo contrario solicitará al usuario de nuevo el número de habitaciones.
 */
package eu.cifpfbmoll.java_examen;


import java.util.*;

/**
 *
 * @author Marat Rafael
 */
public class Vivienda extends Inmueble {

    private int numHabitaciones;
    private String descripcion;

    //constructor
    //constructor vacio
    public Vivienda() {
    }

    //constructor copia
    public Vivienda(Vivienda vivienda) {
        super(vivienda.getMetrosCuadrados(), vivienda.getPrecio(), vivienda.getPoblacion());
        this.numHabitaciones = vivienda.numHabitaciones;
        this.descripcion = vivienda.descripcion;
    }

    //getter/setter
    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        Scanner scNum = new Scanner(System.in);
        while (numHabitaciones < 1) {
            System.out.println("Debe tener al menos una habitación");
            this.numHabitaciones = scNum.nextInt();
        }
        this.numHabitaciones = numHabitaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //toString

    @Override
    public String toString() {
        return super.toString() + " Vivienda {" + "numHabitaciones=" + numHabitaciones + ", descripcion=" + descripcion + '}';
    }

    public Vivienda añadirInmobiliaria() {
        Vivienda vivienda = new Vivienda();
        vivienda.solicitarDatos();
        return vivienda;
    }

    @Override
    public void solicitarDatos() {
        super.solicitarDatos();
        System.out.println("Numero habitaciones: ");
        this.setNumHabitaciones(scNum.nextInt());
        System.out.println("Descripcion:");
        this.setDescripcion(scString.nextLine());
    }

    /*
    Buscar Vivienda. (1,5 puntos) Recibirá como parámetro una lista de
    Inmuebles y solicitará al usuario un número de habitaciones. El método
    mostrará toda la información de todas aquellas Viviendas que
    cumplan con el criterio: número de habitaciones. Este método
    pertenece a la clase Inmueble.
     */

    public static void buscarVivienda(ArrayList<Inmueble>listaInmuebles){
        
    }
}
