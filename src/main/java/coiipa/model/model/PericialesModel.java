package coiipa.model.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SpinnerListModel;

import coiipa.model.dto.AsignacionPericialDTO;
import util.Database;

/**
 * Título: Clase PericialesModel
 *
 * @author Adrián Alves Morales, UO284288
 * @version 18 nov 2022
 */
public class PericialesModel {

	private Database db = new Database();

	private static final String SQL_OBTENER_FECHAS_DISPONIBLES =
			"SELECT P.FECHA "
		            + "FROM SOLICITUDPERICIAL P, COLEGIADO C, INFORMES I "
		            + "WHERE P.DNI=C.DNICOLEGIADO AND P.ID=I.ID";

	private static final String SQL_OBTENER_ASIGNACIONES =
			"SELECT P.ID, I.DNI, I.NOMBRE, "
		            + "C.DNICOLEGIADO, C.NOMBRECOLEGIADO, P.FECHA, P.ESTADO "
		            + "FROM SOLICITUDPERICIAL P, COLEGIADO C, INFORMES I "
		            + "WHERE P.DNI=C.DNICOLEGIADO AND P.ID=I.ID";

	private static final String SQL_OBTENER_ASIGNACIONES_REALIZADAS =
			"SELECT P.ID, I.DNI, I.NOMBRE, "
		            + "C.DNICOLEGIADO, C.NOMBRECOLEGIADO, P.FECHA, P.ESTADO "
		            + "FROM SOLICITUDPERICIAL P, COLEGIADO C, INFORMES I "
		            + "WHERE P.DNI=C.DNICOLEGIADO AND P.ID=I.ID AND P.ESTADO = 'Realizada'";

	private static final String SQL_OBTENER_ASIGNACIONES_NO_REALIZADAS =
			"SELECT P.ID, I.DNI, I.NOMBRE, "
		            + "C.DNICOLEGIADO, C.NOMBRECOLEGIADO, P.FECHA, P.ESTADO "
		            + "FROM SOLICITUDPERICIAL P, COLEGIADO C, INFORMES I "
		            + "WHERE P.DNI=C.DNICOLEGIADO AND P.ID=I.ID AND P.ESTADO = 'NA'";

	private static final String SQL_OBTENER_ASIGNACIONES_ANULADAS =
			"SELECT P.ID, I.DNI, I.NOMBRE, "
		            + "C.DNICOLEGIADO, C.NOMBRECOLEGIADO, P.FECHA, P.ESTADO "
		            + "FROM SOLICITUDPERICIAL P, COLEGIADO C, INFORMES I "
		            + "WHERE P.DNI=C.DNICOLEGIADO AND P.ID=I.ID AND P.ESTADO = 'Anulada'";

	private static final String SQL_OBTENER_ASIGNACIONES_POR_PERITO =
			"SELECT P.ID, I.DNI, I.NOMBRE, "
		            + "C.DNICOLEGIADO, C.NOMBRECOLEGIADO, P.FECHA, P.ESTADO "
		            + "FROM SOLICITUDPERICIAL P, COLEGIADO C, INFORMES I "
		            + "WHERE P.DNI=C.DNICOLEGIADO AND P.ID=I.ID AND I.DNI = ?";


	/**
	 * Método que convierte la lista de cursos a un array de String
	 */
	public List<AsignacionPericialDTO> getAsignaciones() {
		List<AsignacionPericialDTO> asig = db.executeQueryPojo(AsignacionPericialDTO.class, SQL_OBTENER_ASIGNACIONES);
		for (AsignacionPericialDTO a : asig)
			a.setFecha(Instant.ofEpochMilli(Long.valueOf(a.getFecha())).atZone(ZoneId.systemDefault()).toLocalDate().toString());
		return asig;
	}

	/**
	 * Devuelve las fechas que han sido asignadas en forma de SpinnerListModel
	 */
	public SpinnerListModel getFechas() {
		List<AsignacionPericialDTO> fechas = db.executeQueryPojo(AsignacionPericialDTO.class, SQL_OBTENER_FECHAS_DISPONIBLES);
		List<String> result = new ArrayList<>();
		for (AsignacionPericialDTO f : fechas) {
			LocalDate d = Instant.ofEpochMilli(Long.valueOf(f.getFecha())).atZone(ZoneId.systemDefault()).toLocalDate();
			if (!result.contains(d.toString()))
				result.add(d.toString());
		}
		result.add("Todas");

		SpinnerListModel sl = new SpinnerListModel(result);
		return sl;
	}

