package emision.model;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import colegiado.model.ColegiadoDTO;
import util.Database;
import util.Util;

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
			"SELECT DNISOL, IBANSOL FROM COLEGIADO WHERE DNISOL IN (SELECT DNISOL FROM INSCRIBE)";
	
	/**
	 * Constante SQL_GETAMOUNT
	 */
	public static final String SQL_GETAMOUNT = 
			"SELECT SUM(PRECIO) FROM CURSO C, INSCRIBE I WHERE C.TITULOCURSO=I.TITULOCURSO AND "
			+ "I.DNISOL = ? ";
	
	/**
	 * Atributo db
	 */
	private Database db = new Database();
	
	/**
	 * Método getColegiados
	 * @return lista
	 */
	private List<ColegiadoDTO> getColegiados(){
		return db.executeQueryPojo(ColegiadoDTO.class, SQL_GETCOLEGIADOS);
	}
	
	/**
	 * Método getAmount
	 * @param dni
	 * @return amount
	 */
	private int getAmount(String dni) {
		int amount = (int) db.executeQueryArray(SQL_GETAMOUNT, dni).get(0)[0];
		return amount;
	}
	
	/**
	 * Método getReceiptNumber
	 * @return receipt
	 */
	private String getReceiptNumber() {
		int code = new Random().nextInt(9000) + 1000;
		String receipt = "ES" + code;
		return receipt;
	}
	
	/**
	 * Método saveToFile
	 */
	public void saveToFile() {
		List<ColegiadoDTO> colegiados = getColegiados();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("es", "ES"));
		for(ColegiadoDTO colegiado : colegiados) {
			String receipt = getReceiptNumber();
			String dni = colegiado.getDniSol();
			String iban = colegiado.getIbanSol();
			int amount = getAmount(dni);
			
			Util.saveReceiptToFile(receipt, dateFormat.format(new Date()), dni, iban, amount);
		}
	}	
}
