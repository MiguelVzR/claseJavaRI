package Actividad6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String DIR_FICHEROS = System.getProperty("user.dir") + "\\Actividad6\\";
        final String FICHERO_ENTRADA = "AplicacionesGoogle.txt";
        final String FICHERO_SALIDA = "output_proceso_google.txt";
        //Ver ruta de ficheros
        System.out.println((DIR_FICHEROS + FICHERO_ENTRADA) + "\n" + (DIR_FICHEROS + FICHERO_SALIDA));

        List<App> apps = leerFichero(DIR_FICHEROS + FICHERO_ENTRADA);
        escribirFichero(DIR_FICHEROS + FICHERO_SALIDA, apps);
    }    

    private static void escribirFichero(String ruta, List<App> applications){
        // Crear un hilo para escribir el fichero de salida
        Thread hilo = new Thread(() -> {
            try {
                File file = new File(ruta);
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                //El formato es el de un toString
                for (App app : applications) {
                    writer.write(app.toString());
                    writer.newLine();
                }
                writer.close();
            } catch (IOException e) {
                System.err.println("Error al escribir el fichero de salida: " + e.getMessage());
            }
        });

        // Iniciar el hilo de escritura y esperar a que termine
        hilo.setDaemon(false);
        hilo.start();
        try {
            hilo.join();
        } catch (InterruptedException e) {
            System.err.println("Error al esperar a que el hilo de escritura termine: " + e.getMessage());
        }

        // La aplicación no termina hasta que el hilo de escritura haya finalizado
    }

    private static List<App> leerFichero(String ruta){          
        List<App> applications = new ArrayList<>();

        File file = new File(ruta);  
        try {
            // Leer el fichero de entrada y cargar los datos de las aplicaciones
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            //Vamos a hacerlo con el constructor grande en vez de con setters asi que vamos a
            //poner las variables temporales
                //Nombre lo inicializamos como "" para hacer una bandera y despues de la primera vez dado que va a cambiar el nombre
                //ir guardando las nuevas aplicaciones en la lista
            String name = "";
                //Usuarios y coste mensual lo inicializamos por si acaso el formato del archivo viene mal, sim embargo
                //Este programa no esta recogiendo el fallo de que en un futuro los usuarios o el coste mensual vengan mal despues de uno que ha 
                //venido bien, por lo que el objeto se relleneria incorrectamente con los datos del anterior 
                //TODO solucionar lo anterior
            int users = 0;
            double monthlyCost = 0;

            //Buscamos con REGEX por tema de tildes.
            //TODO Poner en constantes las REGEX
            while ((line = reader.readLine()) != null) {
                System.out.println(line+ "F  L") ;
                //Es nombre
                if (line.matches("Aplicaci.n: .*")) {
                    //Como se ha explicado arriba aqui comprobamos la bandera de nombre
                    if (!name.equals("")) {
                        applications.add(new App(name,users,monthlyCost));
                    }
                    name = line.substring(12);
                //Es Usuarios
                } else if (line.matches("Cantidad.*")) {
                    users = Integer.parseInt(line.substring(19));
                //Es Coste Mens
                } else if (line.matches("Costo Mensual.*")) {
                    monthlyCost = Double.parseDouble(line.substring(15));
                }
            }
            //Ya no queda mas que leer del archivo y
            //como se ha explicado arriba aqui comprobamos la bandera de si el nombre es ""
            //esto podria pasar si el archivo esta vacio
            if (!name.equals("")) {
                applications.add(new App(name,users,monthlyCost));
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error al leer el fichero de entrada: " + e.getMessage());
        }
        System.out.println("Las apps generadas: " + applications.toString());
        return applications;
    }
}
