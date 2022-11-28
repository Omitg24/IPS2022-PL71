package main.launchers;

import coiipa.controller.InscripcionController;
import coiipa.model.model.InscripcionModel;
import coiipa.view.InscripcionView;
import coiipa.view.inscripcion.IdentificadorView;

/**
 * Título: Clase InscripcionMain
 *
 * @author Adrián Alves Morales, UO284288
 * @version 12 oct 2022
 */
public class InscripcionMain {
	
	public void main(String[] args) {
	
		IdentificadorView view = new IdentificadorView(new InscripcionView());
		InscripcionModel model = new InscripcionModel();
		InscripcionController controller = new InscripcionController(model,view);
		
		view.getFrame().setVisible(true);
		
		controller.initController();
	}
}
