package cl.unab.ptec102.chris.tarea2.centroDeportivo.frontend;

import cl.unab.ptec102.chris.tarea2.centroDeportivo.backend.ColeccionEjercicio;
import cl.unab.ptec102.chris.tarea2.centroDeportivo.backend.ProcesamientoDatos;

import javax.swing.*;

public class VentanaArchivo {
    // Atributos de la ventana.
    private JPanel panelPrincipal;
    private JLabel Titulo;
    private JButton btCargarArchivo;
    private JButton btCerrarVentana;
    private JTextArea taCaracteristicas;

    // CONSTRUCTOR
    public VentanaArchivo(VentanaPrincipal ventanaPrincipal, ColeccionEjercicio BDEjercicios) {
        // Creamos el frame.
        JFrame frame = new JFrame("Ventana de Dependencias");
        frame.setContentPane(panelPrincipal);
        frame.pack();

        // Le asignamos un tamaño.
        frame.setSize(800, 600);
        // Le decimos que aparezca siempre en el centro.
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Deshabilitamos que se pueda editar el TextArea.
        taCaracteristicas.setEditable(false);

        // Creamos la suscripción del botón.
        btCargarArchivo.addActionListener(e -> {
            // Solicitamos los datos.
            ProcesamientoDatos datos = new ProcesamientoDatos(BDEjercicios);

            // Verificamos que el archivo se pudo leer.
            if (BDEjercicios.cantidadEjerciciosTotal() != 0) {
                // Mostramos las características de los datos.
                this.taCaracteristicas.setText(BDEjercicios.caracteristicasDatos());

                // Deshabilitamos el botón cargar archivos.
                btCargarArchivo.setEnabled(false);
                // Ahora podemos explorar más cosas del programa y las habilitamos.
                ventanaPrincipal.habilitarBotones();
            }

            // Informamos que no se pudo leer el archivo.
            else {
                this.taCaracteristicas.setText("No fue posible leer el archivo.");
            }

        });

        // Al cerrar la ventana, mostramos nuevamente la Ventana Principal.
        btCerrarVentana.addActionListener(e -> {
            ventanaPrincipal.mostrarFrame();
            frame.dispose();
        });
    }
}