/*
Clase Inmobiliaria.(0,5 puntos) Se caracteriza por tener una 
    lista de Inmuebles, 
    nombre de la inmobiliaria 
    CIF de la inmobiliaria. 
Esta clase implementa constructor vacío, getters/setters y método toString.
 */
package eu.cifpfbmoll.java_examen;

import java.util.ArrayList;

/**
 *
 * @author Marat Rafael
 */
public class Inmobiliaria {
    //atributos
    private ArrayList<Inmueble> listaEnmuebles = new ArrayList<>();
    private String nombreInmobiliaria;
    private String cifInmobiliaria;

    //Constructor

    public Inmobiliaria() {
    }

    // getter/setter
    public ArrayList<Inmueble> getListaEnmuebles() {
        return listaEnmuebles;
    }

    public void setListaEnmuebles(ArrayList<Inmueble> listaEnmuebles) {
        this.listaEnmuebles = listaEnmuebles;
    }

    public String getNombreInmobiliaria() {
        return nombreInmobiliaria;
    }

    public void setNombreInmobiliaria(String nombreInmobiliaria) {
        this.nombreInmobiliaria = nombreInmobiliaria;
    }

    public String getCifInmobiliaria() {
        return cifInmobiliaria;
    }

    public void setCifInmobiliaria(String cifInmobiliaria) {
        this.cifInmobiliaria = cifInmobiliaria;
    }

    @Override
    public String toString() {
        return "Inmobiliaria{" + "listaEnmuebles=" + listaEnmuebles + ", nombreInmobiliaria=" + nombreInmobiliaria + ", cifInmobiliaria=" + cifInmobiliaria + '}';
    }
    
    public void mostrarTodadInmobiliarias(ArrayList<Inmobiliaria>listaInmobiliarias){
        for (Inmobiliaria inmo : listaInmobiliarias) {
            System.out.println(inmo);
        }
    }
}
