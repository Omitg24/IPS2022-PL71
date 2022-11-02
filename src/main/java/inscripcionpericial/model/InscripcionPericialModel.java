package inscripcionpericial.model;

import colegiado.model.ColegiadoDTO;
import util.Database;
import util.Util;

public class InscripcionPericialModel {
	
	private Database db = new Database();
	
	private static final String SQL_OBTENER_DATOS_COLEGIADO=
			"Select  numeroColegiado, nombreColegiado, apellidosColegiado,"
			+ "dniColegiado,telefonoColegiado, localidadColegiado "
			+ "from Colegiado where dniColegiado=?";
	private static final String SQL_INSERTAR_INSCRIPCION_PERICIAL=
			"Insert into InscripcionPericial (dniColegiado,fechaInscripcion,posicionLista,"
			+ "estadoInscripcion) values (?,?,?,?)";
	
	public void insertarInscripcionPericial(InscripcionPericialDTO d) {
		Util.validateNotNull(d, "La inscripcion no puede ser null");
		Util.validateNotNull(d.getDniColegiado(), "El dni no puede ser null");
		Util.validateNotNull(d.getFechaInscripcion(), "La fecha no puede ser null");
		Util.validateNotNull(d.getPosicionLista(), "La posicion no puede ser null");
		Util.validateNotNull(d.getEstadoInscripcion(), "El estado no puede ser null");
		
		db.executeUpdate(SQL_INSERTAR_INSCRIPCION_PERICIAL, 
				d.getDniColegiado(),
				d.getFechaInscripcion(),
				d.getPosicionLista(),
				d.getEstadoInscripcion());
	}
	
	public ColegiadoDTO buscarColegiado(String dni) {
		Util.validateNotNull(dni, "El dni no puede ser null");
		return db.executeQueryPojo(ColegiadoDTO.class, SQL_OBTENER_DATOS_COLEGIADO, dni).get(0);
	}

}
