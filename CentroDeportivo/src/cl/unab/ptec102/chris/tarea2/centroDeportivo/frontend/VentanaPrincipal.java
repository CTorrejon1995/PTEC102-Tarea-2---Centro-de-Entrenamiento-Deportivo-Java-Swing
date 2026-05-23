package cl.unab.ptec102.chris.tarea2.centroDeportivo.frontend;

import cl.unab.ptec102.chris.tarea2.centroDeportivo.backend.ColeccionEjercicio;
import cl.unab.ptec102.chris.tarea2.centroDeportivo.backend.ColeccionRutina;

import javax.swing.*;

public class VentanaPrincipal {
    // Atributos de la ventana.
    private JPanel panelPrincipal;
    private JLabel Titulo;
    private JButton btCargarArchivo;
    private JButton btGenerarRutina;
    private JButton btRevisarRutina;
    private JButton btCerrarVentana;

    // Ponemos como atributo el frame para poder mostrar la Ventana Principal en otras Ventanas.
    private JFrame frame;
    private ColeccionEjercicio BDEjercicios;
    private  ColeccionRutina BDRutinas;

    // CONSTRUCTOR
    public VentanaPrincipal(ColeccionEjercicio BDEjercicios, ColeccionRutina BDRutinas) {
        // Recibimos las colecciones del Backend.
        this.BDEjercicios = BDEjercicios;
        this.BDRutinas = BDRutinas;

        // Manipulamos el frame.
        frame = new JFrame("Ventana Principal");
        frame.setContentPane(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        // Le asignamos un tamaño
        frame.setSize(800, 600);
        // Le decimos que aparezca siempre en el centro.
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // No se puede acceder al resto de ventanas sin haber cargado previamente los datos.
        btGenerarRutina.setEnabled(false);
        btRevisarRutina.setEnabled(false);

        // Creamos la suscripción del botón.
        btCargarArchivo.addActionListener(e -> {
            // Ocultamos la Ventana Principal.
            frame.setVisible(false);

            // Nos vamos a la Ventana Archivo para cargar los datos.
            VentanaArchivo cargaArchivo = new VentanaArchivo(this, this.BDEjercicios);
        });

        // Creamos la suscripción del botón. # Solo sirve si se habilitaron estos botones.
        btGenerarRutina.addActionListener(e -> {
            // Ocultamos la Ventana Principal.
            frame.setVisible(false);

            // Nos vamos a la Ventana Generar Rutina para cargar los datos.
            VentanaGenerarRutina generarRutina = new VentanaGenerarRutina(this, this.BDEjercicios, this.BDRutinas);
        });

        // Creamos la suscripción del botón. # Solo sirve si se habilitaron estos botones.
        btRevisarRutina.addActionListener(e -> {
            // Ocultamos la Ventana Principal.
            frame.setVisible(false);

            // Nos vamos a la Ventana Buscar Rutina para cargar los datos.
            VentanaBuscarRutina buscarRutina = new VentanaBuscarRutina(this, this.BDRutinas);
        });

        // Creamos este botón en caso en que el usuario quiera cerrar el programa.
        btCerrarVentana.addActionListener(e -> {
            frame.dispose();
        });
    }

    // Esta función sirve para habilitar los botones para acceder a las nuevas Ventanas y deshabilitar la Carga de Archivo.
    public void habilitarBotones() {
        btGenerarRutina.setEnabled(true);
        btRevisarRutina.setEnabled(true);

        btCargarArchivo.setEnabled(false);
    }

    // Con esta función sirve para volver a mostrar la Ventana Principal una vez se termine el uso de otra Ventana.
    public void mostrarFrame() {
        frame.setVisible(true);
    }
}