package coiipa.model.model;

import java.util.UUID;

import coiipa.model.dto.InformeDTO;
import util.Database;

/**
 * Título: Clase AperturaModel
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class InformeModel {

	private Database db = new Database();
	
	public static final String SQL_INSERTAR_INFORME_PERICIAL=
			"insert into Informes(id, nombre, telefono, correo, dni, descripcion, urgencia) values (?, ?, ?, ?, ?, ?, ?)";
	
	public static final String SQL_OBTENER_INFORMES_POR_DNI=
			"select * from Informes where dni=?";
	
	public static final String SQL_FIND_INFORME = 
			"SELECT * FROM INFORMES WHERE ID=?";
	
	/**
	 * Método que inserta una nueva solicitud de informe pericial
	 */
	public void addInformePericial(String nombre, String telefono, String correo, String dni, String descripcion, boolean normal) {
		String urgencia = normal ? "Normal" : "Urgente";
		db.executeUpdate(SQL_INSERTAR_INFORME_PERICIAL, UUID.randomUUID().toString(), nombre, telefono, correo, dni, descripcion, urgencia);
	}

	/**
	 * Devuelve true si el dni introducido como parámetro ya ha enviado una solicitud
	 */
	public boolean isSent(String dni) {
		if (!db.executeQueryArray(SQL_OBTENER_INFORMES_POR_DNI, dni).isEmpty()) return true;
		else return false;
	}
	
	public InformeDTO findInforme(String id) {
		return db.executeQueryPojo(InformeDTO.class, SQL_FIND_INFORME, id).get(0);
	}
}
