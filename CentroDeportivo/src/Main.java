import cl.unab.ptec102.chris.tarea2.centroDeportivo.backend.*;
import cl.unab.ptec102.chris.tarea2.centroDeportivo.frontend.*;

void main() {
    // Creación de las estructuras de datos.
    ColeccionEjercicio BDEjercicios = new ColeccionEjercicio();
    ColeccionRutina BDRutinas =  new ColeccionRutina();

    // Creación de la Ventana Principal y le pasamos las colecciones (estructuras).
    VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(BDEjercicios, BDRutinas);
}