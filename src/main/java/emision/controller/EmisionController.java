package emision.controller;

import emision.model.EmisionModel;
import emision.view.EmisionView;
import util.SwingUtil;

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
		if (model.saveToFile()) {
			SwingUtil.showInformationDialog("Se han emitido los recibos de cuota.\nLa lista de recibos se encuentra en: resources/files/receipts.csv");
		} else {
			SwingUtil.showInformationDialog("No hay recibos pendientes de emitir");
		}
	}
}
