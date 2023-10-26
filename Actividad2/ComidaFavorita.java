package Actividad2;

import java.io.Serializable;

public class ComidaFavorita implements Serializable{
    protected String nombreComida;
    protected String nombre;

    public ComidaFavorita(String nombreComida, String nombre ){
        this.nombreComida = nombreComida;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombreComida() {
        return nombreComida;
    }
    public void setNombreComida(String nombreComida) {
        this.nombreComida = nombreComida;
    }

    @Override
    public String toString() {
        return "ComidaFavorita{" +
            "nombreComida='" + nombreComida + '\'' +
            ", nombre='" + nombre + '\'' +
            '}';
    }
}
