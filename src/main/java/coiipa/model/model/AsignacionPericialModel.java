package coiipa.model.model;

import java.sql.Timestamp;
import java.util.List;

import coiipa.model.dto.InformeDTO;
import coiipa.model.dto.InscripcionPericialDTO;
import coiipa.model.dto.SolicitudPericialDTO;
import util.Database;

/**
 * Título: Clase AsignacionPericialModel
 *
 * @author David Warzynski Abril, UO278968 y Omar Teixeira González, UO281847
 * @version 23 nov 2022
 */
public class AsignacionPericialModel {	
	
	private static final String SQL_BUSCAR_INFORMES_NO_ASIGNADOS=
			"Select * from Informes  where id "
			+ "not in (select id from SolicitudPericial )";
	
	private static final String SQL_BUSCAR_PERITOS_NO_ASIGNADAS=
			"Select i.*,c.estadoAsignacionPericial from InscripcionPericial i, Colegiado c "
			+ "where i.dniColegiado=c.dniColegiado and  estadoAsignacionPericial= ? "
			+ "and i.estadoInscripcion=? order by i.posicionLista";
	
	private static final String SQL_ASIGNAR_INFORME=
			"Insert into SolicitudPericial (id,dni,estado,fecha) values (?,?,?,?)";

	private static final String SQL_ACTUALIZAR_ESTADO_PERITO = 
			"Update Colegiado set estadoAsignacionPericial=? where dniColegiado=?";

	private static final String SQL_BUSCAR_PERITOS_ASIGNADAS = 
			"Select DISTINCT i.*,c.estadoAsignacionPericial,s.fecha "
			+ "from InscripcionPericial i, SolicitudPericial s, Colegiado c "
			+ "where i.dniColegiado=s.dni and i.estadoInscripcion=? "
			+ "and i.dniColegiado= c.dniColegiado and c.estadoAsignacionPericial=? "
			+ "order by s.fecha asc";

	private static final String SQL_ACTUALIZAR_TURNO = "update InscripcionPericial set posicionLista=? "
			+ "where dniColegiado=?";

	private static final String SQL_ACTUALIZAR_TURNO_ANT =  "update InscripcionPericial set posicionLista= posicionLista-1 "
			+ "where dniColegiado=?";;
			
	private static final String SQL_BUSCAR_ASIGNACIONES_ASIGNADAS =
			"SELECT * FROM SOLICITUDPERICIAL WHERE ESTADO = 'Asignada'";
	
	private Database db = new Database();
	
	
	public List<InformeDTO> getInformes(){
		return db.executeQueryPojo(InformeDTO.class, SQL_BUSCAR_INFORMES_NO_ASIGNADOS);
	}
	
	public List<InscripcionPericialDTO> getPeritos(){
		return db.executeQueryPojo(InscripcionPericialDTO.class, SQL_BUSCAR_PERITOS_NO_ASIGNADAS,"NA","Inscrito");
	}
	
	public List<InscripcionPericialDTO> getPeritosAsignados(){
		return db.executeQueryPojo(InscripcionPericialDTO.class, SQL_BUSCAR_PERITOS_ASIGNADAS,"Inscrito","Asignado");
	}
	
	public void asignarInforme(String dni, String  id) {
		db.executeUpdate(SQL_ASIGNAR_INFORME, id,dni,"Asignada",new Timestamp(System.currentTimeMillis()));
	}
	
	public void asignarPerito(String dni) {
		db.executeUpdate(SQL_ACTUALIZAR_ESTADO_PERITO, "Asignado",dni);
	}
	
	public void actualizarTurno(String dni) {
		int turno =  new InscripcionPericialModel().getUltimoTurnoPericial()+1;
		db.executeUpdate(SQL_ACTUALIZAR_TURNO,turno,dni);
	}

	public void actualizarTurnoAnt(String dniPeritoAnterior) {
		db.executeUpdate(SQL_ACTUALIZAR_TURNO_ANT,dniPeritoAnterior);		
	}
	
	public List<SolicitudPericialDTO> getAsignaciones() {
		return db.executeQueryPojo(SolicitudPericialDTO.class, SQL_BUSCAR_ASIGNACIONES_ASIGNADAS);
	}

}
