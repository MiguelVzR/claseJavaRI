package Actividad2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Act2Main extends ComidaFavorita implements Serializable {
    private String apellido;
    private String puestoLaboral;
    private String ciudad;


    public Act2Main(String nombreComida, String nombre, 
        String apellido, String puestoLaboral, String ciudad) {
        super(nombre, nombreComida);
        this.apellido = apellido;
        this.puestoLaboral = puestoLaboral;
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Act2Main{" +
            "apellido='" + apellido + '\'' +
            ", puestoLaboral='" + puestoLaboral + '\'' +
            ", ciudad='" + ciudad + '\'' +
            ", " + super.toString() +
            '}';
    }
    public static void main(String[] args) {
        //File a escribir
        final String DIRECTORIO = System.getProperty("user.dir");
        final String BARRERA = "\\";
        final String NOMBRE_ARCHIVO = "Salida.txt";

        System.out.println("Directorio: " + DIRECTORIO);
          //Creamos el directorio
        File directorioC = new File (DIRECTORIO); 
        directorioC.mkdir();
        if (directorioC.exists()){
            System.out.println("El directorio ha sido creado con exito o ya existia.");
            File archivo = new File(DIRECTORIO + BARRERA + NOMBRE_ARCHIVO);
            //Se procede a la creacion si el archivo no existe
            if (!archivo.exists()){
                try {
                    archivo.createNewFile();
                    System.out.println("Se creo correctamente el archivo");
                    writeFields(archivo);
                } catch (IOException e) {
                    System.out.println("No se creo correctamente");
                    e.printStackTrace();
                }
            } else {
                System.out.println("El archivo ya existe," +
                    "compruebe que no tiene información inportante y borrelo en" +
                    "caso de querer ejecutar el programa");
            }
        } else {
            System.out.println("El directorio no existe, ha habido un problema con la creación del mismo.");
        }

    }


    private static void writeFields(File archivo) {
        //Rellenamos el constructor con los diferentes campos
        Act2Main persona = new Act2Main("Manzana", "Miguel", "Vizan Ramos", "Desarrollador", "Madrid");
        try {
            //Como objeto
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(persona);
            oos.close();
        } catch (Exception k) {
            k.printStackTrace();
        }
        //Como toString 
/*         FileWriter fw;
        try {
            fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter (fw);
            bw.write(persona.toString());
            bw.close(); 
        } catch (IOException e) {
            System.out.println("Se ha producido un problema con la escritura del archivo.");
            e.printStackTrace();
        } */
    }
}
