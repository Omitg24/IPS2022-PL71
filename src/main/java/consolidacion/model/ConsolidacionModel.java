package consolidacion.model;

import java.util.List;

import curso.model.CursoDTO;
import inscritos.model.InscritoDTO;
import util.Database;
import util.Util;

/**
 * Titulo: Clase ConsolidacionModel
 *
 * @author Omar Teixeira González, UO281847
 * @version 7 nov 2022
 */
public class ConsolidacionModel {
	/**
	 * Constante SQL_LISTAR_CURSOS
	 */
	public static final String SQL_LISTAR_CURSOS = "SELECT TITULOCURSO, "
			+ "FECHACURSO, FECHAINICIOINS, FECHAFININS, PRECIO, ESTADOC, NPLAZAS FROM CURSO";
	
	/**
	 * Constante SQL_LISTAR_PREINSCRITOS
	 */
	public static final String SQL_LISTAR_PREINSCRITOS = "SELECT APELLIDOSCOLEGIADO, NOMBRECOLEGIADO, "
			+ "FECHA, FECHACURSO, ESTADOS, ABONADO FROM INSCRIBE I, COLEGIADO O WHERE O.DNICOLEGIADO=I.DNICOLEGIADO "
			+ "AND ESTADOS='Pre-inscrito' AND I.TITULOCURSO=? AND I.FECHACURSO=? ORDER BY O.APELLIDOSCOLEGIADO, O.NOMBRECOLEGIADO";
	
	/**
	 * Atributo db
	 */
	private Database db = new Database();
	
	/**
	 * Método getListaCursos
	 * @return list
	 */
	public List<CursoDTO> getListaCursos() {
		return db.executeQueryPojo(CursoDTO.class, SQL_LISTAR_CURSOS);
	}
	
	/**
	 * Método getListaPreinscritos
	 * @param tituloCurso
	 * @return list
	 */
	public List<InscritoDTO> getListaPreinscritos(String tituloCurso, String fechaCurso) {
		validateNotNullOrEmpty(tituloCurso);
		validateNotNullOrEmpty(fechaCurso);
		return db.executeQueryPojo(InscritoDTO.class, SQL_LISTAR_PREINSCRITOS, tituloCurso, fechaCurso);
	}
	
	/**
	 * Método validateNotNullOrEmpty
	 * @param cad
	 */
	private void validateNotNullOrEmpty(String cad) {
		Util.validateNotNull(cad,"El título del curso no puede ser null o estar vacio");
	}
}
