package cl.unab.ptec102.chris.tarea2.centroDeportivo.backend;

import java.util.ArrayList;
import java.util.Objects;

/*
    Orquestador es el principal controlador del
    programa, encargado de preservar la integridad
    de los datos, junto a la correcta creación de
    una rutina de entrenamiento.
*/
public class Orquestador {
    /*
        ejercicioDisponibles se encarga de discriminar los ejercicios
        no disponibles para un cliente en una semana según ciertas
        reglas de negocio.
    */
    public ColeccionEjercicio ejerciciosDisponibles(
            ColeccionEjercicio ejercicios,
            ColeccionRutina rutinas,
            int semana,
            int cliente
    ) {
            ColeccionEjercicio ejerciciosDisponibles = new ColeccionEjercicio();
            ArrayList<Ejercicio> ejerciciosProhibidos = new ArrayList<>();

            /*
                Con el siguiente for nos aseguramos de obtener los ejercicios
                no disponibles para un cliente en caso de que se repitan para
                la siguiente semana
            */
            for (Rutina rutina : rutinas.getRutinas()) {
                if (Objects.equals(rutina.getCliente(), cliente) && rutina.getUltimaSemana() == semana - 1) {
                    ejerciciosProhibidos = rutina.getEjercicios();
                    break;
                }
            }

            // Discriminamos los ejercicios prohibidos e indicamos que no se deben usar.
            for (Ejercicio ejercicio : ejercicios.getEjercicios()) {
                boolean prohibido = false;

                for (Ejercicio ej : ejerciciosProhibidos) {
                    if (ejercicio.getCodigoIdentificador() == ej.getCodigoIdentificador()) {
                        // En esta sección indicamos que no se pueden usar.
                        prohibido =  true;
                        break;
                    }
                }

                // En caso de que se puedan usar, se agregan a los ejercicios disponibles.
                if (!prohibido) {
                    ejerciciosDisponibles.setEjercicios(ejercicio);
                }
            }

            // Retornamos los ejercicios disponibles para un cliente en una semana.
            return ejerciciosDisponibles;
    }

    /*
        factibilidad se encarga de asegurar que la cantidad de ejercicios disponible por tipo
        y nivel solicitados por el usuario se pueda satisfacer.
    */
    public boolean factibilidad(ColeccionEjercicio ejercicios, int cantidad, String tipo, String nivelIntensidad) {
        int contador = 0;

        for (Ejercicio ejercicio : ejercicios.getEjercicios()) {
            // Contamos la cantidad de ejercicios por nivel y tipo.
            if (Objects.equals(ejercicio.getTipoEjercicio(), tipo) && Objects.equals(ejercicio.getNivelIntensidad(), nivelIntensidad)) {
                contador ++;
            }
        }

        // Retornamos la condición de factibilidad, devolverá true en caso de que sea posible, false si no.
        return contador >= cantidad;
    }

    /*
        filtro se encarga exclusivamente de rellenar la rutina que se desea crear
        correctamente, verificando el criterio de factibilidad y categorizando los
        datos correctamente.
    */
    public void filtro (
            ColeccionEjercicio ejercicios,
            Rutina rutina,
            int idCliente,
            int ultimaSemana,
            int[] cantTipo,
            String nivelIntensidad,
            String[] tipo,
            boolean factible
    ) {

        // Verificamos la factibilidad del caso.
        if (factible) {

            // Recorremos la cantidad de tipos de ejercicios que existen.
            for (int i = 0; i < tipo.length; i++) {
                int contador = 0;

                for (Ejercicio ejercicio : ejercicios.getEjercicios()) {

                    // Clasificamos correctamente los datos, por tipo, nivel y que no supere la cantidad solicitada.
                    if (Objects.equals(ejercicio.getTipoEjercicio(), tipo[i]) &&
                            Objects.equals(ejercicio.getNivelIntensidad(), nivelIntensidad) &&
                            contador < cantTipo[i]) {

                        rutina.setCliente(idCliente);
                        rutina.setEjercicios(ejercicio);
                        rutina.setTiempoTotal(ejercicio.getTiempoEstimado());
                        rutina.setUltimaSemana(ultimaSemana);

                        // Limitador.
                        contador++;
                    }
                }
            }
        }
    }

    /*
        existeRutina se encarga exclusivamente de imposibilitar al usuario de
        crear una misma rutina más de una vez en una misma semana y para un
        mismo cliente.
    */
    public boolean existeRutina(ColeccionRutina rutinas, Rutina nuevaRutina) {
        for (Rutina rutina : rutinas.getRutinas()) {
            // Verificamos si el usuario y semana son iguales en la colección entera.
            if (
                    rutina.getCliente() == nuevaRutina.getCliente() &&
                            rutina.getUltimaSemana() == nuevaRutina.getUltimaSemana()
            ) {
                // Partimos con la hipótesis de que ambas rutinas tienen la misma cantidad de ejercicios.
                if (
                        rutina.getEjercicios().size() ==
                                nuevaRutina.getEjercicios().size()
                ) {
                    boolean iguales = true;

                    // Recorremos ambas rutinas.
                    for (int i = 0; i < rutina.getEjercicios().size(); i++) {
                        Ejercicio e1 = rutina.getEjercicios().get(i);
                        Ejercicio e2 = nuevaRutina.getEjercicios().get(i);

                        // Verificamos si todos los ejercicios son iguales.
                        if (
                                e1.getCodigoIdentificador() !=
                                        e2.getCodigoIdentificador()
                        ) {
                            // Si no todos son iguales, no es la misma rutina.
                            iguales = false;
                            break;
                        }
                    }

                    // Si son iguales, retornamos true.
                    if (iguales) {
                        return true;
                    }
                }
            }
        }

        // Si no, false.
        return false;
    }

    /*
        crearRutina se encarga de juntar las funciones anteriormente descritas
        y crear correctamente la nueva rutina y guardarla en la colección de
        rutinas.
    */
    public String crearRutina(
            ColeccionEjercicio ejercicios,
            ColeccionRutina rutinas,
            int idCliente,
            int ultimaSemana,
            int[] cantTipo,
            String nivelIntensidad
    ) {
        Rutina rutina = new Rutina();
        ColeccionEjercicio ejerciciosAux = new ColeccionEjercicio();
        String[] tipo = {"Cardiovascular", "Fuerza"};
        boolean factible;

        // Si la colección de rutinas no está vacía, debemos discriminar los posibles ejercicios no disponibles.
        if (!rutinas.getRutinas().isEmpty()) {
            ejerciciosAux = ejerciciosDisponibles(ejercicios, rutinas, ultimaSemana, idCliente);

        } else {
            ejerciciosAux = ejercicios;
        }

        // Una vez filtrado los ejercicios disponibles, verificamos si es factible y filtramos.
        factible = factibilidad(
                ejerciciosAux, cantTipo[0], tipo[0], nivelIntensidad) &&
                factibilidad(ejerciciosAux, cantTipo[1], tipo[1], nivelIntensidad);
        filtro(ejerciciosAux, rutina, idCliente, ultimaSemana, cantTipo, nivelIntensidad, tipo, factible);

        // Verificamos si es posible crear la rutina.
        if (!rutina.getEjercicios().isEmpty()) {

            // Verificamos que no sea una rutina duplicada.
            if (!existeRutina(rutinas, rutina)) {
                rutinas.setRutinas(rutina);

                return "Rutina creada con éxito.";
            } else {
                return "Esa rutina ya existe.";
            }

        } else {
            return "No fue posible crear una rutina con esos requisitos.";
        }
    }
}