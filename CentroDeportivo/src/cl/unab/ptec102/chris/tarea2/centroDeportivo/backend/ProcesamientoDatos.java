package cl.unab.ptec102.chris.tarea2.centroDeportivo.backend;

import java.util.ArrayList;
import java.util.Objects;

/*
    ProcesamientoDatos es la clase encargada de integrar correctamente
    la lectura del archivo asociado al programa.
*/
public class ProcesamientoDatos {
    public ProcesamientoDatos(ColeccionEjercicio laColeccion) {
        ArrayList<String[]> datos;
        datos = LecturaArchivo.leerArchivo("ejercicios.csv");

        for (String[] fila : datos) {

            int codigo = Integer.parseInt(fila[0]);
            String nombre = fila[1];
            String tipo = fila[2];
            String atributoExtra = fila[3];
            String intensidad = fila[4];
            int tiempo = Integer.parseInt(fila[5]);
            String descripcion = fila[6];
            int semana = Integer.parseInt(fila[7]);

            // Filtramos por tipo de ejercicio y creamos el objeto.
            if (Objects.equals(tipo, "Cardiovascular")) {
                EjercicioCardiovascular nuevoEjCardio = new EjercicioCardiovascular(
                        codigo,
                        nombre,
                        tipo,
                        intensidad,
                        tiempo,
                        descripcion,
                        semana,
                        atributoExtra
                );

                laColeccion.setEjercicios(nuevoEjCardio);

            } else {
                EjercicioFuerza nuevoEjFuerza = new EjercicioFuerza(
                        codigo,
                        nombre,
                        tipo,
                        intensidad,
                        tiempo,
                        descripcion,
                        semana,
                        atributoExtra
                );

                laColeccion.setEjercicios(nuevoEjFuerza);
            }
        }
    }
}
