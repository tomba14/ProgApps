package logica.usuarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.List;

import logica.entidades.Usuario;
import logica.formaciones.ObtenerFormacion;
import logica.entidades.Estudiante;
import logica.entidades.Formacion;
import logica.entidades.Curso;
import logica.entidades.Docente;

public class DejarSeguirUsuario {

	private String nickSeguido;
	private String nickSeguidor;

	public DejarSeguirUsuario(String nickName, String nickName2) {
		nickSeguido = nickName;
		nickSeguidor = nickName2;
	}

	private boolean ExisteSeguidor(String nickSeguido, String nickSeguidor) {
		if (new ObtenerUsuario().isEstudiante(nickSeguido)) {

			Estudiante est = new ObtenerUsuario().getEstudianteByNickname(nickSeguido);
			List<Estudiante> seguidores = est.getSeguidores();
			if (seguidores == null)
				return false;
			for (Estudiante estus : seguidores) {
				if (nickSeguidor == estus.getNickname()) {
					return true;
				}
			}
			return false;
		} else {
			Docente doc = new ObtenerUsuario().getDocenteByNickname(nickSeguido);
			List<Docente> seguidores = doc.getSeguidores();
			if (seguidores == null)
				return false;
			for (Docente docs : seguidores) {
				if (nickSeguidor == docs.getNickname()) {
					return true;
				}
			}
			return false;
		}

	}

	public String DejarSeguirUserEstudiante() {

		String retorno = "";
		if (ExisteSeguidor(nickSeguido, nickSeguidor)) {

			if (new ObtenerUsuario().isEstudiante(nickSeguido)) {
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
				EntityManager entitymanager = emfactory.createEntityManager();
				entitymanager.getTransaction().begin();

				Estudiante usr_seguido = entitymanager.find(Estudiante.class, nickSeguido);

				if (new ObtenerUsuario().isEstudiante(nickSeguidor)) {

					Estudiante usr_seguidor = entitymanager.find(Estudiante.class, nickSeguidor);
					usr_seguido.removeSeguidores(usr_seguidor);
					usr_seguidor.removeSiguiendo(usr_seguido);

					entitymanager.getTransaction().commit();

					entitymanager.close();
					emfactory.close();
				}
				if (!new ObtenerUsuario().isEstudiante(nickSeguidor)) {

					Docente usr_seguidor = entitymanager.find(Docente.class, nickSeguidor);
					usr_seguido.removeSeguidores(usr_seguidor);
					usr_seguidor.removeSiguiendo(usr_seguido);

					entitymanager.getTransaction().commit();

					entitymanager.close();
					emfactory.close();
				}

			}
		} else {
			return retorno + "ERROR: No sigue a este usuario \n";
		}

		return retorno;
	}

	public String DejarSeguirUserDocente() {

		String retorno = "";
		if (ExisteSeguidor(nickSeguido, nickSeguidor)) {

			if (!new ObtenerUsuario().isEstudiante(nickSeguido)) {
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InstitutoJPA");
				EntityManager entitymanager = emfactory.createEntityManager();
				entitymanager.getTransaction().begin();

				Docente usr_seguido = entitymanager.find(Docente.class, nickSeguido);

				if (new ObtenerUsuario().isEstudiante(nickSeguidor)) {

					Estudiante usr_seguidor = entitymanager.find(Estudiante.class, nickSeguidor);
					usr_seguido.removeSeguidores(usr_seguidor);
					usr_seguidor.removeSiguiendo(usr_seguido);

					entitymanager.getTransaction().commit();

					entitymanager.close();
					emfactory.close();
				}
				if (!new ObtenerUsuario().isEstudiante(nickSeguidor)) {

					Docente usr_seguidor = entitymanager.find(Docente.class, nickSeguidor);
					usr_seguido.removeSeguidores(usr_seguidor);
					usr_seguidor.removeSiguiendo(usr_seguido);

					entitymanager.getTransaction().commit();

					entitymanager.close();
					emfactory.close();
				}
			}
		} else {
			return retorno + "ERROR: No sigue a este usuario \n";
		}

		return retorno;

	}

}