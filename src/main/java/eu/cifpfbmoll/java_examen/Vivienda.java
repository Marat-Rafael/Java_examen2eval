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

    // usar setters!!!
    // constructor copia
    public Vivienda(Vivienda vivienda) {
        super(vivienda.getMetrosCuadrados(), vivienda.getPrecio(), vivienda.getPoblacion());
        this.setDescripcion(descripcion);
        this.setNumHabitaciones(numHabitaciones);
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
        return super.toString() + " Vivienda {" + "numHabitaciones=" + numHabitaciones + ", descripcion=" + descripcion + '}' + calcularPrecioCompraVenta();
    }

    public Vivienda añadirVivienda() {
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

    /**
     * En el caso de la clase Vivienda los impuestos vendrán dados por el
     * cálculo: precio * IVA que es de un 10%, después del cálculo imprimirá los
     * datos de la vivienda y a continuación el importe de compraventa.
     *
     * @return
     */
    @Override
    public String calcularPrecioCompraVenta() {
        String info = "El precio con iva es: ";
        double precio = this.getPrecio() + (this.getPrecio() * 0.1);
        return info + precio;
    }
}