	/**
	 * Devuelve las asignaciones en una fecha determinada
	 */
	public List<AsignacionPericialDTO> getAsignacionesPorFecha(String fecha) {
		List<AsignacionPericialDTO> asig = db.executeQueryPojo(AsignacionPericialDTO.class, SQL_OBTENER_ASIGNACIONES);
		List<AsignacionPericialDTO> result = new ArrayList<>();
		for (AsignacionPericialDTO a : asig) {
			a.setFecha(Instant.ofEpochMilli(Long.valueOf(
					a.getFecha())).atZone(ZoneId.systemDefault()).toLocalDate().toString());
			if (a.getFecha().equals(fecha)) {
				result.add(a);
			}
		}
		return result;
	}

	/**
	 * Devuelve las asignaciones con estado 'Realizado'
	 */
	public List<AsignacionPericialDTO> getRealizadas() {
		List<AsignacionPericialDTO> asig = db.executeQueryPojo(AsignacionPericialDTO.class, SQL_OBTENER_ASIGNACIONES_REALIZADAS);
		for (AsignacionPericialDTO a : asig)
			a.setFecha(Instant.ofEpochMilli(Long.valueOf(
					a.getFecha())).atZone(ZoneId.systemDefault()).toLocalDate().toString());
		return asig;
	}

	/**
	 * Devuelve las asignaciones con estado 'NA'
	 */
	public List<AsignacionPericialDTO> getNoRealizadas() {
		List<AsignacionPericialDTO> asig = db.executeQueryPojo(AsignacionPericialDTO.class, SQL_OBTENER_ASIGNACIONES_NO_REALIZADAS);
		for (AsignacionPericialDTO a : asig)
			a.setFecha(Instant.ofEpochMilli(Long.valueOf(
					a.getFecha())).atZone(ZoneId.systemDefault()).toLocalDate().toString());
		return asig;
	}

	/**
	 * Devuelve las asignaciones con estado 'Anulada'
	 */
	public List<AsignacionPericialDTO> getAnuladas() {
		List<AsignacionPericialDTO> asig = db.executeQueryPojo(AsignacionPericialDTO.class, SQL_OBTENER_ASIGNACIONES_ANULADAS);
		for (AsignacionPericialDTO a : asig)
			a.setFecha(Instant.ofEpochMilli(Long.valueOf(
					a.getFecha())).atZone(ZoneId.systemDefault()).toLocalDate().toString());
		return asig;
	}

	/**
	 * Devuelve las asignaciones por un perito determinado
	 */
	public List<AsignacionPericialDTO> getPorPerito(String perito) {
		List<AsignacionPericialDTO> asig = db.executeQueryPojo(AsignacionPericialDTO.class, SQL_OBTENER_ASIGNACIONES_POR_PERITO, perito);
		System.out.println(perito);
		for (AsignacionPericialDTO a : asig)
			a.setFecha(Instant.ofEpochMilli(Long.valueOf(
					a.getFecha())).atZone(ZoneId.systemDefault()).toLocalDate().toString());
		System.out.println(asig);
		return asig;
	}

	/**
	 * Devuelve las asignaciones filtradas con unos parámetros determinados
	 */
	public List<AsignacionPericialDTO> getAsignacionesFiltradas(String fecha, boolean realizadas, boolean noRealizadas, boolean anuladas, String dniPerito) {

		// Tomamos las fechas como base
		List<AsignacionPericialDTO> result = getAsignacionesPorFecha(fecha);
		if (fecha.equals("Todas")) result = getAsignaciones();
		List<AsignacionPericialDTO> r = new ArrayList<>();
		List<AsignacionPericialDTO> n = new ArrayList<>();
		List<AsignacionPericialDTO> a = new ArrayList<>();
		List<AsignacionPericialDTO> dni = new ArrayList<>();

		if (realizadas) r = getRealizadas();
		if (noRealizadas) n = getNoRealizadas();
		if (anuladas) a = getAnuladas();
		if (!realizadas && !noRealizadas && !anuladas) {
			r = getRealizadas();
			n = getNoRealizadas();
			a = getAnuladas();
		}
		if (!dniPerito.isEmpty()) dni = getPorPerito(dniPerito);

		// Hacemos la insersección de todas las listas
		if (realizadas)
			result.retainAll(r);
		if (noRealizadas)
			result.retainAll(n);
		if (anuladas)
			result.retainAll(a);
		if (!dniPerito.isEmpty())
			result.retainAll(dni);

		return result;
	}

//	/*
//	 * Devuelve un curso dada una clave primaria
//	 */
//	public CursoDTO getCursoFromKey(String key) {
//		return db.executeQueryPojo(CursoDTO.class, SQL_OBTENER_CURSO_POR_KEY, key).get(0);
//	}
//
//	/*
//	 * Modifica las fechas de inscripción y el estado de un curso con clave key
//	 */
//	public void updateFechasCurso(Date inicio, Date fin, int nplazas, String key) {
//		db.executeUpdate(SQL_ACTUALIZAR_CURSOS, Util.dateToIsoString(inicio), Util.dateToIsoString(fin), nplazas, key);
//	}
}
