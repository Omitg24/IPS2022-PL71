package coiipa.model.model;

import java.util.Date;
import java.util.List;

import coiipa.model.dto.CursoDTO;
import util.Database;
import util.Util;

/**
 * Título: Clase AperturaModel
 *
 * @author Adrián Alves Morales, UO284288 y David Warzynski Abril, UO278968
 * @version 28 nov 2022
 */
public class AperturaModel {


	private Database db = new Database();
	
	public static final String SQL_OBTENER_CURSOS=
			"select * from curso;";
	
	public static final String SQL_ACTUALIZAR_CURSOS=
			"update curso set fechainicioins = ?, fechafinins = ?, nplazas = ?, "
			+ "estadoc = 'Abierta' where titulocurso = ? and fechaCurso=?";
	
	public static final String SQL_OBTENER_CURSO_POR_KEY =
			"select * from curso where titulocurso = ? and fechaCurso=?";
	
	/**
	 * Método que convierte la lista de cursos a un array de String
	 */
	public List<CursoDTO> getCursos() {
		return db.executeQueryPojo(CursoDTO.class, SQL_OBTENER_CURSOS);
	}
	
	/*
	 * Devuelve un curso dada una clave primaria
	 */
	public CursoDTO getCursoFromKey(String titulo, String fecha) {
		return db.executeQueryPojo(CursoDTO.class, SQL_OBTENER_CURSO_POR_KEY, titulo,fecha).get(0);
	}
	
	/*
	 * Modifica las fechas de inscripción y el estado de un curso con clave key
	 */
	public void updateFechasCurso(Date inicio, Date fin, int nplazas, String titulo,String fecha) {
		db.executeUpdate(SQL_ACTUALIZAR_CURSOS, Util.dateToIsoString(inicio), 
				Util.dateToIsoString(fin), nplazas, titulo, fecha);
	}
}
