package cl.unab.ptec102.chris.tarea2.centroDeportivo.backend;

public class EjercicioCardiovascular extends Ejercicio {
    private String tipoMaquina;

    // CONSTRUCTOR
    public EjercicioCardiovascular(
            int codigoIdentificador,
            String nombre,
            String tipoEjercicio,
            String nivelIntensidad,
            int tiempo_estimado,
            String descripcion,
            int ultimaSemana,
            String tipoMaquina
    ) {
        super(
                codigoIdentificador,
                nombre,
                tipoEjercicio,
                nivelIntensidad,
                tiempo_estimado,
                descripcion,
                ultimaSemana
        );
        this.tipoMaquina = tipoMaquina;
    }

    // GETTERS
    public String getTipoMaquina() {
        return tipoMaquina;
    }

    // SETTERS
    public void setTipoMaquina(String tipoMaquina) {
        this.tipoMaquina = tipoMaquina;
    }

    // OTROS MÉTODOS
    @Override
    public String mostrar() {
        return
                super.mostrar() +
                "\n" + "Maquina a utilizar: " + this.tipoMaquina + "\n" +
                "------------------------------------------------------------------------"
                ;
    }
}