package logica.inscripciones;

import logica.cursos.ObtenerCurso;
import logica.edicioncursos.ObtenerEdicionCurso;
import logica.entidades.Curso;
import logica.entidades.EdicionCurso;
import logica.entidades.Estudiante;
import logica.entidades.Inscripcion_Edicion;
import logica.usuarios.ObtenerUsuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.sql.Date;
import java.util.*;

import logica.usuarios.ObtenerUsuario;

public class InscripcionAEdicion {
    Date FInscripcion;
    String NEstudiante;
    String NEdicion;

    public InscripcionAEdicion(String nombreEstudiante, Date FechaIns, String Edicion) {
        NEstudiante = nombreEstudiante;
        FInscripcion = FechaIns;
        NEdicion = Edicion;

    }

    public boolean existeCupo() {
        EdicionCurso edicionCurso = new ObtenerEdicionCurso().getEdicionCurso(NEdicion);
        int cupo = edicionCurso.getCupo();
        List<Inscripcion_Edicion> listaInscripciones = edicionCurso.getInscriptos();

        if (cupo == 0) {
            return false;
        }

        if (listaInscripciones.size() < cupo) {
            return false;
        }
        return true;
    }

    public boolean existeInscripcion() {

        Estudiante es = null;
        ObtenerUsuario ObtUsuario = new ObtenerUsuario();
        es = ObtUsuario.getEstudianteByNickname(NEstudiante);
        if (es != null) {
            List<Inscripcion_Edicion> list = es.getInscripciones();
            for (Inscripcion_Edicion inscripcion : list) {
                if (inscripcion.getEdicionCurso().getNombreEdicion().equals(NEdicion)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String inscripcion() {

        Estudiante es = null;

        if (NEstudiante.isEmpty()) {
            return "ERROR: El nombre del estudiante no debe estar vacio";
        }

        if (NEdicion.isEmpty()) {
            return "ERROR: El nombre de la edicion no debe ser vacio.";
        }

        ObtenerEdicionCurso ObtEdicion = new ObtenerEdicionCurso();
        EdicionCurso edicion = ObtEdicion.getEdicionCurso(NEdicion);

        if (edicion == null) {
            return "ERROR: La edicion no existe.";
        }

        ObtenerUsuario ObtUsuario = new ObtenerUsuario();

        if (ObtUsuario.isEstudiante(NEstudiante)) {
            es = ObtUsuario.getEstudianteByNickname(NEstudiante);
        } else {
            return "ERROR: El usuario no es un estudiante";
        }

        if (existeCupo()) {
            return "ERROR: No existen cupos disponibles, para la edicion";
        }
        
        if(existeInscripcion()) {
        	return "ERROR: Ya se inscribio a esta edici�n";
        }

        // ------------------------------------
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CursoJPA");
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        Inscripcion_Edicion InscEdc = new Inscripcion_Edicion(edicion, es, FInscripcion);
        

        List<Inscripcion_Edicion> inscriptosE = edicion.getInscriptos();
        if(inscriptosE==null) {
        	inscriptosE = new ArrayList<Inscripcion_Edicion>();
        }
        	
        inscriptosE.add(InscEdc);
        edicion.setInscriptos(inscriptosE);

        List<Inscripcion_Edicion> inscripciones = es.getInscripciones();
        if(inscripciones==null) {
        	inscripciones = new ArrayList<Inscripcion_Edicion>();
        }
        inscripciones.add(InscEdc);
        es.setInscripciones(inscripciones);
        
        entitymanager.persist(InscEdc);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();

        return "";
    }
}