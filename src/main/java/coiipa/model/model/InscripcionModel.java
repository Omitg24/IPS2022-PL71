package coiipa.model.model;

import java.time.LocalDate;
import java.util.List;

import coiipa.model.dto.ColegiadoDTO;
import coiipa.model.dto.CursoDTO;
import coiipa.model.dto.InscribeDTO;
import coiipa.model.dto.InscritoDTO;
import util.Database;
import util.Util;

/**
 * Título: Clase InscripcionModel
 *
 * @author Adrián Alves Morales, UO284288 y Omar Teixeira González, UO281847
 * @version 12 oct 2022
 */
public class InscripcionModel {

//	private static final String MSG_FECHA_CURSO_NO_NULA =
//			"La fecha de inscripcion no puede ser nula";
//	private static final String DEFAULT_INICIOINS="2022-01-01";
//	private static final String DEFAULT_FININS="2023-12-12";
//	private static final String DEFAULT_ESTADO="Planificado";
//	private static final int DEFAULT_NPLAZAS= 1;
	
	/**
	 * Atributo db
	 */
	private Database db = new Database();

	/**
	 * Constante SQL_LISTAR_CURSOS_DISPONIBLES
	 */
	private static final String SQL_LISTAR_CURSOS_DISPONIBLES=
			"select * from curso where estadoc='Abierta'";	
	/**
	 * Constante SQL_LISTAR_CURSOS_SOLICITADO
	 */
	private static final String SQL_LISTAR_CURSOS_SOLICITADOS = 
			"Select c.tituloCurso, c.fechaCurso, c.precio, c.estadoC, i.fecha,"
			+ " c.cancelable, c.porcentajeDevolucion "
			+ "from Curso c, Inscribe i "
			+ "where c.tituloCurso=i.tituloCurso and i.enEspera=false and i.estadoS<> 'Cancelado' "
			+ "and c.fechaCurso=i.fechaCurso and i.dniColegiado=?  ";	
	/**
	 * Constante SQL_OBTENER_CURSO
	 */
	private static final String SQL_OBTENER_CURSO =
			"select * from curso where titulocurso = ? and fechaCurso=?";	
	/**
	 * Constante SQL_INTRODUCIR_INSCRIBE
	 */
	private static final String SQL_INSCRIBIRSE =
			"insert into inscribe (dniColegiado, titulocurso, fechaCurso, fecha, estados, abonado, enEspera) "
			+ "values (?, ?, ?, ?, ?, ?, FALSE)";	
	/**
	 * Constante SQL_REDUCIR_NPLAZAS
	 */
	private static final String SQL_REDUCIR_NPLAZAS = 
			"update curso set nplazas=nplazas-1 where titulocurso = ? and fechaCurso=?";
	
	/**
	 * Constante SQL_AUMENTAR_NPLAZAS
	 */
	private static final String SQL_AUMENTAR_NPLAZAS = 
			"update curso set nplazas=nplazas+1 where titulocurso = ? and fechaCurso=?";	
	
	/**
	 * Constante SQL_ACTUALIZAR_INSCRITO
	 */
	private static final String SQL_ACTUALIZAR_INSCRITO_ABONADO=
			"Update Inscribe "
			+ "set estadoS=?, abonado=? "
			+ "where dniColegiado=? and tituloCurso=? and fechaCurso=?";
	
