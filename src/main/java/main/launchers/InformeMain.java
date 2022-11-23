package main.launchers;

import coiipa.controller.InformeController;
import coiipa.model.model.InformeModel;
import coiipa.view.InformeView;

/**
 * Título: Clase AperturaMain
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class InformeMain {
	
	public void main(String[] args) {
		
		InformeView view = new InformeView();
		InformeModel model = new InformeModel();
		InformeController controller = new InformeController(model,view);
		
		controller.initController();
	}
}
