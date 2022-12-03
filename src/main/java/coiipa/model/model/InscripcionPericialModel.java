package coiipa.model.model;

import java.util.List;

import coiipa.model.dto.ColegiadoDTO;
import coiipa.model.dto.InscripcionPericialDTO;
import util.Database;
import util.Util;

public class InscripcionPericialModel {
	
	private Database db = new Database();
	
	private static final String SQL_OBTENER_DATOS_COLEGIADO=
			"Select  * "
			+ "from Colegiado where dniColegiado=?";
	private static final String SQL_INSERTAR_INSCRIPCION_PERICIAL=
			"Insert into InscripcionPericial (dniColegiado,fechaInscripcion,posicionLista,"
			+ "estadoInscripcion) values (?,?,?,?)";

	private static final String SQL_OBTENER_INSCRIPCION_COLEGIADO = ""
			+ "Select * from InscripcionPericial where dniColegiado=?";

	private static final String SQL_ACTUALIZAR_INSCRIPCION_PERICIAL = 
			"Update InscripcionPericial set fechaInscripcion=?, estadoInscripcion=? "
			+ "where dniColegiado=?";

	private static final String SQL_OBTENER_ULTIMO_TURNO = 
			"Select * from InscripcionPericial where estadoInscripcion=?"
			+ "order by (posicionLista) desc";
	
	private static final String SQL_OBTENER_ULTIMO_TURNO_VISADO = 
			"Select * from InscripcionPericial where estadoInscripcion=?"
			+ "order by (posicionListaVisado) desc";
	
	public void insertarInscripcionPericial(InscripcionPericialDTO d) {
		Util.validateNotNull(d, "La inscripcion no puede ser null");
		Util.validateNotNull(d.getDniColegiado(), "El dni no puede ser null");
		Util.validateNotNull(d.fechaInscripcion, "La fecha no puede ser null");
		Util.validateNotNull(d.getPosicionLista(), "La posicion no puede ser null");
		Util.validateNotNull(d.getEstadoInscripcion(), "El estado no puede ser null");
		
		db.executeUpdate(SQL_INSERTAR_INSCRIPCION_PERICIAL, 
				d.getDniColegiado(),
				d.fechaInscripcion,
				d.getPosicionLista(),
				d.getEstadoInscripcion());
	}
	
	public ColegiadoDTO buscarColegiado(String dni) {
		Util.validateNotNull(dni, "El dni no puede ser null");
		return db.executeQueryPojo(ColegiadoDTO.class, SQL_OBTENER_DATOS_COLEGIADO, dni).get(0);
	}

	public InscripcionPericialDTO buscarColegiadoPercial(String dni) {
		Util.validateNotNull(dni, "El dni no puede ser null");
		List<InscripcionPericialDTO> result= 
				db.executeQueryPojo(InscripcionPericialDTO.class, SQL_OBTENER_INSCRIPCION_COLEGIADO, dni);
		if(result.isEmpty()) return null;
		return result.get(0);
	}

	public void actualizarInscripcionPericial(InscripcionPericialDTO p) {
		Util.validateNotNull(p, "La inscripcion no puede ser null");
		db.executeUpdate(SQL_ACTUALIZAR_INSCRIPCION_PERICIAL, 
				p.fechaInscripcion,p.getEstadoInscripcion(),p.getDniColegiado());
		
	}

	public int getUltimoTurnoPericial() {
		return db.executeQueryPojo(InscripcionPericialDTO.class, 
				SQL_OBTENER_ULTIMO_TURNO,"Inscrito").get(0).getPosicionLista();
	}

	public int getUltimoTurnoVisado() {
		return db.executeQueryPojo(InscripcionPericialDTO.class, 
				SQL_OBTENER_ULTIMO_TURNO_VISADO,"Inscrito").get(0).getPosicionListaVisado();
	}

}
