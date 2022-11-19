package main.launchers;

import coiipa.controller.CursoController;
import coiipa.model.model.CursoModel;
import coiipa.view.CursoView;

public class CursoMain {

	public void main(String[] args) {

		CursoView view = new CursoView();
		CursoModel model = new CursoModel();
		CursoController controller = new CursoController(model, view);

		controller.initController();
	}
}