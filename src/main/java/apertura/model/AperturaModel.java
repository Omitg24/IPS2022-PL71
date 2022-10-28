package apertura.model;

import java.util.Date;
import java.util.List;

import curso.model.CursoDTO;
import util.Database;
import util.Util;

/**
 * Título: Clase AperturaModel
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class AperturaModel {

//	private static final String MSG_FECHA_CURSO_NO_NULA = 
//			"La fecha de inscripcion no puede ser nula";
//	private static final String DEFAULT_INICIOINS="2022-01-01";
//	private static final String DEFAULT_FININS="2023-12-12";
//	private static final String DEFAULT_ESTADO="Planificado";
//	private static final int DEFAULT_NPLAZAS= 1;

	private Database db = new Database();
	
	public static final String SQL_OBTENER_CURSOS=
			"select * from curso;";
	
	public static final String SQL_ACTUALIZAR_CURSOS=
			"update curso set fechainicioins = ?, fechafinins = ?, nplazas = ?, "
			+ "estadoc = 'Abierta' where titulocurso = ?";
	
	public static final String SQL_OBTENER_CURSO_POR_KEY =
			"select * from curso where titulocurso = ?";
	
	/**
	 * Método que convierte la lista de cursos a un array de String
	 */
	public List<CursoDTO> getCursos() {
		return db.executeQueryPojo(CursoDTO.class, SQL_OBTENER_CURSOS);
	}
	
	/*
	 * Devuelve un curso dada una clave primaria
	 */
	public CursoDTO getCursoFromKey(String key) {
		return db.executeQueryPojo(CursoDTO.class, SQL_OBTENER_CURSO_POR_KEY, key).get(0);
	}
	
	/*
	 * Modifica las fechas de inscripción y el estado de un curso con clave key
	 */
	public void updateFechasCurso(Date inicio, Date fin, int nplazas, String key) {
		db.executeUpdate(SQL_ACTUALIZAR_CURSOS, Util.dateToIsoString(inicio), Util.dateToIsoString(fin), nplazas, key);
	}
}
