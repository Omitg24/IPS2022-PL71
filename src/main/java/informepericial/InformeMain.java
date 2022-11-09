package informepericial;

import informepericial.controller.InformeController;
import informepericial.model.InformeModel;
import informepericial.view.InformeView;

/**
 * Título: Clase AperturaMain
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class InformeMain {
	
	public static void main(String[] args) {
		
		InformeView view = new InformeView();
		InformeModel model = new InformeModel();
		InformeController controller = new InformeController(model,view);
		
		controller.initController();
	}
}
