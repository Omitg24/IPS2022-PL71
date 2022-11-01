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
			"SELECT DNICOLEGIADO, IBANCOLEGIADO, ESTADOCUOTA FROM COLEGIADO WHERE DNICOLEGIADO IN (SELECT DNICOLEGIADO FROM INSCRIBE)";
	
	/**
	 * Constante SQL_GETAMOUNT
	 */
	public static final String SQL_GETAMOUNT = 
			"SELECT SUM(PRECIO) FROM CURSO C, INSCRIBE I WHERE C.TITULOCURSO=I.TITULOCURSO AND "
			+ "I.DNICOLEGIADO = ? ";
	
	/**
	 * Atributo db
	 */
	private Database db = new Database();
	
	/**
	 * Atributo colegiados
	 */
	private List<ColegiadoDTO> colegiados;
	
	/**
	 * Construcotr EmisionModel 
	 */
	public EmisionModel() {
		this.colegiados = getColegiados();
	}
	
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
	public boolean saveToFile() {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("es", "ES"));
		boolean emittedReceipts = false;
		for(ColegiadoDTO colegiado : colegiados) {
			String estadoCuota = colegiado.getEstadoCuota(); 
			if (estadoCuota.equals("Pendiente")) {
				String receipt = getReceiptNumber();
				String dni = colegiado.getDniColegiado();
				String iban = colegiado.getIbanColegiado();
				int amount = getAmount(dni);
				
				Util.saveReceiptToFile(receipt, dateFormat.format(new Date()), dni, iban, amount);
				colegiado.setEstadoCuota("Emitido");
				emittedReceipts = true;
			}
		}
		return emittedReceipts;
	}	
}
