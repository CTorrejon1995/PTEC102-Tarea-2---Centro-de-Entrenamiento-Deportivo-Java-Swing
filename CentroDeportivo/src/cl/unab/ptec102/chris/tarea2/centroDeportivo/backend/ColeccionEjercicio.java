package cl.unab.ptec102.chris.tarea2.centroDeportivo.backend;

import java.util.ArrayList;
import java.util.Objects;

public class ColeccionEjercicio {
    private ArrayList<Ejercicio> ejercicios;

    // CONSTRUCTOR
    public ColeccionEjercicio() {
        this.ejercicios = new ArrayList<>();
    }

    // GETTERS
    public ArrayList<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    // SETTERS
    public void setEjercicios(Ejercicio unEjercicio) {
        this.ejercicios.add(unEjercicio);
    }

    // OTROS MÉTODOS

    // cantidadEjerciciosTotal devuelve el tiempo total que existe en el conjuto de datos.
    public int cantidadEjerciciosTotal() {
        return this.ejercicios.size();
    }

    public int tiempoTotal() {
        int tiempo = 0;

        // Recorremos todos los ejercicios disponibles.
        for (Ejercicio ejercicio : this.ejercicios) {
            tiempo += ejercicio.getTiempoEstimado();
        }

        // Retornamos el tiempo que le tomaría a alguien hacer todos los ejercicios.
        return tiempo;
    }

    // cantidadEjercicioTipo cuenta la cantidad de ejercicios disponibles por tipo.
    public int[] cantidadEjercicioTipo() {
        int cantCardio = 0;
        int cantFuerza = 0;

        // Contamos la cantidad de ejercicios cardiovascular.
        for (Ejercicio ejercicio : this.ejercicios) {
            if (Objects.equals(ejercicio.getTipoEjercicio(), "Cardiovascular")) {
                cantCardio += 1;
            }
        }

        // Realizamos la resta y nos queda el resto.
        cantFuerza = this.ejercicios.size() - cantCardio;

        return new int[] {cantCardio, cantFuerza};
    }

    // cantidadEjercicioNivel cuenta la cantidad de ejercicios por nivel de intensidad.
    public int[] cantidadEjercicioNivel() {
        int basico = 0;
        int intermedio = 0;
        int avanzado = 0;
        int altoRendimiento = 0;

        // Recorriendo los ejercicios discriminamos con un switch.
        for (Ejercicio ejercicio : this.ejercicios) {
            switch (ejercicio.getNivelIntensidad().toLowerCase()) {
                case "básico": {
                    basico += 1;
                    break;
                }
                case "intermedio": {
                    intermedio += 1;
                    break;
                }
                case "avanzado": {
                    avanzado += 1;
                    break;
                }
                case "alto rendimiento": {
                    altoRendimiento += 1;
                    break;
                }
            }
        }

        // Retornamos el conteo en una lista.
        return new int[] {basico, intermedio, avanzado, altoRendimiento};
    }

    // caracteristicasDatos sirve para mostrar las caracteristicas de la base de datos.
    public String caracteristicasDatos() {
        int[] tipo = cantidadEjercicioTipo();
        int[] nivel = cantidadEjercicioNivel();

        // Variables locales.
        String total = "Cantidad total de ejercicios: " + this.cantidadEjerciciosTotal();
        String tiempoTotal = "Tiempo total disponible: " + this.tiempoTotal() + "min";

        String cantTipoEjercicios =
                "Cantidad de ejercicios Cardiovasculares: " + tipo[0] + "\n" +
                "Cantidad de ejercicios de Fuerza: " + tipo[1];

        String cantNivelEjercicio =
                "Cantidad de ejercicios Básicos: " + nivel[0] + "\n" +
                "Cantidad de ejercicios Intermedios: " + nivel[1] + "\n" +
                "Cantidad de ejercicios Avanzados: " + nivel[2] + "\n" +
                "Cantidad de ejercicios Alto rendimiento: " + nivel[3];

        // Retornamos el formato para mostrar las características.
        return
                "------------------------------------------------------------------------" + "\n" +
                total + "\n" +
                tiempoTotal + "\n" +
                "------------------------------------------------------------------------" + "\n" +
                cantTipoEjercicios + "\n" +
                "------------------------------------------------------------------------" + "\n" +
                cantNivelEjercicio + "\n" +
                "------------------------------------------------------------------------"
                ;
    }
}