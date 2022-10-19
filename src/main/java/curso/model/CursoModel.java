package curso.model;

import java.util.Date;
import java.util.List;

import util.Database;
import util.Util;

public class CursoModel {

	private static final String MSG_FECHA_CURSO_NO_NULA = "La fecha de inscripcion no puede ser nula";
	private static final String DEFAULT_INICIOINS = "2022-01-01";
	private static final String DEFAULT_FININS = "2023-12-12";
	private static final String DEFAULT_ESTADO = "Planificado";
	private static final int DEFAULT_NPLAZAS = 1;

	private Database db = new Database();

	public static final String SQL_INCLUIR_CURSOS = "Insert into curso (tituloCurso, fechaCurso, precio, fechaInicioIns,"
			+ "fechaFinIns, estadoC, nPlazas) values (?,?,?,?,?,?,?)";
	
	public static final String SQL_BUSCAR_CURSOS = "Select * from curso where tituloCurso=?";

	public void planificarCurso(String titulo, Date inicio, double precio) {
		validateFechaInicio(inicio);
		Util.validateNotNull(titulo, "El titulo del curso no puede ser nulo");
		Util.validateNotNull(precio, "El precio del curso no puede ser nulo");
		Util.validateCondition(precio >= 0, "El precio del curso no puede ser negativo");
		db.executeUpdate(SQL_INCLUIR_CURSOS, titulo, Util.dateToIsoString(inicio), precio, DEFAULT_INICIOINS,
				DEFAULT_FININS, DEFAULT_ESTADO, DEFAULT_NPLAZAS);

	}
	
	public List<CursoDTO> buscarCursoPorTitulo(String titulo) {
		Util.validateNotNull(titulo, "El titulo del curso no puede ser nulo");
		return db.executeQueryPojo(CursoDTO.class,SQL_BUSCAR_CURSOS , titulo);
	}

	private void validateFechaInicio(Date inicio) {
		Util.validateNotNull(inicio, MSG_FECHA_CURSO_NO_NULA);
	}	
}