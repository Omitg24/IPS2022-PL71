package coiipa.model.model;

import java.util.List;

import coiipa.model.dto.CursoDTO;
import coiipa.model.dto.InscritoDTO;
import util.Database;
import util.Util;

/**
 * 
 * Título: Clase InscritosModel
 * 
 * @author David Warzynski Abril, UO278968
 * @version 13 oct 2022
 */
public class InscritosModel {
	/**
	 * Constante SQL_LISTAR_CURSOS
	 */
	public static final String SQL_LISTAR_CURSOS = "SELECT C.*, COUNT(*) AS NINSCRITOS FROM CURSO C, INSCRIBE I "
				+ "WHERE C.TITULOCURSO=I.TITULOCURSO AND C.FECHACURSO = I.FECHACURSO "
				+ "GROUP BY C.TITULOCURSO, C.FECHACURSO "
					+ "UNION "
				+ "SELECT *, 0 FROM CURSO "
				+ "WHERE TITULOCURSO NOT IN "
					+ "(SELECT I.TITULOCURSO FROM INSCRIBE I)"
				+ "AND FECHACURSO NOT IN "
					+ "(SELECT I.FECHACURSO FROM INSCRIBE I)";
	/**
	 * Constante SQL_LISTAR_INSCRITOS
	 */
	public static final String SQL_LISTAR_INSCRITOS = "Select DISTINCT apellidosColegiado , nombreColegiado, "
			+ " fecha, estadoS, abonado from Curso c, Inscribe i ,Colegiado o "
			+ "where c.tituloCurso = i.tituloCurso and i.dniColegiado = o.dniColegiado "
			+ "and i.estados<> 'Pendiente' "
			+ "and i.estados<> 'Cancelado' "
			+ "and i.tituloCurso = ? "
			+ "and i.fechaCurso = ? "
			+ "order by o.apellidosColegiado, nombreColegiado";
	/**
	 * Constante SQL_LISTAR_INSCRITOS_CON_CURSOS
	 */
	public static final String SQL_LISTAR_INSCRITOS_A_ELIMINAR = "Select i.dniColegiado , i.tituloCurso, "
			+ " o.apellidosColegiado, o.nombreColegiado, i.fechaCurso, i.fecha, i.estadoS from Curso c, Inscribe i ,Colegiado o "
			+ "where c.tituloCurso = i.tituloCurso and i.dniColegiado = o.dniColegiado and "
			+ "i.tituloCurso = ? and i.fechaCurso = ? order by o.apellidosColegiado, o.nombreColegiado";
	/**
	 * Constante SQL_LISTAR_ESPERA
	 */
	public static final String SQL_LISTAR_ESPERA = "SELECT CO.APELLIDOSCOLEGIADO, CO.NOMBRECOLEGIADO, "
			+ "I.FECHA, I.ESTADOS, I.POSICIONESPERA FROM COLEGIADO CO, INSCRIBE I, CURSO CU "
			+ "WHERE I.ESTADOS='Pendiente' AND I.ENESPERA=TRUE AND CO.DNICOLEGIADO=I.DNICOLEGIADO "
			+ "AND I.TITULOCURSO=CU.TITULOCURSO AND I.FECHACURSO=CU.FECHACURSO "
			+ "AND CU.TITULOCURSO=? AND CU.FECHACURSO=? ORDER BY I.POSICIONESPERA";
	/**
	 * Constante SQL_CANCELAR_CURSO
	 */
	public static final String SQL_CANCELAR_CURSO = "UPDATE CURSO "
			+ "set estadoc = 'Cancelado', porcentajeDevolucion = 1 "
			+ "where tituloCurso = ? and fechaCurso = ?";
	/**
	 * Constante SQL_CANCELAR_INSCRIPCIÓN
	 */
	public static final String SQL_CANCELAR_INSCRIPCION = "UPDATE INSCRIBE "
			+ "set estadoS = 'Cancelado', abonado = 1, incidencia = ? "
			+ "where tituloCurso = ? and fechaCurso = ?";
	
	/**
	 * Atributo db
	 */
	private Database db = new Database();	
	
	/**
	 * Método getListaCursos
	 * @return cursos
	 */
	public List<CursoDTO> getListaCursos(){
		return db.executeQueryPojo(CursoDTO.class, SQL_LISTAR_CURSOS);
	}
	
	/**
	 * Método getListaInscritos
	 * @param tituloCurso
	 * @param fechaCurso
	 * @return inscritos
	 */
	public List<InscritoDTO> getListaInscritos(String tituloCurso, String fechaCurso) {
		Util.validateNotNull(tituloCurso, "El titulo del curso no puede ser null o estar vacio");
		Util.validateNotNull(fechaCurso, "La fecha del curso no puede ser null o estar vacio");
		return db.executeQueryPojo(InscritoDTO.class, SQL_LISTAR_INSCRITOS, tituloCurso, fechaCurso);
	}
	
	/**
	 * Método getListaEspera
	 * @param tituloCurso
	 * @param fechaCurso
	 * @return listaEspera
	 */
	public List<InscritoDTO> getListaEspera(String tituloCurso, String fechaCurso) {
		Util.validateNotNull(tituloCurso, "El titulo del curso no puede ser null o estar vacio");
		Util.validateNotNull(fechaCurso, "La fecha del curso no puede ser null o estar vacio");
		return db.executeQueryPojo(InscritoDTO.class, SQL_LISTAR_ESPERA, tituloCurso, fechaCurso);
	}
	
	/**
	 * Método getListaInscritosAEliminar
	 * @param tituloCurso
	 * @param fechaCurso
	 * @return inscritos
	 */
	public List<InscritoDTO> getListaInscritosAEliminar(String tituloCurso, String fechaCurso) {
		Util.validateNotNull(tituloCurso, "El titulo del curso no puede ser null o estar vacio");
		Util.validateNotNull(fechaCurso, "La fecha del curso no puede ser null o estar vacio");
		return db.executeQueryPojo(InscritoDTO.class, SQL_LISTAR_INSCRITOS_A_ELIMINAR, tituloCurso, fechaCurso);
	}
	
	/**
	 * Método cancelarCurso
	 * @param tituloCurso
	 */
	public void cancelarCurso(String tituloCurso, String fechaCurso) {
		db.executeUpdate(SQL_CANCELAR_CURSO, tituloCurso, fechaCurso);
	}

	/**
	 * Método anularInscripcion
	 * @param tituloCurso
	 */
	public void anularInscripcion(List<InscritoDTO> inscritos) {
		for (InscritoDTO i : inscritos) {
			if (i.getTituloCurso() != null) {
				String incidencia = "Se han devuelto " + i.getAbonado() + "€ por la cancelación del curso " + i.getTituloCurso();
				db.executeUpdate(SQL_CANCELAR_INSCRIPCION, incidencia, i.getTituloCurso(), i.getFechaCurso());
			}
		}		
	}
}
