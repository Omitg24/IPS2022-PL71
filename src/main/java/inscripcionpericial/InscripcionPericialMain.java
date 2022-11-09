package inscripcionpericial;

import inscripcion.view.IdentificadorView;
import inscripcionpericial.controller.InscripcionPericialController;
import inscripcionpericial.model.InscripcionPericialModel;
import inscripcionpericial.view.InscripcionPericialView;

public class InscripcionPericialMain {
	
	public void main(String[] args) {
		
		IdentificadorView view = new IdentificadorView(new InscripcionPericialView());
		InscripcionPericialModel model = new InscripcionPericialModel();
		InscripcionPericialController controller = new InscripcionPericialController(model,view);
		
		view.getFrame().setVisible(true);
		
		controller.initController();
	}

}
