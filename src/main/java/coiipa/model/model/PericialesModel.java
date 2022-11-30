package coiipa.model.model;

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
		            + "WHERE P.DNI=C.DNICOLEGIADO AND P.ID=I.ID AND P.ESTADO = 'Asignada'";

	private static final String SQL_OBTENER_ASIGNACIONES_ANULADAS =
			"SELECT P.ID, I.DNI, I.NOMBRE, "
		            + "C.DNICOLEGIADO, C.NOMBRECOLEGIADO, P.FECHA, P.ESTADO "
		            + "FROM SOLICITUDPERICIAL P, COLEGIADO C, INFORMES I "
		            + "WHERE P.DNI=C.DNICOLEGIADO AND P.ID=I.ID AND P.ESTADO = 'Anulada'";

	private static final String SQL_OBTENER_ASIGNACIONES_POR_PERITO =
			"SELECT P.ID, I.DNI, I.NOMBRE, "
		            + "C.DNICOLEGIADO, C.NOMBRECOLEGIADO, P.FECHA, P.ESTADO "
		            + "FROM SOLICITUDPERICIAL P, COLEGIADO C, INFORMES I "
		            + "WHERE P.DNI=C.DNICOLEGIADO AND P.ID=I.ID AND I.NOMBRE = ?";


	/**
	 * Método que convierte la lista de cursos a un array de String
	 */
	public List<AsignacionPericialDTO> getAsignaciones() {
		return db.executeQueryPojo(AsignacionPericialDTO.class, SQL_OBTENER_ASIGNACIONES);
	}

	/**
	 * Devuelve las fechas que han sido asignadas en forma de SpinnerListModel
	 */
	public SpinnerListModel getFechas() {
		List<AsignacionPericialDTO> fechas = db.executeQueryPojo(AsignacionPericialDTO.class, SQL_OBTENER_FECHAS_DISPONIBLES);
		List<String> result = new ArrayList<>();
		for (AsignacionPericialDTO f : fechas) {
			if (!result.contains(f.getFecha()))
				result.add(f.getFecha());
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
		return db.executeQueryPojo(AsignacionPericialDTO.class, SQL_OBTENER_ASIGNACIONES_REALIZADAS);
	}

	/**
	 * Devuelve las asignaciones con estado 'NA'
	 */
	public List<AsignacionPericialDTO> getNoRealizadas() {
		return db.executeQueryPojo(AsignacionPericialDTO.class, SQL_OBTENER_ASIGNACIONES_NO_REALIZADAS);
	}

	/**
	 * Devuelve las asignaciones con estado 'Anulada'
	 */
	public List<AsignacionPericialDTO> getAnuladas() {
		return db.executeQueryPojo(AsignacionPericialDTO.class, SQL_OBTENER_ASIGNACIONES_ANULADAS);
	}

	/**
	 * Devuelve las asignaciones por un perito determinado
	 */
	public List<AsignacionPericialDTO> getPorPerito(String perito) {
		return db.executeQueryPojo(AsignacionPericialDTO.class, SQL_OBTENER_ASIGNACIONES_POR_PERITO, perito);
	}

	/**
	 * Devuelve las asignaciones filtradas con unos parámetros determinados
	 */
	public List<AsignacionPericialDTO> getAsignacionesFiltradas(String fecha, boolean realizadas, boolean noRealizadas, boolean anuladas, String dniPerito) {

		List<AsignacionPericialDTO> temp = new ArrayList<>();
		List<AsignacionPericialDTO> result = getAsignacionesPorFecha(fecha);
		if (fecha.equals("Todas")) result = getAsignaciones();
		List<AsignacionPericialDTO> r = new ArrayList<>();
		List<AsignacionPericialDTO> n = new ArrayList<>();
		List<AsignacionPericialDTO> a = new ArrayList<>();
		List<AsignacionPericialDTO> dni = new ArrayList<>();

		if (realizadas) r = getRealizadas();
		if (noRealizadas) n = getNoRealizadas();
		if (anuladas) a = getAnuladas();
		if (!dniPerito.isEmpty()) dni = getPorPerito(dniPerito);

		// Hacemos la insersección de todas las listas
		if (!anuladas && !realizadas && !noRealizadas || anuladas && realizadas && noRealizadas) {
			
			if (!dniPerito.isEmpty())
				result.retainAll(dni);

			return result;
		}
		else {
			if (realizadas && !noRealizadas && !anuladas)
				result.retainAll(r);
			
			if (!realizadas && noRealizadas && !anuladas) 
				result.retainAll(n);
			
			if (!realizadas && !noRealizadas && anuladas) 
				result.retainAll(a);
			
			
			if (realizadas && noRealizadas && !anuladas) {
				temp.addAll(r);
				temp.addAll(n);
				result.retainAll(temp);
			}
			if (!realizadas && noRealizadas && anuladas) {
				temp.addAll(n);
				temp.addAll(a);
				result.retainAll(temp);
			}
			
			if (realizadas && !noRealizadas && anuladas) {
				temp.addAll(r);
				temp.addAll(a);
				result.retainAll(temp);
			}

			if (!dniPerito.isEmpty())
				result.retainAll(dni);

			return result;
		}
		
	}
}
