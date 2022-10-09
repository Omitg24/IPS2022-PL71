package curso;

import curso.controller.CursoController;
import curso.model.CursoModel;
import curso.view.CursoView;
import util.Database;

public class CursoMain {

	public static void main(String[] args) {

		Database db = new Database();
		db.createDatabase(false);

		CursoView view = new CursoView();
		CursoModel model = new CursoModel();
		CursoController controller = new CursoController(model, view);

		controller.initController();
	}
}