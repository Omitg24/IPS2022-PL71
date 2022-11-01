package inscripcionpericial.model;

import util.Database;

public class InscripcionPericialModel {
	
	private Database db = new Database();
	
	private static final String INSCRIPCION_PERICIAL_ESTADO="No inscrito";
	
	private static final String SQL_OBTENER_DATOS_COLEGIADO=
			"Select  numeroColegiado, nombreColegiado, apellidosColegiado,"
			+ "dniColegiado,telefonoColegiado, localidadColegiado "
			+ "from Colegiado where dniColegiado=?";
	private static final String SQL_INSERTAR_INSCRIPCION_PERICIAL=
			"Insert into InscripcionPericial (dniColegiado,fechaInscripcion,posicionLista,"
			+ "estadoInscripcion) values (?,?,?,?)";
	
	

}
