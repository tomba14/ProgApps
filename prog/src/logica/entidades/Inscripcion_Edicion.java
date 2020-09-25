package logica.entidades;

import java.lang.String;
import java.sql.Date;
import java.util.*;
import javax.persistence.*;

import logica.entidades.Curso;

/**
 * Entity implementation class for Entity: EdicionCurso
 *
 */
@Entity
@Table
public class Inscripcion_Edicion {
    // @Id
    // private String nicknameEstudiante;
    // @Id

    // private String nombreEdicionCurso;
    @Id
    private EdicionCurso edicionCurso;
    @Id
    private Estudiante estudiante;
    private Date fecha;
    private String estado;

    public Inscripcion_Edicion() {
        super();
    }

    public Inscripcion_Edicion(EdicionCurso edicionCurso, Estudiante estudiante, Date fecha) {
        super();
        // this.nicknameEstudiante = estudiante.getNickname();
        // this.nombreEdicionCurso = edicionCurso.getNombreEdicion();
        this.edicionCurso = edicionCurso;
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.estado = "Inscripto";
    }

    public void setEdicionCurso(EdicionCurso edicionCurso) {
        this.edicionCurso = edicionCurso;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public EdicionCurso getEdicionCurso() {
        return edicionCurso;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

}
