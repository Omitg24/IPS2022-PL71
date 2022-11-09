package lotes.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import colegiado.model.ColegiadoDTO;
import lotes.util.LotesUtil;
import util.Database;

/**
 * Título: Clase AperturaModel
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class LotesModel {

//	private static final String MSG_FECHA_CURSO_NO_NULA = 
//			"La fecha de inscripcion no puede ser nula";
//	private static final String DEFAULT_INICIOINS="2022-01-01";
//	private static final String DEFAULT_FININS="2023-12-12";
//	private static final String DEFAULT_ESTADO="Planificado";
//	private static final int DEFAULT_NPLAZAS= 1;

	private Database db = new Database();
	
	public static final String SQL_OBTENER_SOLICITUDES=
			"select nombreColegiado, apellidoscolegiado, dniColegiado, titulacionColegiado from Colegiado where estadocolegiado = 'Pendiente'";
	
	public static final String SQL_INSERTAR_COMO_ANULADO =
			"insert into Colegiado(dniColegiado, nombreColegiado, apellidosColegiado,"
			+ " localidadColegiado, telefonoColegiado, titulacionColegiado, centroColegiado, anioColegiado, ibanColegiado, estadoColegiado, tipoColegiado, estadoCuota, estadoAsignacionPericial)"
			+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String SQL_OBTENER_NUMS_COLEGIADO = 
			"select (numeroColegiado) from Colegiado";
	
	public static final String SQL_ENCONTRAR_POR_DNI =
			"select * from Colegiado where dniColegiado=?";
	
	public static final String REQUESTS_PATH = "src/main/resources/files/inscriptionrequests.csv";
	public static final String BATCH_PATH = "src/main/resources/files/batch.csv";
	
	/**
	 * Método que convierte la lista de cursos a un array de String
	 */
	public List<ColegiadoDTO> getColegiados() {
		return LotesUtil.getColegiadosFromRequestCsv(REQUESTS_PATH);
	}
	
	/**
	 * Obtiene el número de colegiado más reciente
	 */
	public String getLargestNumColegiado() {
		List<ColegiadoDTO> listDTOs = db.executeQueryPojo(ColegiadoDTO.class, SQL_OBTENER_NUMS_COLEGIADO);
		List<ColegiadoDTO> listBatched = LotesUtil.getColegiadosFromBatchCsv(BATCH_PATH);
		List<Integer> ints = new ArrayList<Integer>();
		System.out.println(listDTOs);
		for (int i = 0; i < listDTOs.size(); i++) 
			ints.add(Integer.parseInt(listDTOs.get(i).getNumeroColegiado().split("-")[1]));
		for (int j = 0; j < listBatched.size(); j++) {
			System.out.println(listBatched.get(j));
			ints.add(Integer.parseInt(listBatched.get(j).getNumeroColegiado().split("-")[1]));
			
		}
		
		return "" + (Collections.max(ints) + 1);
	}
	
	/**
	 * Devuelve true si el DNI está enviado, false si no lo está
	 */
	public boolean isSent(String dni) {
		List<ColegiadoDTO> listBatched = LotesUtil.getColegiadosFromBatchCsv(BATCH_PATH);
		for (ColegiadoDTO col : listBatched)
			if (col.getDniColegiado().equals(dni)) return true;
		return false;
	}
	
	/**
	 * Inserta una solicitud en la base de datos con estado anulado
	 */
	public void insertAsInvalid(ColegiadoDTO dto) {
		db.executeUpdate(SQL_INSERTAR_COMO_ANULADO
				,dto.getDniColegiado()
				,dto.getNombreColegiado()
				,dto.getApellidosColegiado()
				,dto.getLocalidadColegiado()
				,dto.getTelefonoColegiado()
				,dto.getTitulacionColegiado()
				,dto.getCentroColegiado()
				,dto.getAnioColegiado()
				,dto.getIbanColegiado()
				, "Anulado"
				, "Pre-colegiado"
				, "Pendiente"
				, "NA");
	}
	
	/**
	 * Devuelve true si el colegiado no está en la base de datos
	 */
	public boolean findByDni(String dni) {
		return db.executeQueryPojo(ColegiadoDTO.class, SQL_ENCONTRAR_POR_DNI, dni).isEmpty();
	}
}
