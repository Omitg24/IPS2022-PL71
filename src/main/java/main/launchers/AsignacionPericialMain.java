package main.launchers;

import coiipa.controller.AsignacionPericialController;
import coiipa.model.model.AsignacionPericialModel;
import coiipa.view.AsignacionPericialView;

public class AsignacionPericialMain {
	
	public void main(String[] args) {
	AsignacionPericialView view = new AsignacionPericialView();
	AsignacionPericialModel model = new AsignacionPericialModel();
	AsignacionPericialController controller = new AsignacionPericialController(model,view);
	
	view.getFrame().setVisible(true);
	
	controller.initController();
	}

}
