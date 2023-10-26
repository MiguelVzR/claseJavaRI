package Actividad3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Empleado extends Persona implements Operaciones, Serializable{
    private String idEmpleado;
    private String cargo;
    private float antiguedadLab;
    private float sueldoSinDesc;
    private float sueldoFinal;

    public Empleado(String idEmpleado, String cargo, float antiguedadLab, float sueldoSinDesc, String nombre, String apellido, String ciudad, String fechaDeNacimiento) {
        super(nombre, apellido, ciudad, fechaDeNacimiento);
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
        this.antiguedadLab = antiguedadLab;
        this.sueldoSinDesc = sueldoSinDesc;
        calculoSueldoFinal();
    }
    public String getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public float getAntiguedadLab() {
        return antiguedadLab;
    }
    public void setAntiguedadLab(float antiguedadLab) {
        this.antiguedadLab = antiguedadLab;
    }
    public float getSueldoSinDesc() {
        return sueldoSinDesc;
    }
    public void setSueldoSinDesc(float sueldoSinDesc) {
        this.sueldoSinDesc = sueldoSinDesc;
    }
    public float getSueldoFinal() {
        return sueldoFinal;
    }
    public void setSueldoFinal(float sueldoFinal) {
        this.sueldoFinal = sueldoFinal;
    }
    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado='" + idEmpleado + '\'' +
                ", cargo='" + cargo + '\'' +
                ", antiguedadLab=" + antiguedadLab +
                ", sueldoSinDesc=" + sueldoSinDesc +
                ", sueldoFinal=" + sueldoFinal +
                ", " + super.toString() +
                '}';
    }
    //En el enunciado ponia dividido aunque yo creo que es incorrecto y deberia ser multiplicado por los descuentos o impuestos
    @Override
    public void calculoSueldoFinal() {
        this.sueldoFinal= this.sueldoSinDesc / IMPUESTOS;
    }

    public static void imprimirEmpleado(File f, Empleado e){
/*         try {
            //Como objeto
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(e);
            oos.close();
        } catch (Exception k) {
            k.printStackTrace();
        } */
        //Como toString 
        FileWriter fw;
        try {
            fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter (fw);
            bw.write(e.toString());
            bw.close(); 
        } catch (IOException k) {
            System.out.println("Se ha producido un problema con la escritura del archivo.");
            k.printStackTrace();
        }
    }
}
