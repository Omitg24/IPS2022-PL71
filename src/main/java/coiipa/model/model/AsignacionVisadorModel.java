package coiipa.model.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import coiipa.model.dto.ColegiadoDTO;
import coiipa.model.dto.SolicitudVisadoDTO;
import util.Database;

/**
 * 
 * Título: Clase AsignacionVisadorModel
 *
 * @author David Warzynski Abril, UO278968
 * @version 23 nov 2022
 */
public class AsignacionVisadorModel {
	
	
	private static final String SQL_BUSCAR_SOLICITUDES_VISADO=
			"Select * from SolicitudVisado order by estado desc";
	
	private static final String SQL_BUSCAR_PERITOS=
			"Select c.* from InscripcionPericial i, Colegiado c "
			+ "where i.dniColegiado=c.dniColegiado ";
	
	private static final String SQL_ASIGNAR_VISADO=
			"Insert into AsignaVisado (id,dniVisado,dniVisador,fecha) values (?,?,?,?)";

	private static final String SQL_ACTUALIZAR_ESTADO_SOLICITUD = 
			"update SolicitudVisado set estado=? where id=?";

	
	private Database db = new Database();
	
	
	public List<SolicitudVisadoDTO> getSolicitudes(){
		return db.executeQueryPojo(SolicitudVisadoDTO.class, SQL_BUSCAR_SOLICITUDES_VISADO);
	}
	
	public List<ColegiadoDTO> getVisadores(){
		return db.executeQueryPojo(ColegiadoDTO.class, SQL_BUSCAR_PERITOS);
	}
	
	public void asignarVisado(String dniVisado, String  id,String dniVisador) {
		db.executeUpdate(SQL_ASIGNAR_VISADO, id,dniVisado,dniVisador,
				Date.valueOf(LocalDate.now()));
	}

	public void actualizarEstadoSolicitud(String id, String estado) {
		db.executeUpdate(SQL_ACTUALIZAR_ESTADO_SOLICITUD,estado,id);
		
	}
	
	

}
