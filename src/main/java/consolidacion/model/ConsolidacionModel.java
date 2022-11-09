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
	public static final String SQL_LISTAR_PREINSCRITOS = "SELECT I.DNICOLEGIADO, I.TITULOCURSO, O.APELLIDOSCOLEGIADO, O.NOMBRECOLEGIADO, "
			+ "I.FECHA, I.FECHACURSO, I.ESTADOS, I.ABONADO FROM INSCRIBE I, COLEGIADO O WHERE O.DNICOLEGIADO=I.DNICOLEGIADO "
			+ "AND ESTADOS='Pre-inscrito' AND I.TITULOCURSO=? AND I.FECHACURSO=? ORDER BY O.APELLIDOSCOLEGIADO, O.NOMBRECOLEGIADO";	
	/**
	 * Constante SQL_UPDATE_ESTADO
	 */
	public static final String SQL_UPDATE_ESTADO = "UPDATE INSCRIBE SET ESTADOS = ? WHERE DNICOLEGIADO = ?";
	/**
	 * Constante SQL_UPDATE_PREINSCRITO
	 */
	public static final String SQL_UPDATE_PREINSCRITO = "UPDATE INSCRIBE SET ESTADOS = ?, INCIDENCIA = ? WHERE DNICOLEGIADO = ?";
	/**
	 * Constante SQL_UPDATE_INSCRITO
	 */
	public static final String SQL_UPDATE_INSCRITO = "UPDATE INSCRIBE SET ESTADOS = ?, ABONADO = ? WHERE DNICOLEGIADO = ?";
	
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
	 * Método updateEstado
	 * @param estado
	 * @param dni
	 */
	public void updateEstado(String estado, String dni) {
		db.executeUpdate(SQL_UPDATE_ESTADO, estado, dni);
	}
	
	/**
	 * Método updatePreinscrito
	 * @param estado
	 * @param incidencia
	 * @param dni
	 */
	public void updatePreinscrito(String estado, String incidencia,String dni) {
		db.executeUpdate(SQL_UPDATE_PREINSCRITO, estado, incidencia, dni);
	}
	
	public void updateInscrito(String estado, double abonado, String dni) {
		db.executeUpdate(SQL_UPDATE_INSCRITO, estado, abonado, dni);
	}
	
	/**
	 * Método validateNotNullOrEmpty
	 * @param cad
	 */
	private void validateNotNullOrEmpty(String cad) {
		Util.validateNotNull(cad,"La cadena no puede ser null o estar vacio");
	}
}
