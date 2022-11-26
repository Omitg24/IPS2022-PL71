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
	
	public static final String SQL_LISTAR_CURSOS = "SELECT C.*, COUNT(*) AS NINSCRITOS FROM CURSO C, INSCRIBE I "
				+ "WHERE C.TITULOCURSO=I.TITULOCURSO AND C.FECHACURSO = I.FECHACURSO "
				+ "GROUP BY C.TITULOCURSO, C.FECHACURSO "
					+ "UNION "
				+ "SELECT *, 0 FROM CURSO "
				+ "WHERE TITULOCURSO NOT IN "
					+ "(SELECT I.TITULOCURSO FROM INSCRIBE I)"
				+ "AND FECHACURSO NOT IN "
					+ "(SELECT I.FECHACURSO FROM INSCRIBE I)";
	public static final String SQL_LISTAR_INSCRITOS = "Select DISTINCT apellidosColegiado , nombreColegiado, "
			+ " fecha, estadoS, abonado from Curso c, Inscribe i ,Colegiado o "
			+ "where c.tituloCurso = i.tituloCurso and i.dniColegiado = o.dniColegiado "
			+ "and i.tituloCurso = ? and i.fechaCurso = ? order by o.apellidosColegiado,nombreColegiado";
	public static final String SQL_LISTAR_ESPERA = "SELECT CO.APELLIDOSCOLEGIADO, CO.NOMBRECOLEGIADO, "
			+ "I.FECHA, I.ESTADOS, I.POSICIONESPERA FROM COLEGIADO CO, INSCRIBE I, CURSO CU "
			+ "WHERE I.ESTADOS='Pendiente' AND I.ENESPERA=TRUE AND CO.DNICOLEGIADO=I.DNICOLEGIADO "
			+ "AND CU.TITULOCURSO=? AND CU.FECHACURSO=? ORDER BY I.POSICIONESPERA";
	
	private Database db = new Database();	
	
	public List<CursoDTO> getListaCursos(){
		return db.executeQueryPojo(CursoDTO.class, SQL_LISTAR_CURSOS);
	}
	
	public List<InscritoDTO> getListaInscrito(String tituloCurso, String fechaCurso) {
		Util.validateNotNull(tituloCurso, "El titulo del curso no puede ser null o estar vacio");
		Util.validateNotNull(fechaCurso, "La fecha del curso no puede ser null o estar vacio");
		return db.executeQueryPojo(InscritoDTO.class, SQL_LISTAR_INSCRITOS, tituloCurso, fechaCurso);
	}
	
	public List<InscritoDTO> getListaEspera(String tituloCurso, String fechaCurso) {
		Util.validateNotNull(tituloCurso, "El titulo del curso no puede ser null o estar vacio");
		Util.validateNotNull(fechaCurso, "La fecha del curso no puede ser null o estar vacio");
		return db.executeQueryPojo(InscritoDTO.class, SQL_LISTAR_ESPERA, tituloCurso, fechaCurso);
	}
}
