import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ActMig1 {
    public static void main(String[] args) {
        // Const
        final String DIRECTORIO = "C:\\Users\\O008211\\Documents\\cursoJava";
        final String BARRERA = "\\";
        final String NOMBRE_ARCHIVO = "Salida.txt";

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
                    operacionesEnFile(archivo);
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

    private static void operacionesEnFile(File archivo){
    //Numero a realizar las operaciones:
        float x, y; 
        //Recepción de las operaciones
        float sum, rest, mult, div;
        //Para la maquetacion del contenido
        String contenido;
        //Inicializamos Scanner para recoger por consola los números del usuario
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cual es el primer número que se va a operar?");
        x = sc.nextFloat();
        System.out.println("¿Cual es el segundo número que se va a operar?");
        y = sc.nextFloat();
        sc.close();

        sum = suma(x, y);
        rest = resta(x, y);
        mult = multiplicacion(x, y);
        div = division(x, y);

        contenido = 
            "La suma ha dado:           " + sum  + "\n" +
            "La resta ha dado:          " + rest + "\n" +
            "La multiplicacion ha dado: " + mult + "\n" +
            "La division ha dado:       " + div;

        //Escritura de los ficheros
        FileWriter fw;
        try {
            fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter (fw);
            bw.write(contenido);
            bw.close(); 
        } catch (IOException e) {
            System.out.println("Se ha producido un problema con la escritura del archivo.");
            e.printStackTrace();
        }

}

    //Para varios argumentos asi:
    //private static float suma(float... x){} 
    //Sin embargo nos han dicho que son solo dos variables
    
    private static float suma(float x, float y){
        System.out.println( "Se procede con la división");
        //Se podria poner en la salida directamente, pero así queda más claro
        float z = x + y;
        return z;
    }

    private static float resta(float x, float y){
        System.out.println( "Se procede con la resta");
        //Se podria poner en la salida directamente, pero así queda más claro
        float z = x - y;
        return z;
    }

    private static float multiplicacion(float x, float y){
        System.out.println( "Se procede con la multiplicacion");
        //Se podria poner en la salida directamente, pero así queda más claro
        float z = x * y;
        return z;
    }
    private static float division(float x, float y){
        System.out.println( "Se procede con la divisón");
        //Se podria poner en la salida directamente, pero así queda más claro
        float z = x / y;
        return z;
    }
}
