package inscritos;

import inscritos.controller.InscritosController;
import inscritos.model.InscritosModel;
import inscritos.view.InscritosView;
import util.Database;

/**
 * 
 * Título: Clase InscritosMain
 *
 * @author David Warzynski Abril, UO278968
 * @version 13 oct 2022
 */
public class InscritosMain {
	public static void main(String[] args) {

		Database db = new Database();
		db.createDatabase(false);
		db.loadDatabase();

		InscritosView view = new InscritosView();
		InscritosModel model = new InscritosModel();
		InscritosController controller = new InscritosController(model, view);

		controller.initController();
	}
}
