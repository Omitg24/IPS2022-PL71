package main.launchers;

import coiipa.controller.AperturaController;
import coiipa.model.model.AperturaModel;
import coiipa.view.AperturaView;

/**
 * Título: Clase AperturaMain
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class AperturaMain {
	
	public void main(String[] args) {
		
		AperturaView view = new AperturaView();
		AperturaModel model = new AperturaModel();
		AperturaController controller = new AperturaController(model,view);
		
		controller.initController();
	}
}
