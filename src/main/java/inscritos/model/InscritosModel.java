package inscritos.model;

import java.util.List;

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
	
	public static final String SQL_LISTAR_CURSOS = "Select tituloCurso from Curso";
	public static final String SQL_LISTAR_INSCRITOS = "Select apellidosColegiado , nombreColegiado, "
			+ " fecha, estadoS, abonado from Curso c, Inscribe i ,Colegiado o "
			+ "where c.tituloCurso = i.tituloCurso and i.dniColegiado = o.dniColegiado "
			+ "and i.tituloCurso = ? order by o.apellidosColegiado,nombreColegiado";
	
	private Database db = new Database();
	
	
	public List<InscritoDTO> getListaInscrito(String tituloCurso) {
		validateNotNullOrEmpty(tituloCurso);
		return db.executeQueryPojo(InscritoDTO.class, SQL_LISTAR_INSCRITOS,tituloCurso);
	}
	
	public List<Object[]> getListaCursos(){
		return db.executeQueryArray(SQL_LISTAR_CURSOS);
	}
	
	private void validateNotNullOrEmpty(String cadena) {
		Util.validateNotNull(cadena,"El título del curso no puede ser null o estar vacio");
	}

}
