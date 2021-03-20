/*
Clase Terreno. (0,5 puntos) Un terreno es una especialización de la clase
inmueble, y además de los atributos de la clase Inmueble, 
tiene los atributos
    tipo de calificación que únicamente puede ser rústico, urbano y urbanizable.

Esta clase implementa el constructor vacío, getters/setters y método toString.
 */
package eu.cifpfbmoll.java_examen;

import java.util.*;

/**
 *
 * @author Marat Rafael
 */
public class Terreno extends Inmueble {

    //constantes
    private final static float IVA_RUSTICO = 0.4f;
    private final static float IVA_URBANO = 0.6f;
    private final static float IVA_URBANIZABLE = 0.8f;

    static Scanner scNum = new Scanner(System.in);
    static Scanner scString = new Scanner(System.in);
    //atributos
    // tipoTerreno hace referencia a enum 
    private tipoTerreno tipoCalificacion;

    //constructor
    public Terreno() {
    }

    //getter/setter
    // devuelve enum tipoTerreno
    public tipoTerreno getTipoCalificacion() {
        return tipoCalificacion;
    }

    public void setTipoCalificacion(tipoTerreno tipoTerreno) {
        this.tipoCalificacion = tipoTerreno;
    }

    public void setTipoCalificacion() throws Exception{
        System.out.println("Tipo del terreno: ");
        System.out.println("1-rustico");
        System.out.println("2-urbano");
        System.out.println("3-urbanizable");
        byte opcionTipoTerreno = scNum.nextByte();
        switch (opcionTipoTerreno) {
            case 1:
                this.tipoCalificacion = tipoTerreno.RUSTICO;
                break;
            case 2:
                this.tipoCalificacion = tipoTerreno.URBANO;
                break;
            case 3:
                this.tipoCalificacion = tipoTerreno.URBANIZABLE;
            default:
                System.out.println("Error: tipo del terreno introducido no es correcto");
        }

    }

    @Override
    public String toString() {
        return super.toString() + " Terreno {" + "tipo=" + tipoCalificacion + '}' + calcularPrecioCompraVenta();
    }

    //resto metodos
    /*
    Añadir Terreno. (1 punto) 
    Llamará al método solicitar Datos (aparece en el punto F) y 
    devolverá un terreno que se añadirá a la lista de
    inmuebles. Este método pertenece a la clase Terreno.
     */
    public Terreno añadirTerreno() throws Exception{
        
        Terreno terreno = new Terreno();
        terreno.solicitarDatos();
        return terreno;
    }

    @Override
    public void solicitarDatos() throws Exception{
        super.solicitarDatos();
        System.out.println("tipo Calificacion: ");
        this.setTipoCalificacion();
    }

    /*
    Para el caso de los terrenos, su precio de compraventa será de
precio*IVA, pero su IVA varía según la calificación (rústico 4%, urbano
6% y urbanizable 8%). Después del cálculo imprimirá los datos de la
vivienda y a continuación el importe de compraventa.
     */
    @Override
    public String calcularPrecioCompraVenta() {
        double precioConIva = 0;  

        switch (this.getTipoCalificacion()) {
            case RUSTICO:
                precioConIva = this.getPrecio() + (this.getPrecio() * IVA_RUSTICO);
                break;
            case URBANO:
                precioConIva = this.getPrecio() + (this.getPrecio() * IVA_URBANO);
                break;
            case URBANIZABLE:
                precioConIva = this.getPrecio() + (this.getPrecio() * IVA_URBANIZABLE);
                break;
        }           
        String precioFinal = "Precio del terreno con iva: " + Math.round(precioConIva)*100/100;
        return precioFinal;
    }
}
