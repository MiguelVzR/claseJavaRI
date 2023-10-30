package Examen;

import java.time.LocalDate;

public class Libro {
    private int idCliente;
    private String nombreLibro;
    private String genero;
    private LocalDate fechaPublicacion; // Usar una cadena de texto para la fecha
    private String estadoSolicitud;

    public Libro(int idCliente, String nombreLibro, String genero, LocalDate fechaPublicacion, String estadoSolicitud) {
        this.idCliente = idCliente;
        this.nombreLibro = nombreLibro;
        this.genero = genero;
        this.fechaPublicacion = fechaPublicacion;
        this.estadoSolicitud = estadoSolicitud;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }
    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }
    public String getGenero() {
        return genero;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public String getNombreLibro() {
        return nombreLibro;
    }
    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }
    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    @Override
    public String toString() {
        return "Libro:" +
                "\nidCliente=" + idCliente +
                "\nnombreLibro='" + nombreLibro + '\'' +
                "\ngenero='" + genero + '\'' +
                "\nfechaPublicacion='" + fechaPublicacion + '\'' +
                "\nestadoSolicitud='" + estadoSolicitud + '\'';
    }

}
