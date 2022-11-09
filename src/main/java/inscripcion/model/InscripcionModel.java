package inscripcion.model;

import java.time.LocalDate;
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
			"select * from colegiado where dniColegiado = ?";
	
	public static final String SQL_OBTENER_CURSO =
			"select * from curso where titulocurso = ? and fechaCurso=?";

	public static final String SQL_OBTENER_CURSO_POR_KEY =
			"select * from curso where titulocurso = ?";

	public static final String SQL_INTRODUCIR_INSCRIBE =
			"insert into inscribe (dniColegiado, titulocurso,fechaCurso, fecha, estados, abonado)"
			+ "values(?, ?, ?, ?, ?, ?)";
	
	public static final String SQL_REDUCIR_NPLAZAS = 
			"update curso set nplazas=nplazas-1 where titulocurso = ?";
	
	private static final String SQL_LISTAR_CURSO_PREINSCRITO = 
			"Select c.tituloCurso, c.fechaCurso, c.precio, c.estadoC, i.fecha "
			+ "from Curso c, Inscribe i "
			+ "where c.tituloCurso=i.tituloCurso and c.fechaCurso=i.fechaCurso "
			+ "and i.dniColegiado =? and i.estadoS=?";
	
	private static final String SQL_ACTUALIZAR_INSCRITO=
			"Update Inscribe "
			+ "set estadoS=? "
			+ "where dniColegiado=? and tituloCurso=? and fechaCurso=?";
	
	private static final String SQL_FIND_INSCRIPCION=
			"Select * from Inscribe "
			+ "where dniColegiado=? and tituloCurso=? and fechaCurso=?";
	

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
	
	public CursoDTO getCursoFromKey(String titulo, String fecha) {
		System.out.println(titulo+"\n"+fecha);
		return db.executeQueryPojo(CursoDTO.class, SQL_OBTENER_CURSO, titulo,fecha).get(0);
	}

	public void insertarInscribe(CursoDTO curso, ColegiadoDTO colegiado) {
		if (curso.getNplazas() > 0) {
			db.executeUpdate(SQL_INTRODUCIR_INSCRIBE, colegiado.getDniColegiado(),
				curso.getTituloCurso(),curso.getFechaCurso(),LocalDate.now(),"Pre-inscrito", curso.getPrecio());
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
	
	public List<CursoDTO> buscarCursoPorInscrito(String dni) {
		Util.validateNotNull(dni, "El dni no puede ser nulo");
		return db.executeQueryPojo(CursoDTO.class,SQL_LISTAR_CURSO_PREINSCRITO,dni,"Pre-inscrito");
	}
	
	public void actualizarEstadoInscripcion(String dni, String titulo,
			String fecha,String estado) {
		Util.validateNotNull(dni, "El dni no puede ser nulo");
		Util.validateNotNull(titulo, "El titulo no puede ser nulo");
		Util.validateNotNull(fecha, "La fecha no puede ser nulo");
		Util.validateNotNull(estado, "El estado no puede ser nulo");
		db.executeUpdate(SQL_ACTUALIZAR_INSCRITO, estado,dni,titulo,fecha);
	}
	
	public InscribeDTO buscarInscripcionCurso(String dni, String titulo,
			String fecha) {
		Util.validateNotNull(dni, "El dni no puede ser nulo");
		Util.validateNotNull(titulo, "El titulo no puede ser nulo");
		Util.validateNotNull(fecha, "La fecha no puede ser nulo");
		return db.executeQueryPojo(InscribeDTO.class,SQL_FIND_INSCRIPCION,dni,titulo,fecha).get(0);
	}


}
