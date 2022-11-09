package asignacionpericial;

import asignacionpericial.controller.AsignacionPericialController;
import asignacionpericial.model.AsignacionPericialModel;
import asignacionpericial.view.AsignacionPericialView;

public class AsignacionPericialMain {
	
	public void main(String[] args) {
	AsignacionPericialView view = new AsignacionPericialView();
	AsignacionPericialModel model = new AsignacionPericialModel();
	AsignacionPericialController controller = new AsignacionPericialController(model,view);
	
	view.getFrame().setVisible(true);
	
	controller.initController();
	}

}
