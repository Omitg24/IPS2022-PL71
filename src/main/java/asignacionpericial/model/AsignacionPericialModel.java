package asignacionpericial.model;

import java.util.List;

import inscripcionpericial.model.InscripcionPericialDTO;
import util.Database;

public class AsignacionPericialModel {
	
	
	private static final String SQL_BUSCAR_INFORMES_NO_ASIGNADOS=
			"Select * from Informes  where id "
			+ "not in (select id from SolicitudPericial)";
	
	private static final String SQL_BUSCAR_PERITOS_NO_ASIGNADAS=
			"Select i.* from InscripcionPericial i, Colegiado c "
			+ "where i.dniColegiado=c.dniColegiado and  estadoAsignacionPericial= ? "
			+ "and i.estadoInscripcion=? order by i.posicionLista";
	
	private static final String SQL_ASIGNAR_INFORME=
			"Insert into SolicitudPericial (id,dni,estado) values (?,?,?)";

	private static final String SQL_ACTUALIZAR_ESTADO_PERITO = 
			"Update Colegiado set estadoAsignacionPericial=? where dniColegiado=?";
	
	private Database db = new Database();
	
	
	public List<InformeDTO> getInformes(){
		return db.executeQueryPojo(InformeDTO.class, SQL_BUSCAR_INFORMES_NO_ASIGNADOS);
	}
	
	public List<InscripcionPericialDTO> getPeritos(){
		return db.executeQueryPojo(InscripcionPericialDTO.class, SQL_BUSCAR_PERITOS_NO_ASIGNADAS,"NA","Inscrito");
	}
	
	public void asignarInforme(String dni, String  id) {
		db.executeUpdate(SQL_ASIGNAR_INFORME, id,dni,"Asignada");
	}
	
	public void asignarPerito(String dni) {
		db.executeUpdate(SQL_ACTUALIZAR_ESTADO_PERITO, "Asignado",dni);
	}
	

}
