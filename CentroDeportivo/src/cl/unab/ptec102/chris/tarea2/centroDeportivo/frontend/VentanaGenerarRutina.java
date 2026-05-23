package cl.unab.ptec102.chris.tarea2.centroDeportivo.frontend;

import cl.unab.ptec102.chris.tarea2.centroDeportivo.backend.ColeccionEjercicio;
import cl.unab.ptec102.chris.tarea2.centroDeportivo.backend.ColeccionRutina;
import cl.unab.ptec102.chris.tarea2.centroDeportivo.backend.Orquestador;

import javax.swing.*;

public class VentanaGenerarRutina {
    // Atributos de la ventana.
    private JPanel panelPrincipal;
    private JLabel Titulo;
    private JTextField tfIDCliente;
    private JTextField tfUltimaSemana;
    private JTextField tfCantCardio;
    private JTextField tfCantFuerza;
    private JButton btGenerarRutina;
    private JButton btCerrarVentana;
    private JComboBox<String> cbNivelIntensidad;
    private JTextArea taSalida;

    // CONSTRUCTOR
    public VentanaGenerarRutina(VentanaPrincipal ventanaPrincipal, ColeccionEjercicio BDEjercicios, ColeccionRutina BDRutinas) {
        // Opciones de los niveles disponibles.
        String[] niveles = {
                "Básico",
                "Intermedio",
                "Avanzado",
                "Alto rendimiento"
        };

        // Asignamos las opciones al combo box.
        cbNivelIntensidad.setModel(
                new DefaultComboBoxModel<>(niveles)
        );

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
        taSalida.setEditable(false);

        // Creamos la suscripción del botón.
        btGenerarRutina.addActionListener(e -> {
            String salida;

            // Verificamos que la información que el usuario ingreso es numérico.
            try {
                int idCliente = Integer.parseInt(this.tfIDCliente.getText());
                int ultimaSemana = Integer.parseInt(this.tfUltimaSemana.getText());
                int cantCardio = Integer.parseInt(this.tfCantCardio.getText());
                int cantFuerza = Integer.parseInt(this.tfCantFuerza.getText());
                String nivelIntensidad = (String) this.cbNivelIntensidad.getSelectedItem();

                // Verificamos que los datos son lógicos.
                if (idCliente > 0 && cantCardio >= 0 && cantFuerza >= 0 && ultimaSemana > 0) {
                    // Llamamos a orquestador para crear correctamente la rutina.
                    Orquestador controlador = new Orquestador();
                    salida = controlador.crearRutina(BDEjercicios, BDRutinas, idCliente, ultimaSemana, new int[] {cantCardio, cantFuerza}, nivelIntensidad);

                    // Mostramos que la rutina fue correctamente creada o no.
                    this.taSalida.setText(salida);

                } else {
                    // Mostramos que solo se pueden ingresar números positivos.
                    salida = "Debe ingresar números positivos.";

                    this.taSalida.setText(salida);
                }

            } catch (NumberFormatException nfe) {
                // Mostramos el error por pantalla.
                salida = "No puede ingresar letras, debe ingresar números positivos.";

                this.taSalida.setText(salida);
            }
        });

        // Creamos este botón en caso en que el usuario quiera volver a la Ventana Principal.
        btCerrarVentana.addActionListener(e -> {
            ventanaPrincipal.mostrarFrame();
            frame.dispose();
        });
    }
}