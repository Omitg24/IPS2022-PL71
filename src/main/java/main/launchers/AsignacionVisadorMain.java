package main.launchers;

import coiipa.controller.AsignacionVisadorController;
import coiipa.model.model.AsignacionVisadorModel;
import coiipa.view.AsignacionVisadorView;

public class AsignacionVisadorMain {
	
	public void main(String[] args) {
	AsignacionVisadorView view = new AsignacionVisadorView();
	AsignacionVisadorModel model = new AsignacionVisadorModel();
	AsignacionVisadorController controller = new AsignacionVisadorController(model,view);
	
	view.getFrame().setVisible(true);
	
	controller.initController();
	}

}
