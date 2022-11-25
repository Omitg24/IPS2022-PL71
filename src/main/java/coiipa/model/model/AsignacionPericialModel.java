package coiipa.model.model;

import java.sql.Timestamp;
import java.util.List;

import coiipa.model.dto.AsignacionPericialDTO;
import coiipa.model.dto.InformeDTO;
import coiipa.model.dto.InscripcionPericialDTO;
import util.Database;

/**
 * Título: Clase AsignacionPericialModel
 *
 * @author David Warzynski Abril, UO278968 y Omar Teixeira González, UO281847
 * @version 23 nov 2022
 */
public class AsignacionPericialModel {	
	/**
	 * Constante SQL_BUSCAR_INFORMES_NO_ASIGNADOS
	 */
	private static final String SQL_BUSCAR_INFORMES_NO_ASIGNADOS=
			"Select * from Informes  where id "
			+ "not in (select id from SolicitudPericial )";
	/**
	 * Constante SQL_BUSCAR_PERITOS
	 */
	private static final String SQL_BUSCAR_PERITOS=
			"Select i.*,c.estadoAsignacionPericial from InscripcionPericial i, Colegiado c "
			+ "where i.dniColegiado=c.dniColegiado and i.estadoInscripcion=? order by i.posicionLista";
	/**
	 * Constante SQL_ASIGNAR_INFORME
	 */
	private static final String SQL_ASIGNAR_INFORME=
			"Insert into SolicitudPericial (id,dni,estado,fecha) values (?,?,?,?)";
	/**
	 * Constante SQL_ACTUALIZAR_ESTADO_PERITO
	 */
	private static final String SQL_ACTUALIZAR_ESTADO_PERITO = 
			"Update Colegiado set estadoAsignacionPericial=? where dniColegiado=?";
	/**
	 * Constante SQL_ACTUALIZAR_TURNO
	 */
	private static final String SQL_ACTUALIZAR_TURNO = "update InscripcionPericial set posicionLista=? "
			+ "where dniColegiado=?";
	/**
	 * Constante SQL_ACTUALIZAR_TURNO_ANT
	 */
	private static final String SQL_ACTUALIZAR_TURNO_ANT =  "update InscripcionPericial set posicionLista= posicionLista-1 "
			+ "where dniColegiado=?";;
	/**
	 * Constante SQL_BUSCAR_ASIGNACIONES_ASIGNADAS
	 */	
	private static final String SQL_BUSCAR_ASIGNACIONES_ASIGNADAS =
			"SELECT P.ID, I.DNI, I.NOMBRE, "
		            + "C.DNICOLEGIADO, C.NOMBRECOLEGIADO, P.FECHA, P.ESTADO "
		            + "FROM SOLICITUDPERICIAL P, COLEGIADO C, INFORMES I "
		            + "WHERE P.DNI=C.DNICOLEGIADO AND P.ID=I.ID AND P.ESTADO = 'Asignada'";
	/**
	 * Constante SQL_ANULAR_ASIGNACION
	 */
	private static final String SQL_ANULAR_ASIGNACION = "UPDATE SOLICITUDPERICIAL SET ESTADO='Anulada', FECHA=?, MOTIVOANULACION=? WHERE ID=?";
	
	/**
	 * Atributo db
	 */
	private Database db = new Database();
	
	/**
	 * Método getInformes
	 * @return informes
	 */
	public List<InformeDTO> getInformes(){
		return db.executeQueryPojo(InformeDTO.class, SQL_BUSCAR_INFORMES_NO_ASIGNADOS);
	}
	
	/**
	 * Método getPeritos
	 * @return peritos
	 */
	public List<InscripcionPericialDTO> getPeritos(){
		return db.executeQueryPojo(InscripcionPericialDTO.class, SQL_BUSCAR_PERITOS, "Inscrito");
	}
	
	/**
	 * Método getAsignaciones 
	 * @return asignaciones
	 */
	public List<AsignacionPericialDTO> getAsignaciones() {
		return db.executeQueryPojo(AsignacionPericialDTO.class, SQL_BUSCAR_ASIGNACIONES_ASIGNADAS);
	}
	
	/**
	 * Método asignarInforme
	 * @param dni
	 * @param id
	 */
	public void asignarInforme(String dni, String  id) {
		db.executeUpdate(SQL_ASIGNAR_INFORME, id,dni,"Asignada",new Timestamp(System.currentTimeMillis()));
	}
	
	/**
	 * Método asignarPerito
	 * @param dni
	 */
	public void asignarPerito(String dni) {
		db.executeUpdate(SQL_ACTUALIZAR_ESTADO_PERITO, "Asignado", dni);
	}
	
	/**
	 * Método actualizarTurno
	 * @param dni
	 */
	public void actualizarTurno(String dni) {
		int turno =  new InscripcionPericialModel().getUltimoTurnoPericial()+1;
		db.executeUpdate(SQL_ACTUALIZAR_TURNO,turno,dni);
	}
	
	/**
	 * Método actualizarTurnoAnt
	 * @param dniPeritoAnterior
	 */
	public void actualizarTurnoAnt(String dniPeritoAnterior) {
		db.executeUpdate(SQL_ACTUALIZAR_TURNO_ANT,dniPeritoAnterior);		
	}	

	/**
	 * Método anularAsignacion
	 * @param fecha
	 * @param motivo
	 * @param id
	 */
	public void anularAsignacion(String fecha, String motivo, String id) {
		db.executeUpdate(SQL_ANULAR_ASIGNACION, fecha, motivo, id);
	}
	
	/**
	 * Método anularPerito
	 * @param dni
	 */
	public void anularPerito(String dni) {
		db.executeUpdate(SQL_ACTUALIZAR_ESTADO_PERITO, "NA", dni);
	}
}
