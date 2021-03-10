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
public class Terreno extends Inmueble{
    static Scanner scNum = new Scanner(System.in);
    static Scanner scString = new Scanner(System.in);
    //atributos
    private String tipoCalificacion;
    //constructor

    public Terreno() {
    }
    //getter/setter

    public String getTipoCalificacion() {
        return tipoCalificacion;
    }

    public void setTipoCalificacion(String tipo) {
        this.tipoCalificacion = tipo;
    }

    @Override
    public String toString() {
        return super.toString()+" Terreno {" + "tipo=" + tipoCalificacion + '}';
    }
    
    //resto metodos
    /*
    Añadir Terreno. (1 punto) 
    Llamará al método solicitar Datos (aparece en el punto F) y 
    devolverá un terreno que se añadirá a la lista de
    inmuebles. Este método pertenece a la clase Terreno.
    */
    public static Terreno añadirTerreno(){
        Terreno terreno = new Terreno();
        terreno.solicitarDatos();
        return terreno;
    }

    @Override
    public void solicitarDatos() {
        super.solicitarDatos();
        System.out.println("tipo Calificacion: ");
        this.setTipoCalificacion(scString.nextLine());       
    }
}
