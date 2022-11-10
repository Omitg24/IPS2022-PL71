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
			+ "FECHACURSO, FECHAINICIOINS, FECHAFININS, PRECIO, ESTADOC, NPLAZAS FROM CURSO WHERE ESTADOC = 'Abierta'";	
	/**
	 * Constante SQL_LISTAR_PREINSCRITOS
	 */
	public static final String SQL_LISTAR_PREINSCRITOS = "SELECT I.DNICOLEGIADO, I.TITULOCURSO, O.APELLIDOSCOLEGIADO, O.NOMBRECOLEGIADO, "
			+ "I.FECHA, I.FECHACURSO, I.ESTADOS, I.ABONADO FROM INSCRIBE I, COLEGIADO O WHERE O.DNICOLEGIADO=I.DNICOLEGIADO "
			+ "AND ESTADOS='Pre-inscrito' AND I.TITULOCURSO=? AND I.FECHACURSO=? ORDER BY O.APELLIDOSCOLEGIADO, O.NOMBRECOLEGIADO";	
	/**
	 * Constante SQL_UPDATE_ESTADO
	 */
	public static final String SQL_UPDATE_ESTADO = "UPDATE INSCRIBE SET ESTADOS = ? WHERE DNICOLEGIADO = ? AND TITULOCURSO = ? AND FECHACURSO = ?";
	/**
	 * Constante SQL_UPDATE_PREINSCRITO
	 */
	public static final String SQL_UPDATE_PREINSCRITO = "UPDATE INSCRIBE SET ESTADOS = ?, INCIDENCIA = ? WHERE DNICOLEGIADO = ? AND TITULOCURSO = ? AND FECHACURSO = ?";
	/**
	 * Constante SQL_UPDATE_INSCRITO
	 */
	public static final String SQL_UPDATE_INSCRITO = "UPDATE INSCRIBE SET ESTADOS = ?, ABONADO = ? WHERE DNICOLEGIADO = ? AND TITULOCURSO = ? AND FECHACURSO = ?";
	
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
	 * @param estadoS
	 * @param dniColegiado
	 * @param tituloCurso
	 * @param fechaCurso
	 */
	public void updateEstado(String estadoS, String dniColegiado, String tituloCurso, String fechaCurso) {
		db.executeUpdate(SQL_UPDATE_ESTADO, estadoS, dniColegiado, tituloCurso, fechaCurso);
	}
	
	/**
	 * Método updatePreinscrito
	 * @param estadoS
	 * @param incidencia
	 * @param dniColegiado
	 * @param tituloCurso
	 * @param fechaCurso
	 */
	public void updatePreinscrito(String estadoS, String incidencia, String dniColegiado, String tituloCurso, String fechaCurso) {
		db.executeUpdate(SQL_UPDATE_PREINSCRITO, estadoS, incidencia, dniColegiado, tituloCurso, fechaCurso);
	}
	
	/**
	 * Método updateInscrito
	 * @param estado
	 * @param abonado
	 * @param dni
	 * @param tituloCurso
	 * @param fechaCurso
	 */
	public void updateInscrito(String estado, double abonado, String dni, String tituloCurso, String fechaCurso) {
		db.executeUpdate(SQL_UPDATE_INSCRITO, estado, abonado, dni, tituloCurso, fechaCurso);
	}
	
	/**
	 * Método validateNotNullOrEmpty
	 * @param cad
	 */
	private void validateNotNullOrEmpty(String cad) {
		Util.validateNotNull(cad,"La cadena no puede ser null o estar vacio");
	}
}