	/**
	 * Constante SQL_ACTUALIZAR_INSCRITO
	 */
	private static final String SQL_ACTUALIZAR_INSCRITO=
			"Update Inscribe "
			+ "set estadoS=? "
			+ "where dniColegiado=? and tituloCurso=? and fechaCurso=?";
	/**
	 * Constrante SQL_FIND_INSCRIPCION
	 */
	private static final String SQL_FIND_INSCRIPCION=
			"Select * from Inscribe "
			+ "where dniColegiado=? and tituloCurso=? and fechaCurso=?";
	/**
	 * Constante SQL_FIND_CURSO_INSCRITO
	 */
	private static final String SQL_FIND_CURSO_INSCRITO=
			"SELECT C.*, I.ESTADOS, I.POSICIONESPERA FROM CURSO C, INSCRIBE I WHERE C.TITULOCURSO=I.TITULOCURSO AND C.FECHACURSO=I.FECHACURSO "
			+ "AND C.TITULOCURSO=? AND C.FECHACURSO=? AND I.DNICOLEGIADO=?";
	/**
	 * Constante SQL_OBTENER_COLEGIADO
	 */
	private static final String SQL_OBTENER_COLEGIADO=
			"SELECT * FROM COLEGIADO WHERE DNICOLEGIADO=?";	
	/**
	 * Constante SQL_INSERTAR_EN_ESPERA
	 */
	private static final String SQL_INSERTAR_EN_ESPERA = 
			"INSERT INTO INSCRIBE (DNICOLEGIADO, TITULOCURSO, FECHACURSO, FECHA, ESTADOS, ENESPERA, POSICIONESPERA) "
			+ "VALUES (?, ?, ?, ?, 'Pendiente', TRUE, ?)";
	/**
	 * Constante SQL_OBTENER_POSICION
	 */
	private static final String SQL_OBTENER_POSICION = 
			"SELECT * FROM INSCRIBE WHERE TITULOCURSO=? AND FECHACURSO=? AND ENESPERA=TRUE ORDER BY POSICIONESPERA DESC";
	/**
	 * Constante SQL_OBTENER_LISTA_ESPERA
	 */
	private static final String SQL_OBTENER_LISTA_ESPERA = 
			"SELECT * FROM INSCRIBE WHERE ESTADOS='Pendiente' AND ENESPERA=TRUE AND DNICOLEGIADO=? ORDER BY POSICIONESPERA";

	private static final String SQL_BORRAR_INSCRIBIRSE = "DELETE from INSCRIBE WHERE dniColegiado=? and titulocurso=? and fechacurso=?";

	/**
	 * Método getCursosDisponibles
	 */
	public List<CursoDTO> getCursosDisponibles() {
		return db.executeQueryPojo(CursoDTO.class, SQL_LISTAR_CURSOS_DISPONIBLES);
	}
	
	/**
	 * Método getCursosSolicitado
	 * @param dni
	 * @return cursos
	 */
	public List<CursoDTO> getCursosSolicitados(String dni) {
		Util.validateNotNull(dni, "El dni no puede ser nulo");
		return db.executeQueryPojo(CursoDTO.class, SQL_LISTAR_CURSOS_SOLICITADOS, dni);
	}
	
	/**
	 * Método getCursoTituloFecha
	 * @param titulo
	 * @param fecha
	 * @return curso
	 */
	public CursoDTO getCursoTituloFecha(String titulo, String fecha) {
		return db.executeQueryPojo(CursoDTO.class, SQL_OBTENER_CURSO, titulo,fecha).get(0);
	}

	/**
	 * Método inscribir
	 * @param curso
	 * @param colegiado
	 */
	public void inscribir(CursoDTO curso, ColegiadoDTO colegiado) {
		db.executeUpdate(SQL_INSCRIBIRSE, colegiado.getDniColegiado(),
				curso.getTituloCurso(), curso.getFechaCurso(), LocalDate.now(), "Pre-inscrito", curso.getPrecio());
		db.executeUpdate(SQL_REDUCIR_NPLAZAS, curso.getTituloCurso(), curso.getFechaCurso());		
	}
	
	/**
	 * Método actualizarEstadoInscripcion
	 * @param dni
	 * @param titulo
	 * @param fecha
	 * @param estado
	 */
	public void actualizarEstadoInscripcion(String dni, String titulo,
			String fecha,String estado) {
		Util.validateNotNull(dni, "El dni no puede ser nulo");
		Util.validateNotNull(titulo, "El titulo no puede ser nulo");
		Util.validateNotNull(fecha, "La fecha no puede ser nulo");
		Util.validateNotNull(estado, "El estado no puede ser nulo");
		db.executeUpdate(SQL_ACTUALIZAR_INSCRITO, estado,dni,titulo,fecha);
	}
	
