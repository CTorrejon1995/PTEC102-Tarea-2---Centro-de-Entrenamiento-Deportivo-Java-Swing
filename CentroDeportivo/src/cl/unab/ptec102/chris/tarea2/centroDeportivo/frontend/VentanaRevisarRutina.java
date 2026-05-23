package cl.unab.ptec102.chris.tarea2.centroDeportivo.frontend;

import cl.unab.ptec102.chris.tarea2.centroDeportivo.backend.Rutina;

import javax.swing.*;

public class VentanaRevisarRutina {
    // Atributos de la ventana.
    private JLabel Titulo;
    private JTextArea taCaracteristicas;
    private JButton btVolver;
    private JButton btSiguiente;
    private JPanel panelPrincipal;

    // Este atributo sirve para identificar si estamos en el primer o último ejercicio.
    private int indice;

    // CONSTRUCTOR
    public VentanaRevisarRutina(VentanaPrincipal ventanaPrincipal, Rutina laRutina) {
        // Creamos el frame.
        JFrame frame = new JFrame("Ventana Generar Rutina");
        frame.setContentPane(panelPrincipal);
        frame.pack();

        // Le asignamos un tamaño.
        frame.setSize(800, 600);
        // Le decimos que aparezca siempre en el centro.
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Inicializamos desde el primer ejercicio.
        this.indice = 0;

        // Deshabilitamos que se pueda editar el TextArea.
        taCaracteristicas.setEditable(false);

        // Mostramos las características del primer ejercicio.
        taCaracteristicas.setText(laRutina.getEjercicios().get(this.indice).mostrar());
        // No se puede ir atrás desde el primer ejercicio.
        btVolver.setEnabled(false);

        // En caso de la rutina tenga solo 1 ejercicio, se muestra la siguiente opción en vez de "Siguiente".
        if (this.indice == laRutina.getEjercicios().size() - 1) {
            btSiguiente.setText("Resumen de la Rutina");
        }

        // Creamos la suscripción del botón.
        btSiguiente.addActionListener(e -> {
            // Verificamos que no estemos en el último ejercicio.
            if (this.indice < laRutina.getEjercicios().size() - 1) {
                // Aseguramos que botón muestre "Siguiente" en caso de no estar en el último ejercicio.
                btSiguiente.setText("Siguiente");

                // Aumentamos el índice cada vez que cambiemos de ejercicio.
                this.indice++;

                // Mostramos el ejercicio en dicho índice.
                taCaracteristicas.setText(laRutina.getEjercicios().get(this.indice).mostrar());

                // Ya que no estamos en el primer ejercicio, nos podemos devolver.
                btVolver.setEnabled(true);

                // En caso de estar en el último ejercicio, se debe cambiar el texto.
                if (this.indice == laRutina.getEjercicios().size() - 1) {
                    btSiguiente.setText("Resumen de la Rutina");
                }
            }

            // En caso de estar en el último ejercicio y se utiliza el botón, nos cambiamos de Ventana.
            else {
                VentanaResumenRutina resumenRutina = new VentanaResumenRutina(ventanaPrincipal, laRutina);

                frame.dispose();
            }
        });

        // Creamos la suscripción del botón.
        btVolver.addActionListener(e -> {
            // Nos aseguramos que el botón para cambiar de ejercicio hacia adelante diga "Siguiente".
            btSiguiente.setText("Siguiente");

            // Restamos el índice para poder devolvernos al anterior ejercicio.
            this.indice--;

            // Mostramos el ejercicio en dicho índice.
            taCaracteristicas.setText(laRutina.getEjercicios().get(this.indice).mostrar());

            // En caso de estar en el primer ejercicio, deshabilitamos el botón.
            if (this.indice == 0) {
                btVolver.setEnabled(false);
            }
        });
    }
}