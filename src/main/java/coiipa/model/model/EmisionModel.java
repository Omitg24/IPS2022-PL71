package coiipa.model.model;

import java.util.List;
import java.util.Random;

import coiipa.model.dto.ColegiadoDTO;
import util.Database;

/**
 * Titulo: Clase EmisionModel
 *
 * @author Omar Teixeira González, UO281847
 * @version 15 oct 2022
 */
public class EmisionModel {
	/**
	 * Constante SQL_GETCOLEGIADOS
	 */
	public static final String SQL_GETCOLEGIADOS = 
			"SELECT DNICOLEGIADO, IBANCOLEGIADO, ESTADOCUOTA FROM COLEGIADO WHERE DNICOLEGIADO IN (SELECT DNICOLEGIADO FROM INSCRIBE)";	
	/**
	 * Constante SQL_GETAMOUNT
	 */
	public static final String SQL_GETAMOUNT = 
			"SELECT SUM(PRECIO) FROM CURSO C, INSCRIBE I WHERE C.TITULOCURSO=I.TITULOCURSO AND "
			+ "I.DNICOLEGIADO = ? ";	
	/**
	 * Constante SQL_UPDATEEMITIDO
	 */
	public static final String SQL_UPDATEEMITIDO = "UPDATE COLEGIADO SET ESTADOCUOTA = 'Emitido' WHERE DNICOLEGIADO = ?";
	
	/**
	 * Atributo db
	 */
	private Database db = new Database();
	
	/**
	 * Método getColegiados
	 * @return lista
	 */
	public List<ColegiadoDTO> getColegiados(){
		return db.executeQueryPojo(ColegiadoDTO.class, SQL_GETCOLEGIADOS);
	}
	
	/**
	 * Método getAmount
	 * @param dni
	 * @return amount
	 */
	public int getAmount(String dni) {
		int amount = (int) db.executeQueryArray(SQL_GETAMOUNT, dni).get(0)[0];
		return amount;
	}
	
	/**
	 * Método getReceiptNumber
	 * @return receipt
	 */
	public String getReceiptNumber() {
		int code = new Random().nextInt(9000) + 1000;
		String receipt = "ES" + code;
		return receipt;
	}	
	
	/**
	 * Método updateEmitido
	 * @param dniColegiado
	 */
	public void updateEmitido(String dniColegiado) {
		db.executeUpdate(SQL_UPDATEEMITIDO, dniColegiado);
	}
}
