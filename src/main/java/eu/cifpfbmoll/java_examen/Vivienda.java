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

import java.util.Scanner;

/**
 *
 * @author Marat Rafael
 */
public class Vivienda extends Inmueble {

    private byte numHabitaciones;
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

    public void setNumHabitaciones(byte numHabitaciones) {
        Scanner scNum = new Scanner(System.in);
        while (numHabitaciones < 1) {
            System.out.println("Debe tener al menos una habitación");
            this.numHabitaciones = scNum.nextByte();
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

}
