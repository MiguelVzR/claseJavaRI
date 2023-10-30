/* 
ENUNCIADO 
=================================================================================================================================
Nos contrataron de una Libreria para ayudarlos a automatizar el proceso de Stock de Libros que hoy lo tienen hecho en una hoja de Excel. 
Para ello, nos indican que el sistema debe contener la siguiente información: 
ID Cliente:
Nombre del libro:
Genero:
Fecha de publicacion:
Estado de solicitud:

Calculos:
- Se requiere calcular, ademas, la Fecha actual del pedido que es Fecha de publicacion - Fecha Actual.
- Generar una segmentación en base al Estado de la Solicitud. Si el estado de la solicitud es "ENTREGADO" => "Cliente al día"
 "Paso fecha de entrega" => "El Cliente no esta al día"

Formato de TXT de salida:
ID Cliente:
Nombre del libro:
Genero:
Fecha de publicacion:
Estado de solicitud:
Fecha actual del pedido
Segmentacion
CONSIDERACIONES:
- El programa debe implementar 2 thread como minimo e indicar cual es el daemon y cual no lo es.  
================================================================================================================================
*/
package Examen;

import java.io.File;
import java.time.LocalDate;

public class Examen {
    public final static String DIRECTORIO_SALIDA = System.getProperty("user.dir") + "\\Examen\\";
    public final static String ARCHIVO_SALIDA = "resultados.txt";
    public static void main(String[] args) {
        //Si ya existe el archivo de salida lo borro
        File archivo = new File(DIRECTORIO_SALIDA + ARCHIVO_SALIDA);
        if(archivo.exists()){
            archivo.delete();
        }

        // Crear instancias de libros y almacenarlos en una lista
        Libro libro1 = new Libro(1, "Odisea en el Espacio", "Ficción", LocalDate.parse("2023-10-14"), "ENTREGADO");
        Libro libro2 = new Libro(2, "Romeo y Julieta", "Amor",  LocalDate.parse("2023-10-16"), "Paso fecha de entrega");
        Libro libro3 = new Libro(3, "El principito", "Narrativa",  LocalDate.parse("2023-09-14"), "Paso fecha de entrega");

        // Crear threads para procesar los libros
        Thread thread1 = new Thread(new ProcesadorLibro(libro1));
        Thread thread2 = new Thread(new ProcesadorLibro(libro2));
        Thread thread3 = new Thread(new ProcesadorLibro(libro3));

        // Hacemos que el thread1 sea un demonio
        thread1.setDaemon(true); 
        // thread2 es un thread normal (no demonio) por defecto, lo mismo que el tercero

        // Iniciar los threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