	/**
	 * Método actualizarEstadoInscripcion
	 * @param dni
	 * @param titulo
	 * @param fecha
	 * @param estado
	 */
	public void actualizarEstadoInscripcion(String dni, String titulo,
			String fecha,String estado,double abonado) {
		Util.validateNotNull(dni, "El dni no puede ser nulo");
		Util.validateNotNull(titulo, "El titulo no puede ser nulo");
		Util.validateNotNull(fecha, "La fecha no puede ser nulo");
		Util.validateNotNull(estado, "El estado no puede ser nulo");
		db.executeUpdate(SQL_ACTUALIZAR_INSCRITO_ABONADO, estado,abonado,dni,titulo,fecha);
	}
	
	/**
	 * Método buscarInscripcionCurso
	 * @param dni
	 * @param titulo
	 * @param fecha
	 * @return inscribe
	 */
	public InscribeDTO buscarInscripcionCurso(String dni, String titulo,
			String fecha) {
		Util.validateNotNull(dni, "El dni no puede ser nulo");
		Util.validateNotNull(titulo, "El titulo no puede ser nulo");
		Util.validateNotNull(fecha, "La fecha no puede ser nulo");
		return db.executeQueryPojo(InscribeDTO.class,SQL_FIND_INSCRIPCION,dni,titulo,fecha).get(0);
	}
	
	/**
	 * Método getListaDeEspera
	 * @param dniColegiado
	 * @return inscritos
	 */
	public List<InscritoDTO> getListaDeEspera(String dniColegiado) {
		return db.executeQueryPojo(InscritoDTO.class, SQL_OBTENER_LISTA_ESPERA, dniColegiado);
	}

	/**
	 * Método getColegiado
	 * @param dniColegiado
	 * @return colegiado
	 */
	public ColegiadoDTO getColegiado(String dniColegiado) {
		List<ColegiadoDTO> colegiados = db.executeQueryPojo(ColegiadoDTO.class, SQL_OBTENER_COLEGIADO, dniColegiado);
		return colegiados.isEmpty() ? null : colegiados.get(0);
	}
	
	/**
	 * Método getCursoInscrito
	 * @param tituloCurso
	 * @param fechaCurso
	 * @param dniColegiado
	 * @return curso
	 */
	public CursoDTO getCursoInscrito(String tituloCurso, String fechaCurso, String dniColegiado) {
		List<CursoDTO> cursos = db.executeQueryPojo(CursoDTO.class, SQL_FIND_CURSO_INSCRITO, tituloCurso, fechaCurso, dniColegiado);
		return cursos.isEmpty() ? null : cursos.get(0);
	}
	
	/**
	 * Método getPosicionEnEspera
	 * @param tituloCurso
	 * @param fechaCurso
	 * @return posicion
	 */
	public int getPosicionEnEspera(String tituloCurso, String fechaCurso) {
		List<InscritoDTO> inscritos = db.executeQueryPojo(InscritoDTO.class, SQL_OBTENER_POSICION, tituloCurso, fechaCurso);
		return inscritos.isEmpty() ? 0 : inscritos.get(0).getPosicionEspera();
	}
	
	/**
	 * Método insertarEnEspera
	 * @param dniColegiado
	 * @param tituloCurso
	 * @param fechaCurso
	 * @param fecha
	 * @param posicion
	 */
	public void insertarEnEspera(String dniColegiado, String tituloCurso, String fechaCurso, String fecha, int posicion) {
		db.executeUpdate(SQL_INSERTAR_EN_ESPERA, dniColegiado, tituloCurso, fechaCurso, fecha, posicion);
	}

	public void borrarInscripcion(CursoDTO curso, ColegiadoDTO colegiado) {
		db.executeUpdate(SQL_BORRAR_INSCRIBIRSE, colegiado.getDniColegiado(),
				curso.getTituloCurso(), curso.getFechaCurso());
	}
	
	public void aumentarPlazas(String titulo,String fecha) {
		db.executeUpdate(SQL_AUMENTAR_NPLAZAS, titulo, fecha);	
	}
}
