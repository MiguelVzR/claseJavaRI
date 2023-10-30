package Examen;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ProcesadorLibro implements Runnable {
    private Libro libro;

    public ProcesadorLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public void run() {
        // Obtiene la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Calcula la diferencia en días
        long diferenciaEnDias = ChronoUnit.DAYS.between(libro.getFechaPublicacion(),fechaActual );

        //Esta Segmentación se calcula cuando se imprime el resultado, debido a que tambien deberia tenerse en cuenta si se ha 
        //pasado la diferencia de dias, cosa que en el enunciado no se tiene en cuenta
        String segmentacion = 
            libro.getEstadoSolicitud().equals("ENTREGADO") ? 
            "Cliente al día" : 
            "El Cliente no está al día"
        ;

        // Genera el formato de salida en TXT
        String resultado = libro.toString() +
                        "\nDia actual: " + fechaActual +
                        "\nDiferencia de dias: " + diferenciaEnDias +
                        "\nSegmentación: "  + segmentacion + "\n";

        

        // Escribe el resultado en el archivo de salida, importante el append true, para no comerte los resultados anteriores
        try (FileWriter writer = new FileWriter(Examen.DIRECTORIO_SALIDA + Examen.ARCHIVO_SALIDA, true)) {
            writer.write(resultado);
            writer.write("\n\n"); // Agrega una línea en blanco para separar resultados
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}