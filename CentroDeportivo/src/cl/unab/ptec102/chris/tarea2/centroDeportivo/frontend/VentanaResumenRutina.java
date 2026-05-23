package cl.unab.ptec102.chris.tarea2.centroDeportivo.frontend;

import cl.unab.ptec102.chris.tarea2.centroDeportivo.backend.Rutina;

import javax.swing.*;

public class VentanaResumenRutina {
    // Atributos de la ventana.
    private JPanel panelPrincipal;
    private JLabel Titulo;
    private JTextArea taResumenRutina;
    private JButton btCerrarVentana;

    // CONSTRUCTOR
    public VentanaResumenRutina(VentanaPrincipal ventanaPrincipal, Rutina laRutina) {
        // Creamos el frame.
        JFrame frame = new JFrame("Ventana Principal");
        frame.setContentPane(panelPrincipal);
        frame.pack();

        // Le asignamos un tamaño.
        frame.setSize(800, 600);
        // Le decimos que aparezca siempre en el centro.
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Deshabilitamos que se pueda editar el TextArea.
        taResumenRutina.setEditable(false);

        // Mostramos las características asociadas a la rutina seleccionada.
        taResumenRutina.setText(laRutina.mostrarCaracteristicas());

        // Creamos este botón en caso en que el usuario quiera volver a la Ventana Principal.
        btCerrarVentana.addActionListener(e -> {
            ventanaPrincipal.mostrarFrame();
            frame.dispose();
        });
    }
}