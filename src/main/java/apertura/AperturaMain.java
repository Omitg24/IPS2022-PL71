package apertura;

import apertura.controller.AperturaController;
import apertura.model.AperturaModel;
import apertura.view.AperturaView;

/**
 * Título: Clase AperturaMain
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class AperturaMain {
	
	public static void main(String[] args) {
		
		AperturaView view = new AperturaView();
		AperturaModel model = new AperturaModel();
		System.out.println(model.getCursos());
		AperturaController controller = new AperturaController(model,view);
		
		controller.initController();
	}
}
