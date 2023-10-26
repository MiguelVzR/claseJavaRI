package Actividad3;

import java.io.Serializable;

public class Persona implements Serializable{
    private String nombre;
    private String apellido;
    private String ciudad;
    //Esto serioa mas correcto utiizando una clase como Date.
    private String fechaDeNacimiento;

    public Persona(String nombre, String apellido, String ciudad, String fechaDeNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString(){
        return "Nombre: " + this.nombre + " Apellido: " + this.apellido + " Ciudad: " + this.ciudad + " Fecha de Nacimiento: " + this.fechaDeNacimiento;
    }
}
