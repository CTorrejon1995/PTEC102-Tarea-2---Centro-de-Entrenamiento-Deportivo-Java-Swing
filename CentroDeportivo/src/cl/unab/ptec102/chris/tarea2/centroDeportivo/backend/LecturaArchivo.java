package cl.unab.ptec102.chris.tarea2.centroDeportivo.backend;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
    LecturaArchivo se encarga de tomar la url asociada al archivo de datos,
    leer archivo línea por línea y finalmente retornar un ArrayList<> con
    los datos de tipo String[].
*/
public class LecturaArchivo {

    public static ArrayList<String[]> leerArchivo(String nombreArchivo) {
        ArrayList<String[]> datos = new ArrayList<>();

        try {
            // Leemos y escaneamos el archivo.
            File archivo = new File(nombreArchivo);
            Scanner lector = new Scanner(archivo);
            boolean primeraLinea = true;

            while (lector.hasNextLine()) {

                String linea = lector.nextLine();

                // Discriminamos el título de los datos.
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                // Separamos por ",".
                String[] partes = linea.split(",");
                datos.add(partes);
            }

            lector.close();

        } catch (Exception e) {
            // En caso de que no se encuentre el link, se informa.
            IO.println("Error leyendo archivo");
        }

        return datos;
    }
}