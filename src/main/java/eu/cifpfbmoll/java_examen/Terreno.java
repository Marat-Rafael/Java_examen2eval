/*
Clase Terreno. (0,5 puntos) Un terreno es una especialización de la clase
inmueble, y además de los atributos de la clase Inmueble, 
tiene los atributos
    tipo de calificación que únicamente puede ser rústico, urbano y urbanizable.

Esta clase implementa el constructor vacío, getters/setters y método toString.
 */
package eu.cifpfbmoll.java_examen;

/**
 *
 * @author Marat Rafael
 */
public class Terreno extends Inmueble{
    //atributos
    private String tipo;
    //constructor

    public Terreno() {
    }
    //getter/setter

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString()+" Terreno {" + "tipo=" + tipo + '}';
    }
    
}
