package cl.unab.ptec102.chris.tarea2.centroDeportivo.backend;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class ColeccionRutina {
    private ArrayList<Rutina> rutinas;

    // CONSTRUCTOR
    public ColeccionRutina() {
        this.rutinas = new ArrayList<>();
    }

    // GETTERS
    public ArrayList<Rutina> getRutinas() {
        return this.rutinas;
    }

    // SETTERS
    public void setRutinas(Rutina unaRutinas) {
        this.rutinas.add(unaRutinas);
    }

    // OTROS MÉTODOS

    // mostrarInformacionClientes se utiliza para mostrar los clientes disponibles en VentanaBuscarRutina.
    public String mostrarInformacionClientes() {
        ArrayList<Integer> clientes = new ArrayList<>();
        String listadoClientes = "";

        // Obtenemos todos los clientes existentes en las rutinas.
        for (Rutina rutina : this.rutinas) {
            clientes.add(rutina.getCliente());
        }

        // Nos quedamos con los valores no repetidos o únicos.
        Set<Integer> clientesUnicos = new LinkedHashSet<>(clientes);

        // Finalmente, guardamos en el String los clientes con ese formato.
        for (int cliente : clientesUnicos) {
            listadoClientes += "ID Cliente: " + cliente + "\n";
        }

        // Retornamos el listado de clientes.
        return listadoClientes;
    }

    // mostrarInformacionRutinas() sirve para mostrar las rutinas de un cliente en VentanaBuscarRutina.
    public String mostrarInformacionRutinas(int idCliente) {
        String listadoRutinas = "";
        int contador = 0;

        // Recorremos todas las rutinas creadas.
        for (Rutina rutina : this.rutinas) {
            // Filtramos por cliente.
            if (rutina.getCliente() == idCliente) {
                contador++;

                // Creamos el formato para mostrar la información de una rutina de un cliente.
                listadoRutinas += contador + ". Ejercicio Datos:" + "\n" +
                        "Cantidad de Ejercicios: " + rutina.getEjercicios().size() + "\n" +
                        "Tiempo total: " + rutina.getTiempoTotal() + "min" + "\n" +
                        "Ultima semana de entrenamiento: " + rutina.getUltimaSemana() + "\n" +
                        "------------------------------------------------------------------------" + "\n"
                ;
            }
        }

        return listadoRutinas;
    }

    // cantidadRutinasCliente() se utiliza para mostrar en un combo box en VentanaBuscarRutina.
    public ArrayList<String> cantidadRutinasCliente(int idCliente) {
        ArrayList<String> cantidad = new ArrayList<>();
        int contador = 0;

        // Recorremos todas las rutinas.
        for (Rutina rutina : this.rutinas) {
            // Filtramos por el cliente.
            if (rutina.getCliente() == idCliente) {
                contador++;
                cantidad.add(Integer.toString(contador));
            }
        }

        // Retornamos las opciones disponibles de rutinas existentes para un cliente.
        return cantidad;
    }
}