package cl.unab.ptec102.chris.tarea2.centroDeportivo.backend;

public class Ejercicio {
    private int codigoIdentificador;
    private String nombre;
    private String tipoEjercicio;
    private String nivelIntensidad;
    private int tiempoEstimado;
    private String descripcion;
    private int ultimaSemana;

    // CONSTRUCTOR
    public Ejercicio(
            int codigoIdentificador,
            String nombre,
            String tipoEjercicio,
            String nivelIntensidad,
            int tiempo_estimado,
            String descripcion,
            int ultimaSemana
    ) {
        this.codigoIdentificador = codigoIdentificador;
        this.nombre = nombre;
        this.tipoEjercicio = tipoEjercicio;
        this.nivelIntensidad = nivelIntensidad;
        this.tiempoEstimado = tiempo_estimado;
        this.descripcion = descripcion;
        this.ultimaSemana = ultimaSemana;
    }

    // GETTERS
    public int getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoEjercicio() {
        return tipoEjercicio;
    }

    public String getNivelIntensidad() {
        return nivelIntensidad;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getUltimaSemana() {
        return ultimaSemana;
    }

    // SETTERS
    public void setUltimaSemana(int ultimaSemana) {
        this.ultimaSemana = ultimaSemana;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public void setNivelIntensidad(String nivelIntensidad) {
        this.nivelIntensidad = nivelIntensidad;
    }

    public void setTipoEjercicio(String tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // OTROS MÉTODOS
    public String mostrar() {
        return
                "------------------------------------------------------------------------" + "\n" +
                "Nombre: " + this.nombre + "\n" +
                "Tipo de Ejercicio: " + this.tipoEjercicio + "\n" +
                "Nivel de intensidad: " + this.nivelIntensidad + "\n" +
                "Tiempo estimado: " + this.tiempoEstimado + "min\n" +
                "Descripción: " + this.descripcion
                ;
    }
}