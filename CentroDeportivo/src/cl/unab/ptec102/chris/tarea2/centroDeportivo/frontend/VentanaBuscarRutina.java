package cl.unab.ptec102.chris.tarea2.centroDeportivo.frontend;

import cl.unab.ptec102.chris.tarea2.centroDeportivo.backend.ColeccionRutina;

import javax.swing.*;
import java.util.ArrayList;

public class VentanaBuscarRutina {
    // Atributos de la ventana.
    private JPanel panelPrincipal;
    private JLabel Titulo;
    private JTextField tfIDCliente;
    private JTextArea taClientes;
    private JTextArea taRutinas;
    private JButton btBuscarCliente;
    private JComboBox<String> cbRutinas;
    private JButton btCerrarVentana;
    private JButton btSeleccionarRutina;

    // CONSTRUCTOR
    public VentanaBuscarRutina(VentanaPrincipal ventanaPrincipal, ColeccionRutina BDRutinas) {
        String listadoClientes = BDRutinas.mostrarInformacionClientes();

        // Creamos el frame.
        JFrame frame = new JFrame("Ventana Generar Rutina");
        frame.setContentPane(panelPrincipal);
        frame.pack();

        // Le asignamos un tamaño.
        frame.setSize(800, 600);
        // Le decimos que aparezca siempre en el centro.
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Deshabilitamos que se pueda editar el TextArea.
        taClientes.setEditable(false);
        taRutinas.setEditable(false);

        // Mostramos los clientes disponibles.
        taClientes.setText(listadoClientes);
        // No se puede seleccionar una rutina sin un cliente válido.
        btSeleccionarRutina.setEnabled(false);
        // Tampoco se puede utilizar el combo Box para seleccionar la rutina.
        cbRutinas.setEnabled(false);

        // Creamos la suscripción del botón.
        btBuscarCliente.addActionListener(e -> {
            try {
                // Recuperamos el cliente ingresado por el usuario.
                int idCliente = Integer.parseInt(this.tfIDCliente.getText());
                String listadoRutinas = BDRutinas.mostrarInformacionRutinas(idCliente);

                // Si el cliente existe, es porque tiene rutinas asociadas.
                if (!listadoRutinas.isEmpty()) {
                    // Recuperamos las opciones posibles para el cliente seleccionado.
                    ArrayList<String> opciones = BDRutinas.cantidadRutinasCliente(idCliente);

                    // Habilitamos el botón y el combo box.
                    btSeleccionarRutina.setEnabled(true);
                    cbRutinas.setEnabled(true);

                    // Asignamos los valores al combo box.
                    cbRutinas.setModel(
                            new DefaultComboBoxModel<>(opciones.toArray(new String[0]))
                    );

                    // Mostramos las rutinas disponibles para el cliente seleccionado.
                    taRutinas.setText(listadoRutinas);
                }

                // En caso de que el cliente no tenga rutinas, es porque no existe.
                else {
                    btSeleccionarRutina.setEnabled(false);
                    cbRutinas.setEnabled(false);

                    taRutinas.setText("El cliente " + idCliente + " no existe.");
                }

            } catch (NumberFormatException nfe) {
                // Informamos que solo se deben ingresar números positivos.
                btSeleccionarRutina.setEnabled(false);
                cbRutinas.setEnabled(false);

                taRutinas.setText("No puede ingresar letras, debe ingresar números positivos.");
            }
        });

        // Creamos la suscripción del botón.
        btSeleccionarRutina.addActionListener(e -> {
            String opcionRutina = (String) this.cbRutinas.getSelectedItem();
            int indice = Integer.parseInt(opcionRutina);

            // Nos vamos a la Ventana Revisar Rutina, ya que la información está correctamente filtrada.
            VentanaRevisarRutina revisarRutina = new VentanaRevisarRutina(ventanaPrincipal, BDRutinas.getRutinas().get(indice - 1));
            frame.dispose();
        });

        // Creamos este botón en caso en que el usuario quiera volver a la Ventana Principal.
        btCerrarVentana.addActionListener(e -> {
            ventanaPrincipal.mostrarFrame();
            frame.dispose();
        });
    }
}