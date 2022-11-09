package emision.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import colegiado.model.ColegiadoDTO;
import emision.model.EmisionModel;
import emision.view.EmisionView;
import util.SwingUtil;
import util.Util;

/**
 * Titulo: Clase EmisionController
 *
 * @author Omar Teixeira González, UO281847
 * @version 15 oct 2022
 */
public class EmisionController {
	/**
	 * Atributo view
	 */
	private EmisionView view;
	/**
	 * Atributo model
	 */
	private EmisionModel model;
	
	/**
	 * Constructor EmisionController
	 * @param m
	 * @param v
	 */
	public EmisionController(EmisionModel m, EmisionView v) {
		this.model=m;
		this.view=v;	
		
		initView();
	}
	
	/**
	 * Método initView
	 */
	private void initView() {
		view.getFrame().setVisible(true);
	}
	
	/**
	 * Método initController
	 */
	public void initController() {
		view.getBtGenerateReceipts().addActionListener(e -> SwingUtil.exceptionWrapper(() -> emissionPlan()));
	}
	
	/**
	 * Método emissionPlan
	 */
	private void emissionPlan() {
		if (saveToFile()) {
			SwingUtil.showInformationDialog("Se han emitido los recibos de cuota.\nLa lista de recibos se encuentra en: resources/files/receipts.csv");
		} else {
			SwingUtil.showInformationDialog("No hay recibos pendientes de emitir");
		}
	}
	
	/**
	 * Método saveToFile
	 */
	public boolean saveToFile() {
		List<ColegiadoDTO> colegiados = model.getColegiados();
		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("es", "ES"));
		boolean emittedReceipts = false;
		for(ColegiadoDTO colegiado : colegiados) {
			String estadoCuota = colegiado.getEstadoCuota(); 
			if (estadoCuota.equals("Pendiente")) {
				String receipt = model.getReceiptNumber();
				String dni = colegiado.getDniColegiado();
				String iban = colegiado.getIbanColegiado();
				int amount = model.getAmount(dni);
				
				Util.saveReceiptToFile(receipt, dateFormat.format(new Date()), dni, iban, amount);
				model.updateEmitido(dni);
				emittedReceipts = true;
			}
		}
		return emittedReceipts;
	}	
}
