package cl.unab.ptec102.chris.tarea2.centroDeportivo.backend;

import java.util.ArrayList;
import java.util.Objects;

public class Rutina {
    private ArrayList<Ejercicio> ejercicios;
    private int cliente;
    private int tiempoTotal;
    private int ultimaSemana;

    // CONSTRUCTOR
    public Rutina() {
        ejercicios = new ArrayList<>();
    }

    // GETTERS
    public ArrayList<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public int getCliente() {
        return cliente;
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public int getUltimaSemana() {
        return ultimaSemana;
    }

    // SETTERS
    public void setEjercicios(Ejercicio unEjercicio) {
        this.ejercicios.add(unEjercicio);
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public void setTiempoTotal(int tiempoTotal) {
        this.tiempoTotal += tiempoTotal;
    }

    public void setUltimaSemana(int ultimaSemana) {
        this.ultimaSemana = ultimaSemana;
    }

    // OTROS MÉTODOS

    // cantidadEjercicioTipo cuenta la cantidad de ejercicios existentes por tipo.
    public int[] cantidadEjercicioTipo() {
        int cantCardio = 0;
        int cantFuerza = 0;

        // Contamos los ejercicios cardiovasculares
        for (Ejercicio ejercicio : this.ejercicios) {
            if (Objects.equals(ejercicio.getTipoEjercicio(), "Cardiovascular")) {
                cantCardio += 1;
            }
        }

        // Y el resto es la resta.
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

    // mostrarCaracteristicas se utiliza en la VentanaResumenRutina.
    public String mostrarCaracteristicas() {
        int[] cantTipo = cantidadEjercicioTipo();
        int[] cantNivel = cantidadEjercicioNivel();

        // Formato visual.
        return
                "------------------------------------------------------------------------" + "\n" +
                "Cantidad de Ejercicios Cardiovascular: " + cantTipo[0] + "\n" +
                "Cantidad de Ejercicios Cardiovascular: " + cantTipo[1] + "\n" +
                "------------------------------------------------------------------------" + "\n" +
                "Cantidad de Ejercicios Básicos: " + cantNivel[0] + "\n" +
                "Cantidad de Ejercicios Intermedio: " + cantNivel[1] + "\n" +
                "Cantidad de Ejercicios Avanzado: " + cantNivel[2] + "\n" +
                "Cantidad de Ejercicios Alto Rendimiento: " + cantNivel[3] + "\n" +
                "------------------------------------------------------------------------" + "\n" +
                "Tiempo total: " + this.tiempoTotal + "min"
                ;
    }
}