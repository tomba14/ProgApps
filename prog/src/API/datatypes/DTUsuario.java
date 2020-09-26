package API.datatypes;

import java.lang.String;
import java.sql.Date;
import java.io.File;

public class DTUsuario {

	public String nickname;
	public String nombre;
	public String apellido;
	public String mail;
	public Date fechaNac;
	public File image;
	public String passw;

	public DTUsuario() {
	}

	public DTUsuario(String nick, String name, String ape, String email, Date nac, String passp) {
		super();
		nickname = nick;
		nombre = name;
		apellido = ape;
		mail = email;
		fechaNac = nac;
		passw = passp;
	}

}