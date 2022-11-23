package coiipa.model.model;

import java.util.List;
import java.util.UUID;

import coiipa.model.dto.InscripcionPericialDTO;
import util.Database;

/**
 * 
 * Título: Clase SolicitudVisadoModel
 *
 * @author David Warzynski Abril, UO278968
 * @version 23 nov 2022
 */
public class SolicitudVisadoModel {

	private Database db = new Database();
	
	public static final String SQL_INSERTAR_SOLICITUD=
			"insert into SolicitudVisado(id,dni,nombre, apellidos,descripcion) values (?, ?, ?, ?, ?)";
	
	public static final String SQL_BUSCAR_PERITO=
			"Select * from InscripcionPericial where dniColegiado =? and estadoInscripcion='Inscrito'";
	
	/**
	 * Método que inserta una nueva solicitud de visado
	 */
	public void addInformePericial(String dni,String nombre, String apellidos,String descripcion) {
		db.executeUpdate(SQL_INSERTAR_SOLICITUD, UUID.randomUUID().toString(),dni, nombre, apellidos, descripcion);
	}

	public List<InscripcionPericialDTO> buscarPerito(String dni) {
		return db.executeQueryPojo(InscripcionPericialDTO.class, SQL_BUSCAR_PERITO, dni);
	}

}
