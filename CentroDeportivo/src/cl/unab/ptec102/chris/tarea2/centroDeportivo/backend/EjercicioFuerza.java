package cl.unab.ptec102.chris.tarea2.centroDeportivo.backend;

public class EjercicioFuerza extends Ejercicio {
    private String grupoMuscular;

    // CONSTRUCTOR
    public EjercicioFuerza(
            int codigoIdentificador,
            String nombre,
            String tipoEjercicio,
            String nivelIntensidad,
            int tiempo_estimado,
            String descripcion,
            int ultimaSemana,
            String grupoMuscular
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
        this.grupoMuscular = grupoMuscular;
    }

    // GETTERS
    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    // SETTERS
    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    // OTROS MÉTODOS
    @Override
    public String mostrar() {
        return
                super.mostrar() +
                        "\n" +"Maquina a utilizar: " + this.grupoMuscular + "\n" +
                        "------------------------------------------------------------------------"
                ;
    }
}