package main.launchers;

import coiipa.controller.InscripcionPericialController;
import coiipa.model.model.InscripcionPericialModel;
import coiipa.view.InscripcionPericialView;
import coiipa.view.inscripcion.IdentificadorView;

public class InscripcionPericialMain {
	
	public void main(String[] args) {
		
		IdentificadorView view = new IdentificadorView(new InscripcionPericialView());
		InscripcionPericialModel model = new InscripcionPericialModel();
		InscripcionPericialController controller = new InscripcionPericialController(model,view);
		
		view.getFrame().setVisible(true);
		
		controller.initController();
	}

}
