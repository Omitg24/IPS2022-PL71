package inscripcion.model;

import java.util.List;

import colegiado.model.ColegiadoDTO;
import curso.model.CursoDTO;
import util.Database;
import util.SwingUtil;
import util.Util;

/**
 * Título: Clase InscripcionModel
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class InscripcionModel {

//	private static final String MSG_FECHA_CURSO_NO_NULA =
//			"La fecha de inscripcion no puede ser nula";
//	private static final String DEFAULT_INICIOINS="2022-01-01";
//	private static final String DEFAULT_FININS="2023-12-12";
//	private static final String DEFAULT_ESTADO="Planificado";
//	private static final int DEFAULT_NPLAZAS= 1;

	private Database db = new Database();

	public static final String SQL_OBTENER_CURSOS_ABIERTOS=
			"select * from curso where estadoc='Abierta';";

	public static final String SQL_OBTENER_COLEGIADO_POR_KEY =
			"select * from colegiado where dniSol = ?";

	public static final String SQL_OBTENER_CURSO_POR_KEY =
			"select * from curso where titulocurso = ?";

	public static final String SQL_INTRODUCIR_INSCRIBE =
			"insert into inscribe (dnisol, titulocurso, fecha, estados, abonado)"
			+ "values(?, ?, ?, ?, ?)";
	
	public static final String SQL_REDUCIR_NPLAZAS = 
			"update curso set nplazas=nplazas-1 where titulocurso = ?";
	

	/**
	 * Método que convierte la lista de cursos a un array de String
	 */
	public List<CursoDTO> getCursosAbiertos() {
		return db.executeQueryPojo(CursoDTO.class, SQL_OBTENER_CURSOS_ABIERTOS);
	}

	/*
	 * Devuelve un curso dada una clave primaria
	 */
	public CursoDTO getCursoFromKey(String key) {
		return db.executeQueryPojo(CursoDTO.class, SQL_OBTENER_CURSO_POR_KEY, key).get(0);
	}

	public void insertarInscribe(CursoDTO curso, ColegiadoDTO colegiado) {
		if (curso.getNplazas() > 0) {
			db.executeUpdate(SQL_INTRODUCIR_INSCRIBE, colegiado.getDniSol(),
				curso.getTituloCurso(), Util.isoStringToDate(curso.getFechaCurso()),"Pre-inscrito", curso.getPrecio());
			db.executeUpdate(SQL_REDUCIR_NPLAZAS, curso.getTituloCurso());
		}
		else {
			SwingUtil.showErrorDialog("No hay plazas disponibles para el curso seleccionado");
		}
		
	}

	/*
	 * Devuelve un curso dada una clave primaria
	 */
	public ColegiadoDTO getSolicitanteFromKey(String key) {
		if (!db.executeQueryPojo(ColegiadoDTO.class, SQL_OBTENER_COLEGIADO_POR_KEY, key).isEmpty()) {
			System.out.println(db.executeQueryPojo(ColegiadoDTO.class, SQL_OBTENER_COLEGIADO_POR_KEY, key).get(0));
			return db.executeQueryPojo(ColegiadoDTO.class, SQL_OBTENER_COLEGIADO_POR_KEY, key).get(0);
		}
		else return null;
	}
	
	public void reducirNplazas(String key) {
		db.executeUpdate(SQL_REDUCIR_NPLAZAS, key);
	}

}
