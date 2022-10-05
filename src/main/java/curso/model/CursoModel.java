package curso.model;

import java.util.Date;

import util.ApplicationException;
import util.Database;
import util.Util;

public class CursoModel {

	private static final String MSG_FECHA_CURSO_NO_NULA = 
			"La fecha de inscripcion no puede ser nula";
	private static final String DEFAULT_INICIOINS="2022-01-01";
	private static final String DEFAULT_FININS="2023-12-12";
	private static final String DEFAULT_ESTADO="Planificado";
	private static final int DEFAULT_NPLAZAS= 1;
	
	private Database db=new Database();
	
	public static final String SQL_INCLUIR_CURSOS=
			"Insert into curso (titulocurso,fechacurso,precio,fechainicioins,"
			+ "fechafinins,estadoc,nplazas)"
			+ "values (?,?,?,?,?,?,?)";
	
	public void planificarCurso(String titulo, Date inicio, double precio) {
		validateFechaInicio(inicio);
		validateNotNull(titulo,"El titulo del curso no puede ser nulo");
		validateNotNull(precio,"El precio del curso no puede ser nulo");
		validateCondition(precio>=0,"El precio del curso no puede ser negativo");
		db.executeUpdate(SQL_INCLUIR_CURSOS, titulo,Util.dateToIsoString(inicio),precio,
				DEFAULT_INICIOINS,DEFAULT_FININS,DEFAULT_ESTADO,DEFAULT_NPLAZAS);
		
	}

	private void validateFechaInicio(Date inicio) {
		validateNotNull(inicio,MSG_FECHA_CURSO_NO_NULA);
		
		
	}

	private void validateNotNull(Object obj, String message) {
		if (obj==null)
			throw new ApplicationException(message);
	}
	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}
}
