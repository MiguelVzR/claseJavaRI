package Actividad3;

import java.io.File;

public class Actividad3Main {
    public static void main(String[] args) {
        //File a escribir
        final String DIRECTORIO = System.getProperty("user.dir");
        final String BARRERA = "\\";
        final String NOMBRE_ARCHIVO = "Salida.txt";

        File file = new File(DIRECTORIO+BARRERA+NOMBRE_ARCHIVO);

        Empleado emp = new Empleado("APX13", "Desarrollador", 7, 24000.34f ,"Miguel", "Vizan", "Salamanca", "14/10/2002");
        Empleado.imprimirEmpleado(file, emp);
    }
}
