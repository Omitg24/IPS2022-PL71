package curso;

import curso.controller.CursoController;
import curso.model.CursoModel;
import curso.view.CursoView;

public class CursoMain {

	public void main(String[] args) {

		CursoView view = new CursoView();
		CursoModel model = new CursoModel();
		CursoController controller = new CursoController(model, view);

		controller.initController();
	}
}